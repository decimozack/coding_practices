# https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1/
'''
class Node:
    def init(self, val):
        self.right = None
        self.data = val
        self.left = None
'''
# your task is to complete this function
# function should print the level order traversal of the binary tree in spiral order
# Note: You aren't required to print a new line after every test case
from collections import deque
def printSpiral(root):
    # Code here
    
    queue = deque()
    stack = deque()
    level = 1

    queue.append(root)
    queue.append(None)
    if root:
        stack.append(root.data)
    else:
        return

    while queue:
        curr_node = queue.popleft()

        if curr_node:
            
            if curr_node.left:
                queue.append(curr_node.left)
                if level % 2 == 0:
                    stack.append(curr_node.left.data)
            if curr_node.right:
                queue.append(curr_node.right)
                if level % 2 == 0:
                    stack.append(curr_node.right.data)
        
            if level % 2 == 0:
                print(curr_node.data, end=' ')
            else:
                stack_data = stack.pop()
                print(stack_data, end=' ')
        else:
            if queue:
                queue.append(None)
            level += 1
