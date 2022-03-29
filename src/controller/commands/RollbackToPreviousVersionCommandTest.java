package controller.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JEditorPane;

import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class RollbackToPreviousVersionCommandTest {

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
		RollbackToPreviousVersionCommand rollbackCommand = new RollbackToPreviousVersionCommand(versionsManager);
		
		
		latexEditorView.setDocumentType("book");
		
		String bookContents = "\\documentclass[11pt,a4paper]{book}\n" + 
				"\n" + 
				"\\begin{document}\n" + 
				"\\title{Book: How to Structure a LaTeX Document}\n" + 
				"\\author{Author1 \\and Author2 \\and ...}\n" + 
				"\\date{\\today}\n" + 
				"\n" + 
				"\\maketitle\n" + 
				"\n" + 
				"\\frontmatter\n" + 
				"\n" + 
				"\\chapter{Preface}\n" + 
				"% ...\n" + 
				"\n" + 
				"\\mainmatter\n" + 
				"\\chapter{First chapter}\n" + 
				"\\section{Section Title 1}\n" + 
				"\\section{Section Title 2}\n" + 
				"\\section{Section Title.....}\n" + 
				"\n" + 
				"\\chapter{Second chapter}\n" + 
				"\\section{Section Title 1}\n" + 
				"\\section{Section Title 2}\n" + 
				"\\section{Section Title.....}\n" + 
				"\n" + 
				"\\chapter{....}\n" +
				"\\chapter{new Chapter}\n"+
				"\n" + 
				"\\chapter{Conclusion}\n" + 
				"\n" + 
				"\\chapter*{References}\n" + 
				"\n" + 
				"\n" + 
				"\\backmatter\n" + 
				"\\chapter{Last note}\n" + 
				"\n" + 
				"\\end{document}\n";
		editorPane.setText(bookContents);
		createCommand.execute();
		latexEditorView.setHistoryType("stable");
		enableCommand.execute();
		
		editCommand.execute();
		
		String previousDocumentContents = versionsManager.getPreviousVersion().getContents();
		
		rollbackCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		
		
		assertEquals("Test rollback: ", previousDocumentContents, documentContents);
		
	}
}
