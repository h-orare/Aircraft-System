/**
 * FleetDriver.java
 * Created by  Henry Orare
 * On 5th May 2023
 * ULID: horare
 */
package edu.ilstu;
import java.util.*;

/**
 * @author Henry Orare
 * 
 * This a main class program to manage the Aircraft, Fleet and TextMenu classes
 *
 */
public class FleetDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		Fleet f1=new Fleet(10);
		System.out.println();
		System.out.println("*****************Welcome to Delta Airlines Aircraft Management System********************\n What would you like to do?");
		setup();
	
	

	}
	public static void setup()
	{
		String[]menuItems=new String[10];
		menuItems[0]="Add an Aircrfat";
		menuItems[1]="Display the Fleet";
		menuItems[2]="Display Aircraft That Need Maintenance";
		menuItems[3]="Display Aircraft Next Maintenance Date/Miles";
		menuItems[4]="Record Miles Travelled";
		menuItems[5]="Record Maintenance";
		menuItems[6]="Retire Aircraft";
		menuItems[7]="Load From File";
		menuItems[8]="Write to File";
		menuItems[9]="Quit";
		
		
		int input;
		do 
		{
			TextMenu menu1=new TextMenu(menuItems);
			input=menu1.getChoice();
		
		
		if (input==1)
		{
			Scanner scan=new Scanner(System.in);
			System.out.print("Enter the registration number: ");
			String regNum=scan.nextLine();
			System.out.print("Enter the manufacturer: ");
			String manuf=scan.nextLine();
			String pref=manuf.toUpperCase().substring(0, 1);
			System.out.print("Enter model of Aircraft: ");
			String model=scan.nextLine();
			String name=pref+model;
			System.out.print("Enter year of Vehicle: ");
			while(!scan.hasNextInt())
			{
				scan.nextLine();
				System.out.print("Invalid input: Please Enter year in Integers: ");
			}
			int yearIS=scan.nextInt();
			scan.nextLine();
			System.out.print("Enter crew Size: ");
			while(!scan.hasNextInt())
			{
				scan.nextLine();
				System.out.print("Invalid input: Please Enter CrewSize in Integers: ");
			}
			int crewSize=scan.nextInt();
			scan.nextLine();
			System.out.print("Enter Range of the Aircraft: ");
			while(!scan.hasNextInt())
			{
				scan.nextLine();
				System.out.print("Invalid input: Please Enter Range in Integers: ");
			}
			int range=scan.nextInt();
			scan.nextLine();
			System.out.print("Enter the current air Miles: ");
			while(!scan.hasNextInt())
			{
				scan.nextLine();
				System.out.print("Invalid input: Please Enter Current Miles in Integers: ");
			}
			int miles=scan.nextInt();
			scan.nextLine();
			System.out.print("Enter Maximum Take-Off Weight: ");
			while(!scan.hasNextInt())
			{
				scan.nextLine();
				System.out.print("Invalid input: Please Enter Take off Weight in Integers: ");
			}
			int takeWeight=scan.nextInt();
			scan.nextLine();
			System.out.print("Enter Mileage of Last Maintenance: ");
			while(!scan.hasNextInt())
			{
				scan.nextLine();
				System.out.print("Invalid input: Please Enter Last Maintenance Miles in Integers: ");
			}
			int lastMiles=scan.nextInt();
			scan.nextLine();
			System.out.print("Enter the date of the last Maintenance: ");
			String lastDate=scan.nextLine();
			System.out.print("Enter the number of passengers: ");
			while(!scan.hasNextInt())
			{
				scan.nextLine();
				System.out.print("Invalid input: Please Enter Number of Pass in Integers: ");
			}
			int numPass=scan.nextInt();
			scan.nextLine();
			System.out.print("Enter total Miles: ");
			while(!scan.hasNextInt())
			{
				scan.nextLine();
				System.out.print("Invalid input: Please Enter Total Miles in Integers: ");
			}
			int totalMiles=scan.nextInt();
	
			
			 Aircraft air1=new Aircraft(name,regNum,manuf,range,crewSize,yearIS,takeWeight,numPass,totalMiles,lastDate,lastMiles);
			 Fleet f1=new Fleet(10);
			 f1.addAircraft(air1);
		
			 
		}
		if(input==2)
		{
			System.out.println("CURRENT FLEET COMPOSITION"
					+ "\nNAME\t\tREG\t\tMANUF\tRANGE\tCREW\tYIS\tTOWeight PASS\tCMILES\t\t\tLMDATE\t\tLMMILES");
			
			Fleet f2=new Fleet(10);
			//f2.readFile("deltafleet.txt");
			f2.displayFleet();
			System.out.println("Number of vehicles in fleet:"+f2.getcount());
		}
		if(input==3)
		{
			Fleet f1=new Fleet(10);
			f1.displayMaintenanceList();
		}
		if (input==4)
		{
			Fleet f1=new Fleet(10);
			System.out.println("A/C NAME\tREGNUM\t\tMANUF\tNEXT MDATE\tNEXT MMILES");
			f1.displayNextMaintenanceList();
		}
		if(input==5)
		{
			Scanner scan=new Scanner(System.in);
			System.out.print("Enter The Registration Number:");
			String regNo=scan.nextLine();
			System.out.print("How many Miles were flown:");
			while(!scan.hasNextInt())
			{
				scan.nextLine();
				System.out.print("Invalid input: Please Enter Miles flown in Integers: ");
			}
			int dist=scan.nextInt();
			scan.nextLine();
			Fleet f3=new Fleet(10);
		
		
			
			f3.updateMiles(regNo, dist)	;	
		}
		
		if(input==6)
		{
			Fleet f1=new Fleet(10);
			Aircraft cr=new Aircraft();
			Scanner scan=new Scanner(System.in);
			System.out.print("Enter The Registration Number: ");
			String regNo=scan.nextLine();
			f1.updateMaintenance(regNo);
			
		}
		if(input==7)
		{
			Aircraft cr=new Aircraft();
			Scanner scan=new Scanner(System.in);
			System.out.print("Enter The Registration Number:");
			String reg=scan.nextLine();
			System.out.print("This aircraft will be removed from the fleet. Are you sure?(YES/NO): ");
			String choice=scan.next();
			if(choice.equalsIgnoreCase("yes"))
			{
				Fleet f1=new Fleet(10);
				f1.removeAircraft(reg);
				System.out.println("Aircraft "+reg+" has been retired");
				System.out.println("Number of Aircraft in fleet: "+f1.getcount());
			}
		}
		if (input==8)
		{
			Aircraft craft=new Aircraft();
			Fleet f=new Fleet(10);
			Scanner scan=new Scanner(System.in);
			System.out.print("Enter the name of the file to be read: ");
			String fileName=scan.nextLine();
			f.readFile(fileName);
			for (int i=0;i<f.getcount();i++)
			{
				
			}
			if(f.getcount()>0)
				{
					System.out.println("Number of Vehicles in fleet: "+f.getcount());
				}
			
			
			
		}
		if(input==9)
		{
			Fleet f=new Fleet(10);
			Scanner scan=new Scanner(System.in);
			System.out.print("Enter the name of the file to write to: ");
			String fileName=scan.nextLine();
			f.writeFile(fileName);

		
		}
		}while(input!=10);
		{
			System.out.println("Program Terminating!");
		}
		
		
	}
	public static void getAirCraftInfo(int type)
	{
		//Not very clear on how this method is implemented and what it ought to achieve. Even learning center assistants could not get it
	}

}
