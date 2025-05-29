package com.leetcode.algorithm.双指针;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15三数之和 {
    private static int NMAX=3000;
    private static int n;
    private static int[] nums=new int[NMAX];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(bf);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
           n=(int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                nums[i]=(int) in.nval;
            }
            List<List<Integer>> res=threeSum();
            for (List<Integer> triplet : res) {
                for (Integer num : triplet) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
        out.flush();
        out.close();
    }

    private static List<List<Integer>> threeSum() {
        Arrays.sort(nums,0,n);
        List<List<Integer>> ans=new ArrayList<>();
        if(nums==null||n<3) return ans;
        for(int i=0;i<n;i++){
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int j=i+1,k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if (sum==0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k&&nums[j]==nums[j+1]) j++;
                    while(j<k&&nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }else if (sum<0){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return ans;
    }
}
