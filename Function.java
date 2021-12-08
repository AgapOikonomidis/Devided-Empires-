import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Function {

	static Scanner keyboard = new Scanner(System.in); // Used to get input from players

	public static void gameStart() { // Starts the game with round 1 //

		Color tempColor = null; // Used for saving player's color //
		Color fcolor = null; // Used for saving fortifying region's color //
		Color defenderColor = null; // Used for saving defender's color //
		String ras = null; // Used for saving attacker's Region (String) //
		String rds = null; // Used for saving defender's Region (String) //
		String answerS = null; // Used for String answers//

		boolean flag = true; // Used for while{} loop //

		int ra = 0; // Used to save attacker's Region index in tabler[] //
		int rd = 0; // Used to save defender's Region index in tabler[] //
		int f1 = 0; // Used for saving fortify Region 1 index in tabler[] //
		int f2 = 0; // Used for saving fortify Region 2 index in tabler[] //
		int answerI = 0; // Used for integer answers //
		int counter = 0; // Used as loop counter //
		int counter2 = 0; // Used as loop counter //
		int j2 = 4; // Used for saving player's index in table p[] //

		ArrayList<String> alliedStates = new ArrayList<String>(); // Contains player's allied Regions //
		ArrayList<String> alliedBrds = new ArrayList<String>(); // Contains allied borders of a player's Region //
		ArrayList<String> frtfBrds = new ArrayList<String>(); // Contains fortifying Region's borders //
		ArrayList<String> fortifyBorders = new ArrayList<String>(); // Contains fortifying Region's borders with the
																	// same color //
				
		for (int i = 1; i <= 50; i++) { // Round i
			for (int j = 0; j <= 3; j++) { // Player j

				tempColor = GameApp.tablep[j].getPlayerColor();
				alliedStates.clear(); // Removes all elements
				for (counter = 0; counter <= 19; counter++) {
					if (tempColor.equals(GameApp.tabler[counter].getRegionColor())) {
						alliedStates.add(GameApp.tabler[counter].getRegionName());
					}
				}
				System.out.println(GameApp.tablep[j].getPlayerName() + " is your turn to play");
				placeSoldiers(checkSoldiers(j), j, alliedStates);
				flag = true;
				while (flag) { // Shows Menu at each round
					System.out.println("Choose your next move :");
					System.out.println("1. Attack");
					System.out.println("2. Fortify");
					System.out.println("3. Skip");
					answerI = keyboard.nextInt();
					if (answerI == 1 || answerI == 2 || answerI == 3) { // Check valid input for the options
																		// attack, fortify, skip
						flag = false;
					} else {
						System.out.println("Wrong input : Choose between options 1, 2 or 3, please try again..."); // Wrong
																													// input
																													// message
					}
				}

				if (answerI == 1) { // Option 1 : attack

					System.out.println("From where do you want to attack ?");
					try {
						for (counter = 0; counter <= alliedStates.size(); counter++) {
							System.out.println(alliedStates.get(counter));
						}
					}catch (IndexOutOfBoundsException e) {
						System.out.print("Region not found, please try again...");
					}
					flag = true;
					while (flag) { // Check valid input
						
						ras = keyboard.nextLine();
						for (counter = 0; counter <= alliedStates.size(); counter++) {
							if (ras.equals(alliedStates.get(counter))) {
								flag = false;
								break;
							} else {
								System.out.println("Region not found, please try again..."); // Wrong input message
							}
						}
						
					}

					for (counter = 0; counter <= 19; counter++) {
						if (ras.equals(GameApp.tabler[counter].getRegionName())) {
							ra = counter; // Save attacker's index in table
							break;
						}
					}

					System.out.println("Where do you want to attack ?");
					alliedBrds.clear(); // Removes all elements
					alliedBrds = GameApp.tabler[ra].getBorders();
					System.out.println(alliedBrds); // Print borders of region tabler[ra]
					flag = true;
					while (flag) { // Check valid input
						rds = keyboard.nextLine();
						for (counter = 0; counter <= alliedBrds.size(); counter++) {
							if (rds.equals(alliedBrds.get(counter))) {
								flag = false;
								break;
							}
						}

						if (flag == true) {
							System.out.println("Region not found, please try again..."); // Wrong input message
						}
					}

					for (counter = 0; counter <= 19; counter++) {
						if (rds.equals(GameApp.tabler[counter].getRegionName())) {
							rd = counter; // Save defender's index in table
							break;
						}
					}

					defenderColor = GameApp.tabler[rd].getRegionColor();
					for (counter = 0; counter <= 3; counter++) {
						if (defenderColor.equals(GameApp.tablep[counter].getPlayerColor())) {
							j2 = counter;
						}
					}
					attack(ra, rd, j, j2);
				} else if (answerI == 2) { // Option 2 : fortify
					System.out.println("From where do you want to move soldiers ?");
					System.out.println(alliedStates);
					flag = true;
					while (flag) { // Check valid input
						answerS = keyboard.nextLine();
						for (counter = 0; counter <= alliedStates.size(); counter++) {
							if (answerS.equals(alliedStates.get(counter))) {
								flag = false;
								break;
							}
						}
						if (flag == true) {
							System.out.println("Region not found, please try again..."); // Wrong input message
						}
					}

					for (counter = 0; counter <= 19; counter++) {
						if (answerS.equals(GameApp.tabler[counter].getRegionName())) {
							f1 = counter;
							break; // Save fortify Region 1 index in tabler[]
						}
					}

					System.out.println("Where do you want to move your soldiers ?");
					frtfBrds.clear(); // Removes all elements
					fortifyBorders.clear(); // Removes all elements
					frtfBrds = GameApp.tabler[f1].getBorders();
					fcolor = GameApp.tabler[f1].getRegionColor();
					for (counter = 0; counter <= frtfBrds.size(); counter++) { // Accessing ArrayList frtfBrds
						for (counter2 = 0; counter2 <= 19; counter2++) { // Accessing Array tabler[]
							if (GameApp.tabler[counter2].getRegionName().equals(frtfBrds.get(counter))) { // Name in
																											// Array
																											// matches
																											// with name
																											// in
																											// ArrayList
								if (fcolor.equals(GameApp.tabler[counter2].getRegionColor())) { // Color in ArrayList
																								// matches color in
																								// Array
									System.out.print(frtfBrds.get(counter) + " ");
									fortifyBorders.add(frtfBrds.get(counter));
								}
							}
						}
					}
					flag = true;
					while (flag) { // Check valid input
						answerS = keyboard.nextLine();
						for (counter = 0; counter <= fortifyBorders.size(); counter++) {
							if (answerS.equals(fortifyBorders.get(counter))) {
								flag = false;
								break;
							}
						}

						if (flag == true) {
							System.out.println("Region not found, please try again..."); // Wrong input message
						}
					}

					for (counter = 0; counter <= 19; counter++) {
						if (answerS.equals(GameApp.tabler[counter].getRegionName())) {
							f2 = counter; // Save fortify Region 2 index in tabler[]
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

	public static int checkSoldiers(int j) { // Gives soldiers to players depending on their regions' number

		int nof = GameApp.tablep[j].getPlayerRegions() / 2 + 1;
		System.out.println(GameApp.tablep[j].getPlayerName() + " recieves " + nof + " soldiers");
		return nof;
	} // End of checkSoldiers()

	public static void placeSoldiers(int s, int j, ArrayList<String> alliedStates) { // Players choose where to place
																						// their soldiers
		int pr = 0; // Used for saving placing Region's index in tabler[] //
		int counter = 0; // Used as loop counter //
		int answerI = 0; // Used for integer answers //
		boolean flag = true; // Used for while{} loop //
		String answerS = null; // Used for String answers //
		while (s != 0) {
			System.out.println(alliedStates);
			System.out.println("Where would you like to place your soldiers ? ");
			System.out.println("Remaining soldiers to place : " + s);
			flag = true;
			while (flag) { // Check valid input
				try {
					answerS = keyboard.nextLine();
					for (counter = 0; counter <= alliedStates.size(); counter++) {
						if (answerS.equals(alliedStates.get(counter))) {
							flag = false;
							break;
						}
					}
	
					if (flag == true) {
						System.out.println("Region not found, please try again..."); // Wrong input message
					}
				} catch (IndexOutOfBoundsException e){
					System.out.print("");
				}
			}

			for (counter = 0; counter <= 19; counter++) {
				if (answerS.equals(GameApp.tabler[counter].getRegionName())) {
					pr = counter;
				}
			}

			System.out.println("How many soldiers do you want to place ?");
			flag = true;
			while (flag) { // Check valid input
				answerI = keyboard.nextInt();
				if (answerI < 0 ) {
					System.out.println("Wrong input : Positive number of soldiers expected, please try again."); // Wrong
																												// input
																												// message
				} else if (s- answerI<0){
					System.out.println("You dont have enough soldiers for that."); // Valid input but more soldiers than you have
					System.out.println("Try again...");
				}else {
					flag = false;
				}
			}

			GameApp.tabler[pr].setRegionSoldiers(GameApp.tabler[pr].getRegionSoldiers() + answerI);
			s = s - answerI;
		}
	} // End of placeSoldiers()

	public static void attack(int ra, int rd, int ja, int jd) { // The option of attack ( from where to where; ) //

		int answerI = 0; // Used for integer answers //
		boolean flag = true; // Used for while{} loop //
		Random dice = new Random();
		int attackerSoldiers = GameApp.tabler[ra].getRegionSoldiers(); // Used for saving attacker's soldier number //
		int defenderSoldiers = GameApp.tabler[rd].getRegionSoldiers(); // Used for saving defender's soldier number //
		int adice = 0; // Used for saving the result of attacker's dice //
		int ddice = 0; // Used for saving the result of defender's dice //
		while (attackerSoldiers != 1 || defenderSoldiers != 0) {
			adice = 1 + dice.nextInt(6);
			ddice = 1 + dice.nextInt(6);
			if (adice >= ddice) {
				defenderSoldiers = defenderSoldiers - 1;
			} else {
				attackerSoldiers = attackerSoldiers - 1;
			}
		}
		if (attackerSoldiers == 1) { // Attacker loses
			GameApp.tabler[ra].setRegionSoldiers(1);
			GameApp.tabler[rd].setRegionSoldiers(defenderSoldiers);
		}
		flag = true;
		if (defenderSoldiers == 0) { // Attacker wins
			GameApp.tablep[ja].setPlayerRegions(GameApp.tablep[ja].getPlayerRegions() + 1); // Increases attacker's
																							// regions by 1
			GameApp.tablep[jd].setPlayerRegions(GameApp.tablep[jd].getPlayerRegions() - 1); // Decreases defender's
																							// regions by 1
			System.out.println(
					"Attacker wins ! How many soldiers do you want to place in " + GameApp.tabler[rd].getRegionName());
			while (flag) {
				answerI = keyboard.nextInt();
				if (answerI > 0 && answerI <= attackerSoldiers) {
					flag = false;
					GameApp.tabler[rd].setRegionSoldiers(answerI);
					GameApp.tabler[ra].setRegionSoldiers(attackerSoldiers - answerI);
					GameApp.tabler[rd].setRegionColor(GameApp.tabler[ra].getRegionColor());
				} else {
					System.out.println("Wrong input : number of soldiers must be zero or positive and less than "
							+ attackerSoldiers);
					System.out.println("Please try again..."); // Wrong input message
				}
			}
		}
	} // End of attack()

	public static void fortify(int f1, int f2) { // The option of fortifying soldiers ( from where; to where; how much;
													// )

		System.out.println("How many soldiers do you want to move ?");
		int answerI;
		do {
			answerI = keyboard.nextInt();
			if (answerI <= GameApp.tabler[f1].getRegionSoldiers() - 1) {
				GameApp.tabler[f1].setRegionSoldiers(GameApp.tabler[f1].getRegionSoldiers() - answerI);
				GameApp.tabler[f2].setRegionSoldiers(GameApp.tabler[f2].getRegionSoldiers() + answerI);
				break;
			} else {
				System.out.println(
						"Wrong input : number of soldiers must be greater than 1 and less or equal to " + answerI);
				System.out.println("Please try again..."); // Wrong input message
			}
		} while (true);
	} // End of fortify()

	public static void skip(int j) {

		System.out.println(GameApp.tablep[j].getPlayerName() + " skipped his turn");
	} // End of skip()
} // End of class
