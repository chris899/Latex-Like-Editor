package model.strategies;

import java.util.List;

import model.Document;

public interface VersionsStrategy {
	public void putVersion(Document doc);
	public Document getVersion();
	public void setEntireHistory(List<Document> list);
	public List<Document> getEntireHistory();
	public void removeVersion();
}
