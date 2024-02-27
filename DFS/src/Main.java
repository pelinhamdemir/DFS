import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String fileName;
        fileName = keyboard.nextLine();
        String filePath = ( fileName);
        List<String> list= new LinkedList<>();
        List<String> list2= new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line from the file until the end of the file is reached

            while ((line = br.readLine()) != null) {
                String[] edge=line.split(",");
                String firstCity= edge[0].trim();
                String secondCity= edge[1].trim();
                list.add(firstCity);
                list.add(secondCity);



            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        List<String> citylist = new ArrayList<>();
        for(int i=0;i< list.size();i++){
            if(!citylist.contains(list.get(i)))
                citylist.add(list.get(i));
        }



        Graph g= new Graph(citylist.size());
        for(int i=0;i<list.size();i++){

            g.addEdge(citylist.indexOf(list.get(i)),citylist.indexOf(list.get(i+1)));
            i++;

        }




        List<Integer> currentPath= new ArrayList<>();
        int a= keyboard.nextInt();
        String sourceCity= keyboard.next();
        DFS dfs=new DFS(g,citylist.indexOf(sourceCity),a,citylist,currentPath);
        System.out.println("Number of total routes: " + (dfs.sortedPath.size()));
        System.out.println("Routes are:");
        for (int i = 0; i < dfs.sortedPath.size(); i++) {
            for (int j = 0; j < dfs.sortedPath.get(i).size(); j++) {
                String c = citylist.get(dfs.sortedPath.get(i).get(j));

                System.out.print(c);
                if (j < dfs.sortedPath.get(i).size() - 1) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }





    }

}