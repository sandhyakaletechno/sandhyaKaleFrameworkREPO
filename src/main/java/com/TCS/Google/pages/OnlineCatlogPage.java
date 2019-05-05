package com.TCS.Google.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.TCS.Google.CONSTANT.FilePaths;
import com.TCS.Google.base.PredefinedActions;
import com.TCS.Google.util.PropertyFileOperation;

import pojo.OnlineCatlogPOJO;

public class OnlineCatlogPage extends PredefinedActions {
	static PropertyFileOperation propOperation;
	private static OnlineCatlogPage onlineCatlogPage;

	private OnlineCatlogPage() throws IOException {
		propOperation = new PropertyFileOperation(FilePaths.ONLINECATLOGPAGEPROPPATH);
	}

	public static OnlineCatlogPage getOnlineCatlogPageInstance() throws IOException {

		if (onlineCatlogPage == null)
			onlineCatlogPage = new OnlineCatlogPage();
		return onlineCatlogPage;
	}

	public static void goToOnlineCatlogPage() {
		initialization();
		click(propOperation.getValue("gmoOnlineButton"));
	}
	public OnlineCatlogPage orderQuantityDemoTent(int quantity){
		//QTY_TENTS=[xpath]:-(//input[@name='QTY_TENTS'])|(//input[@name='QTY_TENTS'])
		//is stable environment and 
		setText(propOperation.getValue("QTY_TENTS"),String.valueOf(quantity),true);
		return this;
	}
	
	public void setQuantity(OnlineCatlogPOJO onlineCatlogPOJO){
		//System.out.println(onlineCatlogPOJO.getBoots());
		//System.out.println(onlineCatlogPOJO.getFrameBackPack());
if(onlineCatlogPOJO.getDemoTent()!=null&&!(onlineCatlogPOJO.getDemoTent().length()>0))
	setText(propOperation.getValue(""),onlineCatlogPOJO.getDemoTent(),true);
	
	
	}

	public static boolean verifyVisibilityOfResetFormButton() {

		return visibilityOnOnlineCatlogPage(propOperation.getValue("resetFormBtn"));
	}

	public static boolean verifyVisibilityOfPlaceAnOrderButton() {

		return visibilityOnOnlineCatlogPage(propOperation.getValue("placeAnOrderBtn"));
	}

	public static boolean visibilityOnOnlineCatlogPage(String locator) {
		return visibilityOfElement(locator);
	}

	public boolean isResetBtnClickable() {

		return isElementClickable(propOperation.getValue("resetFormBtn"));
	}

	public boolean isPlaceAnOrderBtnClickable() {

		return isElementClickable(propOperation.getValue("placeAnOrderBtn"));
	}

	public boolean isGmoOnlineBtnClickable() {
		// TODO Auto-generated method stub
		return isElementClickable(propOperation.getValue("gmoOnlineButton"));
	}

	public String getWordOfOnlineCatlogPage() {
		// TODO Auto-generated method stub
		click(propOperation.getValue("gmoOnlineButton"));
		return getText(propOperation.getValue("onlineCatlogPageTextLocator"));
	}

	public void clickOnPlaceAnOrderBtn() {
		// TODO Auto-generated method stub
		click(propOperation.getValue("placeAnOrderBtn"));
	}

	public String getTextOfAlert() {
		// TODO Auto-generated method stub
		return getTextOnAlert();

	}

	public boolean verifyOkBtnOnAlert() {
		// TODO Auto-generated method stub
		return isAlertAccepted();
	}

	public String verifyVisibilityOfItem3_Person_Dome_Tent() {
		String text = getText(propOperation.getValue("item3_Person_Dome_Tent"));
		System.out.println(text);
		return text;
	}

	public String verifyVisibilityOfItemExternal_Frame_Backpack() {
		// TODO Auto-generated method stub
		String text = getText(propOperation.getValue("itemExternal_Frame_Backpack"));
		System.out.println(text);
		return text;
	}

	public String verifyVisibilityOfItemGlacier_Sun_Glasses() {
		// TODO Auto-generated method stub
		String text = getText(propOperation.getValue("itemGlacier_Sun_Glasses"));
		System.out.println(text);
		return text;
	}

	public String verifyVisibilityOfItemPadded_Socks() {
		// TODO Auto-generated method stub
		String text = getText(propOperation.getValue("itemPadded_Socks"));
		System.out.println(text);
		return text;
	}

	public String verifyVisibilityOfItemHiking_Boots() {
		// TODO Auto-generated method stub
		String text = getText(propOperation.getValue("itemHiking_Boots"));
		System.out.println(text);
		return text;
	}

	public String verifyVisibilityOfItemBack_Country_Shorts() {
		// TODO Auto-generated method stub
		String text = getText(propOperation.getValue("itemBack_Country_Shorts"));
		System.out.println(text);
		return text;
	}

	public String isName_3PersonDomeTent_ClickableAndRedirectOnCorrectPage() {
		if (isElementClickable(propOperation.getValue("item3_Person_Dome_Tent"))) {
			click(propOperation.getValue("item3_Person_Dome_Tent"));
		}

		return getPageURL();
	}

	public String isName_ExternalFrameBackpack_ClickableAndRedirectOnCorrectPage() {
		// TODO Auto-generated method stub
		if (isElementClickable(propOperation.getValue("itemExternal_Frame_Backpack"))) {
			click(propOperation.getValue("itemExternal_Frame_Backpack"));
		}

		return getPageURL();

	}

	public String isName_GlacierSunGlasses_ClickableAndRedirectOnCorrectPage() {
		// TODO Auto-generated method stub
		if (isElementClickable(propOperation.getValue("itemGlacier_Sun_Glasses"))) {
			click(propOperation.getValue("itemGlacier_Sun_Glasses"));
		}

		return getPageURL();

	}

	public String isName_PaddedSocks_ClickableAndRedirectOnCorrectPage() {
		// TODO Auto-generated method stub
		if (isElementClickable(propOperation.getValue("itemPadded_Socks"))) {
			click(propOperation.getValue("itemPadded_Socks"));
		}

		return getPageURL();

	}

	public String isName_HikingBoots_ClickableAndRedirectOnCorrectPage() {
		// TODO Auto-generated method stub
		if (isElementClickable(propOperation.getValue("itemHiking_Boots"))) {
			click(propOperation.getValue("itemHiking_Boots"));
		}

		return getPageURL();

	}

	public String isName_BackCountryShorts_ClickableAndRedirectOnCorrectPage() {
		// TODO Auto-generated method stub
		if (isElementClickable(propOperation.getValue("itemBack_Country_Shorts"))) {
			click(propOperation.getValue("itemBack_Country_Shorts"));
		}

		return getPageURL();

	}

	public void navigateBackward() {
		goToBackPage();

	}

	public String isItemNumberStartsWith_1000() {
		return getItemNumber(propOperation.getValue("itemNumber1"));

	}

	public boolean isItemNumberIncreasesInIncrementalOrderOf_1() {
		List<String> list = new ArrayList<String>();
		list.add(0, propOperation.getValue("itemNumber1"));
		list.add(1, propOperation.getValue("itemNumber2"));
		list.add(2, propOperation.getValue("itemNumber3"));
		list.add(3, propOperation.getValue("itemNumber4"));
		list.add(4, propOperation.getValue("itemNumber5"));
		list.add(5, propOperation.getValue("itemNumber6"));
		boolean orderVerificationFlag = false;
		for (int i = 0; i < 6; i++) {
			String locator = list.get(i);
			orderVerificationFlag = verifyIncreasingOrderOfItemNumber(locator);

		}
		return orderVerificationFlag;
	}

	public void isUserIsAbleToEnter_1_In_3_PersonDomeTentsOrderQuantity() {

	}

}
