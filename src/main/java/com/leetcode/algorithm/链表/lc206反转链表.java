package com.leetcode.algorithm.链表;

import java.io.*;



public class lc206反转链表 {
    private static  final int MAXN=5000;
    private static int n;
    private static int[] list=new int[MAXN];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n= (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                list[i]= (int) in.nval;
            }
            ListNode head= createLinkedList();
            ListNode ans= reverseList(head);
            printLinkedList(ans);
        }
        out.flush();
        out.close();
    }

    private static void printLinkedList(ListNode ans) {
        ListNode cur=ans;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre=null, next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    private static ListNode createLinkedList() {
        ListNode head=new ListNode(list[0]);
        ListNode cur=head;
        for (int i = 1; i < n; i++) {
            cur.next=new ListNode(list[i]);
            cur=cur.next;
        }
        return head;
    }
}
