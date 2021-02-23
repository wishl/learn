# -*- coding: utf-8 -*-

def fibonacci(num):
    a, b = 0, 1
    if num == 1:
        return a
    elif num == 2:
        return b
    c = 2
    while c < num:
        a, b = b, a + b
        c = c + 1
    return b

# 当遇到break时不会运行else
def while_else():
    c = 0
    while c < 10:
        c = c+1
        break
    else:
        print(c)


def for_else():
    result = []
    for i in range(1, 10, 1):
        print(i, end=',')
        # 通过append添加元素
        result.append(i)
    else:
        print('end')
        # 通过[i] 赋值
        result[len(result) - 1] = -1
    return result


def iter_test():
    a = range(1, 10)
    it = iter(a)
    for x in it:
        print(x, end=",")


def iter_test2():
    list = [1, 2, 3, 4]
    it = iter(list)
    while True:
        try:
            print(next(it))
        except StopIteration:
            break


# 自定义迭代器
class MyIter:
    a = 1

    def __iter__(self):
        self.a = 1
        return self

    def __next__(self):
        x = self.a
        if self.a > 10:
            raise StopIteration
        self.a += 1
        return x


# 生成器
def my_gen():
    n = 1
    print('first call gen')
    n += 1
    yield n

    print('second call gen')
    n += 1
    yield n

    print('last call gen')
    n += 1
    yield n

# num = fibonacci(5)
# print(num)
# while_else()
# result = for_else()
# print(result)
# iter_test()
# iter_test2()
# iter = MyIter()
# while True:
#     try:
#         print(next(iter))
#     except StopIteration:
#         break
# a = my_gen()
# while True:
#     try:
#         print(next(a))
#     except StopIteration:
#         break

