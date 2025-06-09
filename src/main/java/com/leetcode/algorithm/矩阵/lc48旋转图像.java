package com.leetcode.algorithm.矩阵;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc48旋转图像 {
    private static final int MAXN=20;
    private static int n;
    private static int[][] matrix=new int[MAXN][MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n= (int) in.nval;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    in.nextToken();
                    matrix[i][j]= (int) in.nval;
                }
            }
            int[][] ans=rotate();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }
        }
        out.flush();
        out.close();
    }

    private static int[][] rotate() {
        int l=0,r=n-1,h=0,b=n-1;
        while(l<r||h<b){
            for(int i=0;i<r-l;i++){
                //左上《-左下《-右下《-右上《-tmp
                int tmp=matrix[h][l+i];
                matrix[h][l+i]=matrix[b-i][l];
                matrix[b-i][l]=matrix[b][r-i];
                matrix[b][r-i]=matrix[h+i][r];
                matrix[h+i][r]=tmp;
            }

            h++;
            b--;
            l++;
            r--;
        }
        return Arrays.copyOf(matrix,n);
    }
}