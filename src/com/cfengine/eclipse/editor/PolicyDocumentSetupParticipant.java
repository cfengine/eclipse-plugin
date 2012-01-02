package com.cfengine.eclipse.editor;

import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.text.IDocument;

import com.cfengine.eclipse.Plugin;

// WTF: Java. I don't even... know what this is for
public class PolicyDocumentSetupParticipant 
{
	public void setup(IDocument document) {
		ScriptTextTools tools = Plugin.getDefault().getTextTools();
		tools.setupDocumentPartitioner(document, PolicyPartitions.CFENGINE_PARTITIONING);
	}
}
