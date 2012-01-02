package com.cfengine.eclipse;

public class Promises
{
	public static String[] keywords()
	{
		return new String[] {
			"bundle",
			"body"
		};
	}
	
	public static String[] bundleTypes()
	{
		return new String[] {
			"agent",
			"server"
		};
	}

	public static String[] bodyTypes()
	{
		return new String[] {
			"common"
		};
	}
	
	public static String[] promiseTypes()
	{
		return new String[] {
				"reports",
				"files",
				"processes",
				"vars",
				"methods"
		};
	}
}
