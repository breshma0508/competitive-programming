# 🌐 Graph Traversal Implementation: BFS & DFS
This repository contains a Java implementation of the two most important algorithms for exploring graphs: Breadth-First Search (BFS) and Depth-First Search (DFS).
---

## 📖 1. Theory & Logic
### Breadth-First Search (BFS)

BFS explores the graph level-by-level. It visits all immediate neighbors of a node before moving deeper.

Mechanism: Uses a Queue (FIFO).

Key Use Case: Finding the shortest path in an unweighted graph.

Analogy: Like a ripple in a pond spreading out from where a stone was dropped.

---

### Depth-First Search (DFS)
DFS explores the graph by diving as deep as possible along a branch before backtracking.

Mechanism: Uses Recursion (Stack-based).

Key Use Case: Solving puzzles (mazes), cycle detection, and topological sorting.

Analogy: Like walking through a maze and following one wall until you hit a dead end.

---

### CODE 
```

💻 2. The Implementation (Java)
Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // n = total nodes, m = total edges
        int n = s.nextInt();
        int m = s.nextInt();
        
        // 1. Representing the graph using an Adjacency List
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        // 2. Building the bidirectional (undirected) graph
        for(int i = 0; i < m; i++){
            int u = s.nextInt();
            int v = s.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        
        // 3. Running Traversals
        ArrayList<Integer> res = bfs(n, 0, adj);
        ArrayList<Integer> out = dfs(n, adj);
        
        System.out.println("--- BFS Traversal ---");
        for(int i : res) System.out.print(i + " ");
        
        System.out.println("\n--- DFS Traversal ---");
        for(int i : out) System.out.print(i + " ");
    }

    // BFS Method: Uses Queue to explore neighbors level-by-level
    static ArrayList<Integer> bfs(int v, int src, ArrayList<Integer>[] mp){
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visit = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        
        visit[src] = true;
        q.add(src);
        int sum = 0;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            sum += curr; // Tracking sum of visited node values
            res.add(curr);
            for(int neighbor : mp[curr]){
                if(!visit[neighbor]){
                    visit[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        System.out.println("BFS Node Sum: " + sum);
        return res;
    }

    // DFS Method: Wrapper to initialize visited array
    public static ArrayList<Integer> dfs(int v, ArrayList<Integer>[] mp){
        boolean[] visit = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();
        dfshelper(mp, visit, 0, res);
        return res;
    }

    // DFS Helper: Recursive function to dive deep into neighbors
    public static void dfshelper(ArrayList<Integer>[] mp, boolean[] visit, int src, ArrayList<Integer> res){
        visit[src] = true;
        res.add(src);
        for(int neighbor : mp[src]){
            if(!visit[neighbor]){
                dfshelper(mp, visit, neighbor, res);
            }
        }
    }
}

```
---
### 🔍 3. Detailed Logic Breakdown
Adjacency List: Instead of a matrix, we use an array of ArrayLists. This is more space-efficient because we only store actual connections (Edges).

Visited Array: The boolean[] visit array acts as a marker to ensure we don't visit the same node twice, preventing infinite loops.

BFS sum: Inside the BFS while loop, we keep track of the node sum, which can be used for various graph statistics.
