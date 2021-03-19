# -*- coding: utf8 -*-
"""
bm算法详解 https://blog.csdn.net/qq_29423387/article/details/86531392
好后缀和坏字符
"""
from typing import Dict


# 获取好后缀
def get_bmgs(pattern: str) -> Dict[str, int]:
    # 预生成好后缀表
    bmgs = dict()
    # print(len(pattern))
    # 无后缀仅根据坏字移位符规则
    bmgs[''] = 0
    for i in range(len(pattern)):
        # 好后缀
        gs = pattern[len(pattern) - i - 1:]
        for j in range(len(pattern) - i - 1):
            # 匹配部分
            ngs = pattern[j:j + i + 1]
            # 记录模式串中好后缀最靠右位置（除结尾处）
            if gs == ngs:
                # 因为ngs的最后index为length
                bmgs[gs] = len(pattern) - j - i - 1
    return bmgs


# 获取坏字符
def get_bmbc(pattern: str) -> Dict[str, int]:
    bmbc = {}
    bmbc[''] = 0
    for i in range(len(pattern) - 1):
        bmbc[pattern[i]] = i + 1
    return bmbc


def bm(source: str, target: str) -> int:
    bmbc = get_bmbc(target)
    bmgs = get_bmgs(target)
    target_length = len(target)
    i = target_length - 1
    j = target_length - 1
    suffix = ""
    while i < len(source) and j >= 0:
        tc = target[j]
        sc = source[i]
        if tc == sc:
            i -= 1
            j -= 1
            suffix = sc + suffix
        elif sc not in bmbc:
            i = i + target_length
            j = target_length - 1
            suffix = ""
        else:
            bmgs_length = (-1 if suffix not in bmgs else bmgs[suffix])
            bmbc_length = bmbc[sc]
            suffix = ""
            length = max(bmbc_length, bmgs_length)
            i += j + 1 - length
            j = target_length - 1
    # 因为如果i < len(source) 时 说明j < 0, i 多减一次需要加回来
    return i + 1 if i < len(source) else -1


def main():
    result = bm("this is a simple example", "example")
    # result = bm("ABCABA", "ABA")
    print(result)
    # result = get_bmgs('abcabc')
    # print(result)


if __name__ == '__main__':
    main()
