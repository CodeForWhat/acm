package indi.lean.acm.bytedance;

import indi.lean.acm.common.ListNode;

import static indi.lean.acm.common.ListNodeFactory.createListNodes;
import static indi.lean.acm.common.ListNodeFactory.printListNodes;

public class Problem02 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int overflow = 0;
        ListNode cursor = null;
        while (l1 != null || l2 != null) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
            }

            if (l2 != null) {
                temp += l2.val;
            }

            temp += overflow;

            overflow = temp / 10;
            temp = temp % 10;

            if (cursor == null) {
                cursor = new ListNode(temp, null);
                result = cursor;
            } else {
                cursor.next = new ListNode(temp, null);
                cursor = cursor.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (overflow > 0) {
            cursor.next = new ListNode(overflow, null);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] array1 = {2,4,3};
//        int[] array2 = {5,6,4};

        int[] array1 = {1, 2, 3};
        int[] array2 = {9, 8, 7};
        ListNode node1 = createListNodes(array1);
        ListNode node2 = createListNodes(array2);
        ListNode listNode = addTwoNumbers(node1, node2);
        printListNodes(listNode);
    }

}
