# https://practice.geeksforgeeks.org/problems/preorder-to-postorder/0
from typing import List


class Node:
    
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None


INT_MIN = float('-infinity')
INT_MAX = float('infinity')


def main():
    test_cases = int(input())

    for i in range(test_cases):

        arr_size = int(input())
        pre_order = [int(i) for i in input().split(' ')]
        convert_pre_to_post(arr_size, pre_order) 


def get_curr_idx():
    return convert_pre_to_post_in.curr_idx


def incre_curr_idx():
    convert_pre_to_post_in.curr_idx += 1


def convert_pre_to_post(arr_size: int, pre_order: List[int]):
    
    convert_pre_to_post_in.curr_idx = 0
    convert_pre_to_post_in(arr_size, pre_order, INT_MIN, INT_MAX)
    print('')

def convert_pre_to_post_in(arr_size: int, pre_order: List[int], int_min: int, int_max: int):
    
    curr_idx = get_curr_idx()
    if curr_idx == arr_size:
        return
    
    if (pre_order[curr_idx] < int_min or 
            pre_order[curr_idx] > int_max):
        return

    curr_val = pre_order[curr_idx]
    incre_curr_idx()

    # explore the left subtree
    convert_pre_to_post_in(arr_size, pre_order, int_min, curr_val)
    
    # explore the right subtree
    convert_pre_to_post_in(arr_size, pre_order, curr_val, int_max)

    print(curr_val, end=' ')


if __name__ == '__main__':
    main()
