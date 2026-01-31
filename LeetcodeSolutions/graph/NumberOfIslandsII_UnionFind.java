package graph;

import java.util.*;

/*
Problem Statement:
You are given an empty 2D binary grid of size m x n. The grid represents a 
map where 0 is water and 1 is land. Initially, all cells are water.
You are given an array positions where positions[i] = [ri, ci] is the position 
to perform the addLand operation.
Return an array of integers where answer[i] is the number of islands after 
the ith operation.

Input Format:
- m, n
- p (number of operations)
- p pairs of [r, c]

Output Format:
- List of integers.

Constraints:
- 1 <= m, n <= 10^4
- 1 <= positions.length <= 10^4
*/

public class NumberOfIslandsII_UnionFind {
    /**
     * Approach: Union-Find
     * - Each newly added land cell increases island count by 1.
     * - Check 4 neighbors. If any neighbor is land, union the current cell
     * with the neighbor and decrement the island count.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(P * α(M*N)) where P is number of operations.
     * - Space Complexity: O(M * N) for the Union-Find data structure.
     */
    static class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            count = 0;
        }

        public void setParent(int i) {
            if (parent[i] == -1) {
                parent[i] = i;
                count++;
            }
        }

        public int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                count--;
            }
        }

        public boolean isLand(int i) {
            return parent[i] != -1;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            int idx = r * n + c;

            if (uf.isLand(idx)) {
                result.add(uf.count);
                continue;
            }

            uf.setParent(idx);

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                int nIdx = nr * n + nc;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && uf.isLand(nIdx)) {
                    uf.union(idx, nIdx);
                }
            }
            result.add(uf.count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m and n:");
        if (!sc.hasNextInt())
            return;
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Enter number of positions:");
        int pCount = sc.nextInt();
        int[][] positions = new int[pCount][2];
        System.out.println("Enter [r, c] pairs:");
        for (int i = 0; i < pCount; i++) {
            positions[i][0] = sc.nextInt();
            positions[i][1] = sc.nextInt();
        }

        NumberOfIslandsII_UnionFind solver = new NumberOfIslandsII_UnionFind();
        System.out.println("Counts: " + solver.numIslands2(m, n, positions));
        sc.close();
    }
}
