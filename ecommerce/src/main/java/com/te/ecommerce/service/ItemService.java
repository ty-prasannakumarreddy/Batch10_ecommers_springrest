package com.te.ecommerce.service;

import java.util.List;

import com.te.ecommerce.beans.ItemsInfoBean;

public interface ItemService {
	public ItemsInfoBean getItemsData(int id);

	public boolean addItem(ItemsInfoBean  bean);

	public boolean updateItem(ItemsInfoBean bean);

	public boolean deleteItem(Integer id);

	public List<ItemsInfoBean > getAllItems();

}
