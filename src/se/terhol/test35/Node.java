package se.terhol.test35;

/**
 * Graph node.
 * 
 * @author Radek Oslejsek
 * @version 2011-01-16
 */
public class Node
{
    private String name;
    
    /**
     * @param name Room's name, must not be null nor empty
     * @throws IllegalArgumentException if name is null or consists of empty string
     */
    public Node(String name) {
        if(name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("name");
        }
        this.name = name.trim();
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) return false;
        if (obj == this) return true;
        return this.name.equals(((Node)obj).name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
