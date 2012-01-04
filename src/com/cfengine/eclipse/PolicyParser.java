package com.cfengine.eclipse;

import java.util.ArrayList;
import java.util.List;

import com.cfengine.eclipse.dom.Attribute;
import com.cfengine.eclipse.dom.Body;
import com.cfengine.eclipse.dom.Bundle;
import com.cfengine.eclipse.dom.Context;
import com.cfengine.eclipse.dom.Policy;
import com.cfengine.eclipse.dom.PolicyElement;
import com.cfengine.eclipse.dom.Promise;
import com.cfengine.eclipse.dom.PromiseType;
import com.cfengine.eclipse.dom.RVal;
import com.cfengine.eclipse.dom.StringListRVal;
import com.cfengine.eclipse.dom.StringRVal;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PolicyParser 
{
	public static Policy parse(JsonObject policyObject)
	{
		final Policy policy = new Policy(0, 0, policyObject.getAsJsonPrimitive("name").getAsString());
		
		if (policyObject.has("bodies"))
		{
			for (JsonElement bodyElement : policyObject.getAsJsonArray("bodies"))
			{
				policy.getChilds().add(parseBody(bodyElement.getAsJsonObject()));
			}
		}
		
		if (policyObject.has("bundles"))
		{
			for (JsonElement bundleElement : policyObject.getAsJsonArray("bundles"))
			{
				policy.getChilds().add(parseBundle(bundleElement.getAsJsonObject()));
			}
		}
		
		return policy;
	}

	private static PolicyElement parseBundle(JsonObject bundleObject)
	{
		final Bundle bundle = new Bundle(bundleObject.getAsJsonPrimitive("offset").getAsInt(),
				bundleObject.getAsJsonPrimitive("offset-end").getAsInt(),
				bundleObject.getAsJsonPrimitive("name").getAsString(),
				bundleObject.getAsJsonPrimitive("bundle-type").getAsString());
		
		for (JsonElement promiseTypeElement : bundleObject.getAsJsonArray("promise-types"))
		{
			bundle.getChilds().add(parsePromiseType(promiseTypeElement.getAsJsonObject()));
		}
		
		return bundle;
	}

	private static PolicyElement parsePromiseType(JsonObject promiseTypeObject) 
	{
		final PromiseType promiseType = new PromiseType(promiseTypeObject.getAsJsonPrimitive("offset").getAsInt(),
				promiseTypeObject.getAsJsonPrimitive("offset-end").getAsInt(),
				promiseTypeObject.getAsJsonPrimitive("name").getAsString());
		
		for (JsonElement contextElement : promiseTypeObject.getAsJsonArray("classes"))
		{
			promiseType.getChilds().add(parseContext(contextElement.getAsJsonObject()));
		}
		
		return promiseType;
	}

	private static PolicyElement parseBody(JsonObject bodyObject) 
	{
		final Body body = new Body(bodyObject.getAsJsonPrimitive("offset").getAsInt(),
				bodyObject.getAsJsonPrimitive("offset-end").getAsInt(),
				bodyObject.getAsJsonPrimitive("name").getAsString(),
				bodyObject.getAsJsonPrimitive("body-type").getAsString());

		for (JsonElement contextElement : bodyObject.getAsJsonArray("classes"))
		{
			body.getChilds().add(parseContext(contextElement.getAsJsonObject()));
		}
		
		return body;
	}

	private static PolicyElement parseContext(JsonObject contextObject) 
	{
		Context context = new Context(contextObject.getAsJsonPrimitive("offset").getAsInt(),
				contextObject.getAsJsonPrimitive("offset-end").getAsInt(),
				contextObject.getAsJsonPrimitive("name").getAsString());
		
		if (contextObject.has("promises"))
		{
			for (JsonElement promiseElement : contextObject.getAsJsonArray("promises"))
			{
				final JsonObject promiseObject = promiseElement.getAsJsonObject();
				
				final Promise promise = new Promise(promiseObject.getAsJsonPrimitive("offset").getAsInt(),
						promiseObject.getAsJsonPrimitive("offset-end").getAsInt(),
						promiseObject.getAsJsonPrimitive("promiser").getAsString());
				
				for (JsonElement attributeElement : promiseObject.getAsJsonArray("attributes"))
				{
					final JsonObject attributeObject = attributeElement.getAsJsonObject();

					promise.getChilds().add(new Attribute(attributeObject.getAsJsonPrimitive("offset").getAsInt(),
							attributeObject.getAsJsonPrimitive("offset-end").getAsInt(),
							attributeObject.getAsJsonPrimitive("lval").getAsString(),
							parseRVal(attributeObject.getAsJsonObject("rval"))));
				}
				
				context.getChilds().add(promise);
			}
		}
		
		if (contextObject.has("attributes"))
		{
			for (JsonElement attributeElement : contextObject.getAsJsonArray("attributes"))
			{
				final JsonObject attributeObject = attributeElement.getAsJsonObject();
				
				context.getChilds().add(new Attribute(attributeObject.getAsJsonPrimitive("offset").getAsInt(),
						attributeObject.getAsJsonPrimitive("offset-end").getAsInt(),
						attributeObject.getAsJsonPrimitive("lval").getAsString(),
						parseRVal(attributeObject.getAsJsonObject("rval"))));
			}
		}
		
		return context;
	}

	private static RVal parseRVal(JsonObject rvalObject) {
		
		final String type = rvalObject.getAsJsonPrimitive("type").getAsString();
		
		if ("list".equals(type))
		{
			final List<String> list = new ArrayList<String>();
			for (JsonElement listElement : rvalObject.getAsJsonArray("value"))
			{
				list.add(listElement.getAsJsonObject().getAsJsonPrimitive("value").getAsString());
			}
			
			return new StringListRVal(list);
		}
		else if ("string".equals(type))
		{
			return new StringRVal(rvalObject.getAsJsonPrimitive("value").getAsString());
		}
		else
		{
			return null;
		}
	}
}
