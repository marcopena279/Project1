package Main; 
import javax.swing.JOptionPane;

public class Main {

public Main() {

}

public static void main(String[] args) {
	// Variables for the two numbers and their answer
	int a = 0; // first number
	int b = 0; // second number
	int ans = 0; // the answer for a and b

	// A boolean expression to see if we are going to add or not
	boolean add = false;

	// Input (from the user) variables
	int userAns = 0; // the user's answer
	int numOfCorrectAns = 0; // amount of correct answers
	int numOfProblems = 0; // the number of problems they asked for

	String problem = ""; // string for the question 
	String userInput = ""; // when the user inputs anything


	// the beginning box of the program opening
	String input = JOptionPane.showInputDialog(
			null,
			"Hey cutie... You come around here often? You want to impress me you say??" +
			"\nHow many problems do you want to solve then??",
			"Amount of Problems" + 
			" (To end the program, type EXIT)",
			JOptionPane.INFORMATION_MESSAGE); 
	// EXIT option
	if(input.equalsIgnoreCase("Exit"))
	{
		JOptionPane.showMessageDialog(null, "See ya later!");
		System.exit(0);
	}
	else 
		numOfProblems = Integer.parseInt(input);


		// the question
			for(int i = 1; i <= numOfProblems; i++) {
				a = (int)(Math.random() * 10); // random number from 0 thru 9
				b = (int)(Math.random() * 10);
				ans = 0;

				if(Math.random() < 0.5) { // the 50% of probability of getting a problem with adding
					add = true;
				}
				
				if(add) { // if the 50% probability is addition
					problem = a + " + " + b + " = ";
					ans = a + b;
				}
				else { // if the 50% probability is subtraction
					if(a > b) { // if a > b, then there will be no negatives in the subtraction.
						problem = a + " - " + b + " = ";
						ans = a - b;
					}
					else { // id a < b, then we swap b and a to avoid negatives.
						problem = b + " - " + a + " = ";
						ans = b - a;
					}
				}

				// the problem box
				userInput = JOptionPane.showInputDialog(
						null, 
						problem,
						"Questions " + i + " (To stop, type EXIT.)", 
						JOptionPane.INFORMATION_MESSAGE); 
						// EXIT options
				if(userInput.equalsIgnoreCase("exit"))
				{
					JOptionPane.showMessageDialog(null, "See ya later!");
					System.exit(0);
				}
				else
					userAns = Integer.parseInt(userInput);
					
					// we count the amount of questions the user got correct
					// we also let them know if they got it right or wrong
					if(userAns == ans) {
						numOfCorrectAns++;	
						JOptionPane.showMessageDialog(null, "You got it right! Fantastic! ;)");
					}
					else {
						JOptionPane.showMessageDialog(null, "You got it wrong bud! Better luck next time!");
				
					}	
				}
				
				
				// the number and the percentage of correct questions
				double stats = 100 * numOfCorrectAns/numOfProblems;
				
				String results = "Correct Answer(s): " + numOfCorrectAns + "/" + numOfProblems + "\n" + "Percentage(s): " + stats + " %" + "\n";
				JOptionPane.showMessageDialog(null, results);
				
				}
}
