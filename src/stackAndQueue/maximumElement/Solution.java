package stackAndQueue.maximumElement;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

class Solution {
    /**
     * Processes a sequence of stack operations (push, pop, getMax) and returns 
     * the result for each getMax query.
     * * @param operations A List of strings, where each string is a query (e.g., "1 97", "2", "3").
     * @return A List of integers containing the maximum element for each type 3 query.
     */
    public List<Integer> getMax(List<String> operations) {
        // The main stack to store all elements
        Stack<Integer> mainStack = new Stack<>();
        
        // The auxiliary stack to store the maximum element corresponding 
        // to the element at the same depth in the mainStack.
        Stack<Integer> maxStack = new Stack<>();
        
        // List to store the results of Type 3 queries
        List<Integer> results = new ArrayList<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1: // Type 1: Push the element x
                    int x = Integer.parseInt(parts[1]);
                    mainStack.push(x);
                    
                    // Update maxStack: Push the new maximum onto the maxStack
                    if (maxStack.isEmpty() || x >= maxStack.peek()) {
                        maxStack.push(x);
                    } else {
                        // If x is not the new maximum, push the current maximum again
                        // This maintains a 1:1 correspondence with the mainStack
                        maxStack.push(maxStack.peek());
                    }
                    break;

                case 2: // Type 2: Delete the element present at the top of the stack
                    if (!mainStack.isEmpty()) {
                        mainStack.pop();
                        // When an element is popped from the mainStack, 
                        // its corresponding maximum must also be popped.
                        maxStack.pop(); 
                    }
                    break;

                case 3: // Type 3: Print the maximum element in the stack
                    if (!maxStack.isEmpty()) {
                        // The maximum element is always at the top of the maxStack
                        results.add(maxStack.peek());
                    }
                    break;
            }
        }

        return results;
    }
}