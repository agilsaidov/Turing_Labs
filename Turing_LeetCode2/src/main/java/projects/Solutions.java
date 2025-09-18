package projects;


import java.util.ArrayList;
import java.util.Collections;
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

    // LeetCode 217. Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int a : nums){
            list.add(a);
        }

        Collections.sort(list);
        for(int i = 1 ; i< list.size(); i++){
            if(list.get(i).equals(list.get(i-1))){
                return true;
            }
        }

        return false;
    }

    // LeetCode 125. Valid Palindrome
    public boolean isPalindrome(String s) {

        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(cleaned);
        return cleaned.equals(sb.reverse().toString());

    }

    // LeetCode 2. Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        int sum = 0;
        int carry = 0;
        ListNode current = start;

        while(l1 != null || l2 != null || carry != 0) {
            int val1 = 0;
            int val2 = 0;

            if(l1 != null){
                val1 = l1.val;
            }else {
                val1 = 0;
            }

            if(l2 != null){
                val2 = l2.val;
            }else {
                val2 = 0;
            }

            sum = val1 + val2 + carry;
            carry = sum/10;

            current.next = new ListNode(sum%10);
            current = current.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return start.next;
    }

    //LeetCode 11. Container With Most Water
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while(right>left){

            int width = right-left;
            int heigh = Math.min(height[left], height[right]);
            maxArea = Math.max(width*heigh, maxArea);

            if (height[left] > height[right]) right--;
            else left++;
        }
        return maxArea;
    }


    //LeetCode 82. Remove Duplicates from Sorted List 2
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }

}
