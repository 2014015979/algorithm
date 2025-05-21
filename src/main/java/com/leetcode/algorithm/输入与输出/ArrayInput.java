package com.leetcode.algorithm.输入与输出;

import javax.print.DocFlavor;
import java.io.*;

public class ArrayInput {
    private static int MAXN=10000;
    private static int n;
    private static int[] nums=new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n=(int)in.nval;
            for(int i=0;i<n;i++){
                in.nextToken();
                nums[i]= (int) in.nval;
            }
            arraySum();
        }
        out.flush();
        out.close();
    }

    private static void arraySum(){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        System.out.println(sum);
    }
}
