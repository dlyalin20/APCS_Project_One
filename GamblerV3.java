/*
 Group Members: Justin Li; Daniel Lyalin; Isabella Ho

 Compilation: javac Gambler.java
 Execution: java Gambler stake goal N P

 Problem Statement:
  Modify Gambler to take an extra command-line argument that specifies
  the (fixed) probability that the gambler wins each bet.
  Reference Gambler.java for the documentation on what Gambler does.

  Sample Execution:
    % java GamblerV3 10 20 100 0.99
        100 wins of 100
        Percent of games won = 100.0
        Avg # bets           = 10.1

    % java Gambler 50 51 100 .1
        11 wins of 100
        Percent of games won = 11.0
        Avg # bets = 53.83
  
    % java Gambler 50 100 1000 .25
        0 wins of 1000
        Percent of games won = 0.0
        Avg # bets = 100.618      

    Conclusions/Hypotheses:
        Using probabilities even slightly off of 0.5, such as 0.48, drastically 
        reduced the chances of the gambler winning. For example running a $50 stake 
        and $100 goal simulation with a probability of .48 decreases the percent of 
        wins from 49.7% to 1.7%. The average number of bets also decreases, dropping 
        by almost 1000. Increasing the probability even slightly has a similar effect, 
        with the win rate for .52 being 98.8.
*/  
public class GamblerV3 { 

    public static void main(String[] args) {
        int stake  = Integer.parseInt(args[0]);    // gambler's stating bankroll
        int goal   = Integer.parseInt(args[1]);    // gambler's desired bankroll
        int trials = Integer.parseInt(args[2]);    // number of trials to perform
        double probability = Double.parseDouble(args[3]);

        int bets = 0;        // total number of bets made
        int wins = 0;        // total number of games won

        // repeat trials times
        for (int t = 0; t < trials; t++) {

            // do one gambler's ruin simulation
            int cash = stake;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < probability) cash++;     // win $1
                else                     cash--;     // lose $1
            }
            if (cash == goal) wins++;                // did gambler go achieve desired goal?
        }

        // print results
        System.out.println(wins + " wins of " + trials);
        System.out.println("Percent of games won = " + 100.0 * wins / trials);
        System.out.println("Avg # bets           = " + 1.0 * bets / trials);
    }

}

