
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    
    
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void DFS(int V, ArrayList<ArrayList<Integer>> adj, int start_vertex){
        ArrayList<Integer> temp = adj.get(start_vertex);
        
        for(int i = 0;i<temp.size();i++){
            if(hashMap.get(temp.get(i)) == 0){
                hashMap.replace(temp.get(i),0,1);
                list.add(temp.get(i));
                DFS(V,adj,temp.get(i));
                hashMap.replace(temp.get(i),1,2);
            }
        }
    }
    
    public static void solve(int V, ArrayList<ArrayList<Integer>> adj){
        hashMap = new HashMap<>();
        list = new ArrayList<>();
        for(int i =0;i<V;i++){
            hashMap.put(i,0);
        }
        list.add(0);
        hashMap.replace(0,0,2);
        DFS(V,adj,0);
    }
