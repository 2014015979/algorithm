package com.leetcode.algorithm.链表;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class lc160相交链表 {
    private static  final int MAXM=30000,MAXN=30000;
    private static int m,n,skipA,skipB;
    private static int[] listA=new int[MAXM];
    private static int[] listB=new int[MAXN];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n= (int) in.nval;
            in.nextToken();
            skipA= (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                listA[i]= (int) in.nval;
            }
            in.nextToken();
            m= (int) in.nval;
            in.nextToken();
            skipB= (int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                listB[i]= (int) in.nval;
            }
            ListNode[] heads = createLinkedList();
            ListNode headA = heads[0];
            ListNode headB = heads[1];
            ListNode intersect=getintersectVal(headA,headB);
            if (intersect!=null){
                System.out.println(intersect.val);
            }else{
                System.out.println(0);
            }
        }
        out.flush();
        out.close();
    }


    private static ListNode getintersectVal(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        ListNode a=headA,b=headB;
        while(a!=b){
            a=a!=null?a.next:headB;
            b=b!=null?b.next:headA;
        }
        return a;
    }

    private static ListNode[] createLinkedList() {
        // 构造链表A
        ListNode headA = new ListNode(listA[0]);
        ListNode curA =headA;
        List<ListNode> nodesA=new ArrayList<>();
        nodesA.add(headA);
        for (int i = 1; i <n; i++) {
            curA.next=new ListNode(listA[i]);
            curA=curA.next;
            nodesA.add(curA);
        }

        //构造链表B
        ListNode headB=new ListNode(listB[0]);
        ListNode curB=headB;
        for (int i = 1; i < m; i++) {
            if (i==skipB){
                curB.next=nodesA.get(skipA);
                break;
            }else {
                curB.next=new ListNode(listB[i]);
                curB=curB.next;
            }
        }
        if (skipB==0){
            headB=nodesA.get(skipA);
        }
        return new ListNode[]{headA, headB};
    }
}
