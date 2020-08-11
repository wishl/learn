# -*- coding: utf-8 -*-

from collections import deque


# 把列表当做队列用
def stack():
    stack = [3, 4, 5]
    stack.append(6)
    stack.append(7)
    a = stack.pop()
    print(a)
    b = stack.pop()
    print(b)


# list当做队列
def queue(*args) -> None:
    a = list(args)
    print(a)
    queue = deque(a)
    b = queue.popleft()
    print(b)


# 列表推导式
def count_list(*args):
    a = list(args)
    b = [2**x for x in a]
    print(b)
    c = [[2*x, 2**x] for x in a]
    print(c)



# stack()
# queue(1, 2, 3)
count_list(1, 2, 3)

