package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	
	private By homeSections = By.cssSelector("div.homepage-container .header");
//	public By ab = By.tagName("a");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePagetitle() {
		return driver.getTitle();
	}
	
	public int getHomeSectionCount() {
		return driver.findElements(homeSections).size();
	}
	
	
	public List<String> getHomeSectionsList() {
		
		List<String> homeList = new ArrayList<>();
		List<WebElement> homeHeaderList = driver.findElements(homeSections);
		
		for(WebElement e : homeHeaderList) {
			String text = e.getText();
			System.out.println(text);
			homeList.add(text);
		}
		return homeList;
	}
	
}
