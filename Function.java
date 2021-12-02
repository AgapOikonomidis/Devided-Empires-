import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Function {
	
	static Scanner keyboard = new Scanner(System.in); // Used to get input from players
		
	public static void gameStart() { // Starts the game with round 1 //

		for(int i = 1;i <= 50; i++) { 
			for(int j = 0; j <= 3; j++) {
				
				String tempColor = GameApp.tablep[j].getPlayerColor(); 
				ArrayList<String> alliedStates = new ArrayList<String>();
				for(int counter = 0; counter <= 19; counter++) {
					if(tempColor.equals(GameApp.tabler[counter].getRegionColor())) {
						alliedStates.add(GameApp.tabler[counter].getRegionName());						
					}
				}
				
				System.out.println(GameApp.tablep[j].getPlayerName()+" is your turn to play");
				placeSoldiers(checkSoldiers(j), j, alliedStates);
				boolean flag = true;
				int answer = 0;
				while(flag) {	// Shows Menu at each round
					System.out.println("Choose your next move :");
					System.out.println("1. Attack"); 
					System.out.println("2. Fortify)");
					System.out.println("3. Skip");
					answer = keyboard.nextInt();
					if(answer == 1 || answer ==2 || answer == 3) { // Check valid input for the options attack/fortify /skip
						flag = false;
					} else {
						System.out.println("Wrong input : Choose between options 1, 2 or 3, please try again..."); // Wrong input message
					}
				}
							
				if(answer == 1) { // Option 1 : attack
					System.out.println("From where do you want to attack ?"); 
					for(int counter = 0; counter <= alliedStates.size(); counter++) {
						System.out.println(alliedStates.get(counter));					
					}
				
					String ras = null;
					boolean flag2 = true; 
					while(flag2) { // Check valid input
						ras = keyboard.nextLine();
						for(int counter = 0; counter <= alliedStates.size(); counter++) {
							if(ras.equals(alliedStates.get(counter))) {
								flag2 = false;
								break;
							}
						}
						
						if(flag2 == true) {
							System.out.println("Region not found, please try again..."); // Wrong input message
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
					boolean flag3 = true;
					while(flag3) { // Check valid input
						rds = keyboard.nextLine();	
						for(int counter = 0; counter <= alliedBrds.size(); counter++) { // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							if(rds.equals(alliedBrds.get(counter))) {
								flag3 = false;
								break;
							}
						}
						
						if(flag3 == true) {
							System.out.println("Region not found, please try again..."); // Wrong input message
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
				} else if(answer == 2)  { // Option 2 : fortify
					fortify();
				} else { // Option 3 : skip
					skip(j);
			 	}
			}
		}
	} // End of gameStart()
	
	public static int checkSoldiers(int j) { // Gives soldiers to players depending on their regions' number //
		int nof = GameApp.tablep[j].getPlayerRegions()/2 +1;
		System.out.println(GameApp.tablep[j].getPlayerName() + " recieves " + nof + " soldiers");	
		return nof;
	} // End of checkSoldiers()
	
	public static void placeSoldiers(int s, int j, ArrayList<String> alliedStates) { // Players choose where to place their soldiers //
		while(s != 0) {
			System.out.println(alliedStates);
			System.out.println("Where would you like to place your soldiers ? ");
			System.out.println("Remaining soldiers to place : " + s);
			String answer4 = null;
			boolean flag4 = true;
			while(flag4) { // Check valid input 
				answer4 = keyboard.nextLine();
				for(int counter = 0; counter <= alliedStates.size(); counter++) {
					if(answer4.equals(alliedStates.get(counter))) {
						flag4 = false;
						break;
					}
				}
				
				if(flag4 == true) {
					System.out.println("Region not found, please try again..."); // Wrong input message
				}
			}
			
			int pr = 0;
			for(int counter = 0; counter <= 19; counter++) {
				if(answer4.equals(GameApp.tabler[counter].getRegionName())) {
					pr = counter;
				}		
			}
			
			System.out.println("How many soldiers do you want to place ?");
			int answer5 = -1;
			while(answer5 < 0) { // Check valid input
				answer5 = keyboard.nextInt();
				if(answer5 < 0) {
					System.out.println("Wrong input : Positive number of soldiers expected, please try again"); // Wrong input message
				}
			}
			
			GameApp.tabler[pr].setRegionSoldiers(GameApp.tabler[pr].getRegionSoldiers()+1);
			s = s - 1;
		}
	} // End of placeSoldiers()
	
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
		boolean flag6 = true;
		if(defenderSoldiers == 0) { // Attacker wins
			System.out.println("Attacker wins ! How many soldiers do you want to place in " + GameApp.tabler[rd].getRegionName());
			while(flag6) {
				answer2 = keyboard.nextInt();
				if(answer2 > 0 && answer2 <= attackerSoldiers) {
					flag6 = false;
					GameApp.tabler[rd].setRegionSoldiers(answer2);
					GameApp.tabler[ra].setRegionSoldiers(attackerSoldiers - answer2);
					GameApp.tabler[rd].setRegionColor(GameApp.tabler[ra].getRegionColor());
				} else {
					System.out.println("Wrong input : number of soldiers must be zero or positive and less than " + attackerSoldiers); 
					System.out.println("Please try again..."); // Wrong input message
				}
			}
		}
	} // End of attack()
	
	public static void fortify() { // The option of fortifying soldiers ( from where; to where; how much; ) //
	
	} // End of fortify()
	
	public static void skip(int j ) {
		System.out.println(GameApp.tablep[j].getPlayerName() + " skipped his turn");
	}	// End of skip()
} // End of class 
