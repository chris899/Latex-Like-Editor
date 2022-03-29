package controller.commands;

import java.util.ArrayList;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class CreateCommand implements Command{
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	
	public CreateCommand(DocumentManager documentManager, VersionsManager versionsManager) {
		// TODO Auto-generated constructor stub
		this.documentManager = documentManager;
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Execute create");
		String documentType = versionsManager.getView().getDocumentType();
		Document document = documentManager.createDocument(documentType);
		String name = versionsManager.getView().getDocumentName();
		document.setName(name);
		versionsManager.setCurrentVersion(document);
		if(versionsManager.getStrategy() != null) {
			ArrayList<Document> list = new ArrayList<Document>();
			versionsManager.getStrategy().setEntireHistory(list);
		}
		versionsManager.getView().setFlag(true);
	}
	
	
}
