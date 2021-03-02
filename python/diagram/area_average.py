# -*- coding:utf-8 -*-

"""
平分一块土地的最大面积
"""


def average(length: int, width: int) -> int:
    if width > length:
        temp = width
        width = length
        length = temp
    if length % width == 0:
        return width
    l1 = length - (length / width)
    w1 = length % width
    average(l1, w1)
