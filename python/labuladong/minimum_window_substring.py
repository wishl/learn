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
        if s in need:
            need[s] += 1
        else:
            need[s] = 1
        data_map[s] = 0
    while right < source.__len__():
        c = source[right]
        if c in need:
            data_map[c] = data_map[c] + 1
            if data_map[c] == need[c]:
                valid += 1
        right += 1
        while valid == need.__len__():
            c = source[left]
            if right - left <= length:
                length = right - left
                start = left
                end = right
            if c in need:
                data_map[c] -= 1
                if data_map[c] == need[c]:
                    valid -= 1
            left += 1
    return source[start: end]


def main():
    result = min_substring("ADOBECODEBANCEE", "ABC")
    print(result)


if __name__ == '__main__':
    main()
