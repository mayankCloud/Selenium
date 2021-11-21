package testcase;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	static int countOfBrokenLinks = 0;
	
	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("No. of links are: "+links.size());
		
		List<String>urlList = new ArrayList<String>();
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			urlList.add(url);
		}
		
		long startTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(e->{
			try {
				checkBrokenLink(e);
			} catch (IOException e1) {
			
			}
		
		});
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		System.out.println("Count of broken links: " +countOfBrokenLinks);
		driver.quit();
	}
	
	public static void checkBrokenLink(String linkUrl) throws IOException {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setConnectTimeout(5000);
			httpConnection.connect();
			
			if(httpConnection.getResponseCode() >=400 ) {
				countOfBrokenLinks++;
				System.out.println(linkUrl + "----> "+httpConnection.getResponseMessage()+ " is a broken link");
			}
			else
				System.out.println(linkUrl + "-----> "+httpConnection.getResponseMessage());
			
		} catch (MalformedURLException e) {
			
		}
	}
}
