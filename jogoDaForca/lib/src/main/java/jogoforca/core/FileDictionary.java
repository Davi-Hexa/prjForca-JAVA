package jogoforca.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jogoDaForca.game.GameException;
import jogoforca.utils.RandomUtils;

public class FileDictionary extends Dictionary{

	private static final String FILE_NAME = "dicionario.txt";
	
	private List<String> words = new ArrayList<>();
	
	
	
	public FileDictionary() {
		load();
	}

	private void load() {
		
		try(Scanner scanner = 
				new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {
			
			while(scanner.hasNextLine()) {
				String word = scanner.nextLine().trim();
				words.add(word);
			}
			if(words.size() == 0) {
				throw new GameException("A lista de palavras não pode ser vazia!");
			}
			
		}
		
	}
	@Override
	public Word nextWord() {
		int random = RandomUtils.newRandomNumber(0, words.size()); //a palavra que vai vir.
		return new Word(words.get(random));
	}

	@Override
	public String getName() {

		return "arquivo "+ FILE_NAME;
	}
}
