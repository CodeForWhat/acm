package indi.lean.acm.bytedance;

import indi.lean.acm.common.ListNode;

public class Problem21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        while (l1 != null && l2 != null) {
            ListNode nextOne = null;
            if (l1.val < l2.val) {
                nextOne = l1;
                l1 = l1.next;
            } else {
                nextOne = l2;
                l2 = l2.next;
            }

            if (head == null) {
                head = nextOne;
            }

            if (tail != null) {
                tail.next = nextOne;
            }
            tail = nextOne;
        }

        while (l1 != null) {
            if (head == null) {
                head = l1;
            }

            if (tail != null) {
                tail.next = l1;
            }

            tail = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            if (head == null) {
                head = l2;
            }

            if (tail != null) {
                tail.next = l2;
            }

            tail = l2;
            l2 = l2.next;
        }

        return head;
    }
}
