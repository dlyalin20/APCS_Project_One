/*
 Group Members: Justin Li; Daniel Lyalin; Isabella Ho

 Compilation: javac Gambler.java
 Execution: java Gambler stake goal N

 Problem Statement:
  Simulates a gambler who starts with $stake and places fair $1 bets until she goes 
  broke or reaches $goal. Keeps track of the number of times she wins and the number 
  of bets she makes. Runs the experiment N times, averages the results, and prints 
  them out.

  Sample Execution:
    % java Gambler 50 250 1000
        178 wins of 1000
        Percent of games won = 17.8
        Avg # bets = 10010.79

    % java Gambler 50 150 1000
        337 wins of 1000
        Percent of games won = 33.7   
        Avg # bets = 4863.95
  
    % java Gambler 50 100 1000
        503 wins of 1000
        Percent of games won = 50.3
        Avg # bets = 2464.59

  Conclusions/Hypotheses:
    a. If you go to Monte Carlo to try to turn $500 into $2,500 what is your chance of 
        success?
        After having run the Gambler simulation with a stake of $500 and a goal of 
        $2500 1000 times several times, the chances of winning averaged out around 
        20%, but ranged individually from 18% to 23%.
    b. How many bets should you expect to make?
        After having run the Gambler simulation with a stake of $500 and a goal of 
        $2500 1000 times several times, the average number of bets stayed around one 
        million, but ranged on individual runs from 900,000 to 1,100,000.
    c. If you try to turn $1 into $1000 what is your chance of success?
        After having run the Gambler simulation with a stake of $1 and a goal of 
        $1000 1000 times several times, the chances of success averaged around 0.1%, 
        but ranged on individual runs from 0% to 0.5%.
    d. How many bets should you expect to make?
        After having run the Gambler simulation with a stake of $1 and a goal of 
        $1000 1000 times several times, the average number of bets approached 1300, 
        but ranged on individual runs from 500 to 1500.
    3. Use empirical results from the simulation, determine the probability of 
       success in terms of the stake and the goal.
        Considering that the probability of getting to $2500 after starting with 
        $500 was .2 and the probability of getting to $1000 after starting with $1 
        was .1, it would appear that the probability of success is roughly equal to 
        the ratio of the stake to the goal, or of the stake divided by the goal. For 
        example, if one were to stake $2 with a goal of $4, then the mathematically 
        expected probability of success would be 50%, or 1/2. Running the simulation 
        100 times, the chances of success averaged to 51%, which is almost what our 
        ratio model predicts.

  4. Empirically determine the expected number of bets in terms of the stake and the 
     goal.
      Considering that the number of bets made for the $500/$2500 simulation was 
      around one million and the number of bets made for the $1/$1000 simulation was 
      around 1300, it would appear as though the number of bets is approximately 
      equal to and approaches the stake times the goal. For example, a stake of $20 
      with a goal of $400 would have an average of 8000 bets, which is around what 
      the model predicts.
*/  
public class Gambler { 

    public static void main(String[] args) {
        int stake  = Integer.parseInt(args[0]);    // gambler's stating bankroll
        int goal   = Integer.parseInt(args[1]);    // gambler's desired bankroll
        int trials = Integer.parseInt(args[2]);    // number of trials to perform

        int bets = 0;        // total number of bets made
        int wins = 0;        // total number of games won

        // repeat trials times
        for (int t = 0; t < trials; t++) {

            // do one gambler's ruin simulation
            int cash = stake;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < 0.5) cash++;     // win $1
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
