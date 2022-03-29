package controller.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JEditorPane;

import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class LoadCommandTest {

	@Test
	void testSave() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		SaveCommand saveCommand = new SaveCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		latexEditorView.setDocumentType("book");
		createCommand.execute();
		latexEditorView.setFilename("testSave.tex");
		saveCommand.execute();
		String contents = "";
		try {
			FileInputStream fileInputStream = new FileInputStream("testSave.tex");
			Scanner scanner = new Scanner(fileInputStream);
			
			while(scanner.hasNextLine()) {
				contents = contents + scanner.nextLine() + "\n";
			}
			
			scanner.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test load: ", contents, documentContents);
		
	}
}
