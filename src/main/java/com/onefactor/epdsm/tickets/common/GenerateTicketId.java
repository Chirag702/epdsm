package com.onefactor.epdsm.tickets.common;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;
@Service
public class GenerateTicketId {

	private final Random random = new SecureRandom();

	public String generateCustomString() {
		String part1 = generateAlphanumeric(8); // Generates 'T6DD28E9B'
		String part2 = generateNumeric(3); // Generates '001'
		String part3 = generateAlphabetic(3); // Generates 'QOG'

		return String.format("%s-%s-%s", part1, part2, part3);
	}

	private String generateAlphanumeric(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		return randomString(characters, length);
	}

	private String generateNumeric(int length) {
		String numbers = "0123456789";
		return randomString(numbers, length);
	}

	private String generateAlphabetic(int length) {
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return randomString(letters, length);
	}

	private String randomString(String characters, int length) {
		StringBuilder result = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			result.append(characters.charAt(random.nextInt(characters.length())));
		}
		return result.toString();
	}
}
