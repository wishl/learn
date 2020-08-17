# -*- coding: utf-8 -*-

import pymysql
import pandas as pd


def read_mysql():
    print_split('read_sql')
    conn = create_conn()
    df = pd.read_sql(sql="select * from tb_user", con=conn, index_col='id', columns=['id', '名字', '年龄']).head()
    print(df)
    print_split('read_sql_table')
    # df1 = pd.read_sql_table(table_name='tb_user', con=conn)
    # print_split(df1)


def create_conn():
    conn = pymysql.connect(host="localhost", port=3306, user="root",\
                           password="666666", database="mysql_test")
    return conn


def print_split(param: str):
    print("-----------{param}-----------".format(param=param))


read_mysql()
