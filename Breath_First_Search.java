public static ArrayList<Integer> BFS(int V, ArrayList<ArrayList<Integer>> adj){

        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> ret_list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0;i<V;i++){
            hashMap.put(i,0);
        }
        q.add(0);
        hashMap.replace(0,0,1);
        while(!q.isEmpty()){
            int temp_vertex = q.poll();
            for(int i = 0;i<adj.get(temp_vertex).size();i++){
                if(hashMap.get(adj.get(temp_vertex).get(i)) == 0){
                    q.add(adj.get(temp_vertex).get(i));
                    hashMap.replace(adj.get(temp_vertex).get(i),0,1);
                }
            }
            hashMap.replace(temp_vertex,0,2);
            ret_list.add(temp_vertex);
        }
        return ret_list;
        }
