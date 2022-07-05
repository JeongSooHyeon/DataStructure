public class main {
	public static void main(String[] args) {
		//ListStack<String> stack = new ListStack<String>();
		ArrayStack<String> stack = new ArrayStack<String>();
		
	/*	String[] s1 = {"8", "37", "13", "+", "40", "-", "*"};
		String[] s2 = {"20", "-10", "3", "+", "*"};
		for(int i = 0; i < s2.length; i++)
			System.out.print(s2[i] + " ");
		System.out.println(": " + stack.calc(s2));
*/
		

		
		
		/*
		String s1 = "A*(B+C/D)";
		String s2 = "(A+B)*(C-D)";

		System.out.println(s1 + " : " + stack.getPostEq(s1));
		System.out.println(s2+ " : " + stack.getPostEq(s2));
		*/
		
		/*
		String s1 = "redivider";
		String s2 = "redder";
		String s3 = "a";
		String s4 = "abbd";
		String s5 = "abcde";
		System.out.print(s5 + " : ");
		if(stack.checkPalindrome(s5))
			System.out.print("True");
		else
			System.out.print("False");
		*/
		
		
		/*String str1 = "(ant+bee)*crab+{[ant*food]+(offset)}/gas";
		String str2 = "(ant+bee)*crab+[ant*food]+(offset)}/gas";
		System.out.print(str2 + " : ");
		if(stack.checkParentheses(str2))
			System.out.print("True");
		else
			System.out.print("False");*/		
		
		
		
		stack.push("apple");
		stack.push("orange");
		stack.push("cherry");
		System.out.println(stack.peek());
		stack.push("pear");
		stack.print();
		stack.pop();
		System.out.println(stack.peek());
		stack.push("grape");
		stack.print();
		

	}

}
