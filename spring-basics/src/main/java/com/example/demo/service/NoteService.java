package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order1;
import com.example.demo.repository.Order1Repository;

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
	@Autowired
	Order1Repository order1Repository;

	public Order1 getOrder() {
		Order1 order=new Order1();
		order.setItem("Laptop");
		order.setPrice(100F);
		return order;
	}

	public Integer addOrder(Order1 order1) {
		order1Repository.save(order1);
		return order1.getId();
	}

	

	
}