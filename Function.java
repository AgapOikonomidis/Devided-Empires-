import java.util.Scanner;
import java.util.ArrayList;
public class Function {
	
	static Scanner keyboard = new Scanner(System.in);
		
	public static void gameStart() { // Starts the game with round 1 //
		for(int i = 1;i <= 50; i++) { 
			for(int j = 0; j <= 3; j++) {
				System.out.println(GameApp.tablep[j].getPlayerName()+" is your turn to play"); 
				
				// checkSoldiers()
				
				// placeSoldiers()
				
				
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
				System.out.println(GameApp.tabler[ra].getBorders()); //Print borders of region tabler[ra]
				
				String rds = null;
				boolean flag2 = true;
				while(flag2) { // Check valid input
					rds = keyboard.nextLine();	
					for(int counter = 0; counter <= 19; counter++) {
						if(true) {
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
				} // End of attack
				
				attack(ra,rd);
				
				// attack()
				
				// fortify()
			}
		}
	}
	
	public static void checkSoldiers() { // Gives soldiers to players depending on their regions' number //
		
	}
	
	public static void placeSoldiers(int s) { // Players choose where to place their soldiers //
		
	}
	
	public static void attack(int ra, int rd) { // The option of attack ( from where to where; ) //
		
		
	}
	
	public static void fortify() { // The option of fortifying soldiers ( from where; to where; how much; ) //
	
	}
		
}
