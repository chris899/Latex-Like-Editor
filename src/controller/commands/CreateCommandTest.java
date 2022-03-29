package controller.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class CreateCommandTest {

	@Test
	void testBook() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		
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
				"\\chapter{....}\n" + 
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
		
		createCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test creation of book: ", bookContents, documentContents);
		
	}
	@Test
	void testArticle() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		
		latexEditorView.setDocumentType("article");
		
		String articleContents = "\\documentclass[11pt,twocolumn,a4paper]{article}\n" + 
				"\n" + 
				"\\begin{document}\n" + 
				"\\title{Article: How to Structure a LaTeX Document}\n" + 
				"\\author{Author1 \\and Author2 \\and ...}\n" + 
				"\\date{\\today}\n" + 
				"\n" + 
				"\\maketitle\n" + 
				"\n" + 
				"\\section{Section Title 1}\n" + 
				"\n" + 
				"\\section{Section Title 2}\n" + 
				"\n" + 
				"\\section{Section Title.....}\n" + 
				"\n" + 
				"\\section{Conclusion}\n" + 
				"\n" + 
				"\\section*{References}\n" + 
				"\n" + 
				"\\end{document}\n";
		
		createCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test creation of article: ", articleContents, documentContents);
		
	}
	@Test
	void testReport() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		
		latexEditorView.setDocumentType("report");
		
		String reportContents = "\\documentclass[11pt,a4paper]{report}\n" + 
				"\n" + 
				"\\begin{document}\n" + 
				"\\title{Report Template: How to Structure a LaTeX Document}\n" + 
				"\\author{Author1 \\and Author2 \\and ...}\n" + 
				"\\date{\\today}\n" + 
				"\\maketitle\n" + 
				"\n" + 
				"\\begin{abstract}\n" + 
				"Your abstract goes here...\n" + 
				"...\n" + 
				"\\end{abstract}\n" + 
				"\n" + 
				"\\chapter{Introduction}\n" + 
				"\\section{Section Title 1}\n" + 
				"\\section{Section Title 2}\n" + 
				"\\section{Section Title.....}\n" + 
				"\n" + 
				"\\chapter{....}\n" + 
				"\n" + 
				"\\chapter{Conclusion}\n" + 
				"\n" + 
				"\n" + 
				"\\chapter*{References}\n" + 
				"\n" + 
				"\\end{document}\n";
		
		createCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test creation of report: ", reportContents, documentContents);
		
	}
	@Test
	void testLetter() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		
		latexEditorView.setDocumentType("letter");
		
		String letterContents = "\\documentclass{letter}\n" + 
				"\\usepackage{hyperref}\n" + 
				"\\signature{Sender's Name}\n" + 
				"\\address{Sender's address...}\n" + 
				"\\begin{document}\n" + 
				"\n" + 
				"\\begin{letter}{Destination address....}\n" + 
				"\\opening{Dear Sir or Madam:}\n" + 
				"\n" + 
				"I am writing to you .......\n" + 
				"\n" + 
				"\n" + 
				"\\closing{Yours Faithfully,}\n" + 
				"\n" + 
				"\\ps\n" + 
				"\n" + 
				"P.S. text .....\n" + 
				"\n" + 
				"\\encl{Copyright permission form}\n" + 
				"\n" + 
				"\\end{letter}\n" + 
				"\\end{document}\n";
		
		createCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test creation of letter: ", letterContents, documentContents);
		
	}
	
	@Test
	void testEmpty() {
		VersionsManager versionsManager = new VersionsManager();
		LatexEditorView latexEditorView = new LatexEditorView(versionsManager);
		versionsManager.setView(latexEditorView);
		DocumentManager documentManager = new DocumentManager();
		CreateCommand createCommand = new CreateCommand(documentManager, versionsManager);
		
		latexEditorView.setDocumentType("empty");
		
		String emptyContents = "";
		
		createCommand.execute();
		String documentContents = versionsManager.getCurrentVersion().getContents();
		assertEquals("Test creation of empty: ", emptyContents, documentContents);
		
	}
}
