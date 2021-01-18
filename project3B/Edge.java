package project3B;

public class Edge {
    String from;
    String to;
    int distance;

    public Edge(String from, String to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return  "       --------------------- " + distance +
                " KM ---------------------" + to;
    }
}
