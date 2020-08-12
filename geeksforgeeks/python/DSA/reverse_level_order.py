# https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1/
'''
class Node:
    def __init__(self,val):
        self.data = val
        self.left = None
        self.right = None
'''
from collections import deque 

def reversePrint(root):
    '''
    :param root: root of given tree.
    :return: print reverse level order traversal , no need to print next line.
    '''
    # code here
    stack = deque()
    queue = deque()

    queue.append(root)

    while queue:
        curr_node = queue.popleft()

        if curr_node:
            stack.append(curr_node.data)
            if curr_node.right:
                queue.append(curr_node.right)
            if curr_node.left:
                queue.append(curr_node.left)

    while stack:
        curr_node = stack.pop()
        print(curr_node, end=' ')
