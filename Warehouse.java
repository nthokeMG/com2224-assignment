
    import java.util.Scanner;

public class Warehouse {
    public static int findProductIndex(int[] productIDs, int targetID) {
        int start = 0;
        int end = productIDs.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (productIDs[mid] == targetID) {
                return mid;
            }

            // Check if left side is sorted
            if (productIDs[start] <= productIDs[mid]) {
                if (productIDs[start] <= targetID && targetID < productIDs[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // Right side is sorted
                if (productIDs[mid] < targetID && targetID <= productIDs[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1; // Product not found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] productIDs = {104, 105, 106, 107, 101, 102, 103};

        System.out.println("Product ID to search for:");
        int targetID = input.nextInt();

        int index = findProductIndex(productIDs, targetID);

        if (index != -1) {
            System.out.println("Product ID " + targetID + " found at index: " + index);
        } else {
            System.out.println("Product ID " + targetID + " not found.");
        }
    }
}


