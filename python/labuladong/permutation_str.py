# -*- coding: utf8 -*-

"""
 查询字符串是否包含子串的某种序列
"""


def permutation(source: str, target: str) -> bool:
    need = {}
    data = {}
    left = 0
    right = target.__len__() - 1
    valid = 0
    t_len = target.__len__()
    for s in target:
        if s in need:
            need[s] += 1
        else:
            need[s] = 1
        data[s] = 0
    for i in range(0, right):
        if source[i] in data:
            source[i] += 1
            valid += 1
    while right < source.__len__() - 1:
        if valid != t_len:
            if source[left] in need:
                data[source[left]] -= 1
                if data[source[left]] == need[source[left]]:
                    valid -= 1
            left += 1
            right += 1
            print("right{}".format(source[right]))
            if source[right] in need:
                data[source[right]] += 1
                if data[source[right]] == need[source[right]]:
                    valid += 1
        else:
            break
    return valid == need.__len__()


def main():
    result = permutation("eidboaaoo", "oo")
    print(result)


if __name__ == '__main__':
    main()
