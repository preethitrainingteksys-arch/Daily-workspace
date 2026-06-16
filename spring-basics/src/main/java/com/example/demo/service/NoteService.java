package com.example.demo.service;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Order1;
import com.example.demo.repository.Order1Repository;
import org.springframework.transaction.annotation.Transactional;


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
	@Autowired
	PaymentService paymentService;
	@Autowired
	EmailService emailService;
		public Iterable<Order1>getOrder() {
			
			return order1Repository.findAll();
		
	}

		//@Transactional(rollbackFor=Exception.class,noRollbackFor= {IOException.class}//->for rollback to happen
		@Transactional(rollbackFor=Exception.class,noRollbackFor= {})//for no rllback to happen
		public Integer addOrder(Order1 order1) throws IOException{
		paymentService.processPayment();	
		order1Repository.save(order1);
		emailService.send(order1.getId());
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