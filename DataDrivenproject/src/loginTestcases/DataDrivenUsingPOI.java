 package loginTestcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenUsingPOI {
	
	static List<String> usernameList = new ArrayList<String>();
	static List<String>passwordList = new ArrayList<String>();
	

	
	
	public  void readExcel() throws IOException
	{
		FileInputStream excel = new FileInputStream("C:\\Users\\WELCOME\\Desktop\\Testdata.xlsx");
		
	    Workbook workbook =new XSSFWorkbook(excel);
	    

	    Sheet sheet = workbook.getSheetAt(0);
	    
	    Iterator<Row> rowIterator =  sheet.iterator();  //it reads the total rows in sheet
	    
	    while(rowIterator.hasNext())
	    {
	    	Row rowValue = rowIterator.next();
	    	
	    	Iterator<Cell> columnIterator = 	rowValue.iterator();
	    	int i=2;
	    	
	    	while(columnIterator.hasNext())
	    	{
	    		
	    		
	    		if(i%2==0)
	    		{
	    			usernameList.add((columnIterator.next()).getStringCellValue());   //getstringcellvalue -- converts the cell value to string.
	    			  
	    	}
	    		
	    		else
	    		{
	    			passwordList.add((columnIterator.next()).getStringCellValue());
	    		}
	    		i++;
	    	
	    }
	    }
	    }
	 
	    
	
	    public  void login(String uname, String pwd)
	    {
	    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\WELCOME\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    	 WebDriver   driver = new ChromeDriver();
			 
			 driver.get("https://opensource-demo.orangehrmlive.com/");
	    	
			 
			 WebElement username = driver.findElement(By.id("txtUsername"));
			 username.sendKeys(uname);
			 
			 WebElement password = driver.findElement(By.id("txtPassword"));
			 password.sendKeys(pwd);
			 
			 WebElement loginbutton = driver.findElement(By.id("btnLogin"));
			 loginbutton.click();
	    }
	    
	    
	    
	    public void execute()
	    {
	    	for(int i=0;i<usernameList.size();i++)
	    	{
	    		login(usernameList.get(i),passwordList.get(i));
	    	}
	    }
		
	

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub

		DataDrivenUsingPOI usingPOI = new DataDrivenUsingPOI();
		usingPOI.readExcel();
		
		System.out.println(usernameList);
		System.out.println(passwordList);
		usingPOI.execute();

	}

}
