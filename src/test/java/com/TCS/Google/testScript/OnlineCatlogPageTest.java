package com.TCS.Google.testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TCS.Google.pages.OnlineCatlogPage;
import com.TCS.Google.pages.WelcomePage;

import pojo.OnlineCatlogPOJO;

public class OnlineCatlogPageTest extends TestBase {
	OnlineCatlogPage onlineCatlogPage;

	// @Test
	// public void verifyOnlineCatlogWebPageUrl() throws IOException {
	//
	// onlineCatlogPage = getOnlineCatlogPageInstance();
	//
	// String url = onlineCatlogPage.getPageURL();
	// System.out.println(url);
	// }
/*
	@BeforeMethod
	public void initialiseOnlineCatlogPage() throws IOException {
		onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();
		OnlineCatlogPage.goToOnlineCatlogPage();
	}*/

	/**
	 * verify webpage should be open for given url
	 * 
	 * @throws IOException
	 */
	@Test
	public void verifyOnlineCatlogWebPageUrl() throws IOException {

		/**
		 * Yor Not calling On getOnlineCatlogPageInstance method with class name
		 */
		// onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();

		/**
		 * Missing goToOnlineCatlogPage method before calling click method you
		 * should be on page Right ?
		 */
		// OnlineCatlogPage.goToOnlineCatlogPage();
		start();
		onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();
		String actualUrl = OnlineCatlogPage.getPageURL();
		String expectedUrl = "https://demo.borland.com/gmopost/online-catalog.htm";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * verify after clicking on GMO online button Online CAtlog page gets loaded
	 * succsessfully
	 * 
	 * @throws IOException
	 */
	@Test // this test is failed.....
	public void verifyIsGmoOnlineBtnClickable() throws IOException {
		onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();
		OnlineCatlogPage.goToOnlineCatlogPage();
		String actualWord = onlineCatlogPage.getWordOfOnlineCatlogPage();
		String expectedWord = "Online Catlog";
		SoftAssert softAssert = new SoftAssert();
		// boolean gmoOnlineBtnFlag =
		// onlineCatlogPage.isGmoOnlineBtnClickable();
		// softAssert.assertTrue(gmoOnlineBtnFlag);
		softAssert.assertEquals(actualWord, expectedWord);

	}

	/**
	 * verify visibility of reset and place An order button
	 * 
	 * @throws IOException
	 */

	@Test
	public void verifyBtnVisibilityOfOnlineCatlogPage() throws IOException {
		onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();
		OnlineCatlogPage.goToOnlineCatlogPage();
		SoftAssert softAssert = new SoftAssert();
		boolean resetFormFlag = OnlineCatlogPage.verifyVisibilityOfResetFormButton();
		softAssert.assertTrue(resetFormFlag);
		System.out.println("resetFormFlag" + " " + resetFormFlag);
		boolean placeAnOrderFlag = OnlineCatlogPage.verifyVisibilityOfPlaceAnOrderButton();
		softAssert.assertTrue(placeAnOrderFlag);
		System.out.println("placeAnOrderFlag" + " " + placeAnOrderFlag);

	}

	/**
	 * verify rest button and place an order button clickable or not
	 * 
	 * @throws IOException
	 */
	@Test
	public void verifyIsBtnClickableOnOnlineCatlogPage() throws IOException {
		onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();
		OnlineCatlogPage.goToOnlineCatlogPage();
		SoftAssert softAssert = new SoftAssert();
		boolean resetBtnFlag = onlineCatlogPage.isResetBtnClickable();
		softAssert.assertTrue(resetBtnFlag);
		boolean placeAnOrderBtnFlag = onlineCatlogPage.isPlaceAnOrderBtnClickable();
		softAssert.assertTrue(placeAnOrderBtnFlag);
	}

	/*
	 * Verify using 'Reset Form' user is able to Reset filled value for 'OnLine
	 * Catalog' form.
	 *
	 * 1. Go to url "https://demo.borland.com/gmopost/". 2. Click on
	 * "Enter GMO OnLine" button. 3. Filled the any Order Quality as 1. like '3
	 * Person Dome Tent' as 1. 4. Click on "Reset Form". 5.Verify '3 Person Dome
	 * Tent' field value is Reset to 0.
	 */
//incomplete
	@Test
	public void verifyValueAfterClickingOnResetForm() throws IOException {
		WelcomePage welcomePage = start();
		String actualWord = welcomePage.getTextOfElement();
		String expectedWord = "GMO OnLine";
		// verify welcome page gets loaded
		Assert.assertEquals(actualWord, expectedWord);
		welcomePage.clickOnEnterGmoOnlineBtn();
		String actualTitle = welcomePage.getTitleOfPage();
		String expectedTitle = "OnLine Catalog";
		// verify onlinecatlog page gets loaded
		Assert.assertEquals(actualTitle, expectedTitle);
		onlineCatlogPage =OnlineCatlogPage.getOnlineCatlogPageInstance();
		

	}
	/*
	 * Verify user is not able to place an order without selecting any products.
	 * 1. Go to url "https://demo.borland.com/gmopost/". 2. Click on
	 * "Enter GMO OnLine" button. 3. Click on ''Place An Order" button.
	 * 
	 */

	@Test
	public void verifyFunctionOfPlaceAnOrderBtn() throws IOException {
		WelcomePage welcomePage = start();
		String actualWord = welcomePage.getTextOfElement();
		String expectedWord = "GMO OnLine";
		// verify welcome page gets loaded
		Assert.assertEquals(actualWord, expectedWord);
		welcomePage.clickOnEnterGmoOnlineBtn();
		// clicked on Enter Gmo online button
		String actualTitle = welcomePage.getTitleOfPage();
		String expectedTitle = "OnLine Catalog";
		// verify onlinecatlog page gets loaded
		Assert.assertEquals(actualTitle, expectedTitle);
		onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();
		onlineCatlogPage.clickOnPlaceAnOrderBtn();
		// click on place an order button
		String actualText = onlineCatlogPage.getTextOfAlert();
		String expectedText = "Please Order Something First";
		Assert.assertEquals(actualText, expectedText);
		boolean alertOkFlag = onlineCatlogPage.verifyOkBtnOnAlert();
		Assert.assertTrue(alertOkFlag);
		// alert ok button verified
	}

	/*
	 * Verify total 6 Item name is displayed on 'OnLine Catalog' form. 1. Web
	 * page should be open for given URL. 2. Online-catlog page should be loaded
	 * successfully. 3. '3 Person Dome Tent', ' External Frame Backpack', '
	 * Glacier Sun Glasses', ' Padded Socks', 'Hiking Boots' and ' Back Country
	 * Shorts' Item name should be present on 'OnLine Catalog' form.
	 */
	@Test
	public void verifyIsAllItemNameDisplayedOnOnlineCatlogForm() throws IOException {
		WelcomePage welcomePage = start();
		String actualWord = welcomePage.getTextOfElement();
		String expectedWord = "GMO OnLine";
		// verify welcome page gets loaded
		Assert.assertEquals(actualWord, expectedWord);
		welcomePage.clickOnEnterGmoOnlineBtn();
		// clicked on Enter Gmo online button
		String actualTitle = welcomePage.getTitleOfPage();
		String expectedTitle = "OnLine Catalog";
		// verify onlinecatlog page gets loaded
		Assert.assertEquals(actualTitle, expectedTitle);
		onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();
		String actualString1 = onlineCatlogPage.verifyVisibilityOfItem3_Person_Dome_Tent();
		String expectedString1 = "3 Person Dome Tent";
		Assert.assertEquals(actualString1, expectedString1);
		String actualString2 = onlineCatlogPage.verifyVisibilityOfItemExternal_Frame_Backpack();
		String expectedString2 = "External Frame Backpack";
		Assert.assertEquals(actualString2, expectedString2);
		String actualString3 = onlineCatlogPage.verifyVisibilityOfItemGlacier_Sun_Glasses();
		String expectedString3 = "Glacier Sun Glasses";
		Assert.assertEquals(actualString3, expectedString3);
		String actualString4 = onlineCatlogPage.verifyVisibilityOfItemPadded_Socks();
		String expectedString4 = "Padded Socks";
		Assert.assertEquals(actualString4, expectedString4);
		String actualString5 = onlineCatlogPage.verifyVisibilityOfItemHiking_Boots();
		String expectedString5 = "Hiking Boots";
		Assert.assertEquals(actualString5, expectedString5);
		String actualString6 = onlineCatlogPage.verifyVisibilityOfItemBack_Country_Shorts();
		String expectedString6 = "Back Country Shorts";
		Assert.assertEquals(actualString6, expectedString6);

	}

	/*
	 * Verify all the 6 Iteam name is clickable and redirect on correct page. 1.
	 * Go to url "https://demo.borland.com/gmopost/". 2. Click on
	 * "Enter GMO OnLine" button. 3. Verify all the 6 Item name is clickable and
	 * redirect on correct page.
	 */
	@Test
	public void verifyIsAllItemsClickableAndRedirectOnCorrectPage() throws IOException {
		WelcomePage welcomePage = start();
		String actualWord = welcomePage.getTextOfElement();
		String expectedWord = "GMO OnLine";
		// verify welcome page gets loaded
		Assert.assertEquals(actualWord, expectedWord);
		welcomePage.clickOnEnterGmoOnlineBtn();
		// clicked on Enter Gmo online button
		String actualTitle = welcomePage.getTitleOfPage();
		String expectedTitle = "OnLine Catalog";
		// verify onlinecatlog page gets loaded
		Assert.assertEquals(actualTitle, expectedTitle);
		onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();
		String actualUrl1 = onlineCatlogPage.isName_3PersonDomeTent_ClickableAndRedirectOnCorrectPage();
		String expectedUrl1 = "https://demo.borland.com/gmopost/products.htm#tents";
		SoftAssert softAssert = new SoftAssert();
		// Assert.assertEquals(actualUrl1, expectedUrl1);
		softAssert.assertEquals(actualUrl1, expectedUrl1);
		onlineCatlogPage.navigateBackward();
		String actualUrl2 = onlineCatlogPage.isName_ExternalFrameBackpack_ClickableAndRedirectOnCorrectPage();
		String expectedUrl2 = "https://demo.borland.com/gmopost/products.htm#tents";
		// Assert.assertEquals(actualUrl2, expectedUrl2);
		softAssert.assertEquals(actualUrl2, expectedUrl2);
		onlineCatlogPage.navigateBackward();
		String actualUrl3 = onlineCatlogPage.isName_GlacierSunGlasses_ClickableAndRedirectOnCorrectPage();
		String expectedUrl3 = "https://demo.borland.com/gmopost/products.htm#tents";
		softAssert.assertEquals(actualUrl3, expectedUrl3);
		// Assert.assertEquals(actualUrl3, expectedUrl3);
		onlineCatlogPage.navigateBackward();
		String actualUrl4 = onlineCatlogPage.isName_PaddedSocks_ClickableAndRedirectOnCorrectPage();
		String expectedUrl4 = "https://demo.borland.com/gmopost/products.htm#tents";
		softAssert.assertEquals(actualUrl4, expectedUrl4);
		// Assert.assertEquals(actualUrl4, expectedUrl4);
		onlineCatlogPage.navigateBackward();
		String actualUrl5 = onlineCatlogPage.isName_HikingBoots_ClickableAndRedirectOnCorrectPage();
		String expectedUrl5 = "https://demo.borland.com/gmopost/products.htm#tents";
		softAssert.assertEquals(actualUrl5, expectedUrl5);
		// Assert.assertEquals(actualUrl5, expectedUrl5);
		onlineCatlogPage.navigateBackward();
		String actualUrl6 = onlineCatlogPage.isName_BackCountryShorts_ClickableAndRedirectOnCorrectPage();
		String expectedUrl6 = "https://demo.borland.com/gmopost/products.htm#tents";
		// Assert.assertEquals(actualUrl6, expectedUrl6);
		softAssert.assertEquals(actualUrl6, expectedUrl6);

	}

	/*
	 * Verify Item number is start with 1000 and item number is increase in
	 * incremental order of 1. 1. Go to url "https://demo.borland.com/gmopost/".
	 * 2. Click on "Enter GMO OnLine" button. 3. Verify Item number is start
	 * with 1000. 4. Verify Item number is increase in incremental order of 1.
	 */
	@Test
	public void verifyIsItemNumberStartWith_1000_AndIncreaseInIncrementalOrderOf_1() throws IOException {

		WelcomePage welcomePage = start();
		String actualWord = welcomePage.getTextOfElement();
		String expectedWord = "GMO OnLine";
		// verify welcome page gets loaded
		Assert.assertEquals(actualWord, expectedWord);
		welcomePage.clickOnEnterGmoOnlineBtn();
		// clicked on Enter Gmo online button
		String actualTitle = welcomePage.getTitleOfPage();
		String expectedTitle = "OnLine Catalog";
		// verify onlinecatlog page gets loaded
		Assert.assertEquals(actualTitle, expectedTitle);
		onlineCatlogPage = OnlineCatlogPage.getOnlineCatlogPageInstance();
		String actualItemNumber = onlineCatlogPage.isItemNumberStartsWith_1000();
		String expectedItemNumber = "1000";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualItemNumber, expectedItemNumber);
		boolean flag = onlineCatlogPage.isItemNumberIncreasesInIncrementalOrderOf_1();
		softAssert.assertTrue(flag);

	}

	/*
	 * Verify user can Place an Order '3 Person Dome Tent' in quantity of 1. 1.
	 * Web page should be open for given URL. 2. Online-catlog page should be
	 * loaded successfully. 3. Verify user is able to enter 1 in 3 Person Dome
	 * Tent's Order Quantity. 4. User is able to click on "Place An Order"
	 * button. 5. Page should be redirected to the "Place Order" page and Total
	 * price should be displayed as multiply by 1.
	 */
	@Test
	public void verifyUserIsAbleToPlaceAnOrderInQuantityOf_1() throws IOException {
		WelcomePage welcomePage = start();
		String actualWord = welcomePage.getTextOfElement();
		String expectedWord = "GMO OnLine";
		// verify welcome page gets loaded
		Assert.assertEquals(actualWord, expectedWord);
		welcomePage.clickOnEnterGmoOnlineBtn();
		// clicked on Enter Gmo online button
		String actualTitle = welcomePage.getTitleOfPage();
		String expectedTitle = "OnLine Catalog";
		// verify onlinecatlog page gets loaded
		Assert.assertEquals(actualTitle, expectedTitle);
		onlineCatlogPage = getOnlineCatlogPageInstance();

		//onlineCatlogPage.isUserIsAbleToEnter_1_In_3_PersonDomeTentsOrderQuantity();

	}

	@Test
	public void verifyResetQuantity(int quantity) throws IOException{
	WelcomePage welcomePage = start();	
	OnlineCatlogPage onlineCatlogPage = welcomePage.clickOnEnterGmoOnlineBtn();
	//onlineCatlogPage.orderQuantityDemoTent(5)
	OnlineCatlogPOJO onlineCatlogQuantity = new OnlineCatlogPOJO();
	onlineCatlogQuantity.setDemoTent("5");
	onlineCatlogQuantity.setBoots("3");
	onlineCatlogQuantity.setQuantity(onlineCatlogQuantity);
	
	
	
	
	}
	
	
	
	
	
	
	
	
}
