class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int n = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k %= n;

        if (k == 0) {
            return head;
        }

        tail.next = head;
        int count = n - k;
        ListNode newTail = head;

        for (int i = 1; i < count; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
