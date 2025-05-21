package com.leetcode.algorithm.输入与输出;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left,right ;
    TreeNode(int x){this.val=x;}
}
public class BinaryTreeInputAndCreate {
    public static String line;
    public static String[] parts;
    public static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StreamTokenizer in = new StreamTokenizer(br);按行读不能使用这个
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while((line=in.readLine())!=null){
            parts=line.split(" ");
            n= parts.length;
            int[] nums =new int[n];
            for (int i = 0; i <n; i++) {
                nums[i]= Integer.parseInt(parts[i]);
            }
            TreeNode head = createTree(nums);
            bfs(head);
        }
        out.flush();
        out.close();
    }
    public static TreeNode createTree(int[] nums){
        if(nums.length==0||nums[0]==-1) return null;

        TreeNode[] nodes =new TreeNode[n];
        for (int i = 0; i < n; i++) {
            if (nums[i]!=-1) nodes[i]=new TreeNode(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if(nodes[i]!=null){
                int leftIndex = 2*i+1;
                int rightIndex=2*i+2;
                if(leftIndex<n) nodes[i].left=nodes[leftIndex];
                if(rightIndex<n) nodes[i].right=nodes[rightIndex];
            }
        }
        return nodes[0];
    }

    public static void bfs(TreeNode node){
        if(node==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            System.out.println(cur.val);
            if (cur.left!=null) queue.offer(cur.left);
            if (cur.right!=null) queue.offer(cur.right);
        }
    }
}
