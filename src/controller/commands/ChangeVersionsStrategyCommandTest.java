package controller.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JEditorPane;

import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import model.strategies.VersionsStrategy;
import view.LatexEditorView;

class ChangeVersionsStrategyCommandTest {

	@Test
	void testVolatile() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		EditCommand editCommand = new EditCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);
		latexEditorView.setDocumentType("book");
		ChangeVersionStrategyCommand changeCommand = new ChangeVersionStrategyCommand(versionsManager);
		
		createCommand.execute();
		
		latexEditorView.setHistoryType("volatile");
		enableCommand.execute();
		VersionsStrategy prevVersion = versionsManager.getStrategy();
		
		changeCommand.execute();
		VersionsStrategy strategy = versionsManager.getStrategy();
		
		assertNotEquals("Test change volatile: ", prevVersion, strategy);
		
	}

	@Test
	void testStable() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		EditCommand editCommand = new EditCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);
		latexEditorView.setDocumentType("book");
		ChangeVersionStrategyCommand changeCommand = new ChangeVersionStrategyCommand(versionsManager);
		
		createCommand.execute();
		
		latexEditorView.setHistoryType("stable");
		enableCommand.execute();
		VersionsStrategy prevVersion = versionsManager.getStrategy();
		
		changeCommand.execute();
		VersionsStrategy strategy = versionsManager.getStrategy();
		
		assertNotEquals("Test change stable: ", prevVersion, strategy);
		
	}
	
}
