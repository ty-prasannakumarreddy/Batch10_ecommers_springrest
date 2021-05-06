package com.te.ecommerce.DAO;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.te.ecommerce.beans.ItemsInfoBean;

public interface ItemsDAO {
	
	public ItemsInfoBean getItem(int id);
	public boolean addItem(ItemsInfoBean bean);
	public boolean updateItem(ItemsInfoBean bean);
	public boolean deleteItem(int id);
	public List<ItemsInfoBean> getAll();
	

}
