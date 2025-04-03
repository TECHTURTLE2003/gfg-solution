//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
         Queue<Pair> q = new LinkedList<>();
        int fresh = 0, m = mat.length, n = mat[0].length;
        int[] X = {-1, 1, 0, 0};
        int[] Y = {0, 0, -1, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean hasRot = false;
            for (int i = 0; i < size; i++) {
                Pair node = q.remove();
                int x = node.x, y = node.y;

                for (int j = 0; j < 4; j++) {
                    int nx = x + X[j];
                    int ny = y + Y[j];

                    if (nx >= 0 && nx < m && ny >= 0 &&
                    ny < n && mat[nx][ny] == 1) {
                        mat[nx][ny] = 2;
                        q.add(new Pair(nx, ny));
                        fresh--;
                        hasRot = true;
                    }
                }
            }
            if (hasRot) res++;
        }

        return (fresh == 0) ? res : -1; 
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}