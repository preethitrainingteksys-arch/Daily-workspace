package com.example.demo.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Optional;
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
		public Iterable<Order1>getOrder() {
			
			return order1Repository.findAll();
		
	}

	public Integer addOrder(Order1 order1) {
		order1Repository.save(order1);
		
		return order1.getId();
	}

	public Optional<Order1> getOrderById(Integer id) {
		return order1Repository.findById(id);
		
	}

	public void deleteOrderById(Integer id) {
		// TODO Auto-generated method stub
		order1Repository.deleteById(id);
	}

	

	
}