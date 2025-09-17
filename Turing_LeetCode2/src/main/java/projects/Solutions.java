package projects;


public class Solutions {

    //LeetCode 206. Reverse LL
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode pre = null;

        while(temp != null){
            ListNode nextNode = temp.next;
            temp.next = pre;
            pre = temp;
            temp = nextNode;
        }
        return pre;
    }

    //LeetCode 21. Merge Two Sorted List
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(list1 != null && list2 != null){
            if(list1.val<=list2.val){
                temp.next =list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 == null) temp.next = list2;
        if(list2 == null) temp.next = list1;

        return dummy.next;

    }
}
