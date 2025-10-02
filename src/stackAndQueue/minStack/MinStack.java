package stackAndQueue.minStack;

import java.util.Stack;

class MinStack {

    final Stack<Long> s;

    long min;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push((long) val);
            min = val;
        }else{
            if(val<min){
                s.push(2L * val - min);
                min = val;
            }else{
                s.push((long) val);
            }
        }
    }
    
    public void pop() {
        if(s.isEmpty()){
            return;
        }
        long top = s.pop();
        if(top<min){
            min = 2*min -top;
        }
    }
    
    public int top() {
        long top = s.peek();
        if(top<min){
            return (int) min;
        }else{
            return (int) top;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */