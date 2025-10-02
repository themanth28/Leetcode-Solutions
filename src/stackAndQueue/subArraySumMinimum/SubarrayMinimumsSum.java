package stackAndQueue.subArraySumMinimum;

import java.util.*;

public class SubarrayMinimumsSum {

    private static final int MOD = (int) 1e9 + 7;

    // Main function
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prev = getPrevSmaller(arr);
        int[] next = getNextSmaller(arr);

        System.out.println(Arrays.toString(prev));
        System.out.println(Arrays.toString(next));

        long result = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            result = (result + arr[i] * left * right) % MOD;
        }

        return (int) result;
    }

    // Find index of previous smaller or equal elements
    private int[] getPrevSmaller(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return prev;
    }

    // Find index of next smaller elements
    private int[] getNextSmaller(int[] arr) {
        int n = arr.length;
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return next;
    }

    // Testing the implementation
    public static void main(String[] args) {
        SubarrayMinimumsSum solution = new SubarrayMinimumsSum();
        int[] arr = {3, 1, 2, 4};
        System.out.println(Arrays.toString(arr));
        System.out.println("Sum of subarray minimums: " + solution.sumSubarrayMins(arr));
    }
}
