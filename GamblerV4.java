/*
 Group Members: Justin Li; Daniel Lyalin; Isabella Ho

 Compilation: javac Gambler.java
 Execution: java Gambler stake goal N

 Problem Statement:
    Modify Gambler to take an extra command-line argument that specifies
    the number of bets the gambler is willing to make, so that there are
    three possible ways for the game to end; the gambler wins, loses, or runs
    out of time. Add to the output to give the expected amount of money
    the gambler will have when the game ends.
    Reference Gambler.java for the documentation for how the simulation works.

  Sample Execution:
    % java GamblerV4 50 100 1000 200
        1 wins of 1000
        Avg # bets           = 199.99
        Percent of games won = 0.1
        Average Amount of Cash Remaining For Games That Ended Early: 50.454454454454456

    % java GamblerV4 50 100 1000 5  
        0 wins of 1000
        Avg # bets           = 5.0
        Percent of games won = 0.0
        Average Amount of Cash Remaining For Games That Ended Early: 50.052
  
    % java GamblerV4 50 100 1000 500
        25 wins of 1000
        Avg # bets = 494.416
        Percent of games won = 2.5
        Average Amount of Cash Remaining For Games That Ended Early: 50.947257383966246

  Conclusions/Hypotheses:
    No new hypotheses or conclusions can be made.

*/  
public class GamblerV4 { 

    public static void main(String[] args) {
        int stake  = Integer.parseInt(args[0]);    // gambler's stating bankroll
        int goal   = Integer.parseInt(args[1]);    // gambler's desired bankroll
        int trials = Integer.parseInt(args[2]);    // number of trials to perform
        int max = Integer.parseInt(args[3]);

        int bets = 0;        // total number of bets made
        int wins = 0;        // total number of games won

        double remainder = 0;
        double endedEarly = 0;

        // repeat trials times
        for (int t = 0; t < trials; t++) {

            // do one gambler's ruin simulation
            int cash = stake;
            int roundNumber = 0;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < 0.5) cash++;     // win $1
                else                     cash--;     // lose $1
                
                roundNumber++;
                if (roundNumber == max) {
                    remainder += cash;
                    endedEarly++;
                    break;
                }
            }
            if (cash == goal) wins++;                // did gambler go achieve desired goal?
        }

        // print results
        System.out.println(wins + " wins of " + trials);
        System.out.println("Avg # bets           = " + 1.0 * bets / trials);
        System.out.println("Percent of games won = " + 100.0 * wins / trials);

        if (endedEarly == 0) {
            System.out.println("Average Amount of Cash Remaining For Games That Ended Early: " + 0);

        }
        else {
            System.out.println("Average Amount of Cash Remaining For Games That Ended Early: " + remainder / endedEarly);
        }
    }

}

