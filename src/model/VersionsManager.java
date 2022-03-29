package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import model.strategies.VersionsStrategy;
import view.LatexEditorView;

public class VersionsManager {
	private boolean enabled;
	private VersionsStrategy strategy;
	private LatexEditorView view;
	private Document currentDocument;
	
	private HashMap<String, String> latexCommands;
	
	public VersionsManager() {
		super();
		latexCommands = new HashMap<String, String>();
		latexCommands.put("chapter", "\\chapter{...}");
		latexCommands.put("section", "\\section{}");
		latexCommands.put("subsection", "\\subsection{}");
		latexCommands.put("subsubsection", "\\subsubsection{}");
		
		String contents = "\\begin{itemize}\n" + 
				"\\item ...\n" + 
				"\\item ...\n" + 
				"\\end{itemize}\n";
		latexCommands.put("itemize", contents);
		
		contents = "\\begin{enumerate}\n" + 
				"\\item ...\n" + 
				"\\item ...\n" + 
				"\\end{enumerate}\n";
		latexCommands.put("enumerate", contents);
		
		contents = "\\begin{table}\n" + 
				"\\caption{....}\\label{...}\n" + 
				"\\begin{tabular}{|c|c|c|}\n" + 
				"  \\hline\n" + 
				"... &...&...\\\\\n" + 
				"... &...&...\\\\\n" + 
				"... &...&...\\\\\n" + 
				"  \\hline\n" + 
				"\\end{tabular}\n" + 
				"\\end{table}\n";
		latexCommands.put("table", contents);
		
		contents = "\\begin{figure}\n" + 
				"\\includegraphics[width=...,height=...]{...}\n" + 
				"\\caption{....}\\label{...}\n" + 
				"\\end{figure}\n";
		latexCommands.put("figure", contents);
	}

	public void setView(LatexEditorView view) {
		this.view = view;
	}
	public LatexEditorView getView() {
		return view;
	}
	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}
	
	public void disable() {
		enabled = false;
	}

	public void setStrategy(VersionsStrategy strategy) {
		this.strategy = strategy;
	}
	
	public VersionsStrategy getStrategy() {
		return strategy;
	}

	public Document getCurrentVersion() {
		return currentDocument;
	}	
	public void setCurrentVersion(Document document) {
		currentDocument = document;
	}
	
	public Document getPreviousVersion() {
		if(strategy == null)
			return null;
		return strategy.getVersion();
	}
	
	public void rollbackToPreviousVersion() {
		
	}

	public String getLatexCommand() {
		// TODO Auto-generated method stub
		String latexCommand = view.getLatexCommand();
		
		return latexCommands.get(latexCommand);
	}
	
	public void loadDocument() {
		String filename = view.getFilename();
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			Scanner scanner = new Scanner(fileInputStream);
			
			String contents = "";
			String firstLine = "";
			if(scanner.hasNextLine()) {
				firstLine = scanner.nextLine();
				contents = firstLine + "\n";
			}
			while(scanner.hasNextLine()) {
				contents = contents + scanner.nextLine() + "\n";
			}
			
			scanner.close();
			
			currentDocument = new Document();
			currentDocument.setContents(contents);
			if(firstLine.endsWith("{letter}")) {
				view.setDocumentType("letter");
			}
			else if(firstLine.endsWith("{article}")) {
				view.setDocumentType("article");
			}
			else if(firstLine.endsWith("{book}")) {
				view.setDocumentType("book");
			}
			else if(firstLine.endsWith("{report}")) {
				view.setDocumentType("report");
			}
			else {
				view.setDocumentType("empty");
			}

				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void makeStrategy(String historyType) {
		// TODO Auto-generated method stub
		
	}
	
	
}
