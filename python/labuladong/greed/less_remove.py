# -*- coding:utf8 -*-
from typing import List


def take_second(elem):
    return elem[1]


def remove_less(intervals: List[List[int]]) -> int:
    intervals.sort(key=take_second)
    end = intervals[0][1]
    count = 0
    for i in range(1, len(intervals)):
        start = intervals[i][0]
        if end < start:
            count += 1
            end = intervals[i][1]
    return count


def main():
    intervals = [[1, 2], [2, 3], [3, 4], [1, 3]]
    print(remove_less(intervals))


if __name__ == '__main__':
    main()