/*
    Group Members: Daniel Lyalin; Isabella Ho; Justin Li 

    Compilation: javac RandomWalkers.java
    Execution: java RandomWalkers N T

    Problem Statement:
        Write a program RandomWalkers.java that takes two integer command-line 
        arguments N and T. In each of T independent experiments, simulate a random 
        walk of N steps and compute the squared distance. Output the mean squared 
        distance (the average of the T squared distances).
        Reference the documentation of RandomWalker.java for more details.
        
    Execution:
        % java RandomWalkers 100 100000         
            Mean Squared Distance = 100.15086     

        % java RandomWalkers 400 100000
            Mean Squared Distance = 401.22024

    Conclusions/Hypotheses:
        It can be observed that as T increases and approaches infinity, the average
        distance of the walker from the origin approaches N, the number of steps he 
        has taken. For example, a walker taking 100 steps will have an average 
        distance of 100 from the origin (if the simulation were to be run infinite
        times); realistically, the distance will vary from around 90 to 110 per
        simulation.
*/  
public class RandomWalkers {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        double sum = 0;

        for (int i = 0; i <= T; i++) {
            int x = 0;
            int y = 0;

            int steps = N;

            for (int j = 0; j <= steps; j++) {
                double probability = Math.random();

                if (probability < 0.25) {
                    x++;
                }
                else if (probability < 0.5) {
                    y++;
                }
                else if (probability < 0.75) {
                    x--;
                }
                else {
                    y--;
                }

            }

            double squaredDistance = (x*x) + (y*y);
            sum += squaredDistance;
        }

        double avg = sum / T;

        System.out.println("Mean Squared Distance: " + avg);
    } 
}
