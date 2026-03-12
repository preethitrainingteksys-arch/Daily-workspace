package Day3collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CommonelementsExercise {
	public static void main(String args[])
	{
		List<Integer> list1=Arrays.asList(1,2,3,4);
		List<Integer> list2=Arrays.asList(3,4,5,6);
		//TODO:FIND COMMON ELEMENTS BETWEEN THE LISTS
		
		List<Integer>common=new ArrayList<>();
		//for(Integer commonnumber : list1)
		//{
			//if(list2.contains(commonnumber))
				//common.add(commonnumber);
			
		//}
		for(int i=0;i<list1.size();i++)
		{
			for(int j=0;j<list2.size();j++)
			{
				if(list1.get(i).equals(list2.get(j)))
				{
				common.add(list1.get(i));
				}
				
			}
		}
		System.out.println("commo elements "+ common);
	}
}
	


