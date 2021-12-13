package ua.com.foxminded;

import java.util.HashMap;
import java.util.Map;

public class CachedCharsCounter extends Decorator {

	private Map<String, Map<Character, Integer>> cache = new HashMap<>();

	public CachedCharsCounter(CharsCounter charsCounter) {
		super(charsCounter);
	}

	@Override
	public Map<Character, Integer> countChars(String string) {
		return cache.computeIfAbsent(string, s -> super.countChars(string));
	}
}
