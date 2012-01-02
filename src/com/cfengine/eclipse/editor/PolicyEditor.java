package com.cfengine.eclipse.editor;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.internal.ui.editor.ScriptEditor;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.ui.IEditorInput;

import com.cfengine.eclipse.LanguageToolkit;
import com.cfengine.eclipse.Plugin;

public class PolicyEditor extends ScriptEditor
{
	@Override
	public String getEditorId() {
		return "com.cfengine.eclipse.editor";
	}
	
	@Override
	protected void connectPartitioningToElement(IEditorInput input, IDocument document) 
	{
		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension = (IDocumentExtension3) document;
			if (extension.getDocumentPartitioner(PolicyPartitions.CFENGINE_PARTITIONING) == null) 
			{
				PolicyDocumentSetupParticipant participant = new PolicyDocumentSetupParticipant();
				participant.setup(document);
			}
		}
	}

	@Override
	public IDLTKLanguageToolkit getLanguageToolkit() {
		return LanguageToolkit.getDefault();
	}
	
	@Override
	public ScriptTextTools getTextTools() {
		return Plugin.getDefault().getTextTools();
	}

}
