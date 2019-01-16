package se.terhol.test35;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author   Radek Oslejsek
 * @version  2010-12-16
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        Node nA = new Node("A");
        Node nB = new Node("B");
        Node nC = new Node("C");
        Node nD = new Node("D");
        Node nE = new Node("E");
        Node nF = new Node("F");
        Node nG = new Node("G");
        
        List<Node> pathOK1 = new ArrayList<Node>();
        List<Node> pathOK2 = new ArrayList<Node>();
        List<Node> pathOK3 = new ArrayList<Node>();
        List<Node> pathNotOK1 = new ArrayList<Node>();
        List<Node> pathNotOK2 = new ArrayList<Node>();
        
        pathOK1.add(nA);
        pathOK1.add(nB);
        pathOK1.add(nC);
        
        pathOK2.addAll(pathOK1);
        pathOK2.add(nD);
        
        pathNotOK1.addAll(pathOK1);
        pathNotOK1.add(nE);
        
        pathNotOK2.add(nA);
        pathNotOK2.add(new Node("Z"));
        
        
        System.out.print("Reading graph from graph.txt...");
        IDirectedGraph g = new DirectedGraph();
        g.load(new FileInputStream("graph.txt"));
        System.out.println("OK");
        
        System.out.println("Number of edges (expected 4): " + g.numEdges());
        
        System.out.println("Adding new edge");
        g.addEdge(nF, nE);
        System.out.println("Number of edges (expected 5): " + g.numEdges());

        System.out.println("Adding duplicate edge");
        g.addEdge(nA, nB);
        System.out.println("Number of edges (expected 5): " + g.numEdges());
        
        System.out.println("Removing existing edge");
        g.removeEdge(nF, nE);
        System.out.println("Number of edges (expected 4): " + g.numEdges());

        System.out.println("Removing non-existing edge");
        g.removeEdge(nA, nC);
        System.out.println("Number of edges (expected 4): " + g.numEdges());
        
        System.out.print("Test of existing paths: ");
        System.out.println((g.pathExists(pathOK1) && g.pathExists(pathOK2) && g.pathExists(pathOK3)) ? "OK" : "ERROR");
        
        System.out.print("Test of non-existing paths: ");
        System.out.println((g.pathExists(pathNotOK1) || g.pathExists(pathNotOK2)) ? "ERROR" : "OK");
        
        System.out.println();
        System.out.println("save -- line order doesn't matter: ");
        g.save(System.out);
    }
}
 
