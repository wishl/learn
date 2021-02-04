# -*- coding: utf-8 -*-

"""
拉取showx数据到jqka库
"""
import pymysql
import time

insert_host = "localhost"
insert_port = 3306
insert_user = "root"
insert_password = "root"

select_host = "localhost"
select_port = 3306
select_user = "root"
select_password = "root"

str_time = time.strftime("%Y-%m-%d", time.localtime())


class MysqlLer(object):

    def __init__(self, host: str, port: int, data_base: str, pass_word: str, user:str) -> None:
        super().__init__()
        self.host = host
        self.port = port
        self.data_base = data_base
        self.pass_word = pass_word
        self.user = user

    def connect(self):
        connect = pymysql.connect(host=self.host, port=self.port, user=self.user,\
                        database=self.data_base, password=self.pass_word)
        cursor = connect.cursor(cursor=pymysql.cursors.DictCursor)
        return cursor, connect

    def excute(self, sql: str):
        try:
            cursor, connect = self.connect()
            result = cursor.execute(sql)
            connect.commit()
            return result
        except Exception as e:
            print(e)
            connect.rollback()
        return None

    def insert(self, sql: str, param: list) -> int:
        try:
            cursor, connect = self.connect()
            if param.__len__() == 1:
                result = cursor.execute(sql, param)
            else:
                result = cursor.executemany(sql, param)
            connect.commit()
            return result
        except Exception as e:
            print(e)
            connect.rollback()
        return None

    def excute_in(self, sql: str, param: list):
        try:
            cursor, connect = self.connect()
            cursor.execute(sql, param)
        except Exception as e:
            connect.rollback()
        return cursor


def select() -> None:
    mysql = MysqlLer(select_host, select_port,  "pap_jqka", select_user, select_password)
    # params = [str_time]
    result = mysql.excute_in("select * from video_put_charge_dashbord where event_day = %s", "2021-01-02").fetchall()
    for param in result:
        insert_sql = "insert into video_put_charge_dashbord_copy1 \
            (id, put_type, channel, source, charged_video_count, charged_user_count, video_charge, event_day) \
            values (0, {}, {},  {}, {}, {}, {},  '{}')" \
            .format(param['put_type'], param['channel'], param['source'], param['charged_video_count'], param['charged_user_count'],
                    param['video_charge'], param['event_day'])
        print(insert_sql)
        insert_res = mysql.excute(insert_sql)
        print(insert_res)


select()

