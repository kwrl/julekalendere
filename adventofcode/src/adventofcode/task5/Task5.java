package adventofcode.task5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task5 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		long start = System.currentTimeMillis();

		MessageDigest md5 = MessageDigest.getInstance("MD5");
		String input = "abbhdwsy";

		int count = 0;
		int idx = 0;
		
		char[] output = new char[8];

		while (count < 8) {
			byte[] hashBytes = md5.digest((input + idx++).getBytes());
			
			if ((hashBytes[0] | hashBytes[1]) != 0 || (0xFF & hashBytes[2]) > 0x07) {
				continue;
			}
			
			int pos = hashBytes[2] & 0xFF;
			
			if (pos < 0 || output[pos] != 0) {
				continue;
			}
			
			output[pos] = Integer.toHexString((hashBytes[3] & 0xF0) >> 4).charAt(0);
			
			count++;
		}
		System.out.println(new String(output));
		System.out.println((System.currentTimeMillis() - start) / 1000);
	}
}
