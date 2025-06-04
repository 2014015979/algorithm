package com.leetcode.algorithm.普通数组;

import java.io.*;

public class lc53最大数子组和_dp {
    private static int MAXN=100000;
    private static int n;
    private static int[] nums=new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n= (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                nums[i]= (int) in.nval;
            }
            out.println(maxSubArray());
            out.flush();
        }
        out.flush();
        out.close();
    }

    private static int maxSubArray() {
        int ans=nums[0];
        for (int i = 1,pre=nums[0]; i < n; i++) {
            //pre是负数选nums[i]
            pre=Math.max(pre+nums[i],nums[i]);
            ans=Math.max(ans,pre);
        }
        return ans;
    }
}
