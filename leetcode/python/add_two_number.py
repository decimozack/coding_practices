# Definition for singly-linked list.
class ListNode(object):
     def __init__(self, x):
         self.val = x
         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
    
        """
        l3 = ListNode(0)
        
        curr = l3
        
        while not l1 is None or not l2 is None:
            
            next_digit = 0
            
            if l1 and l2:
                
                new_val = l1.val + l2.val
                
                new_val = new_val + curr.val
                    
            else:
                if l1:
                    new_val = curr.val + l1.val
                elif l2:
                    new_val = curr.val + l2.val
                
            if new_val > 9:
                    
                curr.val = (new_val % 10)
                next_digit = new_val // 10
            else:
                curr.val = new_val
            
            if next_digit > 0 or  (next_digit == 0 and ((l1 and l1.next) or (l2 and l2.next))):
                new_node = ListNode(next_digit)
                curr.next = new_node
                curr = new_node
                
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
            
            
           
           
        
       #  while not l3 is None:
       #     if not l3.next is None:
       #         print(str(l3.val) + '->')
       #     else:
       #         print(l3.val)
       #     l3 = l3.next
        
        return l3
                
                
        
