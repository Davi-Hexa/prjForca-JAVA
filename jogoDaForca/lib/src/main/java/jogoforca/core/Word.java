package jogoforca.core;

import java.util.HashSet;
import java.util.Set;

public class Word {
	
	private static final char SECRET_CHAR = '_'; //Os espaços em brancos
	
	private String originalWord;
	private Set<Character> foundChars = new HashSet<>(); //procurar a palavra digitada pelo usuario
	private Set<Character> wordChars = new HashSet<>();

	public Word(String originalWord) {
		this.originalWord = originalWord.toUpperCase();
		
		char[] chars = this.originalWord.toCharArray();
		for (char c : chars) {
			wordChars.add(c);
		}
	}

	
	public int size() { //Funçao para descobrir qual o tamanho da palavra
		return originalWord.length();
	}
	
	public boolean hasChar(char c) {
		c = Character.toUpperCase(c);
		if (originalWord.indexOf(c) > -1) {
			foundChars.add(c); //identificar se a pessoa colocou o valor correto no terminal
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() { //para digitar na tela o valor digitado
		StringBuilder sb = new StringBuilder();
		
		char[] charArray = originalWord.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			
			if (foundChars.contains(c)) {
				sb.append(c);
			}else {
				sb.append(SECRET_CHAR);
			}
			
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public boolean discovered() { //retorna o valor para saber se ja foi digitado a palavra, para a implementação de
		return foundChars.equals(wordChars);
	}
	
	public String getOriginalWord() {
		return originalWord;
	}
}	
