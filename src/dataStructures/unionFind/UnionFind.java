package dataStructures.unionFind;

public class UnionFind {
    private int size;
    private int numbOfComponents;
    private int id[];
    private int sz[];

    UnionFind(int size) {
        if (size < 0) throw new IllegalArgumentException("size is less than null");
        this.size = numbOfComponents = size;
        id = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        if (p < 0 || p >= size)
            throw new IllegalArgumentException("element shouldn't be less than null or more than total size");
        int root = p;
        while (root != id[root])
            root = id[root];

        while (id[p] != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public int size() {
        return size;
    }

    public int getNumbOfComponents() {
        return numbOfComponents;
    }

    public int componentSize(int p) {
        return sz[find(p)];
    }

    public void unify(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        if (root1 == root2) return;

        if (sz[root1] > sz[root2]) {
            id[root2] = root1;
            sz[root1] += sz[root2];
            sz[root2] = 0;
        } else {
            id[root1] = root2;
            sz[root2] += sz[root1];
            sz[root1] = 0;
        }
        numbOfComponents--;
    }


}
