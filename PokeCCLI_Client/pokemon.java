package PokeCCLI_Client;

public class pokemon {
	public static final int MAX_EV = 510;
	
	public int[] ev = {0, 0, 0, 0, 0 ,0}; //hp atk def spa spd spe
	public int happy = 255; //0-255
	public int nature = 0; //0-25
	public int gender = -1; //-1 none, 0 male 1, female
	
	public String name = "empty";
	
	public pokemon(String arg){
		name = arg;
	}
	
	private boolean validEv(int arg, int index){
		if ((arg > 255) || (arg < 0)){
			return false;
		}else{
			switch(index){
			case 0:
				return ((arg + ev[1] + ev[2] + ev[3] + ev[4] + ev[5]) <= MAX_EV);
			case 1:
				return ((ev[0] + arg + ev[2] + ev[3] + ev[4] + ev[5]) <= MAX_EV);
			case 2:
				return ((ev[0] + ev[1] + arg + ev[3] + ev[4] + ev[5]) <= MAX_EV);
			case 3:
				return ((ev[0] + ev[1] + ev[2] + arg + ev[4] + ev[5]) <= MAX_EV);
			case 4:
				return ((ev[0] + ev[1] + ev[2] + ev[3] + arg + ev[5]) <= MAX_EV);
			case 5:
				return ((ev[0] + ev[1] + ev[2] + ev[3] + ev[4] + arg) <= MAX_EV);
			}
		return false;
		}
	}
	
	public void setHp(int arg){
		if(validEv(arg, 0)){
			ev[0] = arg;
		}else{
			System.out.println("Error: ev out of range. \n" + 
					"Ev's must be between 0 and 255, total Evs must be less than or equal to 510.");
		}
	}
	public void setAtk(int arg){
		if(validEv(arg, 1)){
			ev[1] = arg;
		}else{
			System.out.println("Error: ev out of range. \n" + 
					"Ev's must be between 0 and 255, total Evs must be less than or equal to 510.");
		}
	}
	public void setDef(int arg){
		if(validEv(arg, 2)){
			ev[2] = arg;
		}else{
			System.out.println("Error: ev out of range. \n" + 
					"Ev's must be between 0 and 255, total Evs must be less than or equal to 510.");
		}
	}
	public void setSpa(int arg){
		if(validEv(arg, 3)){
			ev[3] = arg;
		}else{
			System.out.println("Error: ev out of range. \n" + 
					"Ev's must be between 0 and 255, total Evs must be less than or equal to 510.");
		}
	}
	public void setSpd(int arg){
		if(validEv(arg, 4)){
			ev[4] = arg;
		}else{
			System.out.println("Error: ev out of range. \n" + 
					"Ev's must be between 0 and 255, total Evs must be less than or equal to 510.");
		}
	}
	public void setSpe(int arg){
		if(validEv(arg, 5)){
			ev[5] = arg;
		}else{
			System.out.println("Error: ev out of range. \n" + 
					"Ev's must be between 0 and 255, total Evs must be less than or equal to 510.");
		}
	}
}
