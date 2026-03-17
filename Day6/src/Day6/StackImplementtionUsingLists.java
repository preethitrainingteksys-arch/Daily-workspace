package Day6;
import java.util.ArrayList;

public class StackImplementtionUsingLists {
	ArrayList<Integer> stack=new ArrayList<>();
	
	void push(int x)
	{
		stack.add(x);
		System.out.println(x+"is pushed");
	}
	int pop()
	{
		if(stack.isEmpty())
		{
			System.out.println("Stack Underflow");
			return -1;
		}
		return stack.remove(stack.size()-1);
		
	}
	void peek()
	{
		if(stack.isEmpty())
		{
			System.out.println("Stack is empty");
		}
		else
		{
			System.out.println(stack.get(stack.size()-1));
		}
		
	}
	

}
