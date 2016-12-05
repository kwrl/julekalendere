package adventofcode.task5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task5 {
	
	private static byte[] hash(String doorID, int salt) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		return md5.digest((doorID + salt).getBytes());
	}

	public static String toHexString(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();

		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}

		return hexString.toString();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		long start = System.currentTimeMillis();
		String input = "abbhdwsy";

		int count = 0;
		char[] output = new char[8];
		int idx = 0;
		
		while (count < 8) {
			byte[] hashBytes = hash(input, idx++);

			if ((hashBytes[0] | hashBytes[1]) != 0 || (0xFF & hashBytes[2]) > 0x0F) {
				continue;
			}

			String hash = toHexString(hashBytes);

			int pos = hash.charAt(5) - 48;
			if (pos < 0 || pos >= output.length || output[pos] != 0) {
				continue;
			}
			output[pos] = hash.charAt(6);
			count++;
		}
		System.out.println((System.currentTimeMillis() - start) / 1000);
		System.out.println(new String(output));
	}
}
