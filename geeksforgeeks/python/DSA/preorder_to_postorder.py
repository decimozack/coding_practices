# https://practice.geeksforgeeks.org/problems/preorder-to-postorder/0
from typing import List
import sys

class Node:
    
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None


def main():
    test_cases = int(input())

    for i in range(test_cases):

        arr_size = int(input())
        pre_order = [int(i) for i in input().split(' ')]
        convert_pre_to_post(arr_size, pre_order) 


def convert_pre_to_post(arr_size: int, pre_order: List[int]):

    if arr_size == 0:
        return
    if arr_size == 1:
        print(f'{pre_order[0]} ')
        return

    root = Node(pre_order[0])

    for i in range(1, arr_size):
        insert_bst(root, pre_order[i])

    final_list = postOrder(root)

    print(' '.join(map(str, final_list)))


def insert_bst(root: Node, curr_num: int):

    if curr_num <= root.data:
        if root.left:
            insert_bst(root.left, curr_num)
        else:
            root.left = Node(curr_num)
    else:
        if root.right:
            insert_bst(root.right, curr_num)
        else:
            root.right = Node(curr_num)


def postOrder(root: Node):
    '''
    :param root: root of the given tree.
    :return the list containing post order traversal of the given binary tree.
    '''
    # code here
    if root is None:
        return []
    if root.left is None and root.right is None:
        return [root.data]
    
    left_list = postOrder(root.left)
    right_list = postOrder(root.right)
    root_list = [root.data]
    
    final_list = left_list + right_list + root_list
    return final_list


if __name__ == '__main__':
    main()
