package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CachedCharsCounterTest {

	@Mock
	CharsCounter charsCounter;

	@InjectMocks
	CachedCharsCounter cachedCharsCounter;

	@Test
	void givenStringTwice_whenCharsCounter_thenCharsCounterCalledOnce() {
		String text = "hello world";
		LinkedHashMap<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('l', 3);
		expected.put('o', 2);
		expected.put(' ', 1);
		expected.put('w', 1);
		expected.put('r', 1);
		expected.put('d', 1);

		when(charsCounter.countChars(text)).thenReturn(expected);
		cachedCharsCounter.countChars(text);
		cachedCharsCounter.countChars(text);

		assertEquals(expected, cachedCharsCounter.countChars(text));
		verify(charsCounter, times(1)).countChars(text);
	}
}
