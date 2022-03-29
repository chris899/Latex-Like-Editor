package model.strategies;

import java.util.ArrayList;
import java.util.List;

import model.Document;

public class VolatileVersionsStrategy implements VersionsStrategy {
	
	private ArrayList<Document> documents;
	
	public VolatileVersionsStrategy() {
		// TODO Auto-generated constructor stub
		documents = new ArrayList<Document>();
	}
	@Override
	public void putVersion(Document doc) {
		// TODO Auto-generated method stub
		documents.add(doc.clone());
	}

	@Override
	public Document getVersion() {
		// TODO Auto-generated method stub
		if(documents.size() == 0)
			return null;
		return documents.get(documents.size() - 1);
	}

	@Override
	public void setEntireHistory(List<Document> list) {
		// TODO Auto-generated method stub
		documents.clear();
		documents.addAll(list);
	}

	@Override
	public List<Document> getEntireHistory() {
		// TODO Auto-generated method stub
		return documents;
	}

	@Override
	public void removeVersion() {
		// TODO Auto-generated method stub
		documents.remove(documents.size() - 1);
	}
}
