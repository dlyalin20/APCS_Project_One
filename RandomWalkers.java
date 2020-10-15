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
