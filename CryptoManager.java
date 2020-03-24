package application;

import java.util.Arrays;

public class CryptoManager {

private static final char LOWER_BOUND = ' '; //32
private static final char UPPER_BOUND = '_'; //95
private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;//64
public static String encrypt ="";
public static String decrypt = "";
static char  c;
/**
* This method determines if a string is within the allowable bounds of ASCII codes
* according to the LOWER_BOUND and UPPER_BOUND characters
* @param plainText a string to be encrypted, if it is within the allowable bounds
* @return true if all characters are within the allowable bounds, false if any character is outside
*/
//bound between 32 and 95
public static boolean stringInBounds (String plainText) {
// throw new RuntimeException("method not implemented");
boolean check = true;
char[] convert = plainText.toCharArray();

for(int i = 0; i < convert.length; i++) {
	if (convert[i] < LOWER_BOUND || convert[i] > UPPER_BOUND)
		check = false;
}
return check;

}

/**
* Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
* and each character in plainText is replaced by the character \"offset\" away from it
* @param plainText an uppercase string to be encrypted.
* @param key an integer that specifies the offset of each character
* @return the encrypted string
*/
public static String encryptCaesar(String plainText, int key) {//check
//throw new RuntimeException("method not implemented");

while (key > RANGE) {
key = key -   RANGE;
}

char[] a = plainText.toCharArray();

	for (int i = 0; i < plainText.length(); i++) {
			
			a[i]= (char) (plainText.charAt(i) + key);
			
			if (a[i] < LOWER_BOUND || a[i] > UPPER_BOUND) { //a[i] > 32 or a[i] <95
				a[i] = (char) (a[i] - RANGE);
			}
			
		}
		

encrypt = String.valueOf(a); 
decryptCaesar(encrypt, key);//pass encrypted text and key to decryptCasear
return encrypt;


}

/**
* Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset
* according to the ASCII value of the corresponding character in bellasoStr, which is repeated
* to correspond to the length of plainText
* @param plainText an uppercase string to be encrypted.
* @param bellasoStr an uppercase string that specifies the offsets, character by character.
* @return the encrypted string
*/
public static String encryptBellaso(String plainText, String bellasoStr) {
//throw new RuntimeException("method not implemented");
	int x = plainText.length();
	String bellasoEncrypted = "";
	
	
	while (bellasoStr.length() > plainText.length()) {
		bellasoStr = bellasoStr.substring(0, bellasoStr.length() - 1);
	}
	
	for (int i = 0;; i++) {
		if (x ==i) {
			i = 0;
		}
		if (bellasoStr.length() == plainText.length()) 
			break;
		bellasoStr += (bellasoStr.charAt(i));
	}
	
	char[] chars = plainText.toCharArray();
	
	for (int i = 0; i < plainText.length(); i++) {
		chars[i] = (char) (plainText.charAt(i) + bellasoStr.charAt(i));
		
		while (chars[i] < ' ' || chars[i] > '_') {
			 chars[i] -= 64; 
		 
		 }
		
	}
	
	bellasoEncrypted = String.valueOf(chars);
	
	decryptBellaso(bellasoEncrypted, bellasoStr);
	
	return bellasoEncrypted;
	
}



/**
* Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
* and each character in encryptedText is replaced by the character \"offset\" characters before it.
* This is the inverse of the encryptCaesar method.
* @param encryptedText an encrypted string to be decrypted.
* @param key an integer that specifies the offset of each character
* @return the plain text string
*/
public static String decryptCaesar(String encryptedText, int key) {
	
	while (key > RANGE) {
		key = key -   RANGE;
		}	
char[] a = encryptedText.toCharArray();

	for(int i = 0; i < a.length; i++) { //go through every character in string
			a[i] = (char) (encryptedText.charAt(i) - key);
			
			if (a[i] < LOWER_BOUND || a[i] > UPPER_BOUND) { //a[i] < 32 or a[i] >95
				a[i] = (char) (a[i] + RANGE);
			}
		}
	decrypt = String.valueOf(a);
return decrypt;
}

/**
* Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
* the character corresponding to the character in bellasoStr, which is repeated
* to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
* @param encryptedText an uppercase string to be encrypted.
* @param bellasoStr an uppercase string that specifies the offsets, character by character.
* @return the decrypted string
*/
public static String decryptBellaso(String encryptedText, String bellasoStr) {
//throw new RuntimeException("method not implemented");
	String bellasoDecrypted = "";
	while (bellasoStr.length() > encryptedText.length()) {
		bellasoStr = bellasoStr.substring(0, bellasoStr.length() - 1);
	}
	
	int x = encryptedText.length();
	for (int i = 0;; i++) {
		if (x ==i) {
			i = 0;
		}
		if (bellasoStr.length() == encryptedText.length()) 
			break;
		bellasoStr += (bellasoStr.charAt(i));
	}
	
	char[] chars = encryptedText.toCharArray();
	
	for (int i = 0; i < encryptedText.length(); i++) {
		chars[i] = (char) (encryptedText.charAt(i) - bellasoStr.charAt(i));
		
		while (chars[i] < ' ' || chars[i] > '_') {
			 chars[i] += 64; 
		 
		 }
		
	}
	bellasoDecrypted = String.valueOf(chars);
	
	return bellasoDecrypted;
}
}














