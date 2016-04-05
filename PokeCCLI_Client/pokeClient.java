package PokeCCLI_Client;
import java.util.*;
public class pokeClient{
	public static final ArrayList<String> COMMAND_LIST = new ArrayList<String>(Arrays.asList(
		new String[] {
				"help",
				"mkTeam"
		}));
	
	public static final ArrayList<String> COMMAND_LIST_TEAM = new ArrayList<String>(Arrays.asList(
		new String[] {
				"help",
				"setPokemon",
				"edit",
				"lsPokemon",
				"exit"
		}));
	
	public static final ArrayList<String> COMMAND_LIST_POKE = new ArrayList<String>(Arrays.asList(
		new String[] {
				"help",
				"set",
				"show"
		}));
	public static final ArrayList<String> POKE_SHOW = new ArrayList<String>(Arrays.asList(
		new String[] {
				"ev",
				"brief"
	}));
	public static final ArrayList<String> POKE_SET = new ArrayList<String>(Arrays.asList(
			new String[]{
			"ev",
			"move",
			"happiness",
			"nature",
			"gender"
	}));
	
	private static Scanner uIn = new Scanner(System.in);
	
	private static team vTeam = new team("null");
	
	public static void main(String[] args){
		Banner();
		ArrayList<String> cmd = new ArrayList<String>();
		while(true){
			cmd = getCmd("pokeCLI# ");
			runMain(cmd);	
		}
	}
	
	private static void runMain(ArrayList<String> cmd){
		int cmdDex = COMMAND_LIST.indexOf(cmd.get(0));
		String warnRes = "";
		switch(cmdDex){
		case 0://
			for(String i : COMMAND_LIST)System.out.println("   " + i);
			break;
		case 1://
			teamBuilder(cmd);
			break;
		default://
			System.out.println("Error: invalid command, use \"help\"");
			break;
		}
	}
	
	
	private static ArrayList<String> getCmd(String prefix){
		System.out.print(prefix);
		ArrayList<String> ret = new ArrayList<String>();
		String buff = "";
		buff = uIn.nextLine();
		Scanner sep = new Scanner(buff);
		try{
			while((buff = sep.next())!=null){
				ret.add(buff);
			}
		}catch(Exception e){}
		try{ret.get(0);}catch(Exception e){ret=getCmd(prefix);}
		sep.close();
		return ret;
	}
	
	private static void Banner(){
		System.out.println("                                .::.\n                              .;:**'            AMC\n                              `                  0\n  .:XHHHHk.              db.   .;;.     dH  MX   0\noMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN\nQMMMMMb  \"MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM\n  `MMMM.  )M> :X!Hk. MMMM   XMM.o\"  .  MMMMMMM X?XMMM MMM>!MMP\n   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `\" MX MMXXMM\n    ~MMMMM~ XMM. .XM XM`\"MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP\n     ?MMM>  YMMMMMM! MM   `?MMRb.    `\"\"\"   !L\"MMMMM XM IMMM\n      MMMX   \"MMMM\"  MM       ~%:           !Mh.\"\"\" dMI IMMP\n      'MMM.                                             IMX\n       ~M!M                                             IMP\n");
		
		System.out.println("##############################################################");
		
		System.out.println("PokeCLI v0.1.0");
		System.out.println("Find at https://github.com/chopsticks00/PokeCLI");
		
		System.out.println("##############################################################");
	}

	private static void teamBuilder(ArrayList<String> cmd){
		String teamName = "null";
		try{
			teamName = cmd.get(1);
		}catch(Exception e){
			System.out.println("Error: please specify team name.");
			return;
		}
		vTeam = new team(teamName);
		while(true){
			cmd = getCmd(teamName + "# ");
			if (runTeam(cmd) == -1)
				break;
		}
	}
	
	private static int runTeam(ArrayList<String> cmd){
		int cmdDex = COMMAND_LIST_TEAM.indexOf(cmd.get(0));
		String warnRes = "";
		switch(cmdDex){
		case 0:
			for(String i : COMMAND_LIST_TEAM){
				System.out.println("   " + i);
			}
			return 0;
		case 1:
			try{
			Integer.parseInt(cmd.get(1));
			cmd.get(2);
			}catch(Exception e){System.out.println("Error: please specify team index<1-6> & pokemon name.");return 0;}
			vTeam.setPokemon(Integer.parseInt(cmd.get(1))-1, cmd.get(2));
			return 0;
		case 2:
			pokeBuilder(cmd);
			return 0;
		case 3:
			for(int i = 0; i < 6; i++){
				try{
					System.out.println((i + 1) + " - " + vTeam.pokemonList[i].name);
				}catch(Exception e){
					
				}			
			}
			return 0;
		case 4:
			System.out.print("WARNING: all unsaved data will be lost.\nDo you wish to continue?[Y/n]");
			warnRes = uIn.nextLine();
			switch(warnRes){
			case "Y":
				return -1;
			default:
				return 0;
			}
		default:
			System.out.println("Error: invalid command, use \"help\".");
			return 0;
		}
	}
	
	private static void pokeBuilder(ArrayList<String> cmd){
		int index = -1;
		try{
			Integer.parseInt(cmd.get(1));
		}catch(Exception e){System.out.println("Error: please specify team index<1-6>.");return;}
		if(Integer.parseInt(cmd.get(1)) - 1 < 0 || Integer.parseInt(cmd.get(1)) - 1 > 5){
			System.out.println("Error: please specify team index<1-6>.");
			return;
		}
		index = Integer.parseInt(cmd.get(1)) -1;
		try{
			String buff = vTeam.pokemonList[index].name;			
		}catch(Exception e){
			System.out.println("Error: pokemon at index " + (index + 1) + " does not exist.");
			return;
		}
		
		while (true){
			cmd = getCmd(vTeam.pokemonList[index].name + "-" + (index + 1) + "# ");
			runPoke(cmd, index);
		}
	}
	
	private static int runPoke(ArrayList<String> cmd, int index){
		int cmdDex = COMMAND_LIST_POKE.indexOf(cmd.get(0));
		
		switch(cmdDex){
		case 0:
			for(String i : COMMAND_LIST_POKE){
				System.out.println("   " + i);
			}
			return 0;
		case 1:
			try{cmd.get(1);}catch(Exception e){System.out.println("Error: please specify set argument");}
			int setDex = POKE_SET.indexOf(cmd.get(1));
			switch(setDex){
			case 0:
				try{cmd.get(2);}catch(Exception e){System.out.println("Error: please specify ev type \"hp/atk/def/spa/spd/spe\"");return 0;}
				switch(cmd.get(2)){
				case "hp":
					vTeam.pokemonList[index].setHp(Integer.parseInt(cmd.get(3)));
					break;
				case "atk":
					vTeam.pokemonList[index].setAtk(Integer.parseInt(cmd.get(3)));
					break;
				case "def":
					vTeam.pokemonList[index].setDef(Integer.parseInt(cmd.get(3)));
					break;
				case "spa":
					vTeam.pokemonList[index].setSpa(Integer.parseInt(cmd.get(3)));
					break;
				case "spd":
					vTeam.pokemonList[index].setSpd(Integer.parseInt(cmd.get(3)));
					break;
				case "spe":
					vTeam.pokemonList[index].setSpe(Integer.parseInt(cmd.get(3)));
					break;
				default:
					System.out.println("Error: please specify ev type \"hp/atk/def/spa/spd/spe\"");
					break;
				}
				break;
			case 1:
				/*
				 * This area is for setting moves
				 * first they must be programmed in
				 * 
				 */
				break;
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				if(cmd.get(1).equals("help")){
					for(String i : POKE_SET){
						System.out.println("   " + i);
					}
				}else{
					System.out.println("Error: invalid set argument, use \"set help\"");
				}
				break;
			}
			return 0;
		case 2:
			try{cmd.get(1);}catch(Exception e){System.out.println("Error: please specify a show argument.");return 0;}
			int showDex = POKE_SHOW.indexOf(cmd.get(1));
			switch(showDex){
			case 0:
				int evs = pokemon.MAX_EV;
				for(int i = 0; i < 6; i ++){
					switch(i){
					case 0:
						System.out.print("hp  - ");
						break;
					case 1:
						System.out.print("atk - ");
						break;
					case 2:
						System.out.print("def - ");
						break;
					case 3:
						System.out.print("spa - ");
						break;
					case 4:
						System.out.print("spd - ");
						break;
					case 5:
						System.out.print("spe - ");
						break;
					}
					System.out.println(vTeam.pokemonList[index].ev[i]);
					evs -= vTeam.pokemonList[index].ev[i];
				}
				System.out.println(evs + " Ev's left");
				break;
			case 1:
				/*This will be the are where
				 * we can show all general information
				 * about the currently specified pokemon
				 * eg: happiness, ev's, gender, name, etc...
				 */
				break;
			default:
				if(cmd.get(1).equals("help")){
					for(String i : POKE_SHOW){
						System.out.println("   " + i);
					}
				}else{
					System.out.println("Error: invalid show argument, use \"show help\".");
				}
					break;
			}
			return 0;
		default:
			System.out.println("Error: invalid command, use \"help\".");
			return 0;
		}
	}
}
