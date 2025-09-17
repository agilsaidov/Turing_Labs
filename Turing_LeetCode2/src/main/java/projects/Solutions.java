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
}
