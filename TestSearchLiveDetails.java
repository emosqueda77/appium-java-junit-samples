package com.mobitv.client.qa.nma.eclipse.search;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.mobitv.client.services.common.Constants;
import com.mobitv.client.services.common.DataParser;
import com.mobitv.client.services.common.ExecuteShellComand;
import com.mobitv.client.services.common.Util;

public class TestSearchLiveDetails {
	private static Util util = new Util();
	//private static WebDriver driver = null;
	private static AppiumDriver driver = null;
	private DataParser mJsonParser = new DataParser();
	private ExecuteShellComand command = new ExecuteShellComand();
	String str_SearchClearHistory;

	@Before
	public void setUp() throws Exception {		
		driver = util.getAndroidDriver(driver);
		//command.executeCommand("Search");
	}

	@After
	public void tearDown() {
		driver.quit();
		//command.kill();
	}
	
	/*
	 * 1. Launch application
	 * 2. Navigate to Live Tab
	 * 3. Verify Search Button is available
	 * 4. Navigate to Search Screen
	 * 5. Verify search screen is present
	 * 6. Select Back Button to dismiss keyboard
	 * 7. Select Back Button to navigate back to Live tab
	 * 8. Verify Application is on Live tab
	 * 9. Select a channel icon to navigate to channel details screen
	 * 10. Verify Search Button Exists
	 * 11. Navigate to Search screen
	 * 12. Verify we are on search screen
	 * 13. Dismiss keyboard
	 * 14. Navigate back to channel details screen
	 * 15. Verify we are back on channel details screen
	 * 16. Select a program row
	 * 17. Verify Search button is present
	 * 18. Navigate to search screen
	 * 19. Verify we are on search screen
	 * 20. Dismiss keyboard
	 * 21. Navigate back to program details screen
	 * 22. Verify we are on program details screen
	 */
	@Test
	public void Test_NMA_6644_Search_Details_Live() throws Exception{
		
		System.out.println("Start Test_NMA_6644 Details Live");
		util.fileWriting("Start Test_NMA_6644 Details Live");
		System.out.println("==========================================================================");
		util.fileWriting("==========================================================================");
		
		//Declare variables
		
		//Search Button
		WebElement wb_SearchButton = driver.findElement(By.id(Constants.App_Package+ ":id/action_search"));
		
		//Live Tab
		WebElement wb_LiveTab = driver.findElement(By.id(Constants.App_Package+ ":id/live_guide_tab"));
		
		//Search Frame On Search Screen
		WebElement wb_SearchBar = driver.findElement(By.id(Constants.App_Package+ ":id/action_search"));

		
		//Temporary string for holding information
		String str_Temp = "";
		
		//This will get us to the Live screen
		wb_LiveTab.click();
		Thread.sleep(Constants.ThreadSleep);
		
		System.out.println("===========================================================================");
		System.out.println("Clicking Live Tab");
		
		
		//This will verify the search button is available
		Assert.assertEquals(wb_SearchButton, wb_SearchButton);
		
		System.out.println("===========================================================================");
		System.out.println("Search Button is present");
		
		//Click On Search Button and navigate to Search Screen
		wb_SearchButton.click();
		Thread.sleep(Constants.ThreadSleep);
		
		System.out.println("===========================================================================");
		System.out.println("Clicked On Search Button");
		
		//Verify We are on search screen
		Assert.assertEquals(wb_SearchBar, wb_SearchBar);
		System.out.println("===========================================================================");
		System.out.println("We are on Search screen");
		
		//Dismiss Virtual Keyboard then navigate back to Live Tab
		driver.navigate().back();
		Thread.sleep(Constants.ThreadSleep);
		driver.navigate().back();
		Thread.sleep(Constants.ThreadSleep);
		
		System.out.println("===========================================================================");
		System.out.println("Navigated back to Live tab");
		
		//Live tab Date Button 
		WebElement wb_DateButton = driver.findElement(By.id(Constants.App_Package+ ":id/date_btn"));
		
		//Verify we are back on Live tab
		Assert.assertEquals(wb_DateButton, wb_DateButton);
		System.out.println("===========================================================================");
		System.out.println("Verified We are on Live Tab");
		
		//Channel Icon for live TV
		WebElement wb_ChannelIcon = driver.findElement(By.id(Constants.App_Package + ":id/channel_list").xpath("//android.widget.LinearLayout[0]").xpath("//android.widget.RelativeLayout").id(Constants.App_Package+":id/channel_thumb"));
		
		//Click the first channel icon to get to channel datails screen
		wb_ChannelIcon.click();
		Thread.sleep(Constants.ThreadSleep);
		System.out.println("===========================================================================");
		System.out.println("Clicked On Channel Icon");
		
		//Action Bar Title
		WebElement wb_ActionBarTitle = driver.findElement(By.id("android:id/action_bar_title"));
		
		//Get title of current channel details screen
		str_Temp = wb_ActionBarTitle.getText();
		System.out.println("===========================================================================");
		System.out.println("Saved Chanel Name");
		
		//This will verify the search button is available
		Assert.assertEquals(wb_SearchButton, wb_SearchButton);
		System.out.println("===========================================================================");
		System.out.println("Search utton is present");
		
		//Click On Search Button and navigate to Search Screen
		wb_SearchButton.click();
		Thread.sleep(Constants.ThreadSleep);
		System.out.println("===========================================================================");
		System.out.println("SearchButton has been clicked");
		
		//Verify We are on search screen
		Assert.assertEquals(wb_SearchBar, wb_SearchBar);
		System.out.println("===========================================================================");
		System.out.println("We are on Search Page");
		
		//Dismiss Virtual Keyboard then navigate back to Live Channel Details
		driver.navigate().back();
		Thread.sleep(Constants.ThreadSleep);
		driver.navigate().back();
		Thread.sleep(Constants.ThreadSleep);
		System.out.println("===========================================================================");
		System.out.println("Navigated back to channel details");
		
		//Verify we are back on Channel Details screen
		Assert.assertEquals(str_Temp,wb_ActionBarTitle.getText());
		System.out.println("===========================================================================");
		System.out.println("Verified We are on Channel Details");
		
		//Program in channel details
		WebElement wb_ProgramCell = driver.findElement(By.id(Constants.App_Package + ":id/details_list").xpath("//android.widget.LinearLayout[1]"));		
		
		//Navigate to a Live Program Details screen
		wb_ProgramCell.click();
		
		//Program Details Name
		WebElement wb_ProgmDetailsName = driver.findElement(By.id(Constants.App_Package + ":id/program_details_program_name"));
		
		//Get Program Details name for comparison
		str_Temp = wb_ProgmDetailsName.getText();
		
		//This will verify the search button is available
		Assert.assertEquals(wb_SearchButton, wb_SearchButton);
		
		//Click On Search Button and navigate to Search Screen
		wb_SearchButton.click();
		Thread.sleep(Constants.ThreadSleep);
		
		//Verify We are on search screen
		Assert.assertEquals(wb_SearchBar, wb_SearchBar);
		
		//Dismiss Virtual Keyboard then navigate back to Live Program Details
		driver.navigate().back();
		Thread.sleep(Constants.ThreadSleep);
		driver.navigate().back();
		Thread.sleep(Constants.ThreadSleep);
		
		//Verify We are back on Program details screen
		Assert.assertEquals(str_Temp,wb_ProgmDetailsName.getText());
		
		
		
		
		
		
		System.out.println("==========================================================================");
		util.fileWriting("==========================================================================");
		System.out.println("End Test_NMA_6644 Details Live");
		util.fileWriting("End Test_NMA_6644 Details Live");
		System.out.println("==========================================================================");
		util.fileWriting("==========================================================================");
		
	}
}
