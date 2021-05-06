
package com.te.ecommerce.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("response")
@JsonPropertyOrder({"status" , "msg"})
@XmlRootElement(name = "response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemResponseBean implements Serializable{

	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int statusCode;
	
	
	private String  msg;
	
	@JsonProperty("items_info")
	@XmlElement(name = "items-info")
	private ItemsInfoBean bean;
	
	
	private List< ItemsInfoBean> itemsInfobeans;


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public ItemsInfoBean getBean() {
		return bean;
	}


	public void setBean(ItemsInfoBean bean) {
		this.bean = bean;
	}


	public List<ItemsInfoBean> getItemsInfobeans() {
		return itemsInfobeans;
	}


	public void setItemsInfobeans(List<ItemsInfoBean> itemsInfobeans) {
		this.itemsInfobeans = itemsInfobeans;
	}


	@Override
	public String toString() {
		return "ItemResponseBean [statusCode=" + statusCode + ", msg=" + msg + ", bean=" + bean + ", itemsInfobeans="
				+ itemsInfobeans + "]";
	}
	
	
	
	


	
}