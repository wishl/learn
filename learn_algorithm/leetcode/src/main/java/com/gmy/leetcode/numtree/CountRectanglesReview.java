package com.gmy.leetcode.numtree;

import java.util.Arrays;

public class CountRectanglesReview {

    int[] tree=new int[101];//Y
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n=rectangles.length,m=points.length,p=0;
        int[] count=new int[m];
        int[][] ps=new int[m][3];
        for(int i=0;i<m;i++){
            ps[i]=new int[]{points[i][0],points[i][1],i};
        }
        Arrays.sort(rectangles,(o1, o2)->o2[0]-o1[0]);
        Arrays.sort(ps,(o1,o2)->o2[0]-o1[0]);
        for(int i=0;i<m;i++){
            int x=ps[i][0];
            while(p<n&&rectangles[p][0]>=x){
                update(rectangles[p][1]);
                p++;
            }
            count[ps[i][2]]=p-query(ps[i][1]-1);
        }
        return count;
    }
    public void update(int y){
        while(y<=100){
            tree[y]++;
            y+=lowBit(y);
        }
    }
    public int query(int y){//1-y
        int c=0;
        while(y>0){
            c+=tree[y];
            y-=lowBit(y);
        }
        return c;
    }
    public int lowBit(int y){
        return y&(-y);
    }

}
