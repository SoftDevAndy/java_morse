import java.util.HashMap;
import java.util.Map;

public class MorseTool{

	private final static Character BAD_CHAR = '*';
	
	private static Map<String,Character> usMorseTable;
	private static Map<Character,String> reverseTable;
	private static String seperator = "/";
	
	public static void main(String[] args) {
				
		if(args.length == 1){
			
			if(args[0].toUpperCase().equals("-HELP")){
				System.out.println("Help and Usage");
				System.out.println("-seperator / -encrypt \"THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG\"");
				System.out.println("-seperator /-unencrypt \"- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.\"");
				System.out.println("-replace / # \"- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.\"");
			}
		}
			
		int count = -1;
	
		int encryptPos = -1;
		int decryptPos = -1;
		int replacePos = -1;
		int sepPos = -1;
		
		if(args.length != 0){
			
			for(String arg : args){
				
				count++;
				
				/* Flags */
				
				if(arg.toUpperCase().equals("-SEPERATOR"))
					sepPos = count + 1;
				
				if(arg.toUpperCase().equals("-ENCRYPT"))
					encryptPos = count + 1;
				
				if(arg.toUpperCase().equals("-UNENCRYPT"))
					decryptPos = count + 1;
				
				if(arg.toUpperCase().equals("-REPLACE"))
					replacePos = count + 1;
				
				/* Arguments */
				
				if(sepPos == count){						
					Setup(arg.charAt(0) + "");
					System.out.println("-seperator set as " + arg.charAt(0));
				}			
				
				if(encryptPos == count){	
					Setup(seperator);
					String result = encrypt(arg);
					System.out.println(result);
				}		
				
				if(decryptPos == count){	
					Setup(seperator);
					String result = unencrypt(arg);
					System.out.println(result);
				}		
				
				if(replacePos == count){						
					
					if(count + 3 >= args.length){	
						Setup(seperator);						
						String result = replaceSeperatorChar(args[count + 2], args[count + 1], args[count]);
						System.out.println(result);
					}
				}	
			}
		}
	}
	
	/* Constructors */
	
	private static void Setup(String symbol){
		
		usMorseTable = new HashMap<String,Character>();
		reverseTable = new HashMap<Character,String>();
		
		usMorseTable.put(".-", 'A');
		usMorseTable.put("-...", 'B');
		usMorseTable.put("-.-.", 'C');
		usMorseTable.put("-..", 'D');
		usMorseTable.put(".", 'E');
		usMorseTable.put("..-.", 'F');
		usMorseTable.put("--.", 'G');
		usMorseTable.put("....", 'H');
		usMorseTable.put("..", 'I');
		usMorseTable.put(".---", 'J');		
		usMorseTable.put("-.-", 'K');
		usMorseTable.put(".-..", 'L');
		usMorseTable.put("--", 'M');
		usMorseTable.put("-.", 'N');
		usMorseTable.put("---", 'O');
		usMorseTable.put(".--.", 'P');
		usMorseTable.put("--.-", 'Q');
		usMorseTable.put(".-.", 'R');
		usMorseTable.put("...", 'S');
		usMorseTable.put("-", 'T');
		usMorseTable.put("..-", 'U');
		usMorseTable.put("...-", 'V');
		usMorseTable.put(".--", 'W');
		usMorseTable.put("-..-", 'X');
		usMorseTable.put("-.--", 'Y');
		usMorseTable.put("--..", 'Z');	
		usMorseTable.put("..--..", '.');
		
		seperator = symbol;
		
		usMorseTable.put(seperator, ' ');
		
		for(String s : usMorseTable.keySet())
			reverseTable.put(usMorseTable.get(s), s);
	}
	
	/* Methods */
	
	private static String replaceSeperatorChar(String morseText, String seperator, String oldseperator){
		
		String replacedText = morseText;
		
		String replaceMe = oldseperator.charAt(0) + "";
		String withMe = seperator.charAt(0) + "";
		
		replacedText = replacedText.replaceAll(replaceMe, withMe);
		
		return replacedText;
	}
	
	private static String encrypt(String plainText) {
		
		StringBuffer sb = new StringBuffer();
		String[] lt = plainText.split(" ");
		String morse;
		
		for(String s : lt){			
			for(Character letter : s.toCharArray()){
				morse = readableToMorseChar(letter);	
				sb.append(morse + " ");
			}		
			
			sb.append(seperator + " ");
		}
		
		return sb.toString();
	}	
	
	private static String unencrypt(String longText) {
		
		StringBuffer sb = new StringBuffer();
		String[] lt = longText.split(" ");
		Character c = ' ';
		
		for(String s : lt){			
			
			if(!s.isEmpty()){
				c = morseCharToReadable(s);		
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
	
	private static Character morseCharToReadable(String mc) {
		
		if(usMorseTable.containsKey(mc))
			return usMorseTable.get(mc);
		
		return ' ';
	}	
	
	private static String readableToMorseChar(Character mc) {
		
		Character c = Character.toUpperCase(mc);
		
		if(reverseTable.containsKey(c))
			return reverseTable.get(c);
				
		return BAD_CHAR + "";
	}	
}