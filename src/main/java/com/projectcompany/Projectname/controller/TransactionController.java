package com.projectcompany.Projectname.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.projectcompany.Projectname.model.Transaction;
import com.projectcompany.Projectname.service.TransactionService;

@Controller
@RequestMapping("/Transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService service;
	
	@ResponseBody
	@RequestMapping(value="/DELETE/item" , method = RequestMethod.POST)
	public String delete(@RequestBody Transaction transaction) {
		String result = null;
		System.out.println(transaction.getTransaction_key());
		service.delete(transaction.getTransaction_key());
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/POST/items" , method = RequestMethod.POST)
	public String save(@RequestBody Transaction transaction) {
		String jsonresult = null;
		System.out.println(transaction.toString());
		try {
			Transaction transactionresult = service.save(transaction);
			ObjectMapper mapper = new ObjectMapper();
			jsonresult = mapper.writeValueAsString(transactionresult);
		} catch (JsonProcessingException e) {
			jsonresult = "sth goes wrong"; 
		}
		return jsonresult;
	}
	
	@ResponseBody
	@RequestMapping("/GET/record/{name}")
	public String getone(@PathVariable("name") String name) {
		String jsonresult = null;
		try {
			Transaction record = new Transaction();
			record.setTransaction_key(name);
			Transaction result = service.findById(record.getTransaction_key()).get();
			
			ObjectMapper mapper = new ObjectMapper();
			jsonresult = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			jsonresult = "sth goes wrong";
			e.printStackTrace();
		}
		return jsonresult;
	}
	
	@ResponseBody
	@RequestMapping("/GET/records")
	public String getall() {
		String jsonresult = "not found.";
		try {
			List<Transaction> list = service.findAll();
			ObjectMapper mapper = new ObjectMapper();
			jsonresult = mapper.writeValueAsString(list);

			System.out.println(jsonresult);
		} catch (Exception e) {
			jsonresult = "sth goes wrong";
			e.printStackTrace();
		}
		return jsonresult;
	}
}
