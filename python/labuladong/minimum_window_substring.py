# -*- coding: utf8 -*-

"""
滑动窗口解决最小字符串子序列问题
https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-shua-shu-zu-ti-mu/hua-dong-chuang-kou-ji-qiao-jin-jie
"""
import sys


def min_substring(source: str, target: str) -> str:
    data_map = {}
    need = {}
    start = 0
    end = 0
    left = 0
    right = 0
    valid = 0
    length = sys.maxsize
    for s in target:
        need.setdefault(need.get(s, 0) + 1)
    while right < source.__len__():
        c = source[right]
        if c in need:
            data_map.set(c, data_map.get(c, 0) + 1)
            if data_map.get(c) == need.get(c):
                valid += 1
        right += 1
        while valid == need.__len__():
            c = source[left]
            if right - left <= length:
                length = right - left
                start = left
                end = right
            if c in need:
                data_map.set(c, data_map.get(c) - 1)
                if data_map.get(c) == need.get(c):
                    valid -= 1
            left += 1
    return source[start: end]


def main():
    result = min_substring("ADOBECODEBANCEE", "ABC")
    print(result)


if __name__ == '__main__':
    main()
