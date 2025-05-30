package com.leetcode.algorithm.哈希;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc01两数之和 {
    private static int NMAX=10000;
    private static int n;
    private static int target;
    private static int[] nums=new int[NMAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n= (int) in.nval;
            in.nextToken();
            target= (int) in.nval;
            for (int i=0;i<n;i++){
                in.nextToken();
                nums[i]= (int) in.nval;
            }
            int[] ans=twoSum();
            System.out.println(ans[0]+" "+ans[1]);
        }
        out.flush();
        out.close();
    }

    private static int[] twoSum() {
        Map<Integer, Integer> dic = new HashMap<>();
        for (int j = 0; j < n; j++) {
            if (dic.containsKey(target-nums[j])){
                return new int[]{dic.get(target-nums[j]),j};
            }else {
                dic.put(nums[j],j);
            }
        }
        return null;
    }
}
