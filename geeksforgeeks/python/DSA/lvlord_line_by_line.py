# https://www.geeksforgeeks.org/level-order-traversal-line-line-set-3-using-one-queue
'''
class Node:
    def _init_(self,val):
        self.data = val
        self.left = None
        self.right = None
'''


def levelOrder(root):

    '''
    :param root: root of given tree.
    :return: print the level order traversal , no need to print next line.
    '''
    # code here
    queue = []
    queue.append(root)
    queue.append(None)
    
    if not root:
        return

    while queue:
        curr_node = queue.pop(0)

        if not curr_node:
            print('$', end=' ')
            if queue:
                queue.append(None)
            continue

        print(curr_node.data, end=' ')
        if curr_node.left:
            queue.append(curr_node.left)

        if curr_node.right:
            queue.append(curr_node.right)
