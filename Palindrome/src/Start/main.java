package Start;

import java.util.Scanner;
import java.util.Stack;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner input = new Scanner(System.in);
       String turn = input.nextLine().toString().toLowerCase();
       String Reverse = TurnString(turn.toLowerCase());
       input.close();
       if(Reverse.equals(turn)) {
    	   System.out.println("Word is a palindrome");
       }else{
    	   System.out.println("Word is not a palindrome");
       }
       System.out.print("Reversed Result: "+TurnString(turn));
      
	}
	public static String TurnString(String in) {
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<in.length();i++) {
			st.add(in.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		int size = st.size();
		for(int i=0;i<size;i++) {
			sb.append(st.pop());
		}
		return sb.toString();
	}

}
