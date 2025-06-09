package com.leetcode.algorithm.矩阵;

import java.io.*;

public class lc240搜索二维矩阵II {
    private static final int MAXM=300,MAXN=300;
    private static int m,n;
    private static long[][] matrix =new long[MAXM][MAXN];
    private static long target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            m= (int) in.nval;
            in.nextToken();
            n= (int) in.nval;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    in.nextToken();
                    matrix[i][j]= (long) in.nval;
                }
            }
            in.nextToken();
            target= (long) in.nval;
            out.println(searchMatrix());
            out.flush();
        }
        out.close();
    }

    private static boolean searchMatrix() {
        int i=m-1,j=0;
        while(i>=0&&j<=n-1){
            if(matrix[i][j]>target){
                i--;
            }else if(matrix[i][j]<target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }
}
