import java.util.ArrayList;
import java.util.Collections;

public class AdjGraph {
    public ArrayList<Vertex> vertices;

    public void allTEU() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            int teutotal = currentv.getTEUreceived() - currentv.getTEUsent();
            currentv.setTEUtotal(teutotal);
            System.out.println("Havn: " + currentv.getName() + ", TEU: " + teutotal);
            /*
             * System.out.println("Havn:" + currentv.getName());
             * currentv.setTEUtotal(currentv.getTEUsent(), currentv.getTEUreceived());
             * System.out.println(currentv.getTEUtotal());
             */
        }

    }

    // Forelæser anbefaler at bruge AdjacencyListGraph, til at lave
    // minimumSpanningTree, da man kan sortere Vertices på baggrund af distances,
    // ved bruge af en queue
    public AdjGraph() {
        vertices = new ArrayList<Vertex>();
        // int TEUsent;
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void newEdge(Vertex from, Vertex to, Integer TEU) {
        if (!(vertices.contains(from) && vertices.contains(to))) // Tjekker om vertices allerede har en from og to
        {
            System.out.println(" Vertex not found ");
            return;
        }
        Edge newedge = new Edge(from, to, TEU);

    }

    public void printGraph() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            System.out.println(" Edges from Vertex: " + currentv.getName());
            for (int j = 0; j < currentv.getOutEdges().size(); j++) { // kører på både edges og vertices
                Edge currente = currentv.getOutEdges().get(j);
                System.out.println("To " + currente.getToVertex().getName() + " weight " + currente.getWeight());
            }
            System.out.println(" ");
        }
    }

    public void printTEU() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            /*
             * System.out.println(" Antal af TEU sendt fra Vertex: " + currentv.getName());
             * // kører på både edges og vertices
             * 
             * System.out.println(currentv.getTEUsent());
             * System.out.println(" Antal af TEU modtaget af Vertex: " +
             * currentv.getName());
             * System.out.println(currentv.getTEUreceived());
             */
            System.out.println(currentv.getName() + ": Total of surplus (TEU) = "
                    + (-(currentv.getTEUsent() - currentv.getTEUreceived())));
        }
    }

    public void reversingFlowCost() {
        Vertex currentv;
        int surplus = 0;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            for (int j = 0; j < currentv.getOutEdges().size(); j++) {
                Edge currente = currentv.getOutEdges().get(j);
                surplus += currente.getWeight();
            }
        }
        System.out.println("Reversing the flow costs: " + surplus * 100 + "$");
    }

    public void cheapestFlow() {
        ArrayList<Vertex> TEUplus = new ArrayList<>();
        ArrayList<Vertex> TEUminus = new ArrayList<>();
        Vertex currentvortex;
        for (int i = 0; i < vertices.size(); i++) {
            currentvortex = vertices.get(i);
            if (currentvortex.getTEUtotal() > 0) {
                TEUplus.add(currentvortex);
                System.out.println("(PLUS) Tilføjede: " + currentvortex.getTEUtotal());
            } else {
                TEUminus.add(currentvortex);
                System.out.println("(MINUS) Tilføjede: " + currentvortex.getTEUtotal());
            }
        }
        while (TEUminus.size() > 0 && TEUplus.size() > 0) {

            if (TEUminus.get(TEUminus.size() - 1).getTEUtotal() == 0) {
                TEUminus.remove(TEUminus.size() - 1);
                continue;
            }
            if (TEUplus.get(TEUplus.size() - 1).getTEUtotal() == 0) {
                TEUplus.remove(TEUplus.size() - 1);
                continue;
            }

            int tempM = -TEUminus.get(TEUminus.size() - 1).getTEUtotal();
            int tempP = TEUplus.get(TEUplus.size() - 1).getTEUtotal();
            int tempDif = Math.min(tempM, tempP);

            // System.out.println("minus: " + tempM);
            // System.out.println("plus: " + tempP);
            // System.out.println("dif: " + tempDif);

            System.out.println(
                    "Overfør fra " + TEUplus.get(0).getName() + " til " +
                            TEUminus.get(0).getName() + ": " + tempDif);

            int test1 = TEUminus.get(TEUminus.size() - 1).getTEUtotal() + tempDif;
            TEUminus.get(TEUminus.size() - 1).setTEUtotal(test1);

            int test = TEUplus.get(TEUplus.size() - 1).getTEUtotal() - tempDif;
            TEUplus.get(TEUplus.size() - 1).setTEUtotal(test);

        }
    }
}

class Vertex implements Comparable<Vertex> { // Comparables bruges så vi kan sortere Vertex (edges), når vi skal
                                             // bruge
                                             // priority queues
    private String Name;
    private ArrayList<Edge> outEdges;
    private Integer distance = Integer.MAX_VALUE;
    private Integer TEUsent = 0;
    private Integer TEUreceived = 0;
    private Integer TEUtotal = 0;

    public Integer getTEUsent() {
        return TEUsent;
    }

    public Integer getTEUreceived() {
        return TEUreceived;
    }

    public Integer getTEUtotal() {
        return TEUtotal;
    }

    public void setTEUsent(Integer teu) {

        TEUsent += teu;
    }

    public void setTEUreceived(Integer teu) {
        TEUreceived += teu;
    }

    public void setTEUtotal(Integer teu) {
        TEUtotal += teu;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Edge> getOutEdges() {
        return outEdges;
    }

    public void setOutEdges(ArrayList<Edge> outEdges) {
        this.outEdges = outEdges;
    }

    /*
     * public Integer getDistance() {
     * return distance;
     * }
     * 
     * public void setDistance(Integer distance) {
     * this.distance = distance;
     * }
     */

    public Vertex(String Origin) // Constructor
    {
        this.Name = Origin;
        outEdges = new ArrayList<>();
    }

    public void addOutEdge(Edge outEdge) {
        outEdges.add(outEdge);

    }

    @Override
    public int compareTo(Vertex o) { // Bruges til sortering
        if (this.distance < o.distance) {
            return -1;
        }
        if (this.distance > o.distance) {
            return 1;
        }
        return 0;
    }
}

class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public void setFromVertex(Vertex fromVertex) {
        this.fromVertex = fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public void setToVertex(Vertex toVertex) {
        this.toVertex = toVertex;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    private Integer weight;

    public Edge(Vertex from, Vertex to, Integer cost) { // Constructor
        fromVertex = from;
        toVertex = to;
        weight = cost;
        from.addOutEdge(this); // denne gør at vi i main kan oprettet Edge, uden også at skulle kalde på
        // addOutEdge
        fromVertex.setTEUsent(weight);
        toVertex.setTEUreceived(weight);
    }

}
