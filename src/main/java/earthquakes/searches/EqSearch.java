package earthquakes.searches;

public class EqSearch{
	private int distance;
	private int minmag;
	private double lat;
	private double lon;
	private String location;

	public EqSearch() {};

	public int getDistance() {return distance;};
	public void setDistance(int d) {this.distance = d;};

	public int getMinmag() {return minmag;};
	public void setMinmag(int m) {this.minmag = m;};

	public double getLat() {return lat;};
	public void setLat(double l) {this.lat = l;};

	public double getLon() {return lon;};
	public void setLon(double l) {this.lon = l;};

	public String getLocation() {return location;};
	public void setLocation(String s) {this.location = s;};
}
