
public class WeightedEdge extends Edge {

	private double weight;
	public WeightedEdge(int u, int v) {
		super(u, v);
		// TODO Auto-generated constructor stub
	}
	
	public WeightedEdge (int u, int v, double w) {
		super (u, v);
		w = weight;
	}
	
	 public double weight() {
	        return weight;
	    }


}
