class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        int n = 0;
        ListNode cur = head;

        while (cur != null) {
            n++;
            cur = cur.next;
        }

        cur = head;

        for (int i = 0; i < n / 2 - 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return head;
    }
}
