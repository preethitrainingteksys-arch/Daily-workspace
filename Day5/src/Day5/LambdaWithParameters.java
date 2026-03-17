package Day5;
@FunctionalInterface
interface Add
{
	void sum(int a, int b);
}

public class LambdaWithParameters {
	public static void main(String[] args) {
		Add add=(a,b)->a + b;
		System.out.println(add.sum(a, b));
		
	}

}
