package com.example.demo.service;
//
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order1;

//@Component
//public class NoteService {
//    public NoteService() {
//        System.out.println("noteservice initialized");
//    }
//}
@Service
public class NoteService {
//    public NoteService() {
//        System.out.println("noteservice initialized");
//    }

	public Order1 getOrder() {
		Order1 order=new Order1();
		order.setItem("Laptop");
		order.setPrice(100F);
		return order;
	}

	

	
}