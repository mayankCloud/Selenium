package testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/test/web-table-element.php");
//		getRows();
//		getColumns("//thead/tr/th");
		Thread.sleep(5000);
		allCompanies();
		driver.quit();
	}

//	public static int getRows() {
//		List<WebElement> rowsList = driver.findElements(By.xpath("//tbody/tr"));
//		System.out.println("No. of rows are : "+rowsList.size());
//		return rowsList.size();
//
//	}
//	
//	public static void getColumns(String columns) {
//		List<WebElement> columnsList = driver.findElements(By.xpath(columns));
//		System.out.println("No. of columns are : "+columnsList.size());
//	}
	
	public static void allCompanies() {
		List<WebElement> rowsList = driver.findElements(By.xpath("//tbody/tr"));
		for (int i = 1; i <rowsList.size(); i++) {
		 System.out.println(driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText());	
		
	}
		}
}
