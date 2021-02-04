# -*- coding: utf8 -*-

"""
计算两数之和
https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-shua-shu-zu-ti-mu/shuang-zhi-zhen-ji-qiao
"""


def two_sum(ints: list, target: int) -> list:
    end = ints.__len__() - 1
    start = 0
    while start < end:
        s = ints[start]
        e = ints[end]
        if (s + e) == target:
            return start + 1, end + 1
        elif (s + e) > target:
            end -= 1
        elif (s + e) < target:
            start += 1
    return None


def main():
    result = two_sum([2, 7, 11, 15], 9)
    print(list(result))


if __name__ == '__main__':
    main()
