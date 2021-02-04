# -*- coding: utf-8 -*-

"""
ListNode 公共类
"""


class ListNode(object):
    pass


class ListNode(object):

    def __init__(self, val: int):
        self.val = val
        self.next = None

    def set_next(self, val: int) -> ListNode:
        result = ListNode(val)
        self.next = result
        return result

    def __str__(self) -> str:
        result = "{\"val\":" + self.val.__str__()
        if self.next is not None:
            result += ", \"next\":" + self.next.__str__()
        result += "}"
        return result

    def get_next(self) -> ListNode:
        return self.next


def main():
    node = ListNode(1)
    node.set_next(2).set_next(3)
    print(node)


if __name__ == '__main__':
    main()


