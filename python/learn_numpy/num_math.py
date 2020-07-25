# -*- coding: utf-8 -*-
"""
numpy的数学库
"""
import numpy as np


# 基础计算
def base_calculate():
    a = np.arange(9, dtype=np.float_).reshape(3, 3)
    print(a)
    b = np.array([10, 11, 12])
    print(b)
    print(a + b)
    print(np.add(a, b))
    print(a - b)
    print(np.subtract(a, b))
    print(a * b)
    print(a / b)


# 倒数
def reciprocal_test():
    a = np.array([0.25, 0.1, 1, 100])
    print(a)
    print(np.reciprocal(a))


# 计算元素的n次幂
def power_test():
    a = np.array([10, 100, 1000])
    print(np.power(a, 2))
    b = np.array([1, 2, 3])
    print(np.power(a, b))


# 计算除数的余数
def mod_test():
    a = np.array([10, 20, 30])
    print(a)
    print(np.mod(a, 3))
    print(np.remainder(a, 3))
    b = np.array([3, 4, 5])
    print(np.mod(a, b))
    print(np.remainder(a, b))


# 获取数组的最小值
def amin_test():
    a = np.arange(9).reshape(3, 3)
    print(a)
    # 寻找0轴的最小值
    print(np.amin(a, axis=0))
    print(np.amin(a, axis=1))
    print(np.amin(a))


# 获取最大值
def amax_test():
    a = np.arange(9).reshape(3, 3)
    print(a)
    print(np.amax(a, axis=0))
    print(np.amax(a, axis=1))
    print(np.amax(a))


# 计算最大值与最小值的差值
def ptp_test():
    a = np.arange(9).reshape(3, 3)
    print(a)
    print(np.ptp(a, axis=0))
    print(np.ptp(a, axis=1))
    print(np.ptp(a))


# 计算百分位数
def percentile_test():
    a = np.array([1, 2, 3, 4, 7, 10]).reshape(2, 3)
    print(a)
    # 把数组展平，然后求中位数
    print(np.percentile(a, 50))
    print(np.percentile(a, 50, axis=0))
    print(np.percentile(a, 50, axis=1))
    # 保持维度
    print(np.percentile(a, 50, axis=1, keepdims=True))


# 计算中位数
def median_test():
    a = np.array([1, 2, 3, 4, 7, 10]).reshape(2, 3)
    print(a)
    print(np.median(a))
    print(np.median(a, axis=0))
    print(np.median(a, axis=1))
    print(np.median(a, axis=1, keepdims=True))


# 计算算数平均数
def mean_test():
    a = np.array([1, 2, 3, 4, 5, 6]).reshape(2, 3)
    print(a)
    # 不加轴则平铺数组后计算
    print(np.mean(a))
    print(np.mean(a, axis=0))
    print(np.mean(a, axis=1))

# 加权平均数
def average_test():
    a = np.array([1, 2, 3, 4, 5, 6]).reshape(2, 3)
    print(a)
    # print(np.average(a))
    wts = np.array([6, 5, 4, 3, 2, 1]).reshape(2, 3)
    print(np.average(a, weights=wts))
    print(np.average(a, weights=wts, axis=1))


def power_test1():
    a = 3
    print(a ** 2)

# 总体标准差=sqrt(((x1-x)^2 +(x2-x)^2 +......(xn-x)^2)/n)；
# 样本标准差=sqrt(((x1-x)^2 +(x2-x)^2 +......(xn-x)^2)/（n-1）)
def standard_test():
    a = np.array([1, 2, 3, 4])
    print(np.std(a))

# 方差 = 标准差 ** 2
def var_test():
    a = np.array([1, 2, 3, 4])
    print(np.var(a))

# base_calculate()
# reciprocal_test()
# power_test()
# mod_test()
# amin_test()
# amax_test()
# ptp_test()
# percentile_test()
# median_test()
# mean_test()
# average_test()
# power_test1()
# standard_test()
var_test()

