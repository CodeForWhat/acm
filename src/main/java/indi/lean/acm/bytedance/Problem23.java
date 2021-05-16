package indi.lean.acm.bytedance;

public class Problem23 {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        boolean[] flags = new boolean[lists.length];
        ListNode head = null, tail = null;
        int nullCounter = 0;

        while (nullCounter < lists.length) {
            int idxOfMaxValueNode = -1, minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (!flags[i] && lists[i] == null) {
                    nullCounter++;
                    flags[i] = true;
                }

                if (lists[i] != null && lists[i].val < minValue) {
                    idxOfMaxValueNode = i;
                    minValue = lists[i].val;
                }
            }

            if (idxOfMaxValueNode >= 0 && idxOfMaxValueNode < lists.length) {
                if (head == null) {
                    tail = head = lists[idxOfMaxValueNode];
                } else {
                    tail.next = lists[idxOfMaxValueNode];
                    tail = lists[idxOfMaxValueNode];
                }
                lists[idxOfMaxValueNode] = lists[idxOfMaxValueNode].next;
            }
        }
        return head;
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

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[] {
                fromArray(new int[0]),
                fromArray(new int[] {-1, 5, 11}),
                fromArray(new int[0]),
                fromArray(new int[] {6, 10})
        };

        ListNode listNode = mergeKLists(lists);
        printNodes(listNode);
    }

    private static void printNodes(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
    }
}
