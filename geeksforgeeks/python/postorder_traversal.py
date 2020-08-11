# https://practice.geeksforgeeks.org/problems/postorder-traversal/1/
'''
# Node Class:
class Node:
    def __init__(self,val):
        self.data = val
        self.left = None
        self.right = None
'''

def postOrder(root):
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

