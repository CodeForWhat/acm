package indi.lean.acm.bytedance;


public class Problem25 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null, newTail = null, curPre = head, curAfter = head;

        while (curAfter != null) {
            int step = k;
            while (curAfter != null && step > 0) {
                curAfter = curAfter.next;
                step--;
            }

            if (step == 0) {
                ListNode tmpHead = null, tmpTail = curPre;
                while (curPre != curAfter) {
                    ListNode tmp = curPre;
                    curPre = curPre.next;
                    tmp.next = tmpHead;
                    tmpHead = tmp;
                }
                
                if (newHead == null) {
                    newHead = tmpHead;
                }

                if (newTail != null) {
                    newTail.next = tmpHead;
                }
                newTail = tmpTail;
            } else {
                if (newTail != null) {
                    newTail.next = curPre;
                }
            }
        }
        
        return newHead;
    }

    private static ListNode createListNodes(int[] array1) {
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

    private static void printListNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode listNode = reverseKGroup(createListNodes(array), 2);
        printListNodes(listNode);
    }
}
