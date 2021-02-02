package model;

public class Utilities {
	/*
	 * Input parameters:
	 * 	- `status` is the filing status (which should be 1 for Single Filing or 2 for Married Filing)
	 *  - `income` is the tax payer's income (an integer value)
	 *  
	 * Assumptions:
	 * 	- `income` passed by user is always positive (> 0)
	 *  
	 * Refer to you lab instructions for what the method should return.
	 * 
	 * See this short tutorial video illustrating how to compute tax:
	 * https://www.youtube.com/watch?v=q2NT5x77hdg&list=PL5dxAmCmjv_7YgI2LgcwjWTHiNZSR-aQX&index=1 
	 */
	public static String getTaxReport(int status, int income) {
		String result = "";

		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		double part1 = 0;
		double part2 = 0;
		double part3 = 0;
		double total = 0;
		// Single filing
		if (status == 1) {
			if (income > 8350) {
				if (income > 33950) {
					part1 = 8350*0.1;
					part2 = (33950 - 8350)*0.15;
					part3 = (income - 33950)*0.25;
					total = part1 + part2 + part3;		
					result = String.format("Single Filing: $%.2f (Part I: $%.2f, Part II: $%.2f, Part III: $%.2f)", total, part1, part2, part3);					
				}
				else if (income <= 33950) {
					part1 = 8350*0.1;
					part2 = (income - 8350)*0.15;
					total = part1 + part2 ;
					result = String.format("Single Filing: $%.2f (Part I: $%.2f, Part II: $%.2f)", total, part1, part2);			
				}
			}
			else if (income <= 8350) {
				part1 = income*0.1;
				total = part1;
				result = String.format("Single Filing: $%.2f (Part I: $%.2f)", total, part1);
			}
			
		}
		// Married filing
		else if (status == 2) {
			if (income > 16700) {
				if (income > 67900) {
					part1 = 16700*0.1;
					part2 = (67900 - 16700)*0.15;
					part3 = (income - 67900)*0.25;
					total = part1 + part2 + part3;		
	
					result = String.format("Married Filing: $%.2f (Part I: $%.2f, Part II: $%.2f, Part III: $%.2f)", total, part1, part2, part3);
				}
				else if (income <= 67900) {
					part1 = 16700*0.1;
					part2 = (income - 16700)*0.15;
					total = part1 + part2;
					result = String.format("Married Filing: $%.2f (Part I: $%.2f, Part II: $%.2f)", total, part1, part2);
							
				}
					
				}
			else if (income <= 16700) {
				part1 = income*0.1;
				total = part1;
				result = String.format("Married Filing: $%.2f (Part I: $%.2f)", total, part1);
				
			}
			
		}
		else {
			result = "Illegal Status: " + status;
		}
		

		/* Your implementation ends here. */

		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `p1` is the name of player 1
	 *  - `p2` is the name of player 2
	 *  - `p1r1` is what player 1 plays in round 1 ('R', 'P', or 'S')
	 *  - `p2r1` is what player 2 plays in round 1 ('R', 'P', or 'S')
	 *  - `p1r2` is what player 1 plays in round 2 ('R', 'P', or 'S')
	 *  - `p2r2` is what player 2 plays in round 2 ('R', 'P', or 'S')
	 *  
	 * Assumptions:
	 * 	- `p1r1`, `p2r1`, `p1r2`, or `p2r2` is one of the following characters:
	 *     'R' for rock, 'P' for paper, and 'S' scissors (case-sensitive)
	 *     
	 * Hints:
	 *  - Compare character values using the relational operator ==.
	 *  - Study the 9 test cases in TestUtilites: they are arranged in a systematic (yet not exhaustive) way.
	 *    Q. In order to exhaustively test this game, considering how two players may play in two rounds,
	 *    	 how many tests do we need? (Optionally, you may write extra test yourself as an exercise.)
	 *    
	 * Refer to you lab instructions for what the method should return.
	 */
	public static String getRPSGameReport(String p1, String p2, char p1r1, char p2r1, char p1r2, char p2r2) {
		String result = "";
		
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		
		/*We can also make a common method for these two rounds. This method can evaluate the winner for each round.*/
		
		// Round 1:
		String winnerRoundString1 = "";
		String winner1 = "";
		char winnerChar1 = ' ';
		char otherChar1 = ' ';
		
		if (p1r1 == 'R') {
			if (p2r1 == 'S') {
				winner1 = p1;
				winnerRoundString1 = p1 + " wins";
				winnerChar1 = 'R';
				otherChar1 = 'S';
				
			}
			else if (p2r1 == 'P') {
				winner1 = p2;
				winnerRoundString1 = p2 + " wins";
				winnerChar1 = 'P';
				otherChar1 = 'R';
			}
			else {
				winner1 = "Tie";
				winnerRoundString1 = "Tie";
				winnerChar1 = 'R';
				otherChar1 = 'R';
			}
		}
		
		
		else if (p1r1 == 'S') {
			if (p2r1 == 'R') {
				winner1 = p2;
				winnerRoundString1 = p2 + " wins";
				winnerChar1 = 'R';
				otherChar1 = 'S';
			}
			else if (p2r1 == 'P') {
				winner1 = p1;
				winnerRoundString1 = p1 + " wins";
				winnerChar1 = 'S';
				otherChar1 = 'P';
			}
			else {
				winner1 = "Tie";
				winnerRoundString1 = "Tie";
				winnerChar1 = 'S';
				otherChar1 = 'S';
			}
		}
		
		
		else if (p1r1 == 'P') {
			if (p2r1 == 'R') {
				winner1 = p1;
				winnerRoundString1 = p1 + " wins";
				winnerChar1 = 'P';
				otherChar1 = 'R';
			}
			else if (p2r1 == 'S') {
				winner1 = p2;
				winnerRoundString1 = p2 + " wins";
				winnerChar1 = 'S';
				otherChar1 = 'P';
			}
			else {
				winner1 = "Tie";
				winnerRoundString1 = "Tie";
				winnerChar1 = 'P';
				otherChar1 = 'P';
			}
		}

		 // Round 2: 
		String winnerRoundString2 = "";
		String winner2 = "";
		char winnerChar2 = ' ';
		char otherChar2 = ' ';
		// If player 1 plays Rock
		if (p1r2 == 'R') {
			if (p2r2 == 'S') {
				winner2 = p1;
				winnerRoundString2 = p1 + " wins";
				winnerChar2 = 'R';
				otherChar2 = 'S';
			}
			else if (p2r2 == 'P') {
				winner2 = p2;
				winnerRoundString2 = p2 + " wins";
				winnerChar2 = 'P';
				otherChar2 = 'R';
			}
			else {
				winner2 = "Tie";
				winnerRoundString2 = "Tie";
				winnerChar2 = 'R';
				otherChar2 = 'R';
			}
		}
		
		// If player 1 plays Scissors
		else if (p1r2 == 'S') {
			if (p2r2 == 'R') {
				winner2 = p2;
				winnerRoundString2 = p2 + " wins";
				winnerChar2 = 'R';
				otherChar2 = 'S';
			}
			else if (p2r2 == 'P') {
				winner2 = p1;
				winnerRoundString2 = p1 + " wins";
				winnerChar2 = 'S';
				otherChar2 = 'P';
			}
			else {
				winner2 = "Tie";
				winnerRoundString2 = "Tie";
				winnerChar2 = 'S';
				otherChar2 = 'S';
			}
		}
		
		// If player 1 plays Paper
		else if (p1r2 == 'P') {
			if (p2r2 == 'R') {
				winner2 = p1;
				winnerRoundString2 = p1 + " wins";
				winnerChar2 = 'P';
				otherChar2 = 'R';
			}
			else if (p2r2 == 'S') {
				winner2 = p2;
				winnerRoundString2 = p2 + " wins";
				winnerChar2 = 'S';
				otherChar2 = 'P';
			}
			else {
				winner2 = "Tie";
				winnerRoundString2 = "Tie" ;
				winnerChar2 = 'P';
				otherChar2 = 'P';
			}
		}
		
		// Actual winner of the rounds
		String winner = "";
		if (winner1.equals(p1)) {
			// if p1 wins the round 2
			if (winner2.equals(p1)) {
				winner = p1 + " wins!";
			}
			// If p2 wins the round 2
			else if (winner2.equals(p2)) {
				winner = "Tie!";
				
			}
			// if Round 2 was a tie
			else {
				winner = p1 + " wins!";
			}
		}
		
		else if (winner1.equals(p2)) {
			// if p1 wins the round 2
			if (winner2.equals(p1)) {
				winner = "Tie!";
			}
			// If p2 wins the round 2
			else if (winner2.equals(p2)) {
				winner = p2 + " wins!";
			}
			// if Round 2 was a tie
			else {
				winner = p2 + " wins!";
			}
		}
		else {
			// if p1 wins the round 2
			if (winner2.equals(p1)) {
				winner = p1 + " wins!";
			}
			// If p2 wins the round 2
			else if (winner2.equals(p2)) {
				winner = p2 + " wins!" ;
			}
			// if Round 2 was a tie
			else {
				winner = "Tie!";
			}
		}

		result = "Game over: " + winner + " [Round 1: " + winnerRoundString1 + " (" + winnerChar1 + " vs. " + otherChar1 + ") ;" + " Round 2: " + winnerRoundString2 + " (" + winnerChar2 + " vs. " + otherChar2 + ")]";
		
		/* Your implementation ends here. */

		return result;
	}
}
