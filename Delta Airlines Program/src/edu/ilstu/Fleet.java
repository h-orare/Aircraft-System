/**
 * Fleet.java
 * Created by  Henry Orare
 * On 5th May 2023
 * ULID: horare
 */
package edu.ilstu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Henry Orare
 * 
 * A an aircraft fleet class
 *
 */
public class Fleet {
	private Aircraft[]fleet;
	private int count;
	
	/**
	 * A Default Constructor that initializes count variable to zero and instantiates the fleet array.
	 */
	public Fleet(int size)
	{
		this.count=0;
	    this.fleet=new Aircraft[size];
	}
	/**
	 * A method that takes the name of a file as a parameter, reads the contents of the file and counts number of items read
	 * @param name
	 */
	public void readFile(String name)
	{
		String airCraftName;
		String regNo;
		String manufacturer;
		int maxRange;
		int crewSize;
		int yearPutInService;
		int maxServiceWeight;
		int numPassengers;
		String lastMaintenanceDate;
		int lastMaintenanceMiles;
		int totalMiles;;
		int countItems=0;
		File file1=new File(name);
		Scanner scan=null;
		
		
		try {
			scan=new Scanner(file1);
			while(scan.hasNext())
			{
				
				airCraftName=scan.next();
				String nextToken=scan.nextLine();
				regNo=nextToken.substring(1);
				manufacturer=scan.nextLine();
				maxRange=scan.nextInt();
				scan.nextLine();
				crewSize=scan.nextInt();
				scan.nextLine();
				yearPutInService=scan.nextInt();
				scan.nextLine();
				maxServiceWeight=scan.nextInt();
				scan.nextLine();
				numPassengers=scan.nextInt();
				scan.nextLine();
				totalMiles=scan.nextInt();
				scan.nextLine();
				lastMaintenanceDate=scan.nextLine();
				lastMaintenanceMiles=scan.nextInt();
				if(scan.hasNextInt())
				{
					lastMaintenanceMiles=scan.nextInt();
					
				}
				scan.nextLine();
				
			
					this.fleet[this.count]=new Aircraft(airCraftName,regNo,manufacturer,maxRange,crewSize,yearPutInService,maxServiceWeight,numPassengers,totalMiles,lastMaintenanceDate,lastMaintenanceMiles);
					this.count++;
			
			}

		
		}catch(FileNotFoundException e)
		{
			System.out.println("File Not Found:");
		}
		finally
		{
			if(scan !=null)
			{
				scan.close();
			}
		}
		
	
	}
	/**
	 * A method that takes an Aircraft object as a parameter, and adds it to the fleet array.
	 * @param craft
	 */
	public void addAircraft(Aircraft craft)
	{
		
		
		Aircraft cr=new Aircraft(craft.getAirCraftName(),craft.getRegNo(),craft.getManufacturer(),craft.getMaxRange(),craft.getCrewSize(),craft.getYearPutInService(),craft.getMaxServiceWeight(),craft.getNumPassengers(),craft.getTotalMiles(),craft.getLastMaintenanceDate(),craft.getLastMaintenanceMiles());
		//readFile("deltafleet.txt");
		
		PrintWriter pw=null;
		try {

			FileWriter fw=new FileWriter("deltafleet.txt",false);
			
			pw=new PrintWriter(fw);
			pw.println(cr.toString());
//			pw.print(new Aircraft(craft.getAirCraftName(),craft.getRegNo(),craft.getManufacturer(),craft.getMaxRange(),
//						craft.getCrewSize(),craft.getYearPutInService(),craft.getMaxServiceWeight(),craft.getNumPassengers(),
//						craft.getTotalMiles(),craft.getLastMaintenanceDate(),craft.getLastMaintenanceMiles()));
			
//			
//			pw.print(craft.getAirCraftName()+" "+craft.getRegNo()+"\n"+craft.getManufacturer()+"\n"+craft.getMaxRange()+"\n"+craft.getCrewSize()
//			+"\n"+craft.getYearPutInService()+"\n"+craft.getMaxServiceWeight()+"\n"+craft.getNumPassengers()+"\n"+craft.getTotalMiles()
//			+"\n"+craft.getLastMaintenanceDate()+"\n"+craft.getLastMaintenanceMiles());
//			pw.println(craft.getRegNo());
//			pw.println(craft.getManufacturer());
//			pw.println(craft.getMaxRange());
//			pw.println(craft.getCrewSize());
//			pw.println(craft.getYearPutInService());
//			pw.println(craft.getMaxServiceWeight());
//			pw.println(craft.getNumPassengers());
//			pw.println(craft.getTotalMiles());
//			pw.println(craft.getLastMaintenanceDate());
//			pw.println(craft.getLastMaintenanceMiles());
			
//			pw.print(cr.getAirCraftName());
//			pw.println(cr.getRegNo());
//			pw.println(cr.getManufacturer());
//			pw.println(cr.getMaxRange());
//			pw.println(cr.getCrewSize());
//			pw.println(cr.getYearPutInService());
//			pw.println(cr.getMaxServiceWeight());
//			pw.println(cr.getNumPassengers());
//			pw.println(cr.getTotalMiles());
//			pw.println(cr.getLastMaintenanceDate());
//			pw.println(cr.getLastMaintenanceMiles());
//			for( int i=0;i<(count+1);i++)
//			{
//				pw.println(this.fleet[count+1]);
//			}
		}catch(IOException e)
		{
			e.getMessage();
		}
		finally
		{
			if (pw!=null)
			{
				pw.close();
			}
		}
		
			
		System.out.println("Number of Vehicles in fleet:"+(count+1));

	}
	/**
	 * A method that takes a file name as a parameter, writes to it the contents of a fleet array.
	 * @param filename
	 */
	public void writeFile(String filename)
	{
		readFile("deltafleet.txt");
		PrintWriter pw=null;
		try 
		{
			FileWriter fw=new FileWriter(filename);
			pw=new PrintWriter(fw,false);
			
			for (int i=0;i<count;i++)
			{
				pw.println(this.fleet[i].getAirCraftName()+" "+this.fleet[i].getRegNo());
				pw.println(this.fleet[i].getManufacturer());
				pw.println(this.fleet[i].getRegNo());
				pw.println(this.fleet[i].getCrewSize());
				pw.println(this.fleet[i].getYearPutInService());
				pw.println(this.fleet[i].getMaxServiceWeight());
				pw.println(this.fleet[i].getNumPassengers());
				pw.println(this.fleet[i].getLastMaintenanceDate());
				pw.println(this.fleet[i].getLastMaintenanceMiles());
				pw.println();
				
			}
			System.out.println(count+" Aircraft written to "+filename);
		
			
		} catch (IOException e) {
			
			e.getMessage();
		}
		finally
		{
			if(pw!=null)
			{
				pw.close();
			}
		}
	}
	/**
	 * A method to display the contents of a fleet array
	 */
	public void displayFleet()
	{
	
		readFile("deltafleet.txt");
		for (int i=0;i<count+1;i++)
		{
			System.out.println(this.fleet[i]);
		}
	}
	/**
	 * A method to display aircraft fleet due for Maintenance
	 */
	public void displayMaintenanceList()
	{
		Aircraft craft1=new Aircraft();
		readFile("deltafleet.txt");
		
		System.out.println("AC NAME\t\tREG NUM\t\tMANUF.\tLAST MDATE\tLAST MILES");
		for (int i=0;i<count;i++)
		{
			if(this.fleet[i].needsMaintenance())
			{
				
			}
		}
		
	}
	/**
	 * A method that takes fleet array as parameter and sorts the fleet by registration number
	 * @param fleet
	 */
	public void sortArray(Aircraft[]fleet)
	{
		Aircraft temp;
		int j;
		for (int i=1;i<this.fleet.length;i++)
		{
			j=i;
			temp=fleet[i];
			while(j!=0 && (temp.getRegNo()).compareToIgnoreCase(fleet[j-1].getRegNo())<0)
			{
				fleet[j]=fleet[j-1];
				j--;
			}
			fleet[j]=temp;
		}
	}
	/**
	 * A method to display fleet for next Maintenance
	 */
	public void displayNextMaintenanceList()
	{
		readFile("deltafleet.txt");
		for (int i=0;i<count;i++)
		{
			System.out.println(this.fleet[i].getAirCraftName()+"\t"+this.fleet[i].getRegNo()+"\t"+this.fleet[i].getManufacturer()+"\t"+this.fleet[i].getLastMaintenanceDate()+"\t"+(this.fleet[i].getLastMaintenanceMiles()+150000));
		}
	}
	/**
	 * A method that updates the miles traveled by an aircraft
	 * 
	 * @param regNo-aircraft registration number
	 * @param miles-distance in miles covered
	 * @return
	 */
	public void updateMiles(String regNo,int miles)
	{
		int temp=0;
		readFile("deltafleet.txt");
		for (int i=0;i<count;i++)
		{
			
			if((fleet[i].getRegNo().equalsIgnoreCase(regNo)))
			{
			
				System.out.println("Miles Updated For:");
				System.out.println(regNo);
				System.out.println(fleet[i].getManufacturer());
				System.out.println(fleet[i].getAirCraftName().substring(1));
				
				temp=fleet[i].getTotalMiles();
				temp+=miles;
			}
		
		}
		System.out.println("New Miles: "+temp);

		
	}
	/**
	 * A method that updates the fleet maintenance list if a maintenance condition is met
	 * 
	 * @param regNo-aircraft registration number
	 */
	public void updateMaintenance(String regNo)
	{
		DateTimeFormatter fmt=DateTimeFormatter.ofPattern("MM/dd/YY");
		LocalDate loc=LocalDate.now();
		String today=loc.format(fmt);
		readFile("deltafleet.txt");
		
		
		for (int i=0;i<count;i++)
		{
			
			if(this.fleet[i].getRegNo().equalsIgnoreCase(regNo))
			{
				
				System.out.println("Maintenance Miles Updated For:");
				System.out.println(regNo);
				System.out.println(fleet[i].getManufacturer());
				System.out.println(fleet[i].getAirCraftName().substring(1));
				
				this.fleet[i].setLastMaintenanceDate(today);
				double temp=this.fleet[i].getLastMaintenanceMiles();
				temp=0;
				System.out.println("Next Maintenance Date: "+this.fleet[i].getLastMaintenanceDate());
				System.out.println("Next Maintenance Miles: "+(this.fleet[i].getLastMaintenanceMiles()+150000));
			}
		}
	}
	/**
	 * A method that searches an aircraft array and returns the details of the aircraft if found
	 * 
	 * @param regNo-Aircraft registration number
	 */
	public void displayAircraft(String regNo)
	{
		
		
		for (int i=0;i<fleet.length;i++)
		{
			if(fleet[i].getRegNo().equalsIgnoreCase(regNo))
			{
				System.out.println(fleet[i]);
			}
			else
				System.out.println("Not Found");
		}
	}
	/**
	 * A method that searches the array for an aircraft and removes it from the array
	 * 
	 * @param regNo-aircraft registration number
	 */
	public void removeAircraft(String regNo)
	{
		readFile("deltafleet.txt");
		for (int i=0;i<count;i++)
		{
			if(!(this.fleet[i].getRegNo().equalsIgnoreCase(regNo)))
			{
			
			}
	}	
 }
	/**
	 * 
	 * @return -A count for the number of aircraft in a fleet array
	 */
	public int getcount()
	{
		return this.count;
	}
	/**
	 * A getter for the aircraft array object
	 * 
	 * @return -fleet array
	 */
	public Aircraft[] getAircraft()
	{
		for (int i=0;i<count;i++)
		{
			 this.fleet[i]=new Aircraft(this.fleet[i].getAirCraftName(),this.fleet[i].getRegNo(),this.fleet[i].getManufacturer(),this.fleet[i].getMaxRange(),this.fleet[i].getCrewSize(),this.fleet[i].getYearPutInService(),
					this.fleet[i].getMaxServiceWeight(),this.fleet[i].getNumPassengers(),this.fleet[i].getTotalMiles(),this.fleet[i].getLastMaintenanceDate(),this.fleet[i].getLastMaintenanceMiles());
		}
		return fleet;
	}

}
