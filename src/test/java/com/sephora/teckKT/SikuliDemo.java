/**
 * 
 */
package com.sephora.teckKT;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.sikuli.basics.Settings;

public class SikuliDemo extends BaseTest {

	@Test(enabled=false)
	public void testSikuliClick() throws FindFailed{
		try {
			String image = System.getProperty("user.dir")+"\\src\\test\\resources\\images\\Amazon_Cart.png";
			// create object of Screen where target needs to be find
			Screen s = new Screen();
			// wait for the desired image/target
			Match m=s.wait(image,30);
			//
			m.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test(enabled=false)
	public void testSikuliTypeText(){
		try{
			String image = System.getProperty("user.dir")+"\\src\\test\\resources\\images\\Sephora_Search.png";
			// create object of Screen where target needs to be find
			Screen s = new Screen();
			s.setAutoWaitTimeout(10);
			Pattern p = new Pattern(image);
			Match m =s.find(p);
			//highlight the found target
			m.highlight();
			// double click
			m.doubleClick();
			// type
			m.type("Apple Cider");
			// Keybaord action
			m.type(Key.ENTER);
		}catch(Exception e){

		}
	}

	@Test(enabled=false)
	public void testSikuliClickByText() throws FindFailed, InterruptedException{
		Thread.sleep(3000);
		Settings.OcrTextRead=true;
		Settings.OcrTextSearch=true;
		Screen screen = new Screen();
		String text = "Just Arrived";
		Match match = screen.find(text);
		match.click();

	}


	@Test
	public void testSikuliOffset(){
		try{
			driver.get("http://www.sephora.com/makeup-cosmetics");
			String target = System.getProperty("user.dir")+"\\src\\test\\resources\\images\\Sephora_Just_Arrived.png";
			Thread.sleep(3000);
			Screen s = new Screen();
			Match m = s.find(target);
			m.right(1000).click();
		}catch(Exception e){

		}
	}
}
