package indi.lean.acm.bytedance;



public class Problem206 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode reverse = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = reverse;
            reverse = tmp;
        }

        return reverse;
    }
}


