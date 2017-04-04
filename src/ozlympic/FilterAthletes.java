package ozlympic;

import java.util.Random;

public class FilterAthletes extends Athlete{
	
	private static Athlete[] athlete = new Athlete[26];
	public static int cyclingCount = 0;
	public static int swimmingCount = 0;
	public static int runningCount = 0;
	public static Athlete cyclingAthletes[] = new Athlete[8];
	public static Athlete swimmingAthletes[] = new Athlete[8];
	public static Athlete runningAthletes[] = new Athlete[8];

	public FilterAthletes(String athId, String name, int age, String state, char type, int points) {
		super(athId, name, age, state, type, points);
		// TODO Auto-generated constructor stub
	}
	
	public FilterAthletes(Athlete[] athlete) {		
		super("","",0,"",'x',0);
		this.athlete = athlete;		
	}
	
	public void FilterNow(char type) {
		int count = 0,j=0;
		Random random = new Random();
		int maxCount = random.nextInt(8-4)+4;
		
		if (type == 'C') {
			/*athlete
			 * count
			 * maxcount
			 * j
			 */
			for(int i = 0; i < athlete.length && count < maxCount ; i++) {
				if ((athlete[i].getType() == 'C') || 
						(athlete[i].getType() == 'A')) {
					athlete[i].compete(500, 800);
					//System.out.println("type" + athlete[i].getType() + " " + " " + athlete[i].getAthId() + athlete[i].getTime());
					cyclingAthletes[j] = athlete[i];
					cyclingCount = count;
					count++;
					j++;					
				}
			}
		}
		
		if (type == 'S') {			
			for(int i = 0; i < athlete.length && count < maxCount ; i++) {
				if ((athlete[i].getType() == 'S') || 
						(athlete[i].getType() == 'A')) {
					athlete[i].compete(100, 200);
					//System.out.println("type" + athlete[i].getType() + " " + " " + athlete[i].getAthId() + athlete[i].getTime());
					swimmingAthletes[j] = athlete[i];
					swimmingCount = count;
					count++;
					j++;					
				}
			}
		}
		
		if (type == 'R') {			
			for(int i = 0; i < athlete.length && count < maxCount ; i++) {
				if ((athlete[i].getType() == 'R') || 
						(athlete[i].getType() == 'A')) {
					athlete[i].compete(500, 800);
					//System.out.println("type" + athlete[i].getType() + " " + " " + athlete[i].getAthId() + athlete[i].getTime());
					runningAthletes[j] = athlete[i];
					runningCount = count;
					count++;
					j++;					
				}
			}
		}	
	}

	public static int getCyclingCount() {
		return cyclingCount;
	}

	public static void setCyclingCount(int cyclingCount) {
		FilterAthletes.cyclingCount = cyclingCount;
	}

	public static int getSwimmingCount() {
		return swimmingCount;
	}

	public static void setSwimmingCount(int swimmingCount) {
		FilterAthletes.swimmingCount = swimmingCount;
	}

	public static int getRunningCount() {
		return runningCount;
	}

	public static void setRunningCount(int runningCount) {
		FilterAthletes.runningCount = runningCount;
	}

	public static Athlete[] getCyclingAthletes() {
		return cyclingAthletes;
	}

	public static void setCyclingAthletes(Athlete[] cyclingAthletes) {
		FilterAthletes.cyclingAthletes = cyclingAthletes;
	}

	public static Athlete[] getSwimmingAthletes() {
		return swimmingAthletes;
	}

	public static void setSwimmingAthletes(Athlete[] swimmingAthletes) {
		FilterAthletes.swimmingAthletes = swimmingAthletes;
	}

	public static Athlete[] getRunningAthletes() {
		return runningAthletes;
	}

	public static void setRunningAthletes(Athlete[] runningAthletes) {
		FilterAthletes.runningAthletes = runningAthletes;
	}


	

	
	

}
