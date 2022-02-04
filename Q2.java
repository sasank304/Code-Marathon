import java.io.*;

class sequence {

    static int maxOnesIndex(char arr[], int n) {
        int max_count = 0;
        int max_index = 0;
        int prev_zero = -1;
        int prev_prev_zero = -1;

        for (int curr = 0; curr < n; ++curr) {

            if (arr[curr] == 'B') {

                if (curr - prev_prev_zero > max_count) {
                    max_count = curr - prev_prev_zero;
                    max_index = prev_zero;
                }

                prev_prev_zero = prev_zero;
                prev_zero = curr;
            }
        }

        if (n - prev_prev_zero > max_count)
            max_index = prev_zero;

        return max_index;
    }

    public static void main(String[] args) {
        char arr[] = { 'A', 'A', 'B', 'B', 'A', 'B', 'A', 'A', 'A', 'B', 'A', 'A', 'A', 'A' };
        int n = arr.length;
        System.out.println("Character of 'B' to be replaced is " +
                maxOnesIndex(arr, n));
    }
}
