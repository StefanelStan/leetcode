package com.ss.leetcode.playground;

public class StartPlayground {
    public static void main(String[] args) {
        StartPlayground start = new StartPlayground();

//        start.quickFind();
        start.quickUnion();
    }

    public void quickFind() {
        QuickFind qf = new QuickFind(10, new int[][]{{1,0},{3,1},{2,0},{4,8},{7,5},{5,6}});

        System.out.println("2 == " + qf.find(3));
        System.out.println("2 == " + qf.find(2));
        System.out.println("4 == " + qf.find(4));
        System.out.println("4 == " + qf.find(8));
        System.out.println("9 == " + qf.find(9));
        System.out.println("7 == " + qf.find(5));
        System.out.println("true == " + qf.areConnected(3,2));
        System.out.println("true == " + qf.areConnected(1,2));
        System.out.println("true == " + qf.areConnected(7,6));
        System.out.println("false == " + qf.areConnected(3,6));
        System.out.println("false == " + qf.areConnected(1,9));
        System.out.println("false == " + qf.areConnected(8,7));
    }

    public void quickUnion() {
//        QuickUnion qu = new QuickUnion(10, new int[][]{{1,0},{3,1},{2,0},{4,8},{7,5},{5,6}});
        QuickUnion qu = new QuickUnion(10, new int[][]{{0,1},{0,2},{1,3},{4,8},{5,7},{5,6}});

        System.out.println("2 == " + qu.find(3));
        System.out.println("2 == " + qu.find(2));
        System.out.println("4 == " + qu.find(4));
        System.out.println("4 == " + qu.find(8));
        System.out.println("9 == " + qu.find(9));
        System.out.println("7 == " + qu.find(5));
        System.out.println("true == " + qu.areConnected(3,2));
        System.out.println("true == " + qu.areConnected(1,2));
        System.out.println("true == " + qu.areConnected(7,6));
        System.out.println("false == " + qu.areConnected(3,6));
        System.out.println("false == " + qu.areConnected(1,9));
        System.out.println("false == " + qu.areConnected(8,7));

        qu.connect(9, 4);
        System.out.println("true == " + qu.areConnected(9,4));
        System.out.println("true == " + qu.areConnected(9,8));
    }
}
