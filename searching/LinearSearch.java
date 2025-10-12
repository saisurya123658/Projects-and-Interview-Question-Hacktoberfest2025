// Author: Sai Surya
// Program: Implementation of Various Searching Algorithms in Java

public class SearchingTechniques {

    // 1️⃣ Linear Search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // return index if found
            }
        }
        return -1; // not found
    }

    // 2️⃣ Binary Search (Iterative)
    public static int binarySearchIterative(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // 3️⃣ Binary Search (Recursive)
    public static int binarySearchRecursive(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;
        if (arr[mid] == key)
            return mid;
        else if (arr[mid] < key)
            return binarySearchRecursive(arr, mid + 1, high, key);
        else
            return binarySearchRecursive(arr, low, mid - 1, key);
    }

    // 4️⃣ Jump Search
    public static int jumpSearch(int[] arr, int key) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        while (arr[prev] < key) {
            prev++;
            if (prev == Math.min(step, n))
                return -1;
        }

        if (arr[prev] == key)
            return prev;
        return -1;
    }

    // 5️⃣ Interpolation Search
    public static int interpolationSearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high && key >= arr[low] && key <= arr[high]) {
            if (low == high) {
                if (arr[low] == key)
                    return low;
                return -1;
            }

            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == key)
                return pos;
            if (arr[pos] < key)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }

    // 🧪 MAIN METHOD FOR TESTING ALL SEARCHES
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };
        int key = 10;

        System.out.println("Linear Search: Element found at index " + linearSearch(arr, key));
        System.out.println("Binary Search (Iterative): Element found at index " + binarySearchIterative(arr, key));
        System.out.println("Binary Search (Recursive): Element found at index " + binarySearchRecursive(arr, 0, arr.length - 1, key));
        System.out.println("Jump Search: Element found at index " + jumpSearch(arr, key));
        System.out.println("Interpolation Search: Element found at index " + interpolationSearch(arr, key));
    }
}
