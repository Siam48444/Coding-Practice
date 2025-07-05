public class TowerOfHanoi {
    public static void main(String[] args) {
        int numberOfDisks = 2;
        solveTowerOfHanoi(numberOfDisks, 'A', 'B', 'C');
    }


    // Recursive method to solve Tower of Hanoi
    public static void solveTowerOfHanoi(int n, char source, char helper, char destination) {
        if (n == 1) {
            System.out.printf("Move disk %d from %s to %s %n", n, source, destination);
            return;
        }

        // Step 1: Move top n-1 disks from source to helper
        solveTowerOfHanoi(n - 1, source, destination, helper);

        // Step 2: Move the nth disk from source to destination
        System.out.printf("Move disk %d from %s to %s %n", n, source, destination);
        
        // Step 3: Move top n-1 disks from helper to destination
        solveTowerOfHanoi(n - 1, helper, source, destination);
    }
}