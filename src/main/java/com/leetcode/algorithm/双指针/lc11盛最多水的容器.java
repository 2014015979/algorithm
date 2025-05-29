package com.leetcode.algorithm.双指针;

import java.io.*;

public class lc11盛最多水的容器 {
    private static int MAXN=100000;
    private  static int n;
    private static int[] height=new int[MAXN];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int)in.nval;
            for (int i=0;i<n;i++){
                in.nextToken();
                height[i]=(int)in.nval;
            }
            System.out.println(maxArea());
        }
        out.flush();
        out.close();
    }

    private static int maxArea() {
        int i=0,j= height.length-1,sum=0;
        while (i!=j){
            if (height[i]<height[j]){
                sum=Math.max(sum,height[i]*(j-i));
                i++;
            }else{
                sum=Math.max(sum,height[j]*(j-i));
                j--;
            }
        }
        return sum;
    }
}
