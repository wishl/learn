# numpy : python中基于数组对象的科学计算库

#特点：拥有N维数组对象，拥有广播功能，拥有各类科学计算api

#n维数组(ndarray)对象，是一系列同类数据的集合，可以进行索引，切片，迭代

import numpy as np

#生成数组
a1 = np.array((1,2,3))
a2 = np.array([1,2,3])
a3 = np.array(((1,2),(3,4)))
a4 = np.array([[1,2],[3,4]])
a5 = np.arange(2,6)

#改变数组形状
a6 = np.array(((1,2,3),(4,5,6)))
a7 = a6.reshape(1,2,3)
a8 = a6.reshape(1,2,3)

#对数组进行索引，切片
a9 = np.array([1,2,3,4])
a10 = a9[:3]
a11 = np.arange(24).reshape(3,2,4)
a12 = a11[2,0,3]
a13 = a11[:2,:1,-2:]

#元素迭代
a14 = np.array((1,2,3,4))
# for i in a14:
#    print(i)

a15 = np.array(((1,2,3),(4,5,6)))
# for i in a15.flat:
#     print(i)

#多维数组变成一维数组
a16 = np.arange(12).reshape(3,4)
a17 = a16.ravel()

#广播机制
a18 = np.array((1,2,3))
a19 = a18 * 2
a20 = np.array((4,5,6))
a21 = np.array((7,8,9))
a22 = a20 + a21
a23 = a20 - a21
a24 = a20 * a21
a25 = a20 / a21
a26 = np.array(((1,2,3),(4,5,6),(7,8,9)))
a27 = np.array((2,3,4))
a28 = a26 - a27

#数组舍入操作
a29 = np.array((1.128,2.2,3.3))
a30 = np.round(a29,2)
a31 = np.floor(a29)
a32 = np.ceil(a29)

#数组转置操作
a33 = np.arange(12).reshape(3,4)
a34 = np.transpose(a33)
a35 = a33.T

#连接相同纬度数组
a36 = np.array(((1,2,3),(4,5,6)))
a37 = np.array(((7,8,9),(10,11,12)))
a38 = np.concatenate((a36,a37))
a39 = np.concatenate((a37,a36),axis=1)

#数组添加值
a40 = np.array(((1,2,3),(4,5,6)))
a41 = np.append(a40,(7,8,9))
a42 = np.append(a40,[[7,8,9],[10,11,12]],axis=1)
a43 = np.insert(a40,1,[7,8,9],axis=0)

#数组去重
a44 = np.array(((1,2,3,2),(2,2,3,4)))
a55 = np.unique(a44)

a56 = np.zeros(10)
a56[4] = 1
#反转数组
a57 = a56[::-1]
#非0索引
a58 = np.nonzero([1,0,0,2,3])
#生成对角矩阵
a59 = np.eye(6)
#生成随机数组
a60 = np.random.random((3,3))
#平均值
a61 = a60.mean()
a62 = np.ones((10,10))
a62[1:-1,1:-1] = 0
a63 = np.zeros((8,8),dtype=int)
a63[1::2,::2] = 1
a63[::2,1::2] = 1
a64 = np.ones((5,3))
a65 = np.ones((3,2))
print(a64)
print(a65)
print(a64 @ a65)
