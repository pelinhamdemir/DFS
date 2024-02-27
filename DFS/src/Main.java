
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner a =new Scanner(System.in);


        int vertexNum= a.nextInt();
        int NumofRailway= a.nextInt();
        int homeVertex= a.nextInt();
        int teduVertex= a.nextInt();
        Graph graph=new Graph(vertexNum);
        for(int o=0;o<NumofRailway;o++) {
            int p, e;
            p = a.nextInt();
            e = a.nextInt();
            graph.addEdge(p-1, e-1);

        }
        Queue queue= new Queue<Integer>();
            for(int i=0;i<vertexNum;i++){
                graph.addNewEdge(graph,i,teduVertex,homeVertex,queue);

            }
           int size= queue.size()/2;
            System.out.println(size);
            for(int k=0;k<size;k++){
              System.out.println( queue.dequeue()+" "+queue.dequeue());
            }

        }



    }
