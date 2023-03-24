// Basic logic before apply dfs to a node remove node from list which this node is calling. Beacuse there may exist a connection between them. which causes problem

class Solution {
    // Function to detect cycle in an undirected graph.
    static int[] isVisited;

    static boolean DFS(int V, ArrayList<ArrayList<Integer>> adj, int node){
        isVisited[node] = 1;
        // System.out.println(terg.toString());
        ArrayList<Integer> temp_List = adj.get(node);
        for(int nbr : temp_List){
            if(isVisited[nbr] == 0){
                for(int i = 0;i<adj.get(nbr).size();i++){
                    if(adj.get(nbr).get(i) == node) {
                        adj.get(nbr).remove(i);
                        break;
                    }
                }
                if(DFS(V,adj,nbr)) return true;
            }else if(isVisited[nbr] == 1){
                return true;
            }
        }
        return false;
    }

    public static int solve(int V, ArrayList<ArrayList<Integer>> adj){
        isVisited = new int[V];
        for(int i = 0;i<V;i++){
            if(isVisited[i] != 1){
                if(DFS(V,adj,i)) return 1;
            }
        }
        return 0;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        int ans = solve(V,adj);
        if(ans == 1){
            return true;
        }else{
            return false;
        }
    }
}
