// PACKAGE WHICH WAS SUPPOSED TO BE ADDED FOR CONNECTING THE APP
package nitc.nss.yellowpagesnitc.lib;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Administration
{
	private final int n = 10;
	private String Name;
//	 THE FOLLOWING IS NOT NEEDED. WE'LL INTEGRATE THAT BY KEEPING THE DEFAULT NUMBER VALUE
//	 private int PhoneNos;
	private PhoneNumber[] Numbers  = new PhoneNumber[n];
//	String Notes;
	public Administration()
	{
		this.Name = "";
//		this.PhoneNos = 0;
		for(int i=0;i<n;i++)
		{
			this.Numbers[i] = new PhoneNumber();
		}
	}
//	 GETTERS AND SETTERS
	public String getName()
	{
		return this.Name;
	}
	public void setName(String Name)
	{
		this.Name = Name;
	}
	public void getPhoneNumber()
	{
		int n = 10;
		for(int i=0;i<n;i++)
		{
			System.out.print("<Administration, Numbers> NUMBER" + i + " : ");
			this.Numbers[i].InputPhoneNumber();
		}
	}
//	 NUMBER OF PHONE NUMBERS
//	public int getPhoneNos() {
//		return PhoneNos;
//	}
//	public void setPhoneNos(int phoneNos) {
//		PhoneNos = phoneNos;
//	}
	public PhoneNumber[] getNumbers() {
		return Numbers;
	}
	public void setNumbers(PhoneNumber[] Numbers)
	{
		for(int i=0;i<n;i++)
			this.Numbers[i] = new PhoneNumber();
		int minVal = Math.min(n,Numbers.length);
		for(int i=0;i<minVal;i++)
			this.Numbers[i] = Numbers[i];

	}
	public void returnFromScanner(Scanner scanner)
	{
		// NAME INPUT
		if(scanner.hasNextLine())
		{
			setName(scanner.nextLine());
		}
		else
			throw new InputMismatchException("Administration, returnFromScanner");
		// MAXIMUM NO OF ELEMENT INPUTS
		int i = n;
		while(scanner.hasNextLine() && i>0)
		{
			this.Numbers[i] = new PhoneNumber(scanner.nextLine());
			i--;
		}
	}

	public Administration(Scanner scanObject)
	{
		if(scanObject.hasNextLine())
		{
			this.setName(scanObject.nextLine());
		}
		int i = n;
		while(scanObject.hasNextLine()&&n>0)
		{
			this.Numbers[i] = new PhoneNumber(scanObject.nextLine());
		}
	}
	public ArrayList<Administration> GetAdministrationList()
	{
		ArrayList<Administration> retnArrayList = new ArrayList<Administration>();
		String filename = "Administration.txt";
		File myFile = new File(filename);
		try
		{
			Scanner fileScanner = new Scanner(myFile);
			while(fileScanner.hasNextLine())
			{
				retnArrayList = addToList(retnArrayList,fileScanner);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return retnArrayList;
	}
	public ArrayList<Administration> addToList(ArrayList<Administration> arrayListObject, Scanner objScanner)
	{
		if(objScanner.hasNextLine())
		{
			arrayListObject.add(new Administration(objScanner));
		}
		return arrayListObject;
	}
}
