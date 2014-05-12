package com.practicaljava.lesson27.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="quote")
@RequestScoped
public class Quote implements Serializable {
	
	private String symbol = "ORCL";
	private int quantity;
	private double price;
	
	public Quote(){

	}
	
	public Quote(String symbol, int quantity, double price){
		this.symbol = symbol;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
	

}
