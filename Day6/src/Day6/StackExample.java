package Day6;
import java.util.Stack;

public class StackExample {
	Stack<Integer> stack=new Stack<>();
	{
	stack.push(10);
	stack.push(20);
	stack.push(30);
	
	System.out.println(stack.pop());
	System.out.println(stack.peek());
}

}
