// https://leetcode.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode newHead = null;
       
        ListNode currPointer = null;

        if (l1.val <= l2.val) {
            newHead = l1;
            l1 = l1.next;
        } else {
            newHead = l2;
            l2 = l2.next;
        }

        currPointer = newHead;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                currPointer.next = l1;
                l1 = l1.next;
            } else {
                currPointer.next = l2;
                l2 = l2.next;
            }

            currPointer = currPointer.next;
        }

        if (l1 != null) {
            currPointer.next = l1;
        } else {
            currPointer.next = l2;
        }

        return newHead;
    }
}
