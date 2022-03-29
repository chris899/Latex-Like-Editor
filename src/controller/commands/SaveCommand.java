package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class SaveCommand implements Command{
	private VersionsManager versionsManager;
	
	public SaveCommand(VersionsManager versionsManager) {
		// TODO Auto-generated constructor stub
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Execute save");
		String filename = versionsManager.getView().getFilename();
		versionsManager.getCurrentVersion().save(filename);
	}
	
	
}
