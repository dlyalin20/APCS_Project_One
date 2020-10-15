/*Checkerboard
  Group Members: Justin Li; Daniel Lyalin; Isabella Ho

  Compilation: javac Checkerboard.java
  Execution: java Checkerboard N

  Problem Statement:
    Write a program Checkerboard.java that takes an integer          
    command-line argument N, and uses two nested for loops to print  
    an N-by-N "checkerboard" pattern like the one below: a total of  
    NxN asterisks, where each row has 2N characters (alternating     
    between asterisks and spaces).

  Sample Execution:L 
    % java Checkerboard 5
      * * * * * 
       * * * * *
      * * * * * 
       * * * * *
      * * * * * 

    % java Checkerboard 4
      * * * * 
       * * * *
      * * * * 
       * * * *

    Conclusions/Hypotheses: 
      No conclusions/hypotheses can or need be made.
*/
public class Checkerboard {

	public static void main(String[] args) {
    
		int N = Integer.parseInt(args[0]);
		String oddIn = "* ";
		String evenIn = " *";
    
		for (int i = 1; i <= N; i++) {

			if (i % 2 == 0) {

				for (int k = 0; k < N; k++) {

					System.out.print(evenIn);

				}

				System.out.println("");

			}

			else {

				for (int k = 0; k < N; k++) {

					System.out.print(oddIn);

				}

				System.out.println("");
				
			}
		}
	}
}
