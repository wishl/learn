# -*- coding: utf-8 -*-

import numpy as np

"""
 numpy对于矩阵的支持
"""


# 创建对角线为1的二位数组
def eye_test():
    a = np.eye(2)
    print(type(a))
    print(a)
    a = np.eye(3, 3, 1)
    print(a)

# 将ndarray转成matrix
def mat_test():
    a = np.eye(2, 3, 1)
    print(type(a))
    b = np.mat(a)
    print(type(b))
    print(b)

# 矩阵的叉乘
def dot_test():
    a = np.array([[1, 2, 3], [4, 5, 6]])
    b = np.array([[7, 8], [10, 11], [9, 12]])
    print(np.dot(a, b))

# 两个向量的点积
def vdot_test():
    a = np.array([[1, 2], [3, 4]])
    b = np.array([[11, 12], [13, 14]])
    # vdot 将数组展开计算内积
    # 1*11 + 2*12 + 3*13 + 4*14 = 130
    print(np.vdot(a, b))

# 矩阵的迹
def trace_test():
    a = np.array([[1, 2], [3, 4]])
    print(np.trace(a))


def linalg_eig_test():
    a = np.array([[1, 2], [4, 5]])
    print(np.linalg.eig(np.mat(a)))


# eye_test()
# mat_test()
# dot_test()
# vdot_test()
# trace_test()
linalg_eig_test()

