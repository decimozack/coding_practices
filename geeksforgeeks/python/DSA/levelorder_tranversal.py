# https://practice.geeksforgeeks.org/problems/level-order-traversal/1/
"""
class Node:
    def __init__(self, value):
        self.left = None
        self.data = value
        self.right = None
"""
# Your task is to complete this function
# Function should return the level order of the tree in the form of a list of integers
def levelOrder( root ):
    # Code here
    # queue is use to queue up the nodes in order
    # this will allow us to do a breadth first traversal
    # because we will always checks the nodes in sequence
    queue = []
    final_list = []
    queue.append(root)

    while queue:
        curr_node = queue.pop(0)
        if curr_node:
            final_list.append(curr_node.data)
            queue.append(curr_node.left)
            queue.append(curr_node.right)

    return final_list
