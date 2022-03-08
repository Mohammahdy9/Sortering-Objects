
public class Library implements Comparable<Library> {

	private String state, branch, city, zip, county;
	private int squareFeet, hoursOpen, weeksOpen;
	
	public Library(String state, String branch, String city, String zip, String county, int squareFeet, int hoursOpen, int weeksOpen) {
		this.setState(state);
		this.setBranch(branch);
		this.setCity(city);
		this.setZip(zip);
		this.setCounty(county);
		this.setSquareFeet(squareFeet);
		this.setHoursOpen(hoursOpen);
		this.setWeeksOpen(weeksOpen);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public int getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(int squareFeet) {
		this.squareFeet = squareFeet;
	}

	public int getHoursOpen() {
		return hoursOpen;
	}

	public void setHoursOpen(int hoursOpen) {
		this.hoursOpen = hoursOpen;
	}

	public int getWeeksOpen() {
		return weeksOpen;
	}

	public void setWeeksOpen(int weeksOpen) {
		this.weeksOpen = weeksOpen;
	}
	
	public boolean equals(Object o){
		if (o instanceof Library)	{	
			Library l1 = (Library) o;	
			if (this.branch.equalsIgnoreCase(l1.branch))
				return true;
		}
		return false;
	}
	
	public int compareTo(Library l) {
		return branch.compareToIgnoreCase(l.getBranch());
	}
	
	public String toString() {
		return state+"\t"+branch+"\t"+city+"\t"+zip+"\t"+county+"\t"+squareFeet+"\t"+hoursOpen+"\t"+weeksOpen;
	}
}
