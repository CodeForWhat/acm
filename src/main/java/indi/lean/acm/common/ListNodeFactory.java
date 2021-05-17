package indi.lean.acm.common;

public class ListNodeFactory {
    public static ListNode createListNodes(int[] array1) {
        ListNode result = null;
        ListNode cursor = null;
        for (int i : array1) {

            if (cursor == null) {
                cursor = new ListNode(i, null);
                result = cursor;
            } else {
                cursor.next = new ListNode(i, null);
                cursor = cursor.next;
            }
        }
        return result;
    }

    public static void printListNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }
}
