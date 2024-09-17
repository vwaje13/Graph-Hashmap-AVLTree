public class Edge {

    private final int u;
    private final int v;

    public Edge(int u, int v) {
        if (u < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (v < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        this.u = u;
        this.v = v;
    }

    /**
     * Returns either endpoint of this edge.
     *
     * @return either endpoint of this edge
     */
    public int u() {
        return u;
    }
    
    public int v() {
    	return v;
    }
    
    
}