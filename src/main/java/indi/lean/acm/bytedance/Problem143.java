package indi.lean.acm.bytedance;

public class Problem143 {
    private static class ListNode {
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

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode cur = head;
        int counter = 0;
        while (cur != null) {
            counter++;
            cur = cur.next;
        }

        ListNode[] nodePos = new ListNode[counter];
        cur = head;
        for (int i = 0; i < counter; i++) {
            nodePos[i] = cur;
            cur = cur.next;
        }

        ListNode pre = head, after = pre.next;

        counter--;
        while (after != null && pre != nodePos[counter] && after != nodePos[counter]) {
            nodePos[counter].next = after;
            pre.next = nodePos[counter];
            pre = after;
            after = pre.next;
            nodePos[counter - 1].next = null;
            counter--;
        }
    }

    private static ListNode fromArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        ListNode head = null, tail = null;
        for (int j : array) {
            ListNode node = new ListNode(j);
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    private static void printNodes(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = fromArray(new int[]{1, 2, 3, 4, 5});
        reorderList(listNode);
        printNodes(listNode);
    }
}
