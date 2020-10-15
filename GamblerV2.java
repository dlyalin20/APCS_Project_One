/*
 Group Members: Justin Li; Daniel Lyalin; Isabella Ho

 Compilation: javac Gambler.java
 Execution: java Gambler stake goal N

 Problem Statement:
  Simulates a gambler who starts with $stake and places fair $1 bets until she goes 
  broke or reaches $goal. Keeps track of the number of times she wins and the number 
  of bets she makes. Runs the experiment N times, averages the results, and prints 
  them out.
  Write a version of the Gambler that uses two nested while loops or two nested for 
  loops instead of a while loop inside a for loop. Name the program GamblerV2.java.
  GamblerV2 is Gambler rewritten using two while loops. 

  Sample Execution:
    % java GamblerV2 50 250 1000
        178 wins of 1000
        Percent of games won = 17.8
        Avg # bets = 10010.79

    % java GamblerV2 50 150 1000
        337 wins of 1000
        Percent of games won = 33.7   
        Avg # bets = 4863.95
  
    % java GamblerV2 50 100 1000
        503 wins of 1000
        Percent of games won = 50.3
        Avg # bets = 2464.59

  Conclusions/Hypotheses:
    No new conclusions or hypotheses can be made. Reference the documentation of 
    Gambler.java to learn more about the math behind the numbers.
*/  
public class GamblerV2 { 

    public static void main(String[] args) {
        int stake  = Integer.parseInt(args[0]);    // gambler's stating bankroll
        int goal   = Integer.parseInt(args[1]);    // gambler's desired bankroll
        int trials = Integer.parseInt(args[2]);    // number of trials to perform

        int bets = 0;        // total number of bets made
        int wins = 0;        // total number of games won

        int counter = 0;

        // repeat trials times
        while (counter < trials) {

            // do one gambler's ruin simulation
            int cash = stake;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < 0.5) cash++;     // win $1
                else                     cash--;     // lose $1
            }
            if (cash == goal) wins++;                // did gambler go achieve desired goal?

            counter++;
        }

        // print results
        System.out.println(wins + " wins of " + trials);
        System.out.println("Percent of games won = " + 100.0 * wins / trials);
        System.out.println("Avg # bets           = " + 1.0 * bets / trials);
    }

}
