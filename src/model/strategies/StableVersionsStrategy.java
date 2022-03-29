package model.strategies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Document;

public class StableVersionsStrategy implements VersionsStrategy {
	private Document currentDocument;
	public StableVersionsStrategy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void putVersion(Document doc) {
		// TODO Auto-generated method stub
		//save sti disko
		doc.save();
	}

	@Override
	public Document getVersion() {
		// TODO Auto-generated method stub
		if(currentDocument == null)
			return null;
		String filename = currentDocument.getPreviousVersionName();
		if(filename != null) {
			try {
				FileInputStream fileInputStream = new FileInputStream(filename);
				Scanner scanner = new Scanner(fileInputStream);
				
				String contents = "";
				while(scanner.hasNextLine()) {
					contents = contents + scanner.nextLine() + "\n";
				}
				
				scanner.close();
				
				Document doc = new Document();
				doc.setContents(contents);
				String[] toks = filename.split("_");
				doc.setName(toks[0]);
				String version = toks[1].substring(0, toks[1].length() - 4);
				doc.setVersionID(version);
				
				return doc;
				
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
		
	}

	@Override
	public void setEntireHistory(List<Document> list) {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++) {
			Document doc = list.get(i);
			doc.save();
		}
	}

	@Override
	public List<Document> getEntireHistory() {
		// TODO Auto-generated method stub
		List<Document> list = new ArrayList<Document>();
		ArrayList<String> names = currentDocument.getAllPreviousVersionsNames();
		for(int i = 0; i < names.size(); i++) {
			String filename = names.get(i);
			try {
				FileInputStream fileInputStream = new FileInputStream(filename);
				Scanner scanner = new Scanner(fileInputStream);
				
				String contents = "";
				while(scanner.hasNextLine()) {
					contents = contents + scanner.nextLine() + "\n";
				}
				
				scanner.close();
				
				Document doc = new Document();
				doc.setContents(contents);
				String[] toks = filename.split("_");
				doc.setName(toks[0]);
				String version = toks[1].substring(0, toks[1].length() - 4);
				doc.setVersionID(version);
				
				list.add(doc);
				
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void removeVersion() {
		// TODO Auto-generated method stub

	}

	public void setDocument(Document doc) {
		this.currentDocument = doc;
	}
}
