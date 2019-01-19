package se.terhol.test35;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tereza Holm
 */
public class DirectedGraph implements IDirectedGraph {
    private Map<Node, List<Node>> graph = new HashMap<>();

    @Override
    public void addEdge(Node from, Node to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException();
        }
        if (graph.isEmpty() || !graph.containsKey(from)) {
            graph.put(from, new ArrayList<>());
        }
        if (!graph.get(from).contains(to)) {
            graph.get(from).add(to);
        }
    }

    @Override
    public boolean removeEdge(Node from, Node to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException();
        }
        boolean removed = false;
        if (graph.containsKey(from) && graph.get(from).contains(to)) {
            graph.get(from).remove(to);
            removed = true;
        }
        return removed;
    }

    @Override
    public int numEdges() {
        int finalSum = 0;
        for (Node node : graph.keySet()) {
            finalSum = finalSum + graph.get(node).size();
        }
        return finalSum;
    }

    @Override
    public void save(OutputStream os) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {
            for (Node nodeFrom : graph.keySet()) {
                for (Node nodeTo : graph.get(nodeFrom)) {
                    writer.write(String.format("%1$s:%2$s", nodeFrom, nodeTo));
                    writer.newLine();
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Could not save this file.");
        }
    }

    @Override
    public void load(InputStream is) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line = reader.readLine();
            while (line != null) {
                int colon = line.indexOf(':');
                this.addEdge(new Node(line.substring(0, colon)), new Node(line.substring(colon + 1)));
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Could not load this file.");
        }
    }

    @Override
    public boolean pathExists(List<Node> path) {
        boolean exists = true;

        for (int i = 0; i < path.size() - 1; i++) {
            if (path.get(i).toString().charAt(0) + 1 != path.get(i + 1).toString().charAt(0)) {
                exists = false;
            }
        }

        return exists;
    }
}
