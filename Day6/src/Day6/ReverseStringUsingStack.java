package Day6;

import java.util.Stack;

public class ReverseStringUsingStack {
	public static void main(String[] args) {
		String string="JAVA PROGRAMMING";
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<string.length();i++)
		{
			stack.push(string.charAt(i));
		}
		
			String reversedString = "";
	        while (!stack.isEmpty()) {
	            reversedString += stack.pop();
	        }

	        System.out.println("Original: " + string);
	        System.out.println("Reversed:" + reversedString);
	}
}

		

			
