package stackAndQueue.needAllOnceOrMaximumAnchoredRectangle;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int j = 0; j <= n; j++) {
            int h = (j == n) ? 0 : heights[j];

            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = j - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(j);
        }
        return maxArea;
    }

    public static int maximalAnchoredRectangle(int[][] matrix, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        int[] heights = new int[m];

        for (int j = 0; j < m; j++) {
            int currentHeight = 0;
            // Iterate from the bottom row (n-1) up to the top row (0)
            for (int i = n - 1; i >= 0; i--) {
                if (matrix[i][j] == 1) {
                    currentHeight++;
                } else {
                    break;
                }
            }
            heights[j] = currentHeight;
        }

        System.out.println(Arrays.toString(heights));

        return largestRectangleArea(heights);
    }
}