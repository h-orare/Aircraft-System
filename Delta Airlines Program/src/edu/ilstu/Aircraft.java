/**
 * Aircraft.java
 * Created by  Henry Orare
 * On 5th May 2023
 * ULID: horare
 */
package edu.ilstu;
import java.time.LocalDate;
import java.time.temporal.*;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author Henry Orare
 * 
 * An aircraft object class
 *
 */
public class Aircraft {
	private String airCraftName;
	private String regNo;
	private String manufacturer;
	private int maxRange;
	private int crewSize;
	private int yearPutInService;
	private int maxServiceWeight;
	private int numPassengers;
	private String lastMaintenanceDate;
	private int lastMaintenanceMiles;
	private int totalMiles;
	
	
	/**
	 * Default Constructor.
	 */
	public Aircraft()
	{
		
	}
	/**
	 * Overloaded Constructor
	 * 
	 * @param airCraftName-Name of aircraft
	 * @param regNo-aircraft registration number
	 * @param manufacturer-aircraft manufacturer
	 * @param maxRange-aircraft max range
	 * @param crewSize-maximum aircraft crew
	 * @param yearPutInService-the year aircraft was put into service
	 * @param maxServiceWeight-aircraft maximum take off weight
	 * @param numPassengers-maximum number of passengers
	 * @param totalMiles-total miles covered by aircraft
	 * @param lastMaintenanceDate-last date aircraft was maintained
	 * @param lastMaintenanceMiles-last miles at which the aircraft was maintained
	 */
	public Aircraft(String airCraftName,String regNo,String manufacturer,int maxRange,int crewSize,int yearPutInService,int maxServiceWeight,int numPassengers,int totalMiles,String lastMaintenanceDate,int lastMaintenanceMiles)
	{
		this();
		this.airCraftName=airCraftName;
		this.crewSize=crewSize;
		this.lastMaintenanceDate=lastMaintenanceDate;
		this.manufacturer=manufacturer;
		this.maxRange=maxRange;
		this.maxServiceWeight=maxServiceWeight;
		this.lastMaintenanceMiles=lastMaintenanceMiles;
		this.numPassengers=numPassengers;
		this.regNo=regNo;
		this.yearPutInService=yearPutInService;
		this.totalMiles=totalMiles;
		
	}
	/**
	 * A method that returns a boolean on whether an aircraft needs maintenance or not
	 * @return-boolean
	 */
	public boolean needsMaintenance()
	{
		DateTimeFormatter fmt=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate current=LocalDate.now();
		boolean isService=false;
		LocalDate lastMaint=LocalDate.parse(this.lastMaintenanceDate, fmt);
		LocalDate updated=lastMaint.plusMonths(3);
		if (updated.isBefore(current)|| this.lastMaintenanceMiles>=150000)
		{
			isService=true;
			System.out.println(this.airCraftName+"\t"+this.regNo+"\t"+this.manufacturer+"\t"+this.lastMaintenanceDate+"\t"+this.lastMaintenanceMiles);
		}
		

	return isService;
	}

	/**
	 * A method that returns a boolean on whether an aircraft should be retired or not
	 * @return-boolean
	 */
	public boolean shouldRetire()
	{
		
		LocalDate today=LocalDate.now();
		int yrNow=today.getYear();
		
		boolean isRetire=false;
		if ((yrNow-this.yearPutInService)>20|| this.lastMaintenanceMiles>2000000)
		{
			isRetire=true;
		}
		return isRetire;
	}
	/**
	 * Getter for aircraft name
	 * @return-aircraft name
	 */

	public String getAirCraftName() 
	{
		return this.airCraftName;
	}
	/**
	 * Getter for registration number
	 * @return-registration number
	 */

	public String getRegNo() 
	{
		return this.regNo;
	}

	/**
	 * Setter for registration number
	 * @param regNo
	 */
	public void setRegNo(String regNo) 
	{
		this.regNo = regNo;
	}
	/**
	 * Getter for aircraft manufacturer
	 * @return-manufacturer
	 */

	public String getManufacturer() 
	{
		return this.manufacturer;
	}
	/**
	 * Getter for maximum range
	 * @return
	 */

	public int getMaxRange() 
	{
		return this.maxRange;
	}
	/**
	 * Setter for maximum range
	 * @param maxRange
	 */

	public void setMaxRange(int maxRange) 
	{
		this.maxRange = maxRange;
	}
	/**
	 * Getter for crew size
	 * @return
	 */

	public int getCrewSize() 
	{
		return this.crewSize;
	}
	/**
	 * Setter for crew size
	 * @param crewSize
	 */

	public void setCrewSize(int crewSize) 
	{
		this.crewSize = crewSize;
	}
	/**
	 * Getter for year in service
	 * @return
	 */

	public int getYearPutInService() 
	{
		return this.yearPutInService;
	}
	/**
	 * Getter for maximum take off weight
	 * @return
	 */
	public int getMaxServiceWeight() 
	{
		return this.maxServiceWeight;
	}
	/**
	 * Getter for number of passengers
	 * @return
	 */

	public int getNumPassengers() 
	{
		return this.numPassengers;
	}
	/**
	 * Getter for last maintenance Date
	 * @return
	 */
	public String getLastMaintenanceDate()
	{
		return this.lastMaintenanceDate;
	}
	/**
	 * Setter for last maintenance date
	 * 
	 * @param lastMaintenanceDate
	 */
	public void setLastMaintenanceDate(String lastMaintenanceDate)
	{
		this.lastMaintenanceDate=lastMaintenanceDate;
	}
	/**
	 * Getter for last maintenance miles
	 * @return
	 */

	public int getLastMaintenanceMiles() {
		return this.lastMaintenanceMiles;
	}
	/**
	 * Getter for total miles
	 * @return
	 */

	public int getTotalMiles()
	{
		return this.totalMiles;
	}
	/**
	 * To string method
	 */
	public String toString()
	{
		return this.airCraftName+"\t"+this.regNo+"\t"+this.manufacturer+"\t"+this.maxRange+"\t"+this.crewSize+"\t"+this.yearPutInService+"\t"+this.maxServiceWeight+"\t"+this.numPassengers
				+"\t"+this.totalMiles+"\t\t\t"+this.lastMaintenanceDate+"\t"+this.lastMaintenanceMiles;
	}
	
}
