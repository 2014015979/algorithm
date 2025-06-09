package com.leetcode.algorithm.链表;

import java.io.*;

public class lc21合并两个有序链表 {
    private static  final int MAXM=50,MAXN=50;
    private static int m,n,T;
    private static int[] listA=new int[MAXM];
    private static int[] listB=new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            T= (int) in.nval;
            for (int j=0;j<T;j++) {
                in.nextToken();
                n= (int) in.nval;
                for (int i = 0; i < n; i++) {
                    in.nextToken();
                    listA[i]= (int) in.nval;
                }
                in.nextToken();
                m= (int) in.nval;
                for (int i = 0; i < m; i++) {
                    in.nextToken();
                    listB[i] = (int) in.nval;
                }
                ListNode headA = createLinkedList(listA,n);
                ListNode headB = createLinkedList(listB,m);
                ListNode ans = mergeTwoLists(headA,headB);
                printLinkedList(ans);

            }
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
    private static ListNode mergeTwoLists(ListNode headA,ListNode headB) {
        if(headA==null||headB==null){
            return headA==null?headB:headA;
        }
        ListNode head=headA.val<= headB.val?headA:headB;
        ListNode c1=head.next;
        ListNode c2=head==headA?headB:headA;
        ListNode pre=head;
        while(c1!=null&&c2!=null){
            if(c1.val<=c2.val){
                pre.next=c1;
                c1=c1.next;
                pre=pre.next;
            }else {
                pre.next=c2;
                c2=c2.next;
                pre=pre.next;
            }
        }
        pre.next=c1==null?c2:c1;
        return head;
    }

    private static ListNode createLinkedList(int[] list,int nums) {
        if (nums==0) return null;
        ListNode head=new ListNode(list[0]);
        ListNode cur=head;
        for (int i = 1; i < nums; i++) {
            cur.next=new ListNode(list[i]);
            cur=cur.next;
        }
        return head;
    }
}

