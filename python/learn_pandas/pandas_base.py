# -*- coding: utf-8 -*-

import pandas as pd
import numpy as np


def print_split():
    print('---------')


# 创建series
def create_series() -> pd.Series:
    series = pd.Series([1, 2, 3], index=['a', 'b', 'c'])
    return series


# 展示series
def series_test():
    series = create_series()
    print(series)
    # 不存在的index报错
    print(series['a'])
    print(series[1])


# 获取index和value
def series_test1():
    series = create_series()
    print(series)
    print(series.values)
    print(series.index)


# 转array和切片操作
def series_test2():
    series = create_series()
    print(series.__array__(dtype=float))
    print(series[::1])
    print(series[[1, 2]])
    print(series[['a', 'b']])


# 遍历series
def series_test3():
    series = create_series()
    it = series.iteritems()
    for idx, value in it:
        print(idx, value)


# append series
def series_test4():
    series = create_series()
    to_append = pd.Series([4, 5, 6], index=['d', 'e', 'f'])
    append = series.append(to_append)
    print(append)


# 通过range创建DatetimeIndex
def range_test() -> pd.DatetimeIndex:
    dates = pd.date_range('2020-01-01', '2020-01-31', periods=6)
    print(dates)
    return dates


# 创建DataFrame
def create_data_frame() -> pd.DataFrame:
    df = pd.DataFrame([{'a': 1, 'b': 2}, {'a': 3, 'b': 4}], index=['index1', 'index2'])
    return df


# 打印dataFrame
def data_frame_test():
    df = create_data_frame()
    print(df)


# 查询dataFrame
def data_frame_test1():
    df = create_data_frame()
    print(df)
    print_split()
    # 获取整个列
    column_result = df.get('a')
    print(column_result)
    print_split()
    # 获取整个列
    print(df['a'])
    print_split()
    # 根据数组位置获取某一条数据
    # 0为index，1为column
    print(df.iloc[0, 1])
    print_split()
    # 根据数组位置切片获取数据
    print(df.iloc[0, ::1])
    print_split()
    # 根据index和column获取数据
    print(df.loc['index1', 'a'])
    print_split()
    # 根据index和column获取切片
    print(df.loc['index1': 'index2', ])


def data_frame_test2():
    df = create_data_frame()
    append = df.append({'a': 5, 'b': 6}, ignore_index=True)
    print(append)
    series = pd.Series({'a': 5, 'b': 6}, name='3')
    print(series)
    append1 = append.append(series, ignore_index=False)
    print(append1)


def data_frame():
    dates = pd.date_range('2020-01-01', '2020-01-31', periods=6)
    array = np.array(range(24)).reshape(6, 4)
    print(array)
    df = pd.DataFrame(array, index=dates, columns=list('ABCD'))
    print(df)


def group_test():
    carray, darray = get_array()
    # 如果不能sum则不展示
    df = pd.DataFrame({
        'A': ['foo', 'bar', 'foo', 'bar',
              'foo', 'bar', 'foo', 'foo'],
        # 'B': ['one', 'one', 'two', 'three',
        #       'two', 'two', 'one', 'three'],
        'B': carray,
        'C': carray,
        'D': darray
    })
    print(df)
    df1 = df.groupby('A').sum()
    print(df1)


def group_test1():
    carray, darray = get_array()
    df = pd.DataFrame({
        'A': ['foo', 'bar', 'foo', 'bar',
              'foo', 'bar', 'foo', 'foo'],
        'B': ['one', 'one', 'two', 'three',
              'two', 'two', 'one', 'three'],
        'C': carray,
        'D': darray
    })
    print(df.groupby(['A', 'B']).sum())


def get_array():
    carray = np.array(range(1, 9, 1))
    darray = np.array(range(9, 17, 1))
    return carray, darray


series_test()
# series_test1()
# series_test2()
# series_test3()
# series_test4()
# data_frame_test()
# data_frame_test1()
# data_frame_test2()
# range_test()
# data_frame()
# group_test()
# group_test1()
