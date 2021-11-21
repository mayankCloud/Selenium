package testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SvgGraph {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://emicalculator.net/");
//		List<WebElement> graphPoints = driver.findElements(By.xpath("(//*[local-name()='svg'])[2]//*[name()='text']"));
//		for (WebElement text : graphPoints) {
//			System.out.println(text.getText());
//		}
		
		List<WebElement> graphPoints = driver.findElements(By.xpath("(//*[local-name()='svg'])[2]//*[@class='highcharts-point']"));
		
		Actions actions = new Actions(driver);
		for(WebElement value : graphPoints) {
			actions.moveToElement(value).perform();
			System.out.println(driver.findElement(By.xpath("(//*[local-name()='svg'])[2]//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']")).getText());
		}
		
	}

}
