package controller;

import java.util.HashMap;

import controller.commands.Command;
import controller.commands.CommandsFactory;
import controller.commands.CreateCommand;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class LatexEditorController {
	private HashMap<String, Command> commands;
	private VersionsManager versionsManager;
	private DocumentManager documentManager;
	
	public LatexEditorController(LatexEditorView view, VersionsManager versionsManager) {
		commands = new HashMap<String, Command>();
		this.versionsManager = versionsManager;
		documentManager = new DocumentManager();
		CommandsFactory commandsFactory = new CommandsFactory(view, versionsManager);
		
		Command createCommand = commandsFactory.createCommand("createCommand");
		commands.put("createCommand", createCommand);
		
		Command editCommand = commandsFactory.createCommand("editCommand");
		commands.put("editCommand", editCommand);
		
		Command addLatexCommand = commandsFactory.createCommand("addLatexCommand");
		commands.put("addLatexCommand", addLatexCommand);
		
		Command saveCommand = commandsFactory.createCommand("saveCommand");
		commands.put("saveCommand", saveCommand);
		
		Command loadCommand = commandsFactory.createCommand("loadCommand");
		commands.put("loadCommand", loadCommand);
		
		Command disableCommand = commandsFactory.createCommand("disableCommand");
		commands.put("disableCommand", disableCommand);
		
		Command enableCommand = commandsFactory.createCommand("enableCommand");
		commands.put("enableCommand", enableCommand);
		
		Command changeCommand = commandsFactory.createCommand("changeCommand");
		commands.put("changeCommand", changeCommand);
		
		Command rollbackCommand = commandsFactory.createCommand("rollbackCommand");
		commands.put("rollbackCommand", rollbackCommand);
	}

	public void enact(String commandType) {
		Command command = commands.get(commandType);
		command.execute();
	}
	
}
