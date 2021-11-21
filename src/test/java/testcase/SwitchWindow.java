package testcase;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");
		
		driver.findElement(By.xpath("//a[contains(text(),'Open Multiple Windows')]")).click();
		
//		Switch to Frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='frames-windows/defult4.html']")));
		driver.findElement(By.xpath("//a[text()='Open multiple pages']")).click();
//		Switch Windows
		Set<String> windows = driver.getWindowHandles();
		
		String windowUrl = "https://www.way2automation.com/way2auto_jquery/frames-windows/defult4-window1.html";
		
//		Using ParallelStream - Does not work probably very fast execution
//		windows.parallelStream().forEach(e->{driver.switchTo().window(e);
//		System.out.println("Window id is: "+e);
//		System.out.println(driver.getCurrentUrl());
//		if(driver.getCurrentUrl().equalsIgnoreCase(windowUrl)) {
//			System.out.println("Window found: "+driver.findElement(By.xpath("//a[@href='#']")).getText());
//		}
//		else {
//			System.out.println("Closing other windows");
//			driver.close();
//		}	
//		
//		});
		
//		Using normal for loop
		for(String window : windows) {
			System.out.println("Window id is: "+window);
			driver.switchTo().window(window);
			System.out.println(driver.getCurrentUrl());
			if(driver.getCurrentUrl().equalsIgnoreCase(windowUrl)) {
				System.out.println("Window found: "+driver.findElement(By.xpath("//a[@href='#']")).getText());
			}
			else {
				System.out.println("Closing other windows");
				driver.close();
			}
		}
		driver.quit();
	}


}
