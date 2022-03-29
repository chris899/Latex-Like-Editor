package controller.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JEditorPane;

import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class AddLatexCommandTest {

	@Test
	void testChapter() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		AddLatexCommand addLatexCommand = new AddLatexCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		latexEditorView.setDocumentType("empty");
		
		String contents = "\n\\chapter{...}\n";
		
		
		createCommand.execute();
		editorPane.setText(versionsManager.getCurrentVersion().getContents());
		latexEditorView.setLatexCommand("chapter");
		
		addLatexCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test add chapter: ", contents, documentContents);
		
	}
	@Test
	void testSection() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		AddLatexCommand addLatexCommand = new AddLatexCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		latexEditorView.setDocumentType("empty");
		
		String contents = "\n\\section{}\n";
		
		
		createCommand.execute();
		editorPane.setText(versionsManager.getCurrentVersion().getContents());
		latexEditorView.setLatexCommand("section");
		
		addLatexCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test add section: ", contents, documentContents);
		
	}
	
	@Test
	void testSubSection() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		AddLatexCommand addLatexCommand = new AddLatexCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		latexEditorView.setDocumentType("empty");
		
		String contents = "\n\\subsection{}\n";
		
		
		createCommand.execute();
		editorPane.setText(versionsManager.getCurrentVersion().getContents());
		latexEditorView.setLatexCommand("subsection");
		
		addLatexCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test add subsection: ", contents, documentContents);
		
	}
	
	@Test
	void testSubsubSection() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		AddLatexCommand addLatexCommand = new AddLatexCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		latexEditorView.setDocumentType("empty");
		
		String contents = "\n\\subsubsection{}\n";
		
		
		createCommand.execute();
		editorPane.setText(versionsManager.getCurrentVersion().getContents());
		latexEditorView.setLatexCommand("subsubsection");
		
		addLatexCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test add subsubsection: ", contents, documentContents);
		
	}
	
	@Test
	void testItemize() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		AddLatexCommand addLatexCommand = new AddLatexCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		latexEditorView.setDocumentType("empty");
		
		String contents = "\n\\begin{itemize}\n" + 
				"\\item ...\n" + 
				"\\item ...\n" + 
				"\\end{itemize}\n\n";
		
		
		createCommand.execute();
		editorPane.setText(versionsManager.getCurrentVersion().getContents());
		latexEditorView.setLatexCommand("itemize");
		
		addLatexCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test add itemize: ", contents, documentContents);
		
	}
	
	@Test
	void testEnumerate() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		AddLatexCommand addLatexCommand = new AddLatexCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		latexEditorView.setDocumentType("empty");
		
		String contents = "\n\\begin{enumerate}\n" + 
				"\\item ...\n" + 
				"\\item ...\n" + 
				"\\end{enumerate}\n\n";
		
		
		createCommand.execute();
		editorPane.setText(versionsManager.getCurrentVersion().getContents());
		latexEditorView.setLatexCommand("enumerate");
		
		addLatexCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test add enumerate: ", contents, documentContents);
		
	}
	@Test
	void testTable() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		AddLatexCommand addLatexCommand = new AddLatexCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		latexEditorView.setDocumentType("empty");
		
		String contents = "\n"+"\\begin{table}\n" + 
				"\\caption{....}\\label{...}\n" + 
				"\\begin{tabular}{|c|c|c|}\n" + 
				"  \\hline\n" + 
				"... &...&...\\\\\n" + 
				"... &...&...\\\\\n" + 
				"... &...&...\\\\\n" + 
				"  \\hline\n" + 
				"\\end{tabular}\n" + 
				"\\end{table}\n\n";
		
		
		createCommand.execute();
		editorPane.setText(versionsManager.getCurrentVersion().getContents());
		latexEditorView.setLatexCommand("table");
		
		addLatexCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test add table: ", contents, documentContents);
		
	}
	
	@Test
	void testFigure() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		AddLatexCommand addLatexCommand = new AddLatexCommand(versionsManager);
		JEditorPane editorPane = new JEditorPane();
		latexEditorView.setEditorPane(editorPane);
		
		latexEditorView.setDocumentType("empty");
		
		String contents = "\n\\begin{figure}\n" + 
				"\\includegraphics[width=...,height=...]{...}\n" + 
				"\\caption{....}\\label{...}\n" + 
				"\\end{figure}\n\n";
		
		
		createCommand.execute();
		editorPane.setText(versionsManager.getCurrentVersion().getContents());
		latexEditorView.setLatexCommand("figure");
		
		addLatexCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test add figure: ", contents, documentContents);
		
	}
}
