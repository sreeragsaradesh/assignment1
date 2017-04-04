package ozlympic;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ozlympic {
	
	public static String selectedGame = null;
	public static boolean cyclingFlag = false;
	public static boolean runningFlag = false;
	public static boolean swimmingFlag = false;
	public static String predictedWinner = null;
	
	public static int cyclingCount = 0;
	public static int swimmingCount = 0;
	public static int runningCount = 0;
	
	public static Athlete cyclingAthletes[] = new Athlete[8];
	public static Athlete swimmingAthletes[] = new Athlete[8];
	public static Athlete runningAthletes[] = new Athlete[8];
	
	public static Athlete cyclingWinners[] = new Athlete[3];
	public static Athlete swimmingWinners[] = new Athlete[3];
	public static Athlete runningWinners[] = new Athlete[3];
	
	public static String cwinner1Id = null, cwinner2Id = null, cwinner3Id = null;
	public static String swinner1Id = null, swinner2Id = null, swinner3Id = null;
	public static String rwinner1Id = null, rwinner2Id = null, rwinner3Id = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		mainMenu();
			
	}
	
	public static void mainMenu() {
		
		int input;
		Scanner in = new Scanner(System.in);
		
		do{
			
			input = 0;
		
		System.out.println("");
		System.out.println("Ozlympic	Game");
		System.out.println("====================");
		
		System.out.println("1.	Select a game to run");
		System.out.println("2.	Predict	the winner of the game");
		System.out.println("3.	Start the game");
		System.out.println("4.	Display	the final results of all games");
		System.out.println("5.	Display	the points of all athletes");
		System.out.println("6.	Exit");
		System.out.println("");
		System.out.println("Enter an option:	");
		
		input = in.nextInt();
		
		try {
			switch (input) {
			case 1: {
				selectGame();
				break;
			}
			case 2: {
				predictWinner();
				break;
			}
			case 3: {
				startGame();					
				break;
			}
			case 4: {
				finalResults();
				break;
			}
			case 5: {
				displayPoints();		
				break;
			}
			case 6: {
				System.out.println("Game Exited");
				System.exit(0);

			}
			default:

				System.out.println("Enter a correct choice");
			}

		} catch (Exception e) {// handles any exceptions which happens during
								// runtime and redirects to main menu
			System.out.println("Please select a valid option!");
		}
		
		}while( input != 6);
		
		
	}
	//select game
	public static void selectGame() {
		
		int input = 0;
		
		do {
			
			System.out.println("Please select a game:");
			System.out.println("1.Running");
			System.out.println("2.Swimming");
			System.out.println("3.Cycling");
			
			Scanner in = new Scanner(System.in);
			input = in.nextInt();
			
			Athlete athlete[] = new Athlete[8];
			
			AthleteDatabase a1 = new AthleteDatabase();
			athlete = AthleteDatabase.getAthlete();
			FilterAthletes fa1 = new FilterAthletes(athlete);
			
			try {
				switch (input) {
				case 1: {
					//running
					selectedGame = "R";
					fa1.FilterNow('R');			
					//filterAthletes(athlete,'R');
					System.out.println("Running selected. Participants are ready..Please start the game now.");
					break;
				}
				case 2: {
					//Swimming;
					selectedGame = "S";
					fa1.FilterNow('S');	
					//filterAthletes(athlete,'S');
					System.out.println("Swimming selected. Participants are ready..Please start the game now.");
					break;
				}
				case 3: {
					//Cycling;
					selectedGame = "C";
					fa1.FilterNow('C');	
					//filterAthletes(athlete,'C');
					System.out.println("Cycling selected. Participants are ready..Please start the game now.");
					break;
				}
				default:

					System.out.println("Enter a correct choice");
				}

			} catch (Exception e) {// handles any exceptions which happens
									// during
									// runtime and redirects to main menu
				System.out.println("Please select a valid option!  ");
			}
			
			cyclingCount = fa1.getCyclingCount();
			runningCount = fa1.getRunningCount();
			swimmingCount = fa1.getSwimmingCount();
			
			cyclingAthletes = fa1.getCyclingAthletes();
			runningAthletes = fa1.getRunningAthletes();
			swimmingAthletes = fa1.getSwimmingAthletes();
			

		} while ((input < 1) || (input > 3));
		
		
	}
	
	private static void predictWinner() {
		System.out.println("Enter the ID of the athlete");
		
		Scanner in = new Scanner(System.in);
		predictedWinner = in.nextLine();
	}
	
	private static void startGame() {
		Athlete athlete[] = new Athlete[26];
		athlete = AthleteDatabase.getAthlete();
		
		
		int winnerTime = 0, secondTime = 0, thirdTime = 0;
		int[] time = new int[8];
		int timeLength = 0;
		
		if (selectedGame == "R") {
			for(int i = 0; i <= runningCount; i++) {
				time[i] = runningAthletes[i].getTime();
				//System.out.println(cyclingAthletes[i].getTime());
			}
			
			for (int i = 0; i <= runningCount; i++) {
				Arrays.sort(time);
			}
			
			timeLength = time.length;
			winnerTime = time[timeLength-1];
			secondTime = time[timeLength-2];
			thirdTime = time[timeLength-3];
			
			//System.out.println("1 " + winnerTime + "2 " + secondTime + "3 " + thirdTime);
			
			for (int i = 0; i <= runningCount; i++) {
				int points = 0, j = 0;
				if (runningAthletes[i].getTime() == winnerTime) {
					rwinner1Id = runningAthletes[i].getAthId();
					points = runningAthletes[i].getPoints();
					runningAthletes[i].setPoints(5+points);
					runningWinners[j] = runningAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == runningWinners[j].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if (runningAthletes[i].getTime() == secondTime) {
					rwinner2Id = runningAthletes[i].getAthId();
					runningAthletes[i].setPoints(2+points);
					runningWinners[j+1] = runningAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == runningWinners[j+1].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if (runningAthletes[i].getTime() == thirdTime) {
					rwinner3Id = runningAthletes[i].getAthId();
					runningAthletes[i].setPoints(1+points);
					runningWinners[j+2] = runningAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == runningWinners[j+2].getAthId())
							athlete[k].setPoints(5+points);
					}
				}			
			}
			
			//System.out.println("winner1Id " + winner1Id + " winner2Id " + winner2Id + " winner3Id " + winner3Id);	
			
			if (predictedWinner == rwinner1Id)
				System.out.println("Congratulations! You predicted the winner..");
			
			System.out.println("Running completed successfully");
			runningFlag = true;
			
		}
		else if (selectedGame == "S") {
			for(int i = 0; i <= swimmingCount; i++) {
				time[i] = swimmingAthletes[i].getTime();
				//System.out.println(cyclingAthletes[i].getTime());
			}
			
			for (int i = 0; i <= swimmingCount; i++) {
				Arrays.sort(time);
			}
			
			timeLength = time.length;
			winnerTime = time[timeLength-1];
			secondTime = time[timeLength-2];
			thirdTime = time[timeLength-3];
			
			for (int i = 0; i <= swimmingCount; i++) {
				int points = 0, j = 0;
				if (swimmingAthletes[i].getTime() == winnerTime) {
					swinner1Id = swimmingAthletes[i].getAthId();
					points = swimmingAthletes[i].getPoints();
					swimmingAthletes[i].setPoints(5+points);
					swimmingWinners[j] = swimmingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == swimmingWinners[j].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if (swimmingAthletes[i].getTime() == secondTime) {
					swinner2Id = swimmingAthletes[i].getAthId();
					swimmingAthletes[i].setPoints(2+points);
					swimmingWinners[j+1] = swimmingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == swimmingWinners[j+1].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if (swimmingAthletes[i].getTime() == thirdTime) {
					swinner3Id = swimmingAthletes[i].getAthId();
					swimmingAthletes[i].setPoints(1+points);
					swimmingWinners[j+2] = swimmingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == swimmingWinners[j+2].getAthId())
							athlete[k].setPoints(5+points);
					}
				}			
			}
			
			if (predictedWinner == swinner1Id)
				System.out.println("Congratulations! You predicted the winner..");
			
			System.out.println("Swimming completed successfully");
			swimmingFlag = true;
			
		}
		else if (selectedGame == "C"){
			for(int i = 0; i <= cyclingCount; i++) {
				time[i] = cyclingAthletes[i].getTime();
				//System.out.println(cyclingAthletes[i].getTime());
			}
			
			for (int i = 0; i <= cyclingCount; i++) {
				Arrays.sort(time);
			}
			
			timeLength = time.length;
			winnerTime = time[timeLength-1];
			secondTime = time[timeLength-2];
			thirdTime = time[timeLength-3];
			
			
			for (int i = 0; i <= cyclingCount; i++) {
				int points = 0, j = 0;
				if (cyclingAthletes[i].getTime() == winnerTime) {
					cwinner1Id = cyclingAthletes[i].getAthId();
					points = cyclingAthletes[i].getPoints();
					cyclingAthletes[i].setPoints(5+points);
					cyclingWinners[j] = cyclingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == cyclingWinners[j].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if (cyclingAthletes[i].getTime() == secondTime) {
					cwinner2Id = cyclingAthletes[i].getAthId();
					cyclingAthletes[i].setPoints(2+points);
					cyclingWinners[j+1] = cyclingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == cyclingWinners[j+1].getAthId())
							athlete[k].setPoints(5+points);
					}
				}
					
				else if (cyclingAthletes[i].getTime() == thirdTime) {
					cwinner3Id = cyclingAthletes[i].getAthId();
					cyclingAthletes[i].setPoints(1+points);
					cyclingWinners[j+2] = cyclingAthletes[i];
					
					for (int k = 0; k < athlete.length; k++) {
						if (athlete[k].getAthId() == cyclingWinners[j+2].getAthId())
							athlete[k].setPoints(5+points);
					}
				}			
			}
			
			//System.out.println("winner1Id " + winner1Id + " winner2Id " + winner2Id + " winner3Id " + winner3Id);	
			
			if (predictedWinner == cwinner1Id)
				System.out.println("Congratulations! You predicted the winner..");
			
			System.out.println("Cycling completed successfully");
			cyclingFlag = true;
		}
		else
			System.out.println("Please select a game first");
			
		
	}
	
	
	public static void finalResults() {
		System.out.println("The final results are..");
		System.out.println("	");
		
		System.out.println("Item: Cycling");
		if (cyclingFlag == true) {
			int cyclingLength = cyclingWinners.length;			
			for(int i = 0; i < cyclingLength; i++){
				System.out.println("ID " + cyclingWinners[i].getAthId() + 
						" Name " + cyclingWinners[i].getName() + 
						" Age " + cyclingWinners[i].getAge() +
						" State " + cyclingWinners[i].getState() +
						" Time " + cyclingWinners[i].getTime());
			}
			
		}
		else
			{
			System.out.println("Cycling hasn't completed yet..");	
			System.out.println("");	
			}

		System.out.println("Item: Swimming");
		if (swimmingFlag == true) {
			int swimmingLength = swimmingWinners.length;
			for (int i = 0; i < swimmingLength; i++) {
				System.out.println("ID " + swimmingWinners[i].getAthId() + " Name " + swimmingWinners[i].getName() + " Age "
						+ swimmingWinners[i].getAge() + " State " + swimmingWinners[i].getState() + " Time "
						+ swimmingWinners[i].getTime());
			}
			
		}
		else
			{
			System.out.println("Swimming hasn't completed yet..");
			System.out.println("");	
			}
		
		System.out.println("Item: Running");
		if (runningFlag == true) {
			int runningLength = runningWinners.length;			
			for (int i = 0; i < runningLength; i++) {
				System.out.println("ID " + runningWinners[i].getAthId() + " Name " + runningWinners[i].getName() + " Age "
						+ runningWinners[i].getAge() + " State " + runningWinners[i].getState() + " Time "
						+ runningWinners[i].getTime());
			}
			
		}
		else{
			
			System.out.println("Running hasn't completed yet..");
			System.out.println("");	
			}
	}
	
	public static void displayPoints() {
		Athlete athlete[] = new Athlete[26];
		athlete = AthleteDatabase.getAthlete();
		
		Points p1 = new Points(athlete,
				rwinner1Id,rwinner2Id,rwinner3Id,
				swinner1Id,swinner2Id,swinner3Id,		
				cwinner1Id,cwinner2Id,cwinner3Id);
		p1.calculatePoints();
		
	}
}
