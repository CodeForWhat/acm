package indi.lean.acm.bytedance;

public class Problem92 {
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE), interTail = null, newTail = newHead, cur = head;

        int counter = 1;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;

            if (counter >= left && counter <= right) {
                if (counter == left) {
                    interTail = newTail;
                    newTail = tmp;
                }

                tmp.next = interTail.next;
                interTail.next = tmp;
            } else {
                tmp.next = newTail.next;
                newTail.next = tmp;
                newTail = tmp;
            }
            counter++;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = fromArray(new int[]{5});
        listNode = reverseBetween(listNode, 1, 1);
        printNodes(listNode);
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
}
