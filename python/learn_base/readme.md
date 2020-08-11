**python 基础语法练习库**  
**生成器:**  
1.generator: 如果一个方法中包含一个或一个以上的yield方法，则此方法为generator方法  
2.generator方法默认实现了__iter()__ 和 __next()__ 方法  
3.在调用generator时，generator函数不会立即开始运行直到__next()__方法被调用  
4.在执行到yield语句时，会暂停该方法并返回调用方,并返回yield方法中的参数  
5.函数终止会抛出StopIteration  

**pymysql 报错 cryptography is required ...**
1.安装cryptography  
2.在安装cryptography 失败时使用  
 pip3 install cryptography -i http://pypi.douban.com/simple/ --trusted-host pypi.douban.com --target=/usr/local/lib/python3.7/site-packages  
 指令
参考资料:  
https://www.cnblogs.com/xiaojianliu/articles/10019243.html
https://www.cnblogs.com/kadima-zy/p/python_pip.html
https://blog.csdn.net/MK_chan/article/details/89390368
