package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class ReadExcelLogin {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement element = driver.findElement(By.cssSelector("input[name='q']"));
		
		ExcelReader reader = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
		String sheetName = "AddCustomerTest";
		
		for (int i = 1; i <reader.getRowCount(sheetName); i++) {
			String search = reader.getCellData(sheetName,"firstname",i);
			((JavascriptExecutor)driver).executeScript("document.querySelector(\"input[name='q']\").value='"+search+"'");
			Thread.sleep(2000);
			element.clear();
		}

	}

}
