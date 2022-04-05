package jogoDaForca.game;

import java.util.HashSet;
import java.util.Set;

import jogoforca.UI.UI;
import jogoforca.core.Dictionary;
import jogoforca.core.InvalidCharacterException;
import jogoforca.core.Word;
import jogoforca.core.config;

public class Game {

	
	int maxErrors = Integer.parseInt(config.get("maxErrors"));
	public void start() {
		UI.print("Bem vindo ao Jogo da Forca!");
		
		Dictionary dictionary = Dictionary.getInstance();
			
		
		Word word = dictionary.nextWord();
		UI.print("A palavra tem " + word.size() + " Letras");
		
		Set<Character> usedChard = new HashSet<>();
		int errorCount = 0;
		
		while (true) {    
			UI.print(word);
			UI.printLn();
			
			char c; 
			
			try {
				c = UI.readChar("Digite uma letra: ");
				
				if(usedChard.contains(c)) {
					throw new InvalidCharacterException("Esta letra já foi utilizada!");
				}
				
				usedChard.add(c);
				
				if (word.hasChar(c)) {
					UI.print("Você acertou uma letra!");
				}else {
					errorCount++;
					if (errorCount < maxErrors) {
						UI.print("Você errou! Você ainda pode errar " + (maxErrors - errorCount) + " vez(es)");
					}
				}
				if (errorCount == maxErrors){

					UI.print("Fim De jogo você não acertou a palavra!");
					UI.print("A palavra correta era: " + word.getOriginalWord());
					break;
				}
				
				if (word.discovered()) {
					UI.print("PARABÉNS! Você acertou a palavra completa! " + word.getOriginalWord());
					break;
				}
			
			} catch(InvalidCharacterException e) {
				UI.print("Erro: " + e.getMessage());
				UI.printLn();
			}
		}
	}

}
