package codility.lessons;




public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode listNode9 = new ListNode(10);
        ListNode listNode8 = new ListNode(8, listNode9);

        ListNode listNode5 = new ListNode(5, listNode8);

        ListNode listNode1 = new ListNode(1, listNode5);

        ListNode listNode4 = new ListNode(8);
        ListNode listNode3 = new ListNode(5, listNode4);
        ListNode listNode2 = new ListNode(1, listNode3);

        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode mergedList = mergeTwoSortedList.mergeTwoLists(listNode1, listNode2);

        while (mergedList != null) {
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}