package com.cfengine.eclipse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Promises
{
	private static JsonParser jsonParser = new JsonParser();
	
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
	
	public static JsonObject parsePolicy(final String path)
	{
		return runProcess(new String[] {
			"cf-promises",
			"--parse-tree",
			"-f",
			path
		});
	}
	
	private static JsonObject runProcess(final String[] path)
	{
		Process process = null;
		try 
		{
			process = Runtime.getRuntime().exec(path);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
		
		final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		final StringBuffer buffer = new StringBuffer();
		
		String line = null;
		try 
		{
			while ((line = reader.readLine()) != null)
			{
				buffer.append(line);
			}
			reader.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		try 
		{
			if (process.waitFor() != 0)
				return null;
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			return null;
		}
		
		return jsonParser.parse(buffer.toString()).getAsJsonObject();
	}
	
	
}
