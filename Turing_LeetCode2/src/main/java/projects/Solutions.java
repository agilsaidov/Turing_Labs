package projects;


import java.util.ArrayList;
import java.util.List;

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

    //LeetCode 141.LinkedListCycle
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode single = head;
        ListNode doublee = head.next;

        while(single != doublee){
            if(doublee == null || doublee.next == null) return false;

            single = single.next;
            doublee = doublee.next.next;
        }
        return true;
    }

    // LeetCode 1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }

        int[] indices = new int[2];
        for(int i = 0; i<nums.length; i++){
            int num = target - nums[i];

            if(list.contains(num)){
                int j = list.indexOf(num);

                if(j != i){
                    indices[0] = i;
                    indices[1] = j;
                }
            }

        }
        return indices;
    }

    // LeetCode 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for(int price : prices){
            if(price < min){
                min = price;
            }else if(price - min > maxProfit){
                maxProfit = price - min;
            }
        }
        return maxProfit;
    }

}
