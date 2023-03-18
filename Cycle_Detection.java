// Take help of back edge concept of dfs to solve this

class Solution {
    // Function to detect cycle in a directed graph.

    static HashMap<Integer, Integer> hashMap_DFS = new HashMap<>();
    static int[][] dp;
    
    public static boolean DFS(int V, ArrayList<ArrayList<Integer>> adj, int start_vertex){
        ArrayList<Integer> temp = adj.get(start_vertex);

        for(int i = 0;i<temp.size();i++){
            
            if(dp[start_vertex][temp.get(i)] != -1){
                    if(dp[start_vertex][temp.get(i)] == 1) return true;
                    else if(dp[start_vertex][temp.get(i)] == 0) return false;
            }

            if(hashMap_DFS.get(temp.get(i)) == 0){
            hashMap_DFS.replace(temp.get(i),0,1);
                if(DFS(V,adj,temp.get(i))){
                    dp[start_vertex][temp.get(i)] = 1;
                    return true;
                }
                    hashMap_DFS.replace(temp.get(i),1,-1);
            }else if(hashMap_DFS.get(temp.get(i)) > 0){
                dp[start_vertex][temp.get(i)] = 1;
                return true;
            }
        }

        Arrays.fill(dp[start_vertex],-1);
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // return solve(V,adj);
        dp = new int[V+1][V+1];
        for(int i  =0;i<V+1;i++)
            Arrays.fill(dp[i],-1);
        
        hashMap_DFS = new HashMap<>();
        for(int i =0;i<V;i++){
            hashMap_DFS.put(i,0);
        }
        
        for(int i =0;i<V;i++){
            if(DFS(V,adj,i)) return true;
            hashMap_DFS.replaceAll((key,value) -> 0);
        }
        return false;
    }
}
