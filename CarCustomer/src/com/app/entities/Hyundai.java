package com.app.entities;

public class Hyundai extends Cars
{

	public Hyundai(int id, int price, String model) 
	{
		this.id=id;
		this.price=price;
		this.model=model;
		this.resaleValue=price*40/100;
		brand="Hyundai";

	}




}
