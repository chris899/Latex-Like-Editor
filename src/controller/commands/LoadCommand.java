package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class LoadCommand implements Command{
	private VersionsManager versionsManager;
	
	public LoadCommand(VersionsManager versionsManager) {
		// TODO Auto-generated constructor stub
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Execute load");
		
		versionsManager.loadDocument();
		String contents = versionsManager.getCurrentVersion().getContents();
		versionsManager.getView().getEditorPane().setText(contents);
	}
	
	
}
