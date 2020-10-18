/*
 Group Members: Justin Li; Daniel Lyalin; Isabella Ho

 Compilation: javac GamblerPlot.java
 Execution: java GamblerPlot stake goal N

 Problem Statement:
   Write a program GamblerPlot that traces a gambler's ruin simulation by printing a 
   line after each bet in which one asterisk corresponds to each dollar held by the 
   gambler and prints  "end of trial #" after the conclusion of each trial. Reference 
   Gambler.java's documentation to learn more about the simulation.
  

  Sample Execution:
    % java GamblerPlot 10 20 1
        Original Stake: 
        ----------------
        ***********

        Dollars After Bet: 
        -------------------
        **********
        *********
        **********
        *********
        **********
        *********
        ********
        *******
        ******
        *****
        ****
        ***
        **
        *
        End of Trial 1

        1 wins of 1
        Percent of games won = 100.0
        Avg # bets = 30.0

  Conclusions/Hypotheses:
    No new conclusions or hypotheses can be made. Reference the documentation of 
    Gambler.java to learn more about the math behind the numbers.
*/ 
public class GamblerPlot { 

    public static void main(String[] args) {
        int stake  = Integer.parseInt(args[0]);    // gambler's stating bankroll
        int goal   = Integer.parseInt(args[1]);    // gambler's desired bankroll
        int trials = Integer.parseInt(args[2]);    // number of trials to perform

        int bets = 0;        // total number of bets made
        int wins = 0;        // total number of games won

        System.out.println("Original Stake: ");
        System.out.println("----------------");
        for (int x = 0; x<= stake; x++) {
          System.out.print("*");
        }
        System.out.println("");
        System.out.println("");

        System.out.println("Dollars After Bet: ");
        System.out.println("-------------------");

        // repeat trials times
        for (int t = 0; t < trials; t++) {

            // do one gambler's ruin simulation
            int cash = stake;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < 0.5) cash++;     // win $1
                else                     cash--;     // lose $1
                
                for (int y = 0; y <= cash; y++) {
                  System.out.print("*");
                }
                System.out.println("");

            }
            if (cash == goal) wins++;                // did gambler go achieve desired goal?
            System.out.println("End of Trial " + t);
            System.out.println("");
        }

        // print results
        System.out.println(wins + " wins of " + trials);
        System.out.println("Percent of games won = " + 100.0 * wins / trials);
        System.out.println("Avg # bets           = " + 1.0 * bets / trials);
    }

}
