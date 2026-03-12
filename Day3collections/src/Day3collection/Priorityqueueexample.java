package Day3collection;

import java.util.*;

public class Priorityqueueexample {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// pq.comparator((a,b)->a-b);
		pq.offer(50);
		pq.add(30);
		pq.add(10);
		pq.add(20);
		System.out.println(pq);
		System.out.println(pq.poll());
		// it gives immediate available element
		// lowest number is given highest priorty but can reverse this by usine
		// comparator

	}

}
