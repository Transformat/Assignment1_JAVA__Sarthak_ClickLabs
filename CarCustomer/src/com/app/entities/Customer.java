package com.app.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.app.main.Main;

public class Customer 
{
	public int customer_id;
	public String customer_name;
	public List<Cars> cars=new ArrayList<Cars>();
	public List<Customer> customerList=new ArrayList<Customer>();



	Main m=new Main();


	public List<Cars> getCar() 
	{
		return cars;
	}

	public Customer(int id,String name)
	{          //Parameterized Constructor
		this.customer_id=id;
		this.customer_name=name;

	}
	public Customer() {								//Default constructor	
		// TODO Auto-generated constructor stub
	}
	//DISPLAY FUNCTION:- Will take customer object and display it's details                     
	public void display()
	{
		System.out.println();
		System.out.println("Customer id :"+customer_id);
		System.out.println("Customer name :"+customer_name);
		System.out.println();
		System.out.println("Cars owned by customer name:"+customer_name);
		System.out.println("*************************************");
		if(cars.size()>0)
		{
			for(int i=0;i<cars.size();i++)
			{

				System.out.println("Car model:"+cars.get(i).model);
				System.out.println("Car Id :"+cars.get(i).id);
				System.out.println("Car Brand "+cars.get(i).brand);
				System.out.println("Car Price:"+cars.get(i).price);
				System.out.println("Car Resale Value :"+cars.get(i).resaleValue);
				System.out.println();
				System.out.println("------------------------------------------");
			}
			System.out.println("*************************************");



		}
		else
		{
			System.out.println("No Cars owned by customer "+customer_id);
			System.out.println();
			System.out.println("------------------------------------------");

		}


	}
	//SORT BY CUSTOMER NAME:- Sorts all customer objects by customer name.
	public ArrayList<Customer> displayByCustomer()
	{
		for (Map.Entry<Integer,Customer> e : m.customerIdMap.entrySet()) 
		{
			customerList.add(e.getValue());
		}
		Collections.sort(customerList,new Comparator<Customer>() 
				{

			@Override
			public int compare(Customer o1, Customer o2) 
			{
				// TODO Auto-generated method stub
				return o1.customer_name.compareTo(o2.customer_name);	//Returning sorted list.
			}
		});
		return (ArrayList<Customer>) customerList;
	}

	//SORT BY MODEL NAME:- Sorts all customer objects by car models they own.
	public ArrayList<Customer> displayByModel()
	{
		for (Map.Entry<Integer,Customer> e : m.customerIdMap.entrySet()) 
		{
			customerList.add(e.getValue());
		}
		for(int i=0;i<customerList.size();i++)
		{
			Collections.sort(customerList.get(i).getCar(), new Comparator<Cars>() {

				@Override
				public int compare(Cars o1, Cars o2) 
				{
					// TODO Auto-generated method stub
					return o1.model.compareTo(o2.model);		//Returning sorted list.
				}

			});

		}return (ArrayList<Customer>) customerList;
	}

}



