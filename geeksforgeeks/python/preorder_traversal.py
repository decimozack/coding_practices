https://practice.geeksforgeeks.org/problems/preorder-traversal/1/


# Node Class:
class Node:
    def _init_(self,val):
        self.data = val
        self.left = None
        self.right = None

def preorder(root):
    '''
    :param root: root of the given tree.
    :return: a list containing pre order Traversal of the given tree.
    {
        class Node:
        def _init_(self,val):
            self.data = val
            self.left = None
            self.right = None
    }
    '''
    # code here
    if root is None:
        return []
    if root.left is None and root.right is None:
        return [root.data]
    
    final_list = [root.data]
    left_list = preorder(root.left)
    right_list = preorder(root.right)
    
    final_list.extend(left_list + right_list)

    return final_list
