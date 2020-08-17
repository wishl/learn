# -*- coding: utf-8 -*-

import pymysql
import pandas as pd


def read_mysql():
    print_split('read_sql')
    conn = create_conn()
    # head ==> limit 默认 5
    df = pd.read_sql(sql="select * from tb_user", con=conn, index_col='id', columns=['id', '名字', '年龄']).head()
    print(df)
    # print_split('read_sql_table')
    # df1 = pd.read_sql_table(table_name='tb_user', con=conn)
    # print_split(df1)


def read_csv():
    print_split('read_csv')
    df = pd.read_csv("./file/test.csv")
    print(df)


def read_excel():
    print_split("read_excel")
    df = pd.read_excel("./file/test.xlsx")
    print(df)


def create_conn():
    conn = pymysql.connect(host="localhost", port=3306, user="root",\
                           password="666666", database="mysql_test")
    return conn


def print_split(param: str):
    print("-----------{param}-----------".format(param=param))


read_mysql()
read_csv()
read_excel()
