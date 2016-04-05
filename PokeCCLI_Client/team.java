package PokeCCLI_Client;

public class team {
	public String name = "";
	
	public static pokemon[] pokemonList = new pokemon[6];
	
	public team(String arg){
		name = arg;
	}
	
	public void setPokemon(int arg1, String arg2){
		if(pokeConst.isName(arg2)&& arg1 >= 0 && arg1 <= 5){
			pokemonList[arg1] = new pokemon(arg2);
		}else{
			System.out.println("Error: invalid pokemon index / name.");
		}
	}
}
