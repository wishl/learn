# -*- coding: utf-8 -*-
"""
numpy标准库
文档地址：https://www.runoob.com/numpy/numpy-array-from-numerical-ranges.html
"""
import numpy as np

def empty():
    x = np.empty([3, 2], dtype=int)
    print(x)

def zeros():
    x = np.zeros([3, 2], dtype=int)
    print(x)
    print(x.shape)
    x1 = x.reshape([2, 3])
    print(x1)


def ones():
    x = np.ones([3, 2], dtype=int)
    print(x)
    print(x.shape)
    x1 = x.reshape(2, 3)
    print(x1)


def asarray():
    x = [1, 2, 3, 4, 5, 6]
    a = np.asarray(x, order='C')
    print(a)
    print(a.shape)
    a1 = a.reshape([2, 3], order='f')
    print(a1)
    print(a1.shape)


def tuple_to_array():
    x = (1, 2, 3, 4)
    a = np.asarray(x)
    print(a)
    print(a.shape)
    b = a.reshape([2, 2])
    print(b)
    print(b.shape)
    x1 = b.reshape([1, 4])
    print(x1)
    print(x1.shape)

def with_dtype():
    x = [1, 2, 3, 4]
    a = np.asarray(x, dtype=float)
    print(a)

def from_buffer():
    s = 'Hello World'
    a = np.from_buffer(s, dtype='S1')
    print(a)

def fromiter():
    list = range(5)
    it = iter(list)
    a = np.fromiter(it, dtype=float)
    print(a)

def arange(num):
    a = np.arange(num, dtype=int)
    print(a)

# 生成 开始为begin，结束为end，步长为length 的数组:
# 左闭右开
def arange_with_length(begin, end, length):
    a = np.arange(begin, end, length)
    print(a)

# 构成等差数列的一维数组
def linspace():
    a, step = np.linspace(0, 5, 5, True, True)
    print(a)
    print(step)
    b = a.reshape([5, 1])
    print(b)

# numpy.logspace 函数用于创建一个于等比数列
def logspace():
    a = np.logspace(1.0, 2.0, 10)
    print(a)

# ndarray对象的内容可以通过索引或切片来访问和修改，
# 与 Python 中 list 的切片操作一样。
def slice_test():
    a = np.arange(10)
    print(a)
    s = slice(0, 10, 2)
    print(a[s])

def slice_test1():
    a = np.arange(10)
    print(a)
    print(a[2:7:2])
    # 步长为1
    print(a[2:7:])
    # 倒序
    print(a[::-1])

# 切多维数组
def slice_test2():
    a = np.array([[1, 3, 5], [2, 4, 6]])
    print(a)
    print(a[::-1])

# 多维数组获取（0，0），（1，0），（1，1）
def slice_test3():
    a = np.array([[1, 3, 5], [2, 4, 6]])
    print(a[[0, 1, 1], [0, 0, 1]])

# 多维数组的对角线
def get_diagonal_num():
    a = np.array([[1, 3, 5], [2, 4, 6]])
    # print (a)
    print(a[[0, 0, 1, 1], [0, 2, 0, 2]])
    rows = np.array([[0, 0], [1, 1]])
    cols = np.array([[0, 2], [0, 2]])
    print(a[rows, cols])

# 可以借助切片 : 或 … 与索引数组组合。
def be_slice():
    a = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
    b = a[..., 1:]
    print(b)
    c = a[1:3, [1, 2]]
    print(c)
    d = a[1:3, 1:3]
    print(d)

def boolean_index():
    a = np.array([1, 2, 3, 4])
    b = a[a > 3]
    print (b)

# 过滤nap
def filter_nap():
    a = np.array([1, np.nan, 2, np.nan, 3, 4])
    print(a)
    b = a[~np.isnan(a)]
    print(b)

# 过滤虚数
def filter_compex():
    a = np.array([1, 2+6j, 5, 3.5+5j])
    print(a)
    b = a[np.iscomplex(a)]
    c = a[~np.iscomplex(a)]
    d = np.iscomplex(a)
    print(b)
    print(c)
    print(d)

# 花式过滤
def fancy_filter():
    a = np.arange(32).reshape([8, 4])
    print(a)
    print(a[np.ix_([1, 5, 7, 2], [0, 3, 1, 2])])
    print(a[[0, -1, -2, -3]])

# 纵向广播
def broadcast_row():
    a = np.array([1, 2, 3, 4])
    b = np.array([[1, 2, 3, 4], [5, 6, 7, 8]])
    print(a + b)

# 迭代数组
def iter():
    a = np.arange(6).reshape([2, 3])
    print(a)
    for x in np.nditer(a):
        print(x, end=",")
    print('\n')

# 已列行优先和列优先
def iter_by_row():
    a = np.arange(6).reshape([2, 3])
    print(a)
    for x in np.nditer(a.T):
        print(x, end=",")
    print('\n')

    for x in np.nditer(a.T.copy(order='C')):
        print(x, end=",")
    print('\n')

# 已列行优先和列优先1
def iter_by_row1():
    a = np.arange(0, 60, 5)
    print(a)
    b = a.reshape(3, 4)
    print(b)
    b = b.T
    print("a 转置结果")
    print(b)
    c = b.copy(order='C')
    print("c copy结果")
    print(c)
    for x in np.nditer(c):
        print(x, end=",")
    print("\n")
    d = b.copy(order='F')
    print("d copy结果")
    print(d)
    for x in np.nditer(d):
        print(x, end=",")
    print("\n")

# 显示控制顺序
def iter_by_row2():
    a = np.arange(0, 60, 5)
    b = a.reshape([3, 4])
    print("原数组:")
    print(b)
    print('以C风格遍历数组')
    for x in np.nditer(b, order="C"):
        print(x, end=",")
    print("\n")
    print("以F风格遍历数组")
    for x in np.nditer(b, order="F"):
        print(x, end=",")
    print("\n")

# 修改数组中的数
def update_num():
    a = np.arange(0, 60, 5)
    b = a.reshape([3, 4])
    print(b)
    for x in np.nditer(b, op_flags=['readwrite']):
        x[...] = 2*x
    print(b)

# https://www.cnblogs.com/gl1573/archive/2019/04/01/10634857.html
def iter_external():
    a = np.arange(0, 60, 5)
    a = a.reshape([3, 4], order="F")
    print('原数组为')
    print(a)
    for x in np.nditer(a, flags=['external_loop'], order="C"):
        print(x, end=",")
    print("\n")

def iter_index():
    a = np.arange(0, 60, 5)
    a = a.reshape([3, 4])
    print(a)
    it = np.nditer(a, flags=['f_index'], order='F')
    while not it.finished:
        print('%d<%d>' % (it[0], it.index), end='')
        it.iternext()

# order：'C' -- 按行，'F' -- 按列，
# 'A' -- 原顺序，'K' -- 元素在内存中的出现顺序。
def iter_flatten():
    a = np.array([[1, 2, 3], [4, 5, 6]])
    b = a.flatten(order='K')
    print(a)
    print(b)

#  flat 迭代器
def iterflat():
    a = np.array([[1, 2, 3], [4, 5, 6]])
    print(a)
    flat = a.flat
    for x in flat:
        print(x)

# 广播过滤
def broadcast_iter():
    a = np.arange(0, 60, 5)
    a = a.reshape([3, 4])
    print(a)
    b = np.array([1, 2, 3, 4])
    for x,y in np.nditer([a, b]):
        print("%d:%d" % (x, y), end=",")

# ravel：把多维数组展平
def ravel_iter():
    a = np.arange(8).reshape(2, 4)
    print("原数组:", end="")
    print(a)
    print('调用 ravel 函数之后：')
    print(a.ravel())
    print('调用 ravel,orderF 函数之后：')
    print(a.ravel(order='F'))

# array的转置
def transpose():
    a = np.arange(0, 60, 5).reshape([3, 2, 2], order="F")
    print(a)
    b = np.transpose(a)
    print('--------------')
    print(b)
    print('--------------')
    c = np.transpose(a, axes=[1, 0, 2])
    print(c)

# 转置时只需要把对应的坐标为止交换即可
# 例如：transpose((0, 2, 1)) 需要把 a[0][1][2] 对应的数和 a[0][2][1] 对应的数交换
# https://blog.csdn.net/u012762410/article/details/78912667
# 过程见./file/多维数组转置
def transpose1():
    # A是array([ 0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15])
    a = np.arange(16)
    # 将A变换为三维矩阵
    a = a.reshape(2, 2, 4)
    print(a)
    print('-----------------------------------')
    print(a[1][0][1])
    b = a.transpose((0, 2, 1))
    print(b)  #将 0轴 和 1轴 交换
    print(b[1][1][1])

def transpose2():
    a = np.array([[1, 2], [3, 4]])
    b = np.transpose(a, axes=[1, 0])
    print(b)

# 对应的是0轴和2轴转置
def t_trans():
    a = np.arange(16)
    a = a.reshape(2, 2, 4)
    print(a)
    print('-----------------------------------')
    print(a.T)

# 将下标挪到指定下标的前面
# 例如 rollaxis(a, 1)
# 就是把下标为1的挪到下标为0的前面
# rollaxis(a, 2, 1）
# 就是把下标为2的挪到下标伟1的前面
# https://blog.csdn.net/liaoyuecai/article/details/80193996
def rollaxis_test():
    # a = np.arange(16).reshape(2, 2, 4)
    # print(a)
    a = np.arange(4).reshape(2, 2)
    print(a)
    b = np.rollaxis(a, 1)
    print(b)

def max():
    a = np.arange(8).reshape(2, 2, 2)
    print(a)
    print("--------")
    print(a.max(axis=0))
    print(a.max(axis=1))

# 交换下标 swapaxes(a, 0, 2) 相当于第二个下标和第0个下标交换
# [1][1][0] -->[0][1][1]
def swapaxes_test():
    a = np.arange(8).reshape(2, 2, 2)
    print(a)
    print("--------")
    b = np.swapaxes(a, 0, 2)
    print(b.dtype)

# 广播
def broadcast_test():
    a = np.array([[1], [2], [3]])
    b = np.array([4, 5, 6])
    x = np.broadcast(a, b)
    # for (u, v) in x:
    #     print("(%d,%d)" % (u, v))
    c = np.empty(x.shape)
    c.flat = [u + v for (u, v) in x]
    print(c)

def broadcast_to_test():
    a = np.arange(4).reshape(1, 4)
    print(a)
    b = np.broadcast_to(a, (4, 4))
    print(b)

# 添加数组的轴
def expand_test():
    a = np.arange(4).reshape(2, 2)
    print(a)
    b = np.expand_dims(a, axis=0)
    print(b)
    c = np.expand_dims(a, axis=2)
    print(c)
    # 比原数组的轴多1以上会报错
    # d = np.expand_dims(a, axis=2)

# 删除空维度
def squezeTest():
    a = np.arange(9).reshape(1, 3, 1, 3)
    print(a)
    b = np.squeeze(a)
    print(b)
    print(b.shape)
    c = np.squeeze(a, axis=2)
    print(c)


# 连接数组
def concatenate_test():
    a = np.array([[1, 2], [2, 3]])
    b = np.array([[4, 5], [6, 7]])
    # 0轴链接
    print(np.concatenate((a, b)))
    # 1轴链接
    print(np.concatenate((a, b), axis=1))


def stack_test():
    a = np.array([[1, 2], [2, 3]])
    b = np.array([[4, 5], [6, 7]])
    print(np.stack((a, b), axis=0))
    print(np.stack((a, b), axis=1))


# 相当于np.stack((a, b), axis=0)
def hstack_test():
    a = np.array([[1, 2], [2, 3]])
    b = np.array([[4, 5], [6, 7]])
    print(np.hstack((a, b)))


# 相当于np.stack((a, b), axis=1)
def vstack_test():
    a = np.array([[1, 2], [2, 3]])
    b = np.array([[4, 5], [6, 7]])
    print(np.vstack((a, b)))


# 切割一维数组
def split_test():
    a = np.arange(9)
    print(a)
    b = np.split(a, 3)
    print(b)
    b = np.split(a, [4, 7])
    print(b)


# 切割多维数组
def split_multi_test():
    # a = np.arange(9).reshape(3, 3)
    # print(a)
    # b = np.split(a, 2, axis=1)
    # 如果不能均等分割，则会报错
    # b = np.split(a, [1, 2], axis=1)
    # print(b)
    c = np.arange(8).reshape(2, 2, 2)
    print(c)
    d = np.split(c, [1, 2], axis=0)
    print(d)


# 水平分割，
# 如果数组纬度>1相当于np.split(c, [1, 2], axis=1)
# else np.split(c, [1, 2], axis=0)
def hsplit_test():
    a = np.arange(8).reshape(2, 2, 2)
    print(a)
    b = np.hsplit(a, [1, 2])
    print(b)


# 竖直分割，
# if 数组纬度 < 2 error
# else  np.split(c, [1, 2], axis=0)
def vsplit_test():
    a = np.arange(8).reshape(2, 2, 2)
    print(a)
    b = np.vsplit(a, [1, 2])
    print(b)


# 返回重新定义大小的array
def resize_test():
    a = np.arange(6).reshape(2, 3)
    print(a)
    b = np.resize(a, (3, 2))
    print(b)
    c = np.resize(a, (3, 1))
    print(c)
    # 在resize时如果不足，会相当于broadcast_to
    d = np.resize(a, [3, 3])
    print(d)
    e = np.resize(a, [4, 2])
    print(e)


# 数组append
def append_test():
    b = np.arange(6).reshape(2, 3)
    print(b)
    c = np.append(b, [1, 2, 3])
    print(c)
    d = np.append(b, [[-1, -2, -3]], axis=0)
    print(d)
    e = np.append(b, [[-1], [-2]], axis=1)
    print(e)


# 多维数组append
def append_multi_test():
    a = np.arange(12).reshape(2, 2, 3)
    print(a)
    print("---------")
    b = np.append(a, [[[-1, -2, -3], [-4, -5, -6]]], axis=0)
    print(b)
    b = np.append(a, [[[-1, -2, -3]], [[-4, -5, -6]]], axis=1)
    print(b)
    b = np.append(a, [[[-1], [-2]], [[-3], [-4]]], axis=2)
    print(b)


# 函数在给定索引之前，沿给定轴在输入数组中插入值。
# 未传递 Axis 参数。 在插入之前输入数组会被展开。
def insert_test():
    a = np.arange(6).reshape(2, 3)
    print(a)
    b = np.insert(a, 1, [1, 2], axis=1)
    print(b)


# 多维数组的insert
def insert_multi_test():
    a = np.arange(12).reshape(2, 2, 3)
    print(a)
    # b = np.insert(a, 1, [[[1, 2], [3, 4]]], axis=2)
    # print(b)
    # b = np.insert(a, 1, [[[1, 2, 3], [2, 5, 6]]], axis= 1)
    # print(b)
    b = np.insert(a, 1, [[[1, 2, 3], [4, 5, 6]]], axis=0)
    print(b)


def delete_test():
    a = np.arange(6).reshape(2, 3)
    print(a)
    # 删除5，没有给定axis则展开数组
    b = np.delete(a, 1)
    print(b)
    # 删除轴为1的数
    # obj表示被删除的index，可以做切片
    b = np.delete(a, 1, axis=1)
    print(b)


def delete_multi_test():
    a = np.arange(12).reshape(2, 2, 3)
    print(a)
    b = np.delete(a, 1, axis=1)
    print(b)


# arr：输入数组，如果不是一维数组则会展开
# return_index：如果为true，返回新列表元素在旧列表中的位置（下标），并以列表形式储
# return_inverse：如果为true，返回旧列表元素在新列表中的位置（下标），并以列表形式储
# return_counts：如果为true，返回去重数组中的元素在原数组中的出现次数
def unique():
    a = np.array([1, 2, 3, 1, 3, 2, 0, 10])
    print(a)
    b = np.unique(a)
    print(b)
    b, c = np.unique(a, return_index=True)
    print(b, c)
    print("----------------")
    b, c = np.unique(a, return_inverse=True)
    print(b, c)


# 与
def bitwise_and_test():
    a, b = 13, 17
    print(bin(a), bin(b))
    print("\n")
    print(np.bitwise_and(a, b))

# 或
def bitwise_or_test():
    a, b = 13, 17
    print(np.bitwise_or(a, b))

# 按位取反
def invert_test():
    a, b = 13, 17
    print(np.invert(a), np.invert(b))




# empty()
# zeros()
# ones()
# asarray()
# tuple_to_array()
# with_dtype()
# from_buffer()
# fromiter()
# arange(5)
# arange_with_length(0, 5, 2)
# linspace()
# logspace()
# slice_test()
# slice_test1()
# slice_test2()
# slice_test3()
# get_diagonal_num()
# be_slice()
boolean_index()
# filter_nap()
# filter_compex()
# fancy_filter()
# broadcast_row()
# iter()
# iter_by_row()
# iter_by_row1()
# iter_by_row2()
# update_num()
# iter_external()
# iter_index()
# iter_flatten()
# broadcast_iter()
# ravel_iter()
# transpose()
# transpose2()
# t_trans()
# rollaxis_test()
# max()
# swapaxes_test()
# broadcast_test()
# broadcast_to_test()
# expand_test()
# squeeze_test()
# concatenate_test()
# hstack_test()
# vstack_test()
# split_test()
# split_multi_test()
# hsplit_test()
# vsplit_test()
# stack_test()
# resize_test()
# append_test()
# append_multi_test()
# insert_test()
# insert_multi_test()
# delete_test()
# delete_multi_test()
# unique()
# bitwise_and_test()
# bitwise_or_test()
# invert_test()