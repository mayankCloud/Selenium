package testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='#example-1-tab-3']")).click();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult3.html']"));
//		frame.click();
				
//		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
//		System.out.println(frameList.size());
		Thread.sleep(5000);
		driver.switchTo().frame(frame);
		System.out.println("Moved into frame");
		driver.findElement(By.xpath("//a[@href='frameset.html']")).click();
		System.out.println("Clicked frame element");
//		for(WebElement frame : frameList) {
//			System.out.println("Frame : "+frame.getAttribute("class"));
//			
//			try {
//				
//				
////				Thread.sleep(5000);		
////				frameSet.click();
////				System.out.println("Switching to " + frame);
////				driver.switchTo().frame(frame);
////				driver.findElement(By.cssSelector("a[href='frameset.html']")).click();
////				System.out.println("Clicked " + frame);
//			}
//			catch(Exception e) {
////				Thread.sleep(5000);
////				frameSet.click();
////				driver.switchTo().defaultContent();
////				System.out.println("Moving to next frame" +frame);
//			}
//		}
//		
//		WebElement outerFrame = driver.findElement(By.id("iframeResult"));
//		driver.switchTo().frame(outerFrame);
//		
//		List<WebElement> innerFrameList = driver.findElements(By.tagName("iframe"));
//		System.out.println("Inner frame list: "+frameList.size());
//		
		
//		driver.quit();
	}
}
