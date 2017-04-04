package ozlympic;


public class AthleteDatabase extends Ozlympic{
	
	private static Athlete athlete[];
	
	/* This is the Database which we would be using to store the data regarding the players */

	public AthleteDatabase(){
		
		athlete = new Athlete[26];
		athlete[0] = new Athlete("A01", "Albert",21, "AState",'C',0);
		athlete[1] = new Athlete("B01", "Bijo",22, "BState",'S',0);
		athlete[2] = new Athlete("C01", "Carren",23, "CState",'R',0);
		athlete[3] = new Athlete("D01", "Donald",24, "DState",'A',0);
		athlete[4] = new Athlete("E01", "Erric",25, "EState",'C',0);
		athlete[5] = new Athlete("F01", "Fletcher",26, "FState",'C',0);
		athlete[6] = new Athlete("G01", "Geo",27, "GState",'C',0);
		athlete[7] = new Athlete("H01", "Harrvy",21, "HState",'C',0);
		athlete[8] = new Athlete("I01", "Ivan",22, "IState",'A',0);
		athlete[9] = new Athlete("J01", "John",24, "JState",'A',0);
		athlete[10] = new Athlete("K01", "Karman",25, "KState",'A',0);
		athlete[11] = new Athlete("L01", "Lionel",25, "LState",'A',0);
		athlete[12] = new Athlete("M01", "Messi",23, "MState",'A',0);
		athlete[13] = new Athlete("N01", "Neymar",24, "NState",'S',0);
		athlete[14] = new Athlete("O01", "Orlando",21, "OState",'R',0);
		athlete[15] = new Athlete("P01", "Palmer",25, "PState",'R',0);
		athlete[16] = new Athlete("Q01", "Queen",26, "QState",'R',0);
		athlete[17] = new Athlete("R01", "Robin",27, "RState",'R',0);
		athlete[18] = new Athlete("S01", "Sattire",24, "SState",'S',0);
		athlete[19] = new Athlete("T01", "Tommy",27, "TState",'S',0);
		athlete[20] = new Athlete("U01", "Uvan",28, "UState",'S',0);
		athlete[21] = new Athlete("V01", "Veronica",29, "VState",'S',0);
		athlete[22] = new Athlete("W01", "Wytt",21, "WState",'A',0);
		athlete[23] = new Athlete("X01", "Xavier",22, "XState",'A',0);
		athlete[24] = new Athlete("Y01", "Yen",24, "YState",'R',0);
		athlete[25] = new Athlete("Z01", "Zohan",26, "ZState",'R',0);
				
	}
	
	public static Athlete[] getAthlete() {
		return athlete;
	}

}
