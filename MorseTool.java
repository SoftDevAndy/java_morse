import java.util.HashMap;
import java.util.Map;

public class MorseTool{

	private Map<String,Character> usMorseTable;
	private Map<Character,String> reverseTable;
	private final Character BAD_CHAR = '*';
	
	public MorseTool(){
		usMorseTable = new HashMap<String,Character>();
		reverseTable = new HashMap<Character, String>();
		
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
		usMorseTable.put("/", ' ');
		
		for(String s : usMorseTable.keySet())
			reverseTable.put(usMorseTable.get(s), s);
	}
	
	public String translateToMorse(String longText) {
		
		StringBuffer sb = new StringBuffer();
		String[] lt = longText.split(" ");
		String morse;
		
		for(String s : lt){			
			for(Character letter : s.toCharArray()){
				morse = readableToMorseChar(letter);	
				sb.append(morse + " ");
			}		
			
			sb.append("/ ");
		}
		
		return sb.toString();
	}	
	
	public String translateRawMorse(String longText) {
		
		StringBuffer sb = new StringBuffer();
		String[] lt = longText.split(" ");
		Character c;
		
		for(String s : lt){			
			c = morseCharToReadable(s);			
			sb.append(c);
		}
		
		return sb.toString();
	}
	
	public Character morseCharToReadable(String mc) {
		
		if(usMorseTable.containsKey(mc))
			return usMorseTable.get(mc);
		
		return BAD_CHAR;
	}	
	
	public String readableToMorseChar(Character mc) {
		
		Character c = Character.toUpperCase(mc);
		
		if(reverseTable.containsKey(c))
			return reverseTable.get(c);
				
		return BAD_CHAR + "";
	}	
}