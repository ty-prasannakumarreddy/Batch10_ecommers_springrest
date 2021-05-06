package com.te.ecommerce.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;


@Data
@Table(name="items")
@Entity
@XmlRootElement(name="items_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("items_info")
public class ItemsInfoBean implements Serializable {

	@Column(name="id")
	@Id
	private int itemId;
	
	@Column(name="name")
	private String itemname;
	@Column
	private int quantity;
	
	@Column
	private double price;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemsInfoBean [itemId=" + itemId + ", itemname=" + itemname + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
	
	
	
}
