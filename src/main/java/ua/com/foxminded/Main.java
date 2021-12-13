package ua.com.foxminded;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CachedCharsCounter charCounter = new CachedCharsCounter(new UniqueCharsCounter());
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter string");
			String input = scanner.nextLine();
			if (input.equals("stop")) {
				break;
			}
			printResult(charCounter.countChars(input));
		}
		scanner.close();
	}

	public static void printResult(Map<Character, Integer> source) {
		source.entrySet().forEach(e -> System.out.println("\"" + e.getKey() + "\" - " + e.getValue()));
	}
}
