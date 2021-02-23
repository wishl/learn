# -*- coding:utf8 -*-

"""
快速排序
"""
from typing import List


def quick_sort(arr: List[int]) -> List[int]:
    if len(arr) is None or len(arr) < 2:
        return arr
    middle = arr[0]
    less = [i for i in arr[1:] if arr[i] <= middle]
    more = [i for i in arr[1:] if arr[i] > middle]
    return quick_sort(less) + [middle] + quick_sort(more)


result = quick_sort([4, 3, 2, 1])
print(result)

