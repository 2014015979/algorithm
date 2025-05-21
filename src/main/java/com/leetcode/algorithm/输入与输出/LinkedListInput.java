package com.leetcode.algorithm.输入与输出;


import java.io.*;

// 定义链表节点
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListInput {
    public static int MAXN=10000;

    public static int n;

    public static int[] nums=new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));;
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int)in.nval;
            for(int i=0;i<n;i++){
                in.nextToken();
                nums[i]=(int)in.nval;
            }
            ListNode head = createLinkedList();  // 创建链表
            printLinkedList(head);  // 遍历链表并输出
        }
        out.flush();
        out.close();
    }

    // 创建链表
    public static ListNode createLinkedList() {
        if (n<=1) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }

    // 遍历并输出链表
    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
//import java.util.Scanner;
//
//// 定义链表节点
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
//
//public class Main {
//    // 创建链表
//    public static ListNode createLinkedList(int[] nums) {
//        if (nums.length == 0) return null;
//
//        ListNode head = new ListNode(nums[0]);
//        ListNode curr = head;
//        for (int i = 1; i < nums.length; i++) {
//            curr.next = new ListNode(nums[i]);
//            curr = curr.next;
//        }
//        return head;
//    }
//
//    // 遍历并输出链表
//    public static void printLinkedList(ListNode head) {
//        ListNode curr = head;
//        while (curr != null) {
//            System.out.println(curr.val);
//            curr = curr.next;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();  // 读取数组长度
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();  // 读取数组元素
//        }
//
//        ListNode head = createLinkedList(nums);  // 创建链表
//        printLinkedList(head);  // 遍历链表并输出
//
//        sc.close();
//    }
//}


