public class Example {
	public static void main(String[] args) {
		MorseTool mt = new MorseTool();
		
		String rawMorse = "- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.";
		String rawText = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
		
		String a = mt.translateRawMorse(rawMorse);
		String b = mt.translateToMorse(rawText);
	
		System.out.println(a);
		System.out.println(b);
	}
}
