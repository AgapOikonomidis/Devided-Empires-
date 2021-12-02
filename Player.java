public class Player {

	private String playerName;
	private String playerColor;
	private int playerSoldiers;
	private int playerRegions;
	public Player(String playerName, String playerColor, int playerSoldiers, int playerRegions) {
		
		this.playerName = playerName;
		this.playerColor = playerColor;
		this.playerSoldiers = playerSoldiers;
		this.playerRegions = playerRegions;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerColor() {
		return playerColor;
	}
	public void setPlayerColor(String playerColor) {
		this.playerColor = playerColor;
	}
	public int getPlayerSoldiers() {
		return playerSoldiers;
	}
	public void setPlayerSoldiers(int playerSoldiers) {
		this.playerSoldiers = playerSoldiers;
	}
	public int getPlayerRegions() {
		return playerRegions;
	}
	public void setPlayerRegions(int playerRegions) {
		this.playerRegions = playerRegions;
	}
	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", playerColor=" + playerColor + ", playerSoldiers="
				+ playerSoldiers + ", playerRegions=" + playerRegions + "]";
	}	
}
