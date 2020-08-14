import numpy as np
import pandas as pd
from pandas import Series,DataFrame
import webbrowser

#Series
mylist = list('abcdefghijklmnopqrstuvwxyz')
myarr = np.arange(26)
mydict = dict(zip(mylist, myarr))

#从列表，数组，字典构建series
ser1 = pd.Series(mylist)
ser2 = pd.Series(myarr)
ser3 = pd.Series(mydict)
df = ser3.to_frame()

#series的索引列转化为dataframe的列
df.reset_index(inplace=True)
# print(df.head())

#结合多个series组成dataframe
ser4 = pd.Series(list('abcdefghijklmnopqrstuvwxyz'))
ser5 = pd.Series(np.arange((26)))
#axis=1表示列拼接，0表示行拼接
ser6 = pd.concat([ser4, ser5], axis=1)
ser7 = pd.DataFrame({'col1': ser4,'col2': ser5})

#命名列索引的名称
ser4.name = 'haha'
# print(ser4.head())

#获得series对象A中不包含series对象B的元素
ser8 = pd.Series([1, 2, 3, 4, 5])
ser9 = pd.Series([4, 5, 6, 7, 8])
ser10 = ~ser8.isin(ser9)
ser3=~ser1.isin(ser2)
# print(ser10)
# print(ser8[ser10])

#获得seriesA和seriesB不相同的项
#并集
ser11 = pd.Series(np.union1d(ser8, ser9))
#交集
ser12 = pd.Series(np.intersect1d(ser8, ser9))
# print(ser12)

#获得数值series的四分位值
ser13 = np.random.RandomState(100)
# print(ser13)
# 从均值为5标准差为25的正态分布随机抽取5个点构成series
ser14 = pd.Series(ser13.normal(10, 5, 25))
# print(ser14)

#使numpy数组转化为给定形状的dataframe
ser15 = pd.Series(np.random.randint(1, 10, 35))
ser16 = pd.DataFrame(ser15.values.reshape(7, 5))
# print(ser16)

#找到series的值是3的倍数的位置
ser17 = pd.Series(np.random.randint(1, 10, 7))
# print(ser17)
# np.argwhere(ser17 % 3==0)

#获取series中给定索引的元素（items）
ser18 = pd.Series(list('abcdefghijklmnopqrstuvwxyz'))
index1 = [0, 4, 8, 14, 20]
ser19 = ser18.take(index1)
# print(ser19)

#垂直和水平的拼接series
ser20 = pd.Series(range(5))
ser21 = pd.Series(list('abcde'))
#垂直拼接
ser22 = pd.concat([ser20,ser21],axis=0)
#水平拼接
ser23 = pd.concat([ser20,ser21],axis=1)
# print(ser22)
# print(ser23)

#获取series对象A中包含series对象B元素的位置




s1 = pd.Series([1, 2, 3, 4])
# print(s1.values)
s2 = pd.Series(np.arange(10))
# print(s2)
s3 = pd.Series({'1': 1, '2': 2, '3': 3})
# print(s3.index)
s4 = pd.Series([1, 2, 3, 4],index=['A', 'B', 'C', 'D'])
# print(s4[s4>1])
# print(s4.to_dict())
s5 = pd.Series(s4.to_dict())
# print(s5)
s6 = pd.Series(s5, index=['A', 'B', 'C', 'D', 'E'])
# print(s6)
# print(pd.isnull(s6))
# print(pd.notnull(s6))
s6.name = 'demo'
s6.index.name = 'demo_index'
# print(s6.index)

#Dataframe
# link = 'https://www.tiobe.com//tiobe-index/'
# webbrowser.open(link)
# 1	2	change	C	16.98%	+1.83%
# 2	1	change	Java	14.43%	-1.60%
# 3	3		Python	9.69%	-0.33%
# 4	4		C++	6.84%	+0.78%
# 5	5		C#	4.68%	+0.83%
# 6	6		Visual Basic	4.66%	+0.97%
# 7	7		JavaScript	2.87%	+0.62%
# 8	20	change	R	2.79%	+1.97%
# 9	8	change	PHP	2.24%	+0.17%
# 10	10		SQL	1.46%	-0.17%
# 11	17	change	Go	1.43%	+0.45%
# 12	18	change	Swift	1.42%	+0.53%
# 13	19	change	Perl	1.11%	+0.25%
# 14	15	change	Assembly language	1.04%	-0.07%
# 15	11	change	Ruby	1.03%	-0.28%
# 16	12	change	MATLAB	0.86%	-0.41%
# 17	16	change	Classic Visual Basic	0.82%	-0.20%
# 18	13	change	Groovy	0.77%	-0.46%
# 19	9	change	Objective-C	0.76%	-0.93%
# 20	28	change	Rust	0.74%	+0.29%
# df = pd.read_clipboard()   #读取粘贴板的内容
# print(df.columns)   #读取索引
# print(df.Ratings)
# 从原先的dataframe中提取想要的数据，并赋给新的dataframe，该操作很有用
# df_new = DataFrame(df, columns=['Sep 2019','Sep 2018', 'Change', 'Programming Language'])
# print(df_new)