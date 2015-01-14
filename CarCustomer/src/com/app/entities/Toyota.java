package com.app.entities;

public class Toyota extends Cars
{


	public Toyota(int id, int price, String model) 
	{
		this.id=id;
		this.price=price;
		this.model=model;
		this.resaleValue=(price*80)/100;
		brand="Toyota";
	}


}
