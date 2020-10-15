/*
    Group Members: Daniel Lyalin; Isabella Ho; Justin Li
    
    Compilation: javac RandomWalker.java
    Execution: java RandomWalker N

    Problem Statement:
        Write a program RandomWalker.java that takes an integer command-line
        argument N and simulates the motion of a random walker for N steps.
	    After each step, print the location of the random walker, treating
	    the lamp post as the origin (0, 0). Also, print the square of the
        final distance from the origin.
        
    Sample Execution:
        % java RandomWalker 10
            (0,1)
            (-1,1)
            (-2,1)
            (-2,0)
            (-3,0)
            (-3,-1)
            (-4,-1)
            (-5,-1)
            (-4,-1)
            (-3,-1)
            (-2,-1)
            Squared Distance: 5
        % java RandomWalker 20
            (1,0)
            (2,0)
            (3,0)
            (3,1)
            (2,1)
            (3,1)
            (2,1)
            (3,1)
            (3,2)
            (3,3)
            (3,2)
            (4,2)
            (5,2)
            (5,1)
            (5,0)
            (5,-1)
            (6,-1)
            (6,0)
            (6,1)
            (6,0)
            (5,0)
            Squared Distance: 25

    Conclusions/Hypotheses: 
        It can be observed that as N increases, so does the 
        squared distance of the walker from the origin. For example, the distance was 5
        after 10 steps, and 25 after 20 steps. Other than that, no conclusions can be 
        drawn without running more test runs and averaging them. For that, refer to
        RandomWalkers.java.
*/
public class RandomWalker {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        int steps = Integer.parseInt(args[0]);

        for (int i = 0; i <= steps; i++) {
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

            System.out.println("(" + x + "," + y + ")");
        }

        int squaredDistance = (x*x) + (y*y);

        System.out.println("Squared Distance: " + squaredDistance);
    }
}
