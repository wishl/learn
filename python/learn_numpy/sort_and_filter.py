# -*- coding: utf-8 -*-

import numpy as np

"""
排序，条件筛选
"""


# quicksort
# mergesort
# heapsort
def sort_test():
    a = np.array([1, 4, 3, 2]).reshape(2, 2)
    print(a)
    b = np.sort(a, axis=0)
    c = b[...][::-1]
    print(b)
    print(c)
    # print(np.sort(a, axis=0, kind='quicksort'))


# 根据字段排序
def sort_type_test():
    dt = np.dtype([('name', 'S9'), ('age', 'int64')])
    a = np.array([("wishl", 18), ("gmy", 19)], dtype=dt)
    print(a)
    print(np.sort(a, order='name'))


# 先根据a排序，相同的根据b排序
def sort_lexsort_test():
    a = np.array([1, 2, 1, 2, 1])
    b = np.arange(0, 10, 2)
    print(a)
    print(b)
    print(np.lexsort((b, a)))


# 按照第一个轴排序
def msort_test():
    a = np.arange(12).reshape(2, 2, 3)
    print(a)
    print(np.hsort(a))


def sort_complex_test():
    a = np.array([1, 2, 1 + 1j, 2])
    print(a)
    print(np.sort_complex(a))


# 获取最大和最小下标
def arg_max_min_test():
    a = np.array([1, 2, 3, 4])
    print(np.argmax(a))
    print(np.argmin(a))
    a = np.arange(12).reshape(2, 2, 3)
    print(a)
    print("--------")
    print(np.argmax(a, axis=1))
    print(np.argmin(a, axis=1))


# 过滤
def non_zero_test():
    a = np.array([[30, 40, 0], [0, 20, 10], [50, 0, 60]])
    print('我们的数组是：')
    print(a)
    print('\n')
    print('调用 nonzero() 函数：')
    a, b = np.nonzero(a)
    print(a, b)


# 过滤数组
def where_test():
    a = np.arange(6).reshape(2, 3)
    print(a)
    print(np.where(a > 3))
    print(np.where(a > 3))


# 根据条件过滤
def extract_test():
    a = np.arange(6).reshape(2, 3)
    print(a)
    print(np.extract(np.mod(a, 2) == 0, a))




# sort_test()
# sort_type_test()
# sort_lexsort_test()
# msort_test()
# sort_complex_test()
# arg_max_min_test()
# non_zero_test()
extract_test()


