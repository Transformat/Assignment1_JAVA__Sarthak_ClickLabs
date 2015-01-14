//MAIN CLASS:
package com.app.main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.app.entities.*;
import com.app.util.*;

public class Main implements AppConst 
{
	public static Map<Integer,Customer> customerIdMap=new HashMap<Integer,Customer>();//Hashmap for customer objects.
	public static List<Integer> prizeList=new ArrayList<Integer>();
	public static void main(String[] args) 
	{
		Scanner scan= new Scanner(System.in);

		//MAIN MENU FOR OPTIONS :-
		System.out.println("--**--**--**--**--**--");
		System.out.println("* WELCOME TO CAR SALES *");
		System.out.println("--**--**--**--**--**--");
		System.out.println("Select an option:");
		System.out.println("1. Add Customer");
		System.out.println("2. Add Car");
		System.out.println("3. Display customer data(order by car model)");
		System.out.println("4. Display data of specific customer");
		System.out.println("5. Display customer data(order by customer name)");
		System.out.println("6. Prize");
		System.out.println("7. Exit");
		System.out.print("Option:");

		if(scan.hasNextInt())
		{
			int option =scan.nextInt();

			//SWITCH FOR MAIN MENU:	
			switch (option)
			{
			case ADD_CUSTOMER:
				addCustomer();
				break;


			case ADD_CAR:
				addCar();
				break;

			case DISPLAY_CAR_MODEL:
				displayAll();
				main(args);
				break;
			case DISPLAY_CUSTOMER:
				displaySpecific();
				main(args);
				break;

			case DISPLAY_CUSTOMER_NAME:
				displayCustomerName();
				main(args);
				break;

			case PRIZE:
				prize();
				main(args);
				break;
			case EXIT:
				System.out.println("Thanks for using Car Sales.");
				break;

			default:
				System.out.println("The option entered is wrong,please try again..!!");
				System.out.println();
				main(args);

			}


		}
		else
		{
			System.out.println("The option entered is not valid,Please try again..!!");
			System.out.println();
			main(args);
		}

	}

	//FUNCTION DEFINITIONS :


	
	//1.ADD CUSTOMER:-
	public static void addCustomer()
	{
		Scanner scanner= new Scanner(System.in);
		System.out.print("Enter Customer id:");
		if(scanner.hasNextInt())
		{
			int id=scanner.nextInt();

			if(customerIdMap.containsKey(id))
			{
				System.out.println("Customer already exists,please choose other id..!!");
				System.out.println();
				addCustomer();
			}
			else
			{
				Scanner scanner1= new Scanner(System.in);
				System.out.print("Enter Customer name:");
				String name=scanner1.nextLine();

				customerIdMap.put(id,new Customer(id,name));
				System.out.println();
				System.out.println("Customer with id:"+id+" and Name:"+name+", Sucessfully added.");
				System.out.println();
				System.out.println("********************************************");

				String[] args = null;
				main(args);
			}

		}
		else
		{
			System.out.println("The id entered is not valid,Please try again..!!");
			System.out.println();
			addCustomer();
		}
	}





	//2.ADD CAR FUNCTOIN:-
	public static void addCar()
	{
		Scanner idScanner= new Scanner(System.in);

		System.out.print("Enter id of customer who wants to buy car:");
		int idOfCustomer=idScanner.nextInt();
		String[] args = null;
		if(customerIdMap.containsKey(idOfCustomer))
		{
			Scanner carScanner= new Scanner(System.in);
			System.out.print("Enter Brand name:");
			String brand=carScanner.nextLine().toLowerCase();
			System.out.print("Enter Model:");
			String carModel=carScanner.nextLine();
			System.out.print("Enter Car id:");
			int carID = carScanner.nextInt();
			System.out.print("Enter Price:");
			int carPrice = carScanner.nextInt();

			//SWITCH FOR BRAND SELECTION:
			switch(brand)
			{
			case BRAND_NAME_MARUTI:
				Maruti maruti=new Maruti(carID,carPrice,carModel);
				customerIdMap.get(idOfCustomer).getCar().add(maruti);
				System.out.println("Car "+carModel.toUpperCase()+ " Sucessfully added in "+customerIdMap.get(idOfCustomer).customer_name+"'s list of cars.");
				System.out.println();
				main(args);
				break;
			case BRAND_NAME_HYUNDAI:
				Hyundai hyundai=new Hyundai(carID,carPrice,carModel);
				customerIdMap.get(idOfCustomer).getCar().add(hyundai);
				System.out.println("Car "+carModel.toUpperCase()+ " Sucessfully added in "+customerIdMap.get(idOfCustomer).customer_name+"'s list of cars.");
				System.out.println();
				main(args);
				break;
			case BRAND_NAME_TOYOTA:
				Toyota toyota=new Toyota(carID,carPrice,carModel);
				customerIdMap.get(idOfCustomer).getCar().add(toyota);
				System.out.println("Car "+carModel.toUpperCase()+ " Sucessfully added in "+customerIdMap.get(idOfCustomer).customer_name+"'s list of cars.");
				System.out.println();
				main(args);
			default:
				System.out.println("Brand is not recognized");
				addCar();

			}
		}
		else 
		{
			System.out.println("Customer does not exist,Enter details for new customer");
			System.out.println();
			addCustomer();

		}

	}

	//3.DISPLAY BY MODEL:-
	public static void displayAll()
	{
		Customer cust=new Customer();
		List<Customer> customerList=cust.displayByModel();//Calling displayByModel from Customer class.
		for(int i=0;i<customerList.size();i++)
		{
			customerList.get(i).display();//Calling display method from Customer class. 
		}


	}
	
	//4.DISPLAY SPECIFIC CUSTOMER DATA:-
	public static void displaySpecific() 
	{

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter id of customer:");
		if(scan.hasNextInt())
		{
			int i=scan.nextInt();
			if(customerIdMap.containsKey(i))
			{
				Customer customer=customerIdMap.get(i);
				customer.display();
				String[] args = null;
				main(args);
			}
			else
			{
				System.out.println();
				System.out.println("This id does not exist,Please try again");
				System.out.println();

				displaySpecific();
			}
		}
		else
		{
			System.out.println();
			System.out.println("Wrong id type,Please try again");
			System.out.println();
			displaySpecific();
		}
	}


	//5.DISPLAY BY CUSTOMER NAME:-
	public static void displayCustomerName()
	{
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		Customer cust=new Customer();
		List<Customer> customerList=cust.displayByCustomer();//Calling displayByCustomer in Customer class.
		for(int i=0;i<customerList.size();i++){
			customerList.get(i).display();//Calling display from Customer class.
		}
	}

	//6.PRIZE FUNCTION:- Takes the id's of customers and shuffles them using Collection.shuffle()
	public static void prize(){


		for (Map.Entry<Integer,Customer> e : customerIdMap.entrySet()) { //Getting all id's
			prizeList.add(e.getKey());
		}
		if(prizeList.size()>5)
		{

			Collections.shuffle(prizeList);
			System.out.print("Enter an id for prize:");
			Scanner scan=new Scanner(System.in);
			if(scan.hasNextInt())
			{
				int prizeId=scan.nextInt();
				ArrayList<Integer> selected = new ArrayList<Integer>(prizeList.subList(0,6));//Sublisting
				if(selected.contains(prizeId))
				{
					System.out.println("Congratulations you have won the prize..!!");
					System.out.println();
					System.out.println("***************************************");
					System.out.println();
				}
				else
				{
					System.out.println("Sorry you have not won the prize,Better luck next time..!!");
					System.out.println();
					System.out.println("***************************************");
					System.out.println();

				}

			}

		}
		else
		{
			System.out.println("Need more entries in the draw.");
			System.out.println();
			System.out.println("***********************************");
			System.out.println();
		}
	}
}
