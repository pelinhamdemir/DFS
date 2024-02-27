import java.util.*;



public class Graph {


    private final int V;
    private Bag<Integer>[] adj;
    public Graph(int V)    {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();    }
    public void addEdge(int v, int w)    {
        adj[v].add(w);
        adj[w].add(v);    }
    public Iterable<Integer> adj(int v)    {
        return adj[v];  }

    public int V() {
        return V;
    }
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v))
            degree++;
        return degree; }

    public int addNewEdge(Graph g, int v, int teduVertex, int homeVertex, Queue queue){
        Graph g1= new Graph(g.V());
        g1=g;
        int w;
        int newEdgesCount = 0;
        List<Integer> list = new ArrayList<>();
        for (int b : g.adj(v)){
            list.add(b);}
        BreadthFirstPaths bfp= new BreadthFirstPaths(g,teduVertex-1, homeVertex-1);
        int dist=bfp.distTo[teduVertex-1];
        for(w=0;w<g.V();w++){
          if (!list.contains(w) && v!=w ) {
            g1.addEdge(v, w);
              BreadthFirstPaths bfp2= new BreadthFirstPaths(g1,teduVertex-1, homeVertex-1);
              int dist2=bfp2.distTo[teduVertex-1];
              if(!(dist2<dist)){
                  g.addEdge(v,w);
                  queue.enqueue(v+1);
                  queue.enqueue(w+1);
                  //System.out.println((v+1)+" "+(w+1));//

              }
        }}
        return -1;


        }
}


