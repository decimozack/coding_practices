# https://practice.geeksforgeeks.org/problems/inorder-traversal/1

# Node Class:
class Node:
    def init(self,val):
        self.data = val
        self.left = None
        self.right = None

# Return a list containing the inorder traversal of the given tree
def InOrder(root):
    # code here
    if root is None:
        return []
    if root.left is None and root.right is None:
        return [root.data]
   
    left_list = InOrder(root.left)
    right_list = InOrder(root.right)
    
    final_list = left_list + [root.data] + right_list
    return final_list
