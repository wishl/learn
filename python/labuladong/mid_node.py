# -*- coding: utf-8 -*-

from list_node import ListNode


def mid_node(head: ListNode) -> ListNode:
    l1 = head
    l2 = head
    while l2 is not None and l2.next is not None :
        l2 = l2.next.next
        l1 = l1.next
    return l1


def main():
    list_node = ListNode(1)
    list_node.set_next(2).set_next(3)
    print(list_node)
    result = mid_node(list_node)
    print(result)


if __name__ == '__main__':
    main()
