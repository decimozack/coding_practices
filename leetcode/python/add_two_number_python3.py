#!/usr/bin/python3
# https://leetcode.com/problems/add-two-numbers/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:

        curr_sum = 0
        start_node = l1
        prev_node = l1

        while l1 is not None or l2 is not None or curr_sum > 0:

            curr_sum = (l1.val if l1 else 0) + \
                    (l2.val if l2 else 0) + \
                    (curr_sum)

            rem = curr_sum % 10
            if l1:
                l1.val = rem
            else:
                if l2:
                    prev_node.next = l2
                    l2.val = rem
                    l2 = None
                else:
                    prev_node.next = ListNode(rem)
                l1 = prev_node.next

            if curr_sum > 9:
                curr_sum = 1
            else:
                curr_sum = 0

            prev_node = l1
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None

        return start_node

