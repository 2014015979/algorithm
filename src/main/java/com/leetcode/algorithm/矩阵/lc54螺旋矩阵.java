package com.leetcode.algorithm.矩阵;



import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc54螺旋矩阵 {
    private static final int MAXM=10,MAXN=10;
    private static int m,n;
    private static int[][] matrix=new int[MAXM][MAXN];

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
                    matrix[i][j]= (int) in.nval;
                }
            }
            List<Integer> ans=spiralOrder();
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }
        out.flush();
        out.close();
    }

    private static List<Integer> spiralOrder() {
        if (m == 0 || n == 0) return new ArrayList<>();
        int l=0,r=n-1,h=0,b=m-1;
        int i=0;
        Integer[] res= new Integer[n * m];
        while(true){
            for (int x = l; x <= r; x++) res[i++]=matrix[h][x];
            if (++h>b) break;
            for (int x = h; x <= b; x++) res[i++]=matrix[x][r];
            if (--r<l) break;
            for (int x = r; x >= l; x--) res[i++]=matrix[b][x];
            if (--b<h) break;
            for (int x = b; x >=h ; x--) res[i++]=matrix[x][l];
            if (++l>r) break;
        }
        return Arrays.asList(res);
    }
}
