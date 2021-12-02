import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Function {
	
	static Scanner keyboard = new Scanner(System.in); // Used to get input from players
		
	public static void gameStart() { // Starts the game with round 1 //
		
		boolean flag = true; 
		int answerI = 0; // Used for integer answers
		String answerS = null; // Used for String answers
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
				flag = true;
				answerI = 0;
				while(flag) {	// Shows Menu at each round
					System.out.println("Choose your next move :");
					System.out.println("1. Attack"); 
					System.out.println("2. Fortify)");
					System.out.println("3. Skip");
					answerI = keyboard.nextInt();
					if(answerI == 1 || answerI ==2 || answerI == 3) { // Check valid input for the options attack/fortify /skip
						flag = false;
					} else {
						System.out.println("Wrong input : Choose between options 1, 2 or 3, please try again..."); // Wrong input message
					}
				}
							
				if(answerI == 1) { // Option 1 : attack
					System.out.println("From where do you want to attack ?"); 
					for(int counter = 0; counter <= alliedStates.size(); counter++) {
						System.out.println(alliedStates.get(counter));					
					}
				
					String ras = null;
					flag = true; 
					while(flag) { // Check valid input
						ras = keyboard.nextLine();
						for(int counter = 0; counter <= alliedStates.size(); counter++) {
							if(ras.equals(alliedStates.get(counter))) {
								flag = false;
								break;
							}
						}
						
						if(flag == true) {
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
					flag = true;
					while(flag) { // Check valid input
						rds = keyboard.nextLine();	
						for(int counter = 0; counter <= alliedBrds.size(); counter++) { // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							if(rds.equals(alliedBrds.get(counter))) {
								flag = false;
								break;
							}
						}
						
						if(flag == true) {
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
				} else if(answerI == 2)  { // Option 2 : fortify
					System.out.println("From where do you want to move soldiers ?");
					System.out.println(alliedStates);
					flag = true;
					while(flag) { // Check valid input
					    answerS = keyboard.nextLine();	
						for(int counter = 0; counter <= alliedStates.size(); counter++) { // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							if(answerS.equals(alliedStates.get(counter))) {
								flag = false;
								break;
							}
						}
						
						if(flag == true) {
							System.out.println("Region not found, please try again..."); // Wrong input message
						}
					}
					int f1 = 0; // Save fortify Region 1 index in tabler[]
					for(int counter = 0; counter <= 19; counter++) {
						if(answerS.equals(GameApp.tabler[counter].getRegionName())) {
							f1 = counter;
							break;
						}	
					}
					System.out.println("Where do you want to move your soldiers ?");
					ArrayList<String> frtfBrds = new ArrayList<String>();
					ArrayList<String> fortifyBorders = new ArrayList<String>();
					frtfBrds = GameApp.tabler[f1].getBorders();
					String fcolor = GameApp.tabler[f1].getRegionColor();
					for(int counter = 0; counter <= frtfBrds.size(); counter++) { // Accesing ArrayList frtfBrds 
						for(int counter2 = 0; counter2 <= 19; counter2 ++) { // Accesing Array tabler[]
							if(GameApp.tabler[counter2].getRegionName().equals(frtfBrds.get(counter))) { // Name in Array matches with name in ArrayList					
								if(fcolor.equals(GameApp.tabler[counter2].getRegionColor())) { // Color in ArrayList matches color in Array
									System.out.print(frtfBrds.get(counter) + " ");
									fortifyBorders.add(frtfBrds.get(counter));       
								}
							}
						}
					}
					
					answerS= null;
					flag = true;
					while(flag) { // Check valid input
						answerS = keyboard.nextLine();	
						for(int counter = 0; counter <= fortifyBorders.size(); counter++) { // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							if(answerS.equals(fortifyBorders.get(counter))) {
								flag = false;
								break;
							}
						}
						
						if(flag == true) {
							System.out.println("Region not found, please try again..."); // Wrong input message
						}
					}
					
					int f2 = 0; // Save fortify Region 2 index in tabler[]
					for(int counter = 0; counter <= 19; counter++) {
						if(answerS.equals(GameApp.tabler[counter].getRegionName())) {
							f2 = counter;
							break;
						}	
					}
					fortify(f1, f2);
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
		
		int answerI;
		boolean flag = true;
		String answerS = null;
		while(s != 0) {
			System.out.println(alliedStates);
			System.out.println("Where would you like to place your soldiers ? ");
			System.out.println("Remaining soldiers to place : " + s);
			flag = true;
			while(flag) { // Check valid input 
				answerS = keyboard.nextLine();
				for(int counter = 0; counter <= alliedStates.size(); counter++) {
					if(answerS.equals(alliedStates.get(counter))) {
						flag = false;
						break;
					}
				}
				
				if(flag == true) {
					System.out.println("Region not found, please try again..."); // Wrong input message
				}
			}
			
			int pr = 0;
			for(int counter = 0; counter <= 19; counter++) {
				if(answerS.equals(GameApp.tabler[counter].getRegionName())) {
					pr = counter;
				}		
			}
			
			System.out.println("How many soldiers do you want to place ?");
			answerI = -1;
			while(answerI < 0) { // Check valid input
				answerI = keyboard.nextInt();
				if(answerI < 0) {
					System.out.println("Wrong input : Positive number of soldiers expected, please try again"); // Wrong input message
				}
			}
			
			GameApp.tabler[pr].setRegionSoldiers(GameApp.tabler[pr].getRegionSoldiers()+1);
			s = s - 1;
		}
	} // End of placeSoldiers()
	
	public static void attack(int ra, int rd) { // The option of attack ( from where to where; ) //
		
		int answerI;
		boolean flag;
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
		answerI = 0;
		flag = true;
		if(defenderSoldiers == 0) { // Attacker wins
			System.out.println("Attacker wins ! How many soldiers do you want to place in " + GameApp.tabler[rd].getRegionName());
			while(flag) {
				answerI = keyboard.nextInt();
				if(answerI > 0 && answerI <= attackerSoldiers) {
					flag = false;
					GameApp.tabler[rd].setRegionSoldiers(answerI);
					GameApp.tabler[ra].setRegionSoldiers(attackerSoldiers - answerI);
					GameApp.tabler[rd].setRegionColor(GameApp.tabler[ra].getRegionColor());
				} else {
					System.out.println("Wrong input : number of soldiers must be zero or positive and less than " + attackerSoldiers);
					System.out.println("Please try again..."); // Wrong input message
				}
			}
		}
	} // End of attack()
	
	public static void fortify(int f1, int f2) { // The option of fortifying soldiers ( from where; to where; how much; ) 
		
		System.out.println("How many soldiers do you want to move ?");
		int soldiers;
		do {
			soldiers = keyboard.nextInt();
			if(soldiers <= GameApp.tabler[f1].getRegionSoldiers() - 1) {
				GameApp.tabler[f1].setRegionSoldiers(GameApp.tabler[f1].getRegionSoldiers() - soldiers);
				GameApp.tabler[f2].setRegionSoldiers(GameApp.tabler[f2].getRegionSoldiers() + soldiers);
				break;
			} else {
				System.out.println("Wrong input : number of soldiers must be greater than 1 and less or equal to " + soldiers);
				System.out.println("Please try again..."); // Wrong input message
			}
		}
		while(true);
	} // End of fortify()
	
	public static void skip(int j ) {
		
		System.out.println(GameApp.tablep[j].getPlayerName() + " skipped his turn");
	}	// End of skip()
} // End of class 
