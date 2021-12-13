package ua.com.foxminded;

import java.util.Map;
import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

import java.util.LinkedHashMap;

public class UniqueCharsCounter implements CharsCounter {

	@Override
	public Map<Character, Integer> countChars(String string) {
		if (string == null) {
			throw new IllegalArgumentException("Incoming string can't be null!");
		}
		return string.chars().mapToObj(c -> (char) c)
				.collect(groupingBy(identity(), LinkedHashMap::new, reducing(0, c -> 1, Integer::sum)));
	}
}
