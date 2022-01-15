import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class In2p extends ConsoleProgram{
	 public void run() {
		 postFix testmer = new postFix();
		 println("PostFix: " + testmer.PostEval(testmer.In2Post(testmer.parse("4+1+(5)"))));
		 while (true) {
			 // ask for user input
			 String input = readLine("Enter a string (blank line to exit) : ");
			 // if they give non end the program
			 if (input.equals("")) break;
			 // create a new postfix instance
			 postFix test = new postFix();
			 // print the output of the method In2Post
			 println("PostFix: " + test.In2Post(test.parse(input)).toString());
		 }
		 
		 
		 
	 }

}
