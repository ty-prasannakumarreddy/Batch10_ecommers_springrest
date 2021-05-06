package com.te.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.te.ecommerce.DAO.ItemsDAO;
import com.te.ecommerce.beans.ItemsInfoBean;

public class Itemserviceimpl implements ItemService {
	
	@Autowired
	ItemsDAO dao;

	@Override
	public ItemsInfoBean getItemsData(int id) {
		return dao.getItem(id);
		
	}

	@Override
	public boolean addItem(ItemsInfoBean bean) {
		return dao.addItem(bean);
		
	}

	@Override
	public boolean updateItem(ItemsInfoBean bean) {
		return dao.updateItem(bean);
		
		
	}

	@Override
	public boolean deleteItem(Integer id) {
		return dao.deleteItem(id);
		
	}

	@Override
	public List<ItemsInfoBean> getAllItems() {
		return dao.getAll();
		
	}

}
