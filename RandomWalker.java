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
