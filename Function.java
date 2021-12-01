import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Function {
	
	static Scanner keyboard = new Scanner(System.in);
		
	public static void gameStart() { // Starts the game with round 1 //
		for(int i = 1;i <= 50; i++) { 
			for(int j = 0; j <= 3; j++) {
				
				System.out.println(GameApp.tablep[j].getPlayerName()+" is your turn to play");
				placeSoldiers(checkSoldiers(j),j);
				
				boolean flag3 = true;
				int answer = 0;
				while(flag3) {	// Shows Menu at each round
					System.out.println("Choose your next move :");
					System.out.println("1. Attack"); 
					System.out.println("2. Fortify)");
					System.out.println("3. Skip");
					answer = keyboard.nextInt();
					if(answer == 1 || answer ==2 || answer == 3) { // Check valid input for the options attack/fortify /skip
						flag3 = false;
					}
				}
							
				if(answer == 1) {
					System.out.println("From where do you want to attack ?"); // Attack
					String tempColor = GameApp.tablep[j].getPlayerColor(); 
					ArrayList<String> alliedStates = new ArrayList<String>();
					for(int k = 0; k <= 19; k++) {
						if(tempColor.equals(GameApp.tabler[k].getRegionColor())) {
							alliedStates.add(GameApp.tabler[k].getRegionName());
							System.out.println(GameApp.tabler[k].getRegionName());						
						}
					}
				
					String ras = null;
					boolean flag = true; 
					while(flag) { // Check valid input
						ras = keyboard.nextLine();
						for(int counter = 0; counter <= alliedStates.size(); counter++) {
							if(ras.equals(alliedStates.get(counter))) {
								flag = false;
								break;
							}
						}							
					}
				
					int ra = 0; // Save attacker's index in tabler[]
					for(int counter = 0; counter <= 19; counter++) {
						if(ras.equals(GameApp.tabler[counter].getRegionName())) {
							ra = counter;
							break;
						}	
					}
					
					System.out.println("Where do you want to attack ?");
					ArrayList<String> alliedBrds = new ArrayList<String>();
					alliedBrds = GameApp.tabler[ra].getBorders();
					System.out.println(alliedBrds); //Print borders of region tabler[ra] ( example prints : [Athens, Sparta]
				
					String rds = null;
					boolean flag2 = true;
					while(flag2) { // Check valid input
						rds = keyboard.nextLine();	
						for(int counter = 0; counter <= alliedBrds.size(); counter++) { // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							if(rds.equals(alliedBrds.get(counter))) {
								flag2 = false;
								break;
							}
						}
					}
				
					int rd = 0; // Save defender's index in tabler[]
					for(int counter = 0; counter <= 19; counter++) {
						if(rds.equals(GameApp.tabler[counter].getRegionName())) {
							rd = counter;
							break;
						}
					}			
					attack(ra,rd);				
				} else if(answer == 2)  {
					fortify();
				} else {
					skip(j);
				}
			}
		}
	}
	
	public static int checkSoldiers(int j) { // Gives soldiers to players depending on their regions' number //
		int nof = GameApp.tablep[j].getPlayerRegions()/2 +1;
		System.out.println(GameApp.tablep[j].getPlayerName() + " recieves " + nof + " soldiers");	
		return nof;
	}
	
	public static void placeSoldiers(int s, int j) { // Players choose where to place their soldiers //
		while(s != 0) {
			
			System.out.println("Where would you like to place your soldiers ? ");
			System.out.println("Remaining soldiers to place : " + s);
			
		}
	}
	
	public static void attack(int ra, int rd) { // The option of attack ( from where to where; ) //
		Random dice = new Random();
		int attackerSoldiers = GameApp.tabler[ra].getRegionSoldiers();
		int defenderSoldiers = GameApp.tabler[rd].getRegionSoldiers();
		int adice = 0;
		int ddice = 0;
		while(attackerSoldiers != 1 || defenderSoldiers != 0) {
			adice = 1 +	dice.nextInt(6);
			ddice = 1 + dice.nextInt(6);
			if(adice >= ddice) {
				defenderSoldiers = defenderSoldiers - 1;
			} else {
				attackerSoldiers = attackerSoldiers - 1;
			}				
		}
		if(attackerSoldiers == 1) { // Attacker loses
			GameApp.tabler[ra].setRegionSoldiers(1);
			GameApp.tabler[rd].setRegionSoldiers(defenderSoldiers);
		}
		int answer2 = 0;
		if(defenderSoldiers == 0) { // Attacker wins
			System.out.println("Attacker wins ! How many soldiers do you want to place in " + GameApp.tabler[rd].getRegionName());
			answer2 = keyboard.nextInt();
			GameApp.tabler[rd].setRegionSoldiers(answer2);
			GameApp.tabler[ra].setRegionSoldiers(attackerSoldiers - answer2);
			GameApp.tabler[rd].setRegionColor(GameApp.tabler[ra].getRegionColor());
		}
	}
	
	public static void fortify() { // The option of fortifying soldiers ( from where; to where; how much; ) //
	
	}
	
	public static void skip(int j ) {
		System.out.println(GameApp.tablep[j].getPlayerName() + " skipped his turn");
	}		
}
