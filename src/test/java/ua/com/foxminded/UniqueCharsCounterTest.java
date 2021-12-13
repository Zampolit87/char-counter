package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UniqueCharsCounterTest {

	private UniqueCharsCounter uniqueCharsCounter;

	@BeforeEach
	void init() {
		uniqueCharsCounter = new UniqueCharsCounter();
	}

	@Test
	void givenNull_whenCountChars_thenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			uniqueCharsCounter.countChars(null);
		});
	}

	@Test
	void givenEmptyString_whenCountChars_thenEmptyString() {
		Map<Character, Integer> expected = new HashMap<>();
		assertEquals(expected, uniqueCharsCounter.countChars(""));
	}

	@Test
	void givenHelloWorld_whenCountChars_thenHeloWrd() {
		Map<Character, Integer> expected = new HashMap<>();
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('l', 3);
		expected.put('o', 2);
		expected.put(' ', 1);
		expected.put('w', 1);
		expected.put('r', 1);
		expected.put('d', 1);

		assertEquals(expected, uniqueCharsCounter.countChars("hello world"));
	}

	@Test
	void givenUpperKeys_whenCountChars_thenUpperKeys() {
		Map<Character, Integer> expected = new HashMap<>();
		expected.put('H', 1);
		expected.put('E', 1);
		expected.put('L', 3);
		expected.put('O', 2);
		expected.put(' ', 1);
		expected.put('W', 1);
		expected.put('R', 1);
		expected.put('D', 1);

		assertEquals(expected, uniqueCharsCounter.countChars("HELLO WORLD"));
	}

	@Test
	void givenSpecialChars_whenCountChars_thenSpecialChars() {
		Map<Character, Integer> expected = new HashMap<>();
		expected.put('!', 1);
		expected.put('@', 1);
		expected.put('#', 1);
		expected.put('$', 1);
		expected.put('%', 1);
		expected.put('^', 1);
		expected.put('&', 1);
		expected.put('+', 1);
		expected.put('}', 1);
		expected.put('{', 1);
		assertEquals(expected, uniqueCharsCounter.countChars("!@#$%^&+}{"));
	}
	
	@Test
	void givenMixedKeys_whenCountChars_thenMixedKeys() {
		Map<Character, Integer> expected = new HashMap<>();
		expected.put('H', 1);
		expected.put('e', 1);
		expected.put('L', 1);
		expected.put('l', 2);
		expected.put('O', 1);
		expected.put(' ', 1);
		expected.put('W', 1);
		expected.put('o', 1);
		expected.put('R', 1);
		expected.put('D', 1);

		assertEquals(expected, uniqueCharsCounter.countChars("HeLlO WoRlD"));
	}
}
