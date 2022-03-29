package controller.commands;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class CommandsFactory {
	private LatexEditorView view;
	private VersionsManager versionsManager;
	private DocumentManager documentManager;
	
	public CommandsFactory(LatexEditorView view, VersionsManager versionsManager) {
		// TODO Auto-generated constructor stub
		this.versionsManager = versionsManager;
		this.view = view;
		this.documentManager = new DocumentManager();
	}

	public Command createCommand(String type) {
		if(type.equals("createCommand")) {
			return new CreateCommand(documentManager, versionsManager);
		}
		if(type.equals("editCommand")) {
			return new EditCommand(versionsManager);
		}
		if(type.equals("addLatexCommand")) {
			return new AddLatexCommand(versionsManager);
		}
		if(type.equals("saveCommand")) {
			return new SaveCommand(versionsManager);
		}
		if(type.equals("loadCommand")) {
			return new LoadCommand(versionsManager);
		}
		if(type.equals("disableCommand")) {
			return new DisableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("enableCommand")) {
			return new EnableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("changeCommand")) {
			return new ChangeVersionStrategyCommand(versionsManager);
		}
		if(type.equals("rollbackCommand")) {
			return new RollbackToPreviousVersionCommand(versionsManager);
		}
		return null;
	}
}
