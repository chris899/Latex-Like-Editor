package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DocumentManager {

	private HashMap<String, Document> templates;
	
	public DocumentManager() {
		// TODO Auto-generated constructor stub
		templates = new HashMap<String, Document>();
		
		Document article = createArticle();
		templates.put("article", article);
		
		Document book = createBook();
		templates.put("book", book);
		
		Document report = createReport();
		templates.put("report", report);
		
		Document letter = createLetter();
		templates.put("letter", letter);
		
		Document empty = new Document();
		empty.setContents("");
		templates.put("empty", empty);
	}
	
	public Document createDocument(String template) {
		
		return templates.get(template).clone();
	}
	public Document createBook() {
		Document book = new Document();
		String contents = readFromFile("tex-templates/book-template.tex");
		book.setContents(contents);
		return book;
	}
	public Document createReport() {
		Document report = new Document();
		String contents = readFromFile("tex-templates/report-template.tex");
		report.setContents(contents);
		return report;
	}
	
	public Document createArticle() {
		Document article = new Document();
		String contents = readFromFile("tex-templates/article-template.tex");
		article.setContents(contents);
		return article;
	}
	
	public Document createLetter() {
		Document letter = new Document();
		String contents = readFromFile("tex-templates/letter-template.tex");;
		letter.setContents(contents);
		return letter;
	}
	public String readFromFile(String filename) {
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
			return contents;
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
