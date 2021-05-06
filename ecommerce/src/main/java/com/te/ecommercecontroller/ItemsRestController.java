package com.te.ecommercecontroller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.ecommerce.beans.ItemResponseBean;
import com.te.ecommerce.exp.ItemsException;

@RestControllerAdvice
public class ItemsRestController {
	@ExceptionHandler(ItemsException.class)
	public ItemResponseBean handleEmployeeExp(ItemsException exception) {
		ItemResponseBean response = new ItemResponseBean();
		response.setStatusCode(500);
		response.setMsg(exception.getMessage());
		return response;
	}

}
