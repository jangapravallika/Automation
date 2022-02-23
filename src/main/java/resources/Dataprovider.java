package resources;

import org.testng.annotations.DataProvider;

import flipkart.Baseclass;

public class Dataprovider extends Baseclass {

	
	@DataProvider(name="getrdata")
	public  Object[][] getrdata()
	{
		Object[][] obj=new Object[1][3];
		
		obj[0][0]="9701763306";
		obj[0][1]="prava@56789";
		obj[0][2]="registered user";
		return obj;
	}
	
	@DataProvider(name="geturdata")
	public  Object[][] geturdata()
	{
	
		
		return new Object[][] {
            { "9959978789", "India@757","unregistered user" }
           
        };  
	}
	
	
	
	
	
	@DataProvider(name="getdata")
	public  Object[][] getdata()
	{
		Object[][] obj=new Object[4][3];
		
		obj[0][0]="9701763306";
		obj[0][1]="prava@56789";
		obj[0][2]="registered user";
		
		obj[1][0]="7386765247";
		obj[1][1]="rama@1234";
		obj[1][2]="unregistered user";
		
		obj[2][0]="kjlskjdljs";
		obj[2][1]="jshdjklsd";
		obj[2][2]="bothwrong";
		
		
		
		obj[3][0]=" ";
		obj[3][1]=" ";
		obj[3][2]="nill";
		
		return obj;
		
	}
	
	
}
