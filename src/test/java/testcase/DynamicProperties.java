package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicProperties {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demoqa.com/dynamic-properties");
//		Dynamic id element
		WebElement dynamicProperty = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div/p"));
		System.out.println("Dynamic Property element text: "+dynamicProperty.getText());
//		Element activation after 5 seconds - not working
		WebElement colorChange = driver.findElement(By.cssSelector("#colorChange"));
		System.out.println("Enabled after 5 seconds: "+colorChange.getText());
//		Tool tip
		WebElement frame = driver.findElement(By.xpath("//iframe[@src='https://www.google.com/recaptcha/api2/aframe']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.cssSelector(".header-wrapper")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@id='item-6'])[2]")).click();
		Actions actions = new Actions(driver);
		WebElement hoverButton = driver.findElement(By.cssSelector("#toolTipButton"));
		actions.moveToElement(hoverButton).perform();
		System.out.println("Tooltip text: "+driver.findElement(By.cssSelector(".tooltip-inner")).getText());
		
		driver.quit();
	}

}
