package com.app.entities;

public class Maruti extends Cars 
{


	public Maruti(int id, int price, String model) 
	{
		this.id=id;
		this.price=price;
		this.model=model;
		this.resaleValue=price*6/10;
		brand="Maruti";
	}






}
