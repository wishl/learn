# -*- coding: utf8 -*-


def revert_str(chars: list) -> list:
    end = chars.__len__() - 1
    start = 0
    while start < end:
        c = chars[start]
        chars[start] = chars[end]
        chars[end] = c
        start += 1
        end -= 1
    return chars


def main():
    result = revert_str(['1', '2', '3', '4', '5', '6'])
    print(result)


if __name__ == '__main__':
    main()
