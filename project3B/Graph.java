package project3B;
import java.util.*;
import java.util.LinkedList;

    public class Graph {
        int numVertices;
        int numEdges;
        Hashtable<String, LinkedList<Edge>> map = new Hashtable<>();

        Graph(int V) {
            this.numVertices = V;
        }

        public void addEdge(String from, String to, int distance) {
            Edge edge = new Edge(from, to, distance);
            Edge edge2 = new Edge(to, from, distance);
            if (!map.containsKey(from)){
                map.put(from, new LinkedList<>());
            }
            if (!map.containsKey(to)){
                map.put(to, new LinkedList<>());
            }

            map.get(from).add(edge);
            map.get(to).add(edge2);
            numEdges++;
        }

        public void printGraph(){
            Hashtable<String, LinkedList<Edge>> printed = new Hashtable<>();
            for (Map.Entry<String, LinkedList<Edge>> entry : map.entrySet()){
                LinkedList<Edge> temp = entry.getValue();
                if (!printed.containsKey(entry.getKey())){
                    System.out.println(entry.getKey());
                }
                printed.put(entry.getKey(), temp);
                for (Edge edge : temp) {
                    System.out.print(edge.toString());
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }

        public void printCloseCities(String toCity){
            try{
                int count = 0;
                for (Map.Entry<String, LinkedList<Edge>> entry : map.entrySet()){
                    LinkedList<Edge> temp = entry.getValue();
                    for (Edge edge : temp) {
                        if (edge.distance < 100 && entry.getKey().equalsIgnoreCase(toCity)) {
                            System.out.println(edge.from + edge.toString());
                            count++;
                        }
                    }
                }
                if (count == 0){
                    System.out.print("Sorry, there are no such cities which has distance lower than 100 KM to " + toCity);
                }
                System.out.println();
            }catch (Exception e){
                System.out.println(e);
            }
        }

    public void printFartherCities(String toCity){
        try{
            int count = 0;
            for (Map.Entry<String, LinkedList<Edge>> entry : map.entrySet()){
                LinkedList<Edge> temp = entry.getValue();
                for (Edge edge : temp) {
                    if (edge.distance > 500 && entry.getKey().equalsIgnoreCase(toCity)) {
                        System.out.println(edge.from + edge.toString());
                        count++;
                    }
                }
            }
            if (count == 0){
                System.out.print("Sorry, there are no such cities which has distance higher than 500 KM to " + toCity);
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void checkIfConnected(String c1,String c2){
        try{
            if (Arrays.toString(map.get(c1).toArray()).contains(c2)){
                System.out.println("Yes, " + c1 + " and " + c2 + " are connected cities. ");
            }else {
                System.out.println(c1 + " and " + c2 + " are not connected cities.");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void minHops(String c1,String c2){//DFS USAGE
    }

    public boolean hasPathBfs(String c1, String c2){
        LinkedList<Edge> nextToVisit = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();//to olarak atansın
        nextToVisit.push(map.get(c1).getFirst());
        while (!nextToVisit.isEmpty()){
            Edge edge = nextToVisit.remove();
            if (edge.from.equals(c2)) {
                return true;
            }
            if (visited.contains(edge.from)){
                continue;
            }
            visited.add(edge.from);
            for (LinkedList<Edge> entry : adjacent(c1)) {
                nextToVisit.push(entry.poll());
            }
        }
        return false;
    }

    public LinkedList<LinkedList<Edge>> adjacent(String c1){
        LinkedList<LinkedList<Edge>> adj =new LinkedList<>();
        String toN;
        for(int i = 0; i < map.get(c1).size(); i++){
            toN = map.get(c1).get(i).to;
            adj.push(map.get(toN));
        }
        return adj;
    }

    public void minDistance(String c1,String c2){//BFS USAGE

    }

}
