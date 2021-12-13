package ua.com.foxminded;

import java.util.Map;

public abstract class Decorator implements CharsCounter {

	private CharsCounter charsCounter;

	public Decorator(CharsCounter charsCounter) {
		this.charsCounter = charsCounter;
	}

	@Override
	public Map<Character, Integer> countChars(String string) {
		return charsCounter.countChars(string);
	}
}
