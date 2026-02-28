# 🛣️ All Paths from Source to Destination (Backtracking)

---

This repository contains a Java implementation that finds and prints every possible path between two nodes in a graph using Depth-First Search (DFS) with Backtracking.

### 📖 1. The Theory: Why Backtracking?

In a standard DFS, once we visit a node, we mark it as true in our visit[] array and never look at it again for that traversal. However, to find all paths, we need to:

Mark the node as visited so we don't go in circles (infinite loops).

Explore all neighbors of that node.

Unmark the node (set visit[s] = false) once we finish exploring its neighbors.

This "unmarking" step is called Backtracking. It allows the algorithm to "forget" it visited a node so it can use that same node again in a different path.
 
 ---

### 💻 2. The Implementation (Java)

Java

```
import java.util.*;class Main {

    /**

     * Initializes the visit array and path list, then starts the DFS.

     */

    static void printallpath(ArrayList<Integer>[] g, int s, int d) {

        boolean visit[] = new boolean[g.length];

        ArrayList<Integer> path = new ArrayList<>();

        System.out.println("Finding all paths from " + s + " to " + d + ":");

        dfs(g, s, d, visit, path);

    }



    /**

     * Recursive DFS with Backtracking logic.

     */

    static void dfs(ArrayList<Integer>[] g, int s, int d, boolean[] visit, ArrayList<Integer> path) {

        // Step 1: Mark current node as visited and add to path

        visit[s] = true;

        path.add(s);



        // Step 2: If destination reached, print the path

        if (s == d) {

            System.out.println(path);

        } else {

            // Step 3: Recur for all neighbors not yet visited

            for (int neighbor : g[s]) {

                if (!visit[neighbor]) {

                    dfs(g, neighbor, d, visit, path);

                }

            }

        }



        // Step 4: BACKTRACKING

        // Remove current node from path and mark as unvisited for other potential paths

        path.remove(path.size() - 1);

        visit[s] = false;

    }



    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        

        // Input: Number of nodes (n) and edges (m)

        int n = s.nextInt();

        int m = s.nextInt();

        

        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {

            adj[i] = new ArrayList<>();

        }

        

        // Input: m edges (u v)

        for (int i = 0; i < m; i++) {

            int u = s.nextInt();

            int v = s.nextInt();

            adj[u].add(v);

            adj[v].add(u);

        }

        

        // Example: Print all paths from node 0 to node 3

        printallpath(adj, 0, 3);

    }

}
```

--- 

### 🔍 3. Logic Breakdown

Line of CodePurposevisit[s] = true;Locks the node so we don't visit it twice in the current path.if(s == d)The base case: we found the destination!path.remove(...)Removes the last node before going back up the recursion tree.visit[s] = false;The Magic Step. Unlocks the node so it can be part of another unique path.🚀 4. Sample Walkthrough

If you have a square graph: 0-1, 1-3, 0-2, 2-3

Path 1: 0 → 1 → 3 (Found! Backtrack from 3, then 1).

Path 2: 0 → 2 → 3 (Found! Backtrack from 3, then 2).

Without visit[s] = false, the algorithm would visit 0, 1, and 3, and then stop, never finding the path through 2 because 0 would still be marked "true".
