package com.cfengine.eclipse.editor;

public interface PolicyParts
{
	public static final String CFENGINE_DEFAULT = "__cfengine_default";
	public static final String CFENGINE_BUNDLE_TYPE = "__cfengine_bundle_type";
	public static final String CFENGINE_BODY_TYPE = "__cfengine_body_type";
	public static final String CFENGINE_PROMISE_TYPE = "__cfengine_promise_type";
	public static final String CFENGINE_CONTEXT = "__cfengine_context";
	public static final String CFENGINE_KEYWORD = "__cfengine_keyword";
	public static final String CFENGINE_ARROW = "__cfengine_arrow";
	public static final String CFENGINE_ASSIGN = "__cfengine_assign";
	
	public static final String[] CFENGINE_POLICY_PARTS = {
		CFENGINE_PROMISE_TYPE,
		CFENGINE_CONTEXT,
		CFENGINE_KEYWORD,
		CFENGINE_ARROW,
		CFENGINE_ASSIGN
	};
}
