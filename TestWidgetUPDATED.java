package com.mobitv.client.qa.nma.eclipse.regression;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mobitv.client.services.common.Constants;
import com.mobitv.client.services.common.ExecuteShellComand;
import com.mobitv.client.services.common.SwipeAndScroll;
import com.mobitv.client.services.common.Util;

public class TestWidget {
	private static Util util = new Util();
	//private static WebDriver driver = null;
	private static AppiumDriver driver = null;
	private ExecuteShellComand command = new ExecuteShellComand();

	@Before
	public void setUp() throws Exception {		
		driver = util.getAndroidDriver(driver);
		
	}

	@After
	public void tearDown() {
		driver.quit();
		command.kill();
	}
	
	
	
	
	
	@Test
	public void Test_NMA_8966() throws Exception {
		System.out.println("Start Test_NMA_8966");
		util.fileWriting("Start Test_NMA_8966");
		System.out.println("==========================================================================");
		util.fileWriting("==========================================================================");
		
		
		
		//Exit the application using device back key
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		
		//Variable to use
		String str_TileText = "";
		String  str_LabelText = "";
		WebElement wb_CurrentTile = null;
		String str_MediaPlayerTitle = "";
		String str_DetailPageText = "";
		String str_ActionBar = "";
		WebElement wb_BottomTile = null;
		//This will be our constant x and y value for scrolling
		Double dbl_WidgetXValue = (double)(driver.findElement(By.id(Constants.app_Package + ":id/widget_tile_list")).getLocation().x) + 20.0;
		Double dbl_WidgetYValue = (double)(driver.findElement(By.id(Constants.app_Package + ":id/widget_tile_list")).getLocation().y);
		//This value is based on widge tile position
		Double dbl_ScrollingYValue = 0.0;
		
		Thread.sleep(Constants.ThreadSleep);

	
		
		//Start the loop to walkthrough tiles on widget, there may be up to 8 tiles
		for (int count = 0; count < 8; count ++){
			System.out.println("********************** " + count + " **********************");
			
			//Get the text of current tile so we can compare when we deeplink into application
			
			//This is to make sure we are gathering details from correct tile
			WebElement wb_TopTile = driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[1]"));
			
			//Getting Text from tile
			if (wb_TopTile.getLocation().y > 0){
				str_TileText = driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
			}else{
				str_TileText = driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
			}
			
			//See if there is a label
			try {
				if (wb_TopTile.getLocation().y > 0){
					str_LabelText = driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
				}else{
					str_LabelText = driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
				}
				
			}catch(Exception e){
				System.out.println("No category Name found!");
				
				}
			
			//If a label exists, then we are checking a tile that will stream
			if (!str_LabelText.equals("")){
				System.out.println("str_LabelText is not empty, str_LabelText is: " + str_LabelText);
				
				//here we get the current tile to click
				if (wb_TopTile.getLocation().y > 0){
					wb_CurrentTile = driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[1]/android.widget.FrameLayout"));
					wb_CurrentTile.click();
					//get the title from media player
					str_MediaPlayerTitle = driver.findElement( By.id(Constants.app_Package + ":id/playback_txt_title2")).getText();
					
					System.out.println("Content streaming is: " + str_MediaPlayerTitle);
					//Compare the tile text to media player text
					System.out.println("We are comparing: " + str_TileText + " with: " + str_MediaPlayerTitle);
					Assert.assertEquals(str_TileText, str_MediaPlayerTitle);
					
					System.out.println("We are comparing: " + str_TileText + " with: " + str_MediaPlayerTitle);
					//Now we select back had key to get to the details page for the the streamed content
					
					System.out.println("Backing out to see details page!");
					driver.navigate().back();
					//We get the text from detail screen to compare to tile text
					str_DetailPageText = driver.findElement(By.id(Constants.app_Package + ":id/details_txt_title")).getText();
					//Compare to tile text
					
					System.out.println("We are comparing: " + str_TileText + " with: " + str_DetailPageText);
					Assert.assertEquals(str_TileText, str_DetailPageText);
					//Use device back key to exit back out of application
					
					System.out.println("Backing out to device home screen!");
					driver.navigate().back();					
					
				}else{
					wb_CurrentTile = driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[2]/android.widget.FrameLayout"));
					wb_CurrentTile.click();
					//get the title from media player
					str_MediaPlayerTitle = driver.findElement( By.id(Constants.app_Package + ":id/playback_txt_title2")).getText();
					
					System.out.println("Content streaming is: " + str_MediaPlayerTitle);
					//Compare the tile text to media player text
					System.out.println("We are comparing: " + str_TileText + " with: " + str_MediaPlayerTitle);
					Assert.assertEquals(str_TileText, str_MediaPlayerTitle);
					
					System.out.println("We are comparing: " + str_TileText + " with: " + str_MediaPlayerTitle);
					//Now we select back had key to get to the details page for the the streamed content
					
					System.out.println("Backing out to see details page!");
					driver.navigate().back();
					//We get the text from detail screen to compare to tile text
					str_DetailPageText = driver.findElement(By.id(Constants.app_Package + ":id/details_txt_title")).getText();
					//Compare to tile text
					
					System.out.println("We are comparing: " + str_TileText + " with: " + str_DetailPageText);
					Assert.assertEquals(str_TileText, str_DetailPageText);
					//Use device back key to exit back out of application
					
					System.out.println("Backing out to device home screen!");
					driver.navigate().back();				
				}
				
			}else{
				if (wb_TopTile.getLocation().y > 0){
				System.out.println("str_LabelText is empty, str_LabelText is: " + str_LabelText + " We are testing a marketing tile");
				wb_CurrentTile = driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[1]/android.widget.FrameLayout"));
				wb_CurrentTile.click();
				
				//Get string from action bar on detail page
				str_ActionBar = driver.findElement(By.id("android:id/action_bar_title")).getText();
				//Compare tile text to action bar text
				
				System.out.println("We are comparing: " + str_TileText + " with: " + str_ActionBar);
				Assert.assertEquals(str_TileText, str_ActionBar);
				//Navigate back to device home screen by selecting back hard key
				
				System.out.println("Backing out to device home screen!");
				driver.navigate().back();
				}else{
					System.out.println("str_LabelText is empty, str_LabelText is: " + str_LabelText + " We are testing a marketing tile");
					wb_CurrentTile = driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[2]/android.widget.FrameLayout"));
					wb_CurrentTile.click();
					
					//Get string from action bar on detail page
					str_ActionBar = driver.findElement(By.id("android:id/action_bar_title")).getText();
					//Compare tile text to action bar text
					
					System.out.println("We are comparing: " + str_TileText + " with: " + str_ActionBar);
					Assert.assertEquals(str_TileText, str_ActionBar);
					//Navigate back to device home screen by selecting back hard key
					
					System.out.println("Backing out to device home screen!");
					driver.navigate().back();
				}
			}
			
			
			//Here we will scroll once per loop iteration
			
			if (wb_TopTile.getLocation().y > 0){
				
				System.out.println("Scrolling down once");
				dbl_ScrollingYValue = (double)(driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[2]/android.widget.FrameLayout")).getLocation().y);
				SwipeAndScroll.swipeWithConstantValues(driver, dbl_WidgetXValue, dbl_ScrollingYValue, dbl_WidgetXValue, dbl_WidgetYValue, 3.0);
			}else{
				try{
					
					System.out.println("Scrolling down once");
					dbl_ScrollingYValue = (double)(driver.findElement(By.xpath("//android.widget.ListView/android.widget.FrameLayout[3]/android.widget.FrameLayout")).getLocation().y);
					SwipeAndScroll.swipeWithConstantValues(driver, dbl_WidgetXValue, dbl_ScrollingYValue, dbl_WidgetXValue, dbl_WidgetYValue, 3.0);
					}catch(Exception e){
						System.out.println("There is no bottom tile!");
					}
				
			}
			
			
		}
		
	}
	
	

}
