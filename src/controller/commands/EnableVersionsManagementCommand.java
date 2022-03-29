package controller.commands;

import javax.swing.JOptionPane;
import javax.xml.stream.events.StartDocument;

import model.Document;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

public class EnableVersionsManagementCommand implements Command {
	private VersionsManager versionsManager;
	
	public EnableVersionsManagementCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Execute enable");
		
		String historyType = versionsManager.getView().getHistoryType();
		if(versionsManager.isEnabled()) {
			JOptionPane.showMessageDialog(null, "Strategy is already enabled. Try change strategy.");
		}
		else {
			VersionsStrategy strategy = versionsManager.getStrategy();
			if(strategy == null) {
				if(historyType.equals("volatile")) {
					strategy = new VolatileVersionsStrategy();
				}
				else {
					strategy = new StableVersionsStrategy();
					Document doc = versionsManager.getCurrentVersion();
					((StableVersionsStrategy)strategy).setDocument(doc);
				}
				
				versionsManager.setStrategy(strategy);
				versionsManager.enable();
			}
			else {
				if(strategy instanceof VolatileVersionsStrategy && historyType.equals("stable")) {
					JOptionPane.showMessageDialog(null, "You have history in main memory. Enable it first and then change it");
				}
				else if(strategy instanceof StableVersionsStrategy && historyType.equals("volatile")) {
					JOptionPane.showMessageDialog(null, "You have history in disk. Enable it first and then change it");
				}
				else {
					versionsManager.enable();
				}
			}
		}
	}

}
