package controller.commands;

import java.util.List;

import javax.swing.JOptionPane;

import model.Document;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

public class ChangeVersionStrategyCommand implements Command {

	private VersionsManager versionsManager;
	
	public ChangeVersionStrategyCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
System.out.println("Execute enable");
		
		String historyType = versionsManager.getView().getHistoryType();
		if(versionsManager.isEnabled() == false) {
			JOptionPane.showMessageDialog(null, "Strategy is not enabled. Try enable strategy.");
		}
		else {
			VersionsStrategy strategy = versionsManager.getStrategy();
			VersionsStrategy newStrategy = null;
			if(historyType.equals("volatile")) {
				newStrategy = new StableVersionsStrategy();
				versionsManager.getView().setHistoryType("stable");
			}
			else {
				newStrategy = new VolatileVersionsStrategy();
				versionsManager.getView().setHistoryType("volatile");
			}
			List<Document> list = strategy.getEntireHistory();
			newStrategy.setEntireHistory(list);
			versionsManager.setStrategy(newStrategy);
			versionsManager.enable();
		}
	}

}
