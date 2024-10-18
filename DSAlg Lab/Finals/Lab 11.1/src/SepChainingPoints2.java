
public class SepChainingPoints2 extends SepChainingPoints {
	public boolean isCrossRoad(Point p) throws Exception {
		// Add the point
		this.add(p);
		// Use a pre-built method
		return pointValueExist(p);
	}
}
