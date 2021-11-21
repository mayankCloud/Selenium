package testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CovidGraphValues {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.google.com/search?q=COVID-19&si=AHuW2sRoWU-Pbcc4ro7J7T-D_KBseCAX6BqywQCsUcZZRInOZ09yEirGLvp8G8rRUywdv7Rzat4rGvxTGR_gJrfElf8etu9BqIC-si7TSsKh62ktpzxa2Is%3D&biw=1366&bih=643&dpr=1");
		
//		Value - //div[@data-ved='2ahUKEwiTi8XElaX0AhXjxzgGHfYTBRYQ3IMGegUINhCrAg']/div[2]/div[1]/span[3]
		
		List<WebElement> graphList = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[1]//*[name()='rect']"));
		Actions actions = new Actions(driver);
		
		for(WebElement element : graphList) {
			actions.moveToElement(element).perform();
			System.out.println(driver.findElement(By.xpath("(//div[@class='ExnoTd'])[1]")).getText());
		}
	}

}
