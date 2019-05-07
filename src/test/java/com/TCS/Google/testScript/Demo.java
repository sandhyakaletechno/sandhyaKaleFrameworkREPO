package com.TCS.Google.testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.TCS.Google.CONSTANT.FilePaths;
import com.TCS.Google.util.PropertyFileOperation;

public class Demo {

	@Test
	public static void demo() throws IOException {
		PropertyFileOperation propertyOperation = new PropertyFileOperation(FilePaths.ONLINECATLOGPAGEPROPPATH);
		System.out.println(propertyOperation.getValue("gmoOnlineBtn"));
		System.out.println(propertyOperation.getValue("placeAnOrderBtn"));
		System.out.println(propertyOperation.getValue("resetFormBtn"));

	}
}
