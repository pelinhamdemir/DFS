
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    public int[] distTo;

    public BreadthFirstPaths(Graph G, int s, int homeVertex) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        bfs(G, s,homeVertex);
    }

    private void bfs(Graph G, int s,int homeVertex) {
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(homeVertex);
        marked[homeVertex] = true;
        distTo[homeVertex] = 0;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    } }