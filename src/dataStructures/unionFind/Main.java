package dataStructures.unionFind;

public class Main {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(5);
        unionFind.unify(4, 3);
        unionFind.unify(1, 2);
        unionFind.unify(0, 4);
        unionFind.unify(1, 0);
        System.out.println(unionFind.find(1));
        System.out.println(unionFind.isConnected(2,1));
    }
}