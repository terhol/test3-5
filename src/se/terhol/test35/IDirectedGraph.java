package se.terhol.test35;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Graph.
 *
 * @author Radek Oslejsek
 * @version 2011-01-16
 */
public interface IDirectedGraph {
    /**
     * Adds a new directed edge to this graph. If this edge already
     * * exists in the graph then nothing happens.
     *
     * @param from First node of directed edge
     * @param to   Second node of directed edge
     * @throws IllegalArgumentException if some node parameter is null
     */
    void addEdge(Node from, Node to);

    /**
     * Removes edge from this graph.
     *
     * @param from First node of the edge to be removed
     * @param to   Second node of the edge to be removed
     * @return true on success, false if the edge does not exist
     * @throws IllegalArgumentException if some node parameter is null
     */
    boolean removeEdge(Node from, Node to);

    /**
     * @return number of edges in this graph
     */
    int numEdges();

    /**
     * Writes graph to given output stream as follows:
     * 1. Data are writen in text mode.
     * 2. Edges are written to single lines in the form "from:to",
     * where "from" is the name of source node and "to" is the name of
     * desitation node of directed edge.
     *
     * @param os Output stream
     * @throws IOException on any I/O error
     */
    void save(OutputStream os) throws IOException;

    /**
     * Reads directed edges from given input stream and instantiates the graph.
     * For format see the save() method.
     *
     * @param is Input stream
     * @throws IOException on any I/O failure
     */
    void load(InputStream is) throws IOException;

    /**
     * Checks whether the given path exists in the graph.
     *
     * @param path List of nodes defining path in graph
     * @return true if path exists in this graph, false otherwise
     */
    boolean pathExists(List<Node> path);
}
