package testcase;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://www.seleniumframework.com/Practiceform/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("newBrwTab()");
		
		Set<String> tabs = driver.getWindowHandles();
		for(String tab : tabs) {
			System.out.println("Window Tabs: "+tab);
			driver.switchTo().window(tab);
			if(driver.getTitle().contains("Selenium Framework | Selenium,")) {
				System.out.println("Moved to new Tab");
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//a[@title='Decision Models']")).click();
				driver.switchTo().defaultContent();
				System.out.println("Moved to main window");
				System.out.println(driver.getTitle());
				driver.close();
			}
		}

	}

}
