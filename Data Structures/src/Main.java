import com.company.datastructures.LinkedList;
import com.company.datastructures.Queue;
import com.company.datastructures.Stack;
import com.company.datastructures.StackedQueue;
import com.company.exceptions.StackUnderflowException;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Testing LinkedList...");
//
//        LinkedList<Integer> linkedList = new LinkedList<>(1, 2, 3, 4, 5, 6);
//        System.out.println("Initial linkedList: " + linkedList);
//
//        linkedList.insert(0, 0);
//        System.out.println("Inserted 0 at index 0: " + linkedList);
//
//        linkedList.add(7);
//        System.out.println("Added 7: " + linkedList);
//
//        linkedList.delete(7);
//        System.out.println("Deleted index 8: " + linkedList);
//
//        System.out.println("Getting index 2: " + linkedList.get(2));
//
//        linkedList.set(6, 0);
//        System.out.println("Set index 7 to 0: " + linkedList);
//
//        linkedList.deleteAll();
//        System.out.println("Deleted complete linkedList: " + linkedList);
//
//        System.out.println("Current linkedList length: " + linkedList.length());
//
//        System.out.println("Is linkedList empty: " + linkedList.isEmpty());
//
//
//        System.out.println("\nTesting Stack...");
//
//        Stack<Integer> stack = new Stack<>(5, 1, 2, 3, 4);
//        System.out.println("Top of initial stack with max length of " + stack.getMAX_LENGTH() + ": " + stack.peek());
//
//        stack.push(5);
//        System.out.println("Top of stack after pushing 5: " + stack.peek());
//
//        System.out.println("Is stack full: " + stack.isFull());
//
//        stack.pop();
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println("Top stack value after popping: " + stack.pop());
//        }
//
//        System.out.println("Length of stack after popping: " + stack.length());
//
//        System.out.println("Is stack empty: " + stack.isEmpty());
//
//
//        System.out.println("\nTesting Queue...");
//
//        Queue<Integer> queue = new Queue<>(5, 1, 2, 3, 4);
//        System.out.println("First element in initial queue with max length of " + queue.getMAX_LENGTH() + ": " + queue.dequeue());
//
//        System.out.println("Is queue empty: " + queue.isEmpty());
//
//        System.out.println("First element in queue after dequeuing: " + queue.peek());
//
//        queue.enqueue(5);
//        System.out.println("First element in queue after enqueuing 5: " + queue.peek());
//
//        System.out.println("Queue length: " + queue.length());
//
//        queue.enqueue(6);
//        System.out.println("Is queue full after enqueuing: " + queue.isFull());
//
//        queue.offer(7);
//        System.out.println("This message indicates that a QueueOverFlowException was not thrown while offering a value to a full queue.");
//
//        System.out.println("\nTesting isValidExpression()...");
//        System.out.println("Is '(ABC){DEF}[XYZ(LMN)]}' a valid expression: " + isValidExpression("(ABC){DEF}[XYZ(LMN)]}"));
//        System.out.println("Is '(ABC){DEF[XYZ(LMN)]}' a valid expression: " + isValidExpression("(ABC){DEF[XYZ(LMN)]}"));

        StackedQueue<Integer> stackedQueue = new StackedQueue<>(5);
        stackedQueue.enqueue(1);
        System.out.println(stackedQueue.peek());
        stackedQueue.enqueue(2);
        System.out.println(stackedQueue.dequeue());
        System.out.println(stackedQueue.dequeue());

    }

    private static boolean isValidExpression(String input) {
        Map<Character, Character> matchingParentheses = new HashMap<>();
        matchingParentheses.put(')', '(');
        matchingParentheses.put(']', '[');
        matchingParentheses.put('}', '{');

        try {
            Stack<Character> stack = new Stack<>(input.length());

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                    stack.push(currentChar);
                }

                if (matchingParentheses.containsKey(currentChar) && stack.pop() != matchingParentheses.get(currentChar)) {
                    return false;
                }
            }
            return stack.isEmpty();
        } catch (StackUnderflowException sue) {
            return false;
        }
    }
}