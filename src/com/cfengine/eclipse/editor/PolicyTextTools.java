package com.cfengine.eclipse.editor;

import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.ui.texteditor.ITextEditor;

public class PolicyTextTools extends ScriptTextTools
{
	private final PolicyPartitionScanner partitionScanner = new PolicyPartitionScanner();
	
	public PolicyTextTools(boolean autoDisposeOnDisplayDispose) 
	{
		super(PolicyPartitions.CFENGINE_PARTITIONING, PolicyPartitions.CFENGINE_PARTITION_TYPES, autoDisposeOnDisplayDispose);
	}

	@Override
	public ScriptSourceViewerConfiguration createSourceViewerConfiguraton(IPreferenceStore store, 
			ITextEditor editor, String partitioning) 
	{
		return new PolicySourceViewerConfiguration(getColorManager(), store, editor, partitioning);
	}
	
	public IPartitionTokenScanner getPartitionScanner()
	{
		return partitionScanner;
	}

}
