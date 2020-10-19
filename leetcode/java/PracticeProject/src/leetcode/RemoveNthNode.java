// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
package leetcode;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int delIdx = count - n;
        int currIdx = 0;

        if (delIdx == 0) {
            head = head.next;
            return head;
        }

        curr = head;
        while (curr != null) {

            if (currIdx + 1 == delIdx) {
                curr.next = curr.next.next;
                break;
            }

            curr = curr.next;
            currIdx++;
        }

        return head;
    }

    public ListNode removeNthFromEndOnePass(ListNode head, int n) {

        ListNode curr = head;
        ListNode prev = head;

        int count = 0;

        while (curr != null) {

            if (count >= n && curr.next != null) {
                prev = prev.next;
            }
            count++;
            curr = curr.next;
        }

        if (count == n) {
            head = head.next;
        } else {
            prev.next = (prev.next == null) ? prev.next : prev.next.next;
        }
        return head;
    }
}
