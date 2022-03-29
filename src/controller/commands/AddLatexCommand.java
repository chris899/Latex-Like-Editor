package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class AddLatexCommand implements Command{
	private VersionsManager versionsManager;
	
	public AddLatexCommand(VersionsManager versionsManager) {
		// TODO Auto-generated constructor stub
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Execute add latex");
		String contents = versionsManager.getView().getEditorPane().getText();
		String latexCommand = versionsManager.getLatexCommand();
		
		int index = versionsManager.getView().getEditorPane().getCaretPosition();
		if(index != -1) {
			
		
		String before = contents.substring(0, index);
		String after = contents.substring(index);
		
		if(versionsManager.isEnabled()) {
			Document doc = versionsManager.getCurrentVersion();
			versionsManager.getStrategy().putVersion(doc);
		}
		versionsManager.getCurrentVersion().setContents(before+"\n"+latexCommand + "\n"+after);
		versionsManager.getView().getEditorPane().setText(before+"\n"+latexCommand + "\n"+after);
	
		}
		else {
			if(versionsManager.isEnabled()) {
				Document doc = versionsManager.getCurrentVersion();
				versionsManager.getStrategy().putVersion(doc);
			}
			versionsManager.getCurrentVersion().setContents(contents+"\n"+latexCommand+"\n");
			versionsManager.getView().getEditorPane().setText(contents+"\n"+latexCommand+ "\n");
		
		}
	}
	
	
}
