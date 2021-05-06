package com.te.ecommerce.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.ecommerce.beans.ItemsInfoBean;
import com.te.ecommerce.exp.ItemsException;

@Repository
public class ItemsDAOimpl implements ItemsDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;


	@Override
	public ItemsInfoBean getItem(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mahesh");
		EntityManager manager = factory.createEntityManager();
		ItemsInfoBean bean = manager.find(ItemsInfoBean.class, id);
		return bean;
	}
		
	

	@Override
	public boolean addItem(ItemsInfoBean bean) {
		try {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	

		
	}
		

	@Override
	public boolean updateItem(ItemsInfoBean bean) {
		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("mahesh");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ItemsInfoBean orgData = manager.find(ItemsInfoBean.class, bean.getItemId());

			if (bean.getItemname() != null && bean.getItemname() != "") {
				orgData.setItemname(bean.getItemname());
			}

			if (bean.getQuantity()!= 0) {
				orgData.setQuantity(bean.getQuantity());
			}

			if (bean.getPrice() != 0.0 ) {
				orgData.setPrice(bean.getPrice());
			}

			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteItem(int id) {
		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ItemsInfoBean infoBean = manager.find(ItemsInfoBean.class, id);
			manager.remove(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();

			throw new ItemsException("The Data is not present");
		}
		
	}

	@Override
	public List<ItemsInfoBean> getAll() {
		List<ItemsInfoBean> items = null;

		try {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();

			Query query = manager.createQuery("from EmployeeInfoBean");

			items = query.getResultList();

		} catch (Exception e) {
			items = null;
			e.printStackTrace();
		}

		return items;
		
	}

}
