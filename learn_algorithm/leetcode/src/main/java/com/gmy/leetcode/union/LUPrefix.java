package com.gmy.leetcode.union;

/**
 *
 */
class LUPrefix {


    int[] u;
    boolean[] add;
    int n;

    public LUPrefix(int n) {
        this.n = n;
        u = new int[n + 1];
        for (int i = 0; i < u.length; i++) {
            u[i] = i;
        }
        add = new boolean[n + 1];
        add[0] = true;
    }

    public void upload(int video) {
        add[video] = true;
        if (add[video - 1]) {
            union(video - 1, video);
        }
        if (video < n && add[video + 1]) {
            union(video, video + 1);
        }
    }

    private void union(int l, int r) {
        u[l] = find(r);
    }

    public int longest() {
        return find(0);
    }

    private int find(int i) {
        if (u[i] != i) {
            u[i] = find(u[i]);
        }
        return u[i];
    }


}
