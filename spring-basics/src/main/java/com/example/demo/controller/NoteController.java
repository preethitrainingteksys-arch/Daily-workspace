//package com.example.demo.controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
//public class NoteController {
//	@GetMapping("/order")
//	String getOrder() {
//		return "hello123";
//	}
//}
//
// 

package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order1;
import com.example.demo.service.NoteService;
@RestController
public class NoteController {
	@Autowired
	NoteService noteService;
	@GetMapping("/order")
	Order1 getOrder()
	{
		return noteService.getOrder();
	}
	
}

 
