package controller.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class SaveCommandTest {

	@Test
	void testLoad() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		LoadCommand loadCommand = new LoadCommand(versionsManager);
		
		
		latexEditorView.setFilename("testSave.tex");
		loadCommand.execute();
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
		assertEquals("Test save: ", contents, documentContents);
		
	}
}
