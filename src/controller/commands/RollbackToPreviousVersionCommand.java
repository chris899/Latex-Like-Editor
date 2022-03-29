package controller.commands;

import javax.swing.JOptionPane;

import model.Document;
import model.VersionsManager;
import model.strategies.VersionsStrategy;
import view.LatexEditorView;

public class RollbackToPreviousVersionCommand implements Command {
	private VersionsManager versionsManager;
	
	public RollbackToPreviousVersionCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		VersionsStrategy strategy = versionsManager.getStrategy();
		if(strategy.getVersion() == null) {
			JOptionPane.showMessageDialog(null, "There is no history.");
		}
		else {
			Document doc = strategy.getVersion();
			versionsManager.setCurrentVersion(doc);
			LatexEditorView view = versionsManager.getView();
			view.getEditorPane().setText(doc.getContents());
			strategy.removeVersion();
		}
	}

}
