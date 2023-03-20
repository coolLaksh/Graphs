
class Solution
{
    static Stack<Integer> stack;
        static int[] isVisited;

        static void DFS(int V, ArrayList<ArrayList<Integer>> adj, int node){
            ArrayList<Integer> temp_List = adj.get(node);
            isVisited[node] = 1;

            for(Integer nbr: temp_List){
                if(isVisited[nbr] == 0){
                    DFS(V,adj,nbr);
                }
            }
            stack.push(node);
        }


        static void solve(int V, ArrayList<ArrayList<Integer>> adj){
            for(int i = 0;i<V;i++){
                if(isVisited[i] == 0){
                    DFS(V,adj,i);
                }
            }
        }

        //Function to return list containing vertices in Topological order.
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
        {
            // add your code here
            stack = new Stack<>();
            isVisited = new int[V];
            solve(V, adj);
            int[] retList = new int[V];
            int idx = 0;
            while(!stack.isEmpty()){
                retList[idx++] = stack.pop();
            }
            return retList;
        }
}
