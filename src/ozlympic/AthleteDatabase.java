package ozlympic;


public class AthleteDatabase extends Ozlympic{
	
	private static Athlete athlete[];
	
	

	public AthleteDatabase(){
		
		athlete = new Athlete[26];
		athlete[0] = new Athlete("A01", "AJohn",21, "AState",'C',0);
		athlete[1] = new Athlete("B01", "BJohn",22, "BState",'S',0);
		athlete[2] = new Athlete("C01", "CJohn",23, "CState",'R',0);
		athlete[3] = new Athlete("D01", "DJohn",24, "DState",'A',0);
		athlete[4] = new Athlete("E01", "EJohn",25, "EState",'C',0);
		athlete[5] = new Athlete("F01", "FJohn",26, "FState",'C',0);
		athlete[6] = new Athlete("G01", "GJohn",27, "GState",'C',0);
		athlete[7] = new Athlete("H01", "HJohn",21, "HState",'C',0);
		athlete[8] = new Athlete("I01", "IJohn",22, "IState",'A',0);
		athlete[9] = new Athlete("J01", "JJohn",24, "JState",'A',0);
		athlete[10] = new Athlete("K01", "KJohn",25, "KState",'A',0);
		athlete[11] = new Athlete("L01", "LJohn",25, "LState",'A',0);
		athlete[12] = new Athlete("M01", "MJohn",23, "MState",'A',0);
		athlete[13] = new Athlete("N01", "NJohn",24, "NState",'S',0);
		athlete[14] = new Athlete("O01", "OJohn",21, "OState",'R',0);
		athlete[15] = new Athlete("P01", "PJohn",25, "PState",'R',0);
		athlete[16] = new Athlete("Q01", "QJohn",26, "QState",'R',0);
		athlete[17] = new Athlete("R01", "RJohn",27, "RState",'R',0);
		athlete[18] = new Athlete("S01", "SJohn",24, "SState",'S',0);
		athlete[19] = new Athlete("T01", "TJohn",27, "TState",'S',0);
		athlete[20] = new Athlete("U01", "UJohn",28, "UState",'S',0);
		athlete[21] = new Athlete("V01", "VJohn",29, "VState",'S',0);
		athlete[22] = new Athlete("W01", "WJohn",21, "WState",'A',0);
		athlete[23] = new Athlete("X01", "XJohn",22, "XState",'A',0);
		athlete[24] = new Athlete("Y01", "YJohn",24, "YState",'R',0);
		athlete[25] = new Athlete("Z01", "ZJohn",26, "ZState",'R',0);
				
	}
	
	public static Athlete[] getAthlete() {
		return athlete;
	}

}
