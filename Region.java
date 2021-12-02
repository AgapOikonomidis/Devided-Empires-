import java.util.ArrayList;
public class Region {
	
	private String regionName;
	private int regionSoldiers;
	private String regionColor;
	private ArrayList<String> borders = new ArrayList<String>();
	
	
	public Region(String regionName, int regionSoldiers, String regionColor, ArrayList<String> borders) {
		this.regionName = regionName;
		this.regionSoldiers = regionSoldiers;
		this.regionColor = regionColor;
		this.borders = borders;
	}

	public String getRegionName() {
		return regionName;
	}
	
	public void setRegionName(String regionName ) {
		this.regionName = regionName;
	}
	
	public int getRegionSoldiers() {
		return regionSoldiers;
	}

	public void setRegionSoldiers(int regionSoldiers) {
		this.regionSoldiers = regionSoldiers;
	}

	public String getRegionColor() {
		return regionColor;
	}

	public void setRegionColor(String regionColor) {
		this.regionColor = regionColor;
	}

	public ArrayList<String> getBorders() {
		return borders;
	}

	public void setBorders(ArrayList<String> borders) {
		this.borders = borders;
	}

	@Override
	public String toString() {
		return "Region [regionName=" + regionName + ", regionSoldiers=" + regionSoldiers + ", regionColor="
				+ regionColor + ", borders=" + borders + "]";
	}			
}
