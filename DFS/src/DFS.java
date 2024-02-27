import java.util.*;

public class DFS {
    private boolean[] marked;
    int limit;
    List<List<Integer>> path;

    public DFS(Graph G, int s, int hopNum, List citylist,List<Integer> currentPath) {
        marked = new boolean[G.V()];
        this.limit = hopNum;
        this.path = new ArrayList<>();
        this.sortedPath = new ArrayList<>();
        dfs(G,s, 0, citylist, new ArrayList<>());
    }

    List<Integer> citylistNew= new LinkedList<>();
    List<Integer> list2 = new LinkedList<>();


    int p = 0;



    private void dfs(Graph graph, int v, int numHops, List<String> citylist, List<Integer> currentPath) {
        if (numHops == limit) {
            currentPath.add(v);
            path.add(new ArrayList<>(currentPath));
            printPath(citylist, path.get(path.size() - 1));
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        currentPath.add(v);


        for (int a : graph.adj(v)){
            dfs(graph,a, numHops + 1,citylist, currentPath);
        }

        currentPath.remove(currentPath.size() - 1);

    }



    List<List<Integer>> sortedPath;
    private void printPath(List<String> citylist, List<Integer> path) {
        sortedPath.add(path);
        sortedPath.sort((path1, path2) -> {
            int result = citylist.get(path1.get(0)).compareTo(citylist.get(path2.get(0)));
            if (result == 0) {
                result = citylist.get(path1.get(1)).compareTo(citylist.get(path2.get(1)));
                if (result == 0) {
                    result = citylist.get(path1.get(2)).compareTo(citylist.get(path2.get(2)));
                }
                if (result == 0) {
                    result = citylist.get(path1.get(3)).compareTo(citylist.get(path2.get(3)));
                }
            }
            return result;
        });


    }






}




