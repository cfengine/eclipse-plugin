package com.cfengine.eclipse.editor;

import org.eclipse.jface.text.IDocument;

public interface PolicyPartitions
{	
	public static final String CFENGINE_PARTITIONING = "__cfengine_partitioning";
	
	public static final String CFENGINE_COMMENT = "__cfengine_comment";
	public static final String CFENGINE_STRING = "__cfengine_string";
	
	public static final String[] CFENGINE_PARTITION_TYPES = {
		CFENGINE_COMMENT,
		CFENGINE_STRING,
		IDocument.DEFAULT_CONTENT_TYPE
	};
}
