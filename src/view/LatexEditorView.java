package view;

import javax.swing.JEditorPane;

import controller.LatexEditorController;
import model.VersionsManager;

public class LatexEditorView {
	private LatexEditorController latexEditorController; 
	
	private String documentType;
	private JEditorPane editorPane;
	private String latexCommand;
	private String filename;
	private String historyType;
	private String documentName;
	private boolean flag = true;
	
	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getHistoryType() {
		return historyType;
	}

	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	public String getLatexCommand() {
		return latexCommand;
	}

	public void setLatexCommand(String latexCommand) {
		this.latexCommand = latexCommand;
	}

	public JEditorPane getEditorPane() {
		return editorPane;
	}

	public void setEditorPane(JEditorPane editorPane) {
		this.editorPane = editorPane;
	}

	public LatexEditorView(VersionsManager versionsManager) {
		latexEditorController = new LatexEditorController(this, versionsManager);
	}
	
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	public void enact(String commandType) {
		latexEditorController.enact(commandType);
	}

	public String getFilename() {
		// TODO Auto-generated method stub
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public boolean getFlag() {
		// TODO Auto-generated method stub
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
  