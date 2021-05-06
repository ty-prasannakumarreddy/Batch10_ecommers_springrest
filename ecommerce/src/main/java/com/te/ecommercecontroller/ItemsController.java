package com.te.ecommercecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.beans.ItemResponseBean;
import com.te.ecommerce.beans.ItemsInfoBean;
import com.te.ecommerce.service.ItemService;

@RestController
public class ItemsController {
	
	@Autowired
	private ItemService service;

	@GetMapping(path = "/getItem", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ItemResponseBean getEmpData(int id) {

		ItemResponseBean response = new ItemResponseBean();
		ItemsInfoBean infoBean = service.getItemsData(id);

		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setBean(infoBean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure , Data Not found");
		}

		return response;
	}// end of getEmpData

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ItemResponseBean getAllEmployeeDetails() {
		ItemResponseBean response = new ItemResponseBean();
		List<ItemsInfoBean> infoBeans = service.getAllItems();

		if (infoBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setItemsInfobeans(infoBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("Datas not found");
		}

		return response;
	}// END OF GETALL

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ItemResponseBean addItemdata(@RequestBody ItemsInfoBean infoBean) {
		ItemResponseBean response = new ItemResponseBean();
		

		if (service.addItem(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Added the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not add the data");
		}

		return response;
	}// end of addEmp

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ItemResponseBean updateItemData(@RequestBody ItemsInfoBean infoBean) {
		ItemResponseBean response = new ItemResponseBean();

		if (service.updateItem(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Updated the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not update the record");
		}
		return response;
	} // update

	
	@DeleteMapping(path = "/delete/{empId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ItemResponseBean deleteEmpData(@PathVariable(name = "empId")int id ) {
		ItemResponseBean response = new ItemResponseBean();

		if (service.deleteItem(id)) {
			response.setStatusCode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}

	

}
