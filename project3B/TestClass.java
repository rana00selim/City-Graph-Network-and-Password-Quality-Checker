package project3B;
import java.io.*;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int ans = 1;
        String toCity;
        String toCity2;
        Graph g2 = null;
        System.out.println("=> Welcome to the [Işık - City Graph Program]");
        while (ans > -1 && ans < 9) {
            System.out.println("───────────────────────────────────────────────── MENU ─────────────────────────────────────────────────\n" +
                    "1)   Creates the cities.txt randomly\n" +
                    "2)   Load cities.txt and returns a graph\n" +
                    "3)   Print close cities(distance is less than 100km)\n" +
                    "4)   Print farther cities(distance is higher than 500km) \n" +
                    "5)   Check if given cities are connected\n" +
                    "6)   Print the path of given two cities with least number of hopes\n" +
                    "7)   Print the number of city (connected component) groups\n" +
                    "8)   Print the path minimum distance path from given city1 to city2 and the path length in km \n" +
                    "9)   Exit.\n" +
                    "────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
            System.out.print("Your option: ");
            ans = input.nextInt();
            System.out.println();
            if (ans == 1) {
                readFromFile("cities.txt");
                System.out.println("Successfully created.");
            }

            else if (ans == 2) {
                g2 = readFromFile("cities.txt");
                g2.printGraph();
            }

            else if (ans == 3){
                if (g2 == null){
                    System.out.println("First you need to load your graph. Please select the 2. option!");
                }else {
                    System.out.print("Please enter the city you want the source for: ");
                    toCity = input.next();
                    System.out.println();
                    g2.printCloseCities(toCity);
                }
            }

            else if (ans == 4) {
                if (g2 == null){
                    System.out.println("First you need to load your graph. Please select the 2. option!");
                }else {
                    System.out.print("Please enter the city you want the source for: ");
                    toCity = input.next();
                    System.out.println();
                    g2.printFartherCities(toCity);
                }
            }

            else if (ans == 5) {
                if (g2 == null){
                    System.out.println("First you need to load your graph. Please select the 2. option!");
                }else {
                    System.out.print("Please enter the city you want the source for: ");
                    toCity = input.next();
                    System.out.print("And now the destination city: ");
                    toCity2 = input.next();
                    System.out.println();
                    g2.checkIfConnected(toCity, toCity2);
                }
            }

            else if (ans == 6){
                if (g2 == null){
                    System.out.println("First you need to load your graph. Please select the 2. option!");
                }else {
                    System.out.print("Please enter the city you want the source for: ");
                    toCity = input.next();
                    System.out.print("And now the destination city: ");
                    toCity2 = input.next();
                    System.out.println();
                    System.out.print(toCity + " has path to " + toCity2 + " => ");
                    System.out.println(g2.hasPathBfs(toCity, toCity2));
                }
            }

            else if (ans == 7) {
                if (g2 == null) {
                    System.out.println("First you need to load your graph. Please select the 2. option!");
                } else {
                    System.out.println("Number of cities: " + g2.numVertices);
                }
            }

            else if (ans == 8){
                if (g2 == null){
                    System.out.println("First you need to load your graph. Please select the 2. option!");
                }else {
                    System.out.print("Please enter the city you want the source for: ");
                    toCity = input.next();
                    System.out.print("And now the destination city: ");
                    toCity2 = input.next();
                    System.out.println();
                    g2.minDistance(toCity, toCity2);
                    System.out.print(toCity + " has path to " + toCity2 + " => ");
                    System.out.println(g2.hasPathBfs(toCity, toCity2));
                }
            }
        }
        if (ans == 9){
            System.out.println("Exiting...");
        }if (ans < 1 || ans > 9){
            System.out.println("Invalid option! ");
        }
    }


    public static Graph readFromFile(String file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));
        int edgeNumF = input.nextInt();
        int verticeNumF = input.nextInt();
        System.out.println("Constructing a graph of " + verticeNumF + " vertices and " + "" + edgeNumF + " edges: \n");
        Graph g1 = new Graph(verticeNumF);
        for (int i = 0; i < verticeNumF; i++) {
            String from = input.next();
            String to = input.next();
            int distance = (int) (Math.random()*921)+80;
            g1.addEdge(from, to, distance);
        }
        return g1;
    }
}