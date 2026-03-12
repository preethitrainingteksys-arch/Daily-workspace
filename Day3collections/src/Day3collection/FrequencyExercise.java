package Day3collection;
import java.util.*;

import java.util.Arrays;

public class FrequencyExercise {
	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(1,2,2,3,2,4);
		int target=2;
		//fibd frequency of target
		int count=0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++)
			{
				if(list.get(i)==list.get(j))
				{
					count +=1;
					System.out.println("")
					
				}
			}
		}
		
	}

}
