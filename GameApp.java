import java.awt.Color;
import java.util.ArrayList;

public class GameApp {

	static ArrayList<String> br1 = new ArrayList<String>();
	static ArrayList<String> br2 = new ArrayList<String>();
	static ArrayList<String> br3 = new ArrayList<String>();
	static ArrayList<String> br4 = new ArrayList<String>();
	static ArrayList<String> br5 = new ArrayList<String>();
	static ArrayList<String> br6 = new ArrayList<String>();
	static ArrayList<String> br7 = new ArrayList<String>();
	static ArrayList<String> br8 = new ArrayList<String>();
	static ArrayList<String> br9 = new ArrayList<String>();
	static ArrayList<String> br10 = new ArrayList<String>();
	static ArrayList<String> br11 = new ArrayList<String>();
	static ArrayList<String> br12 = new ArrayList<String>();
	static ArrayList<String> br13 = new ArrayList<String>();
	static ArrayList<String> br14 = new ArrayList<String>();
	static ArrayList<String> br15 = new ArrayList<String>();
	static ArrayList<String> br16 = new ArrayList<String>();
	static ArrayList<String> br17 = new ArrayList<String>();
	static ArrayList<String> br18 = new ArrayList<String>();
	static ArrayList<String> br19 = new ArrayList<String>();
	static ArrayList<String> br20 = new ArrayList<String>();

	// Easy variables for colors
	static Color blue = new Color(51, 204, 255);
	static Color green = new Color(102, 255, 51);
	static Color yellow = new Color(255, 255, 51);
	static Color red = new Color(255, 51, 0);

	public static Player p1;
	public static Player p2;
	public static Player p3;
	public static Player p4;
	public static Player[] tablep = { p1, p2, p3, p4 };

	public static void borderPlacing() {

		// for each region creates an array list with borders
		br1.add("Sicily");
		br1.add("Tanis");
		br2.add("Florence");
		br2.add("Thinis");
		br3.add("Babylon");
		br3.add("Memphis");
		br4.add("Crete");
		br4.add("Nineveh");
		br5.add("Persepolis");
		br5.add("Rome");
		br5.add("Babylon");
		br5.add("Thinis");
		br5.add("Florence");
		br5.add("Avaris");
		br5.add("Ravenna");
		br5.add("Susa");
		br5.add("Alexandria");
		br6.add("Persepolis");
		br6.add("Macedonia");
		br6.add("Babylon");
		br6.add("Memphis");
		br6.add("Ashur");
		br7.add("Avaris");
		br7.add("Macedonia");
		br7.add("Susa");
		br8.add("Alexandria");
		br8.add("Persepolis");
		br8.add("Tanis");
		br8.add("Athens");
		br9.add("Avaris");
		br9.add("Macedonia");
		br9.add("Sparta");
		br9.add("Thinis");
		br10.add("Crete");
		br10.add("Nineveh");
		br11.add("Sparta");
		br11.add("Florence");
		br11.add("Macedonia");
		br11.add("Babylon");
		br12.add("Athens");
		br12.add("Sicily");
		br12.add("Persepolis");
		br13.add("Susa");
		br13.add("Sicily");
		br13.add("Persepolis");
		br13.add("Macedonia");
		br14.add("Ravenna");
		br14.add("Macedonia");
		br14.add("Florence");
		br15.add("Babylon");
		br15.add("Rome");
		br15.add("Ashur");
		br15.add("Nineveh");
		br15.add("Corinth");
		br16.add("Memphis");
		br16.add("Sardinia");
		br16.add("Crete");
		br17.add("Ravenna");
		br17.add("Macedonia");
		br17.add("Alexandria");
		br18.add("Rome");
		br18.add("Memphis");
		br19.add("Tanis");
		br19.add("Sicily");
		br19.add("Alexandria");
		br19.add("Macedonia");
		br19.add("Rome");
		br20.add("Thinis");
		br20.add("Macedonia");
		br20.add("Rome");
		br20.add("Memphis");
		br20.add("Corinth");

	}

	// Create Region Objects
	static Region r1 = new Region("Athens", 3, blue, br1);
	static Region r2 = new Region("Sparta", 5, blue, br2);
	static Region r3 = new Region("Corinth", 3, blue, br3);
	static Region r4 = new Region("Crete", 4, blue, br4);
	static Region r5 = new Region("Macedonia", 4, blue, br5);
	static Region r6 = new Region("Rome", 6, yellow, br6);
	static Region r7 = new Region("Ravenna", 3, yellow, br7);
	static Region r8 = new Region("Sicily", 2, yellow, br8);
	static Region r9 = new Region("Florence", 4, yellow, br9);
	static Region r10 = new Region("Sardinia", 2, yellow, br10);
	static Region r11 = new Region("Thinis", 4, green, br11);
	static Region r12 = new Region("Tanis", 7, green, br12);
	static Region r13 = new Region("Alexandria", 7, green, br13);
	static Region r14 = new Region("Avaris", 4, green, br14);
	static Region r15 = new Region("Memphis", 3, green, br15);
	static Region r16 = new Region("Nineveh", 5, red, br16);
	static Region r17 = new Region("Susa", 2, red, br17);
	static Region r18 = new Region("Ashur", 3, red, br18);
	static Region r19 = new Region("Persepolis", 7, red, br19);
	static Region r20 = new Region("Babylon", 2, red, br20);

	// Create Table with Regions
	static Region[] tabler = { r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19,
			r20 };

	// Creates Player Objects
	public static void initializePlayers() {
		p1 = new Player(MainMenu.playerName1, blue, 20, 5);
		p2 = new Player(MainMenu.playerName2, green, 20, 5);
		p3 = new Player(MainMenu.playerName3, yellow, 20, 5);
		p4 = new Player(MainMenu.playerName4, red, 20, 5);

		// Create Table with players
		tablep[0] = p1;
		tablep[1] = p2;
		tablep[2] = p3;
		tablep[3] = p4;

		// Starts the Game Functions
		Function.gameStart();
	}

	public static void main(String[] args) {
		MainMenu.menu(); // opens Main Menu window
		GameApp.borderPlacing(); // for each region creates an array list with borders
	}
}
