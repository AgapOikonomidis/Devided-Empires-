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
	
	
	static Region r1 = new Region("Athens", 3, "Blue", br1);
	static Region r2 = new Region("Sparta", 5, "Red", br2);
	static Region r3 = new Region("Corinth", 3, "Green", br3);
	static Region r4 = new Region("Crete", 4, "Yellow", br4);
	static Region r5 = new Region("Macedonia", 4, "Blue", br5);
	static Region r6 = new Region("Rome", 6, "Red", br6);
	static Region r7 = new Region("Ravenna", 3, "Green", br7);
	static Region r8 = new Region("Sicily", 2, "Yellow", br8);
	static Region r9 = new Region("Florence", 4, "Blue", br9);
	static Region r10 = new Region("Sardinia", 2, "Red", br10);
	static Region r11 = new Region("Thinis", 4, "Green", br11);
	static Region r12 = new Region("Tanis", 7, "Yellow", br12);
	static Region r13 = new Region("Alexandria", 7, "Blue", br13);
	static Region r14 = new Region("Avaris", 4, "Red", br14);
	static Region r15 = new Region("Memphis", 3, "Green", br15);
	static Region r16 = new Region("Nineveh", 5, "Yellow", br16);
	static Region r17 = new Region("Susa", 2, "Blue", br17);
	static Region r18 = new Region("Ashur", 3, "Red", br18);
	static Region r19 = new Region("Persepolis", 7, "Green", br19);
	static Region r20 = new Region("Babylon", 2, "Yellow", br20);
				
	static Region[] tabler = {	r1, r2, r3, r4, r5,
								r6, r7, r8, r9, r10,
								r11, r12, r13, r14, r15,
								r16, r17, r18, r19, r20 };
		
	static Player p1 = new Player("", "Blue", 20, 5);
	static Player p2 = new Player("", "Red", 20, 5);
	static Player p3 = new Player("", "Green", 20, 5);
	static Player p4 = new Player("", "Yellow", 20, 5);
	
	static Player[] tablep = { p1, p2, p3, p4 };
	
	public static void borderPlacing() {
		br1.add("Tanis");
		br1.add("Sicily");
		br2.add("Florence");
		br2.add("Thinis");
		br3.add("Babylon");
		br3.add("Memphis");
		br4.add("Nineveh");
		br4.add("Sardinia");
		br5.add("Florence");
		br5.add("Avaris");
		br5.add("Ravenna");
		br5.add("Susa");
		br5.add("Alexandria");
		br5.add("Rome");
		br5.add("Persepolis");
		br5.add("Babylon");
		br5.add("Thinis");
		br6.add("Persepolis");
		br6.add("Macedonia");
		br6.add("Babylon");
		br6.add("Memphis");
		br6.add("Ashur");
		br7.add("Avaris");
		br7.add("Macedonia");
		br7.add("Susa");
		br8.add("Alexandria");
		br8.add("Athens");
		br8.add("Tanis");
		br8.add("Persepolis");
		br9.add("Avaris");
		br9.add("Macedonia");
		br9.add("Sparta");
		br9.add("Thinis");
		br10.add("Nineveh");
		br10.add("Crete");
		br11.add("Sparta");
		br11.add("Florence");
		br11.add("Macedonia");
		br11.add("Babylon");
		br12.add("Athens");
		br12.add("Sicily");
		br12.add("Persepolis");
		br13.add("Sicily");
		br13.add("Susa");
		br13.add("Persepolis");
		br13.add("Macedonia");
		br14.add("Florence");
		br14.add("Ravenna");
		br14.add("Macedonia");
		br15.add("Ashur");
		br15.add("Nineveh");
		br15.add("Corinth");
		br15.add("Babylon");
		br15.add("Rome");
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
		br19.add("Thinis");
		br20.add("Thinis");
		br20.add("Macedonia");
		br20.add("Rome");
		br20.add("Memphis");
		br20.add("Corinth");
	}
	
	public static void main(String[] args) {
		
		GameApp.borderPlacing();
		Function.gamestart();
	}	
}
