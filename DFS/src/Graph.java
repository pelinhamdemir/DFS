import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final int V;
    private final Bag<Integer>[] adj;
    public Graph(int V)    {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();    }
    public void addEdge(int v, int w)    {
        adj[v].add(w);       }
    public Iterable<Integer> adj(int v)    {
        return adj[v];  }

    public int V(){
        return V;
    }


    }

