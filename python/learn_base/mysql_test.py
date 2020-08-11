# -*- coding: utf-8 -*-

"""
python3 没有mysqlLab了，使用pymysql代替，使用方法类似
"""
import pymysql


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
        cursor = connect.cursor()
        return cursor, connect

    def excute(self, sql: str):
        try:
            cursor, connect = self.connect()
            cursor.execute(sql)
        except Exception as e:
            connect.rollback()
        return cursor

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


def select_test() -> None:
    sql = "select * from tb_user"
    mysql = MysqlLer("localhost", 3306, "mysql_test", "666666", "root")
    cursor = mysql.excute(sql)
    # 获取数据之后光标位移
    result = cursor.fetchall()
    # 结果是个元组
    print(result)
    for i in range(result.__len__()):
        print(result[i])
    # 移动到某一个index
    cursor.scroll(0, mode="absolute")
    result = cursor.fetchone()
    print(result)
    # 往前或往后移动
    cursor.scroll(-1, mode="relative")
    result = cursor.fetchmany(1)
    print(result)

def insert_test() -> None:
    # 报错：%d format: a number is required, not str
    # sql = "insert into tb_user (name, age) values(%s, %d)"
    sql = "insert into tb_user (name, age) values(%s, %s)"
    param = [("gmy1", 20), ("wishl1", 20)]
    mysql = MysqlLer("localhost", 3306, "mysql_test", "666666", "root")
    result = mysql.insert(sql, param)
    print(result)

def select_in() -> None:
    sql = "select * from tb_user where id in (%s, %s, %s)"
    param = [1, 2, 3]
    mysql = MysqlLer("localhost", 3306, "mysql_test", "666666", "root")
    cursor = mysql.excute_in(sql, param)
    result = cursor.fetchall()
    print(result)

# select_test()
# insert_test()
select_in()
