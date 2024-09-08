package com.ss.leetcode.playground;

public class StartPlayground {
    public static void main(String[] args) {
        StartPlayground start = new StartPlayground();

//        start.addNumerical();
//        start.quickFind();
//        start.quickUnion();
//        start.unionByRank();
//        start.pathCompression();
//        start.pathCompressionUnionByRank();
//        start.dfsGraph();
//        start.fenwickTree();
//        start.topologicalSort();
//        start.kahnTopologicalSort();
        start.dijkstra();
//        start.bellmanFord();
    }

    public void addNumerical() {
        AddNumerical an = new AddNumerical();

        System.out.println("22 == " + an.sumOfSubStringIntegers("ab+10+ced1>:{11#$%^"));
        System.out.println("20 == " + an.sumOfSubStringIntegers("ab+10+ced-1>:{11#$%^"));
        System.out.println("0 == " + an.sumOfSubStringIntegers("ab++ced->:{#$%^"));
        System.out.println("0 == " + an.sumOfSubStringIntegers("ab++c0ed->:{#$%^"));
        System.out.println("0 == " + an.sumOfSubStringIntegers("ab++-c0ed->:{#$%^"));
        System.out.println("4 == " + an.sumOfSubStringIntegers("ab++-c0ed->:{#$%^4"));
        System.out.println("-4 == " + an.sumOfSubStringIntegers("ab++-c0ed->:{#$%^-4"));
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
        QuickUnion qu = new QuickUnion(10, new int[][]{{0,1},{0,2},{1,3},{4,8},{5,7},{5,6}});

        System.out.println("0 == " + qu.find(3));
        System.out.println("0 == " + qu.find(2));
        System.out.println("4 == " + qu.find(4));
        System.out.println("4 == " + qu.find(8));
        System.out.println("9 == " + qu.find(9));
        System.out.println("5 == " + qu.find(5));
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

    public void unionByRank() {
        UnionByRank ubr = new UnionByRank(10, new int[][]{{0,1},{0,2},{1,3},{4,8},{5,7},{5,6}});

        System.out.println("0 == " + ubr.find(3));
        System.out.println("0 == " + ubr.find(2));
        System.out.println("4 == " + ubr.find(4));
        System.out.println("4 == " + ubr.find(8));
        System.out.println("9 == " + ubr.find(9));
        System.out.println("5 == " + ubr.find(5));
        System.out.println("true == " + ubr.areConnected(3,2));
        System.out.println("true == " + ubr.areConnected(1,2));
        System.out.println("true == " + ubr.areConnected(7,6));
        System.out.println("false == " + ubr.areConnected(3,6));
        System.out.println("false == " + ubr.areConnected(1,9));
        System.out.println("false == " + ubr.areConnected(8,7));

        ubr.connect(9, 4);
        System.out.println("true == " + ubr.areConnected(9,8));
        System.out.println("true == " + ubr.areConnected(9,4));
        System.out.println("true == " + ubr.areConnected(4,9));
    }

    public void pathCompression() {
        PathCompression pc = new PathCompression(10, new int[][]{{0,1},{0,2},{1,3},{4,8},{5,7},{5,6}});
/**
        System.out.println("0 == " + pc.find(3));
        System.out.println("0 == " + pc.find(2));
        System.out.println("4 == " + pc.find(4));
        System.out.println("4 == " + pc.find(8));
        System.out.println("9 == " + pc.find(9));
        System.out.println("5 == " + pc.find(5));
        System.out.println("true == " + pc.areConnected(3,2));
        System.out.println("true == " + pc.areConnected(1,2));
        System.out.println("true == " + pc.areConnected(7,6));
        System.out.println("false == " + pc.areConnected(3,6));
        System.out.println("false == " + pc.areConnected(1,9));
        System.out.println("false == " + pc.areConnected(8,7));

        pc.connect(9, 4);
        System.out.println("true == " + pc.areConnected(9,8));
        System.out.println("true == " + pc.areConnected(9,4));
        System.out.println("true == " + pc.areConnected(4,9));
*/
        pc = new PathCompression(4, new int[][]{{0,3},{1,2},{0,2}});
        System.out.println("true == " + pc.areConnected(0, 1));
        System.out.println("true == " + pc.areConnected(2, 1));
        System.out.println("true == " + pc.areConnected(3, 1));
    }

    public void pathCompressionUnionByRank() {
        PathCompressionUnionByRank ppubr = new PathCompressionUnionByRank(10, new int[][]{{0,1},{0,2},{1,3},{4,8},{5,7},{5,6}});

        System.out.println("0 == " + ppubr.find(3));
        System.out.println("0 == " + ppubr.find(2));
        System.out.println("4 == " + ppubr.find(4));
        System.out.println("4 == " + ppubr.find(8));
        System.out.println("9 == " + ppubr.find(9));
        System.out.println("5 == " + ppubr.find(5));
        System.out.println("true == " + ppubr.areConnected(3,2));
        System.out.println("true == " + ppubr.areConnected(1,2));
        System.out.println("true == " + ppubr.areConnected(7,6));
        System.out.println("false == " + ppubr.areConnected(3,6));
        System.out.println("false == " + ppubr.areConnected(1,9));
        System.out.println("false == " + ppubr.areConnected(8,7));

        ppubr.connect(9, 4);
        System.out.println("true == " + ppubr.areConnected(9,4));
        System.out.println("true == " + ppubr.areConnected(9,8));
    }

    public void dfsGraph() {
        DfsTraversal dt = new DfsTraversal(8, new int[][]{{0,1},{0,2},{0,3},{1,4},{2,5},{3,6},{4,7},{5,7},{6,7}});

        System.out.println("[0,1,2,3,4,5,6,7]== " + dt.traverse());
    }

    public void fenwickTree() {
        FenwickTree ft = new FenwickTree(new int[]{2, 21, 12, 31, 22, 33, 40, 15, 60, 17, 18, 19});

        int total = ft.getPrefixSum(6);
        System.out.println("Sum of the elements in array a[0 ... 6]" + " is: " + total);
        System.out.println("64 == " + ft.getRangeSum(1,3));
        ft.updateFenwick(3, 1);
        total = ft.getPrefixSum(6);
        System.out.println("Sum of the elements in array a[0 ... 6] after update is: " + total);

    }

    public void topologicalSort() {
        DFSTopologicalSort ts = new DFSTopologicalSort(10, new int[][]{{0,1},{5,8},{8,9},{3,5},{1,4},{5,7},{1,3},{0,2},{5,6},{7,8},{1,2}});
        System.out.println(ts.getTopologicalSort());
    }

    public void kahnTopologicalSort() {
//        KahnTopologicalSort kts = new KahnTopologicalSort(7, new int[][]{{0, 1},{0,4},{0,6}, {2,6},{3,1}, {3,5},{3,6},{4,3},{4,6}});
//        System.out.println(kts.getTopologicalSort());

        KahnTopologicalSort kts = new KahnTopologicalSort(7, new int[][]{{1, 0},{0,4},{0,6}, {2,6},{3,1}, {3,5},{3,6},{4,3},{4,6}});
        System.out.println(kts.getTopologicalSort());
    }

    public void dijkstra() {
        Dijkstra dijkstra = new Dijkstra();

        int[][] edges = {{3,5,20},{0,3,40},{4,5,25},{1,3,20},{0,1,5},{1,4,25},{2,5,30},{0,2,35},{4,3,45},{2,4,30}};
        int[][] edgesWithNegativeCost = {{3,5,20},{0,3,40},{4,5,25},{1,3,20},{0,1,5},{1,4,25},{2,5,30},{0,2,35},{4,3,45},{2,4,-30}};

        System.out.println("45 == " + dijkstra.shortestPathCost(6, edges, 0, 5));
        System.out.println("45 == " + dijkstra.shortestPathCost(6, edgesWithNegativeCost, 0, 5));
        System.out.println("25 == " + dijkstra.shortestPathCost(6, edges, 0, 3));
        System.out.println("2147483647 == " + dijkstra.shortestPathCost(6, edges, 1, 2));
    }

    public void bellmanFord() {
        BellmanFord bellmanFord = new BellmanFord();

        int[][] edges = {{3,5,20},{0,3,40},{4,5,25},{1,3,20},{0,1,5},{1,4,25},{2,5,30},{0,2,35},{4,3,45},{2,4,30}};
        int[][] edgesWithNegativeCost = {{3,5,20},{0,3,40},{4,5,25},{1,3,20},{0,1,5},{1,4,25},{2,5,30},{0,2,35},{4,3,45},{2,4,-30}};

        System.out.println("45 == " + bellmanFord.shortestPathCost(6, edges, 0, 5));
        System.out.println("30 == " + bellmanFord.shortestPathCost(6, edgesWithNegativeCost, 0, 5));
        System.out.println("25 == " + bellmanFord.shortestPathCost(6, edges, 0, 3));
        System.out.println("2147483647 == " + bellmanFord.shortestPathCost(6, edges, 1, 2));
    }
}
