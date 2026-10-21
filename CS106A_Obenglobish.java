//CS106A_Obenglobish
/**
 * File: CS106A_Obenglobish.java
 * -----------------------------------
 * The CS106A_Obenglobish class puts the letters 
 * "ob" before any non-silent vowels not preceded
 * by another.I.e. it translates words and phrases 
 * into their obenglobish equivalent.
 * 
 */

import acm.program.*;
import java.util.*;

public class CS106A_Obenglobish extends ConsoleProgram
{
	//Named constants
	private static final String SENTINEL = "ENDPROGRAM";
	
	public void run()
	{
		introduceApp();
		while (true){
			String clientInput = readLine("Enter a word: ");
			if (clientInput.equals(SENTINEL) || clientInput.equals("")) { 
				println("goodbye"); 
				break; 
			}
			println(clientInput + " -> " + obenglobish(clientInput));
		}
	}
	
	
	private void introduceApp()
	{
		println("The CS106A_Obenglobish class transforms words and " +
				"phrases into their Obenglobish equivalent by " +
				"putting the letters \"ob\" " +
				"before any non-silent vowels not preceded " +
				"by another. Type \"ENDPROGRAM\" or nothing at all to exit.");
	}
	
	
	/**
	 * Transforms a string of words into Obenglobish
	 * @param the words to be transformed
	 * @return the transformed words
	 * */
	private String obenglobish(String words)
	{
		//StringTokenizer auto splits using spaces and doesn't return delims
		StringTokenizer tokenizer = new StringTokenizer(words);
		String obString = "";
		
		while (tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			boolean precedingVowel = false;
			
			for (int i = 0; i < token.length(); i++){
				char ch = token.charAt(i);
				if (checkForVowel(ch) && !precedingVowel && i != token.length()-1){
					precedingVowel = true;
					obString += "ob" + ch;
				} else {
					if (!checkForVowel(ch)) precedingVowel = false;
					obString += ch;
				}
			}
			
			obString += " ";
		}
		
		return obString;
	}
	
	
	/**
	 * Checks whether or not a character is a vowel.
	 * @param ch the character being evaluated.
	 * @return a boolean stating true if it's a vowel 
	 * and false if not.
	 * */
	private boolean checkForVowel(char ch)
	{
		switch (Character.toLowerCase(ch)){
		case 'a': case 'e': case 'i': case 'o': case 'u':
			return true;
		default:
			return false;
		}
	}
}
