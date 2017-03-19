/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //split
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        //sort each
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        //merge
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = l1;
        ListNode prev1 = dummyHead, curr1 = l1, curr2 = l2;
        while (curr1 != null && curr2 != null) {
            if (curr2.val < curr1.val) {
                ListNode temp = curr2.next;
                //insert curr2 before curr1
                prev1.next = curr2;
                curr2.next = curr1;
                //reset prev1
                prev1 = curr2;
                //move forward curr2
                curr2 = temp;
            } else {
                prev1 = curr1;
                curr1 = curr1.next;
            }
        }
        if (curr2 != null) prev1.next = curr2;
        l1 = dummyHead.next;
        dummyHead.next = null;
        return l1;
    }
}
