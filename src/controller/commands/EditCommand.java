package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class EditCommand implements Command{
	private VersionsManager versionsManager;
	
	public EditCommand(VersionsManager versionsManager) {
		// TODO Auto-generated constructor stub
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Execute edit");
		String contents = versionsManager.getView().getEditorPane().getText();
		
		if(versionsManager.isEnabled()) {
			Document doc = versionsManager.getCurrentVersion();
			doc.setName(versionsManager.getView().getDocumentName());
			versionsManager.getStrategy().putVersion(doc);
			doc.updateVersionId();
		}
		versionsManager.getCurrentVersion().setContents(contents);
	}
	
	
}
