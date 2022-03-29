package model;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Document {
	private String author;
	private String date;
	private String copyright;
	private String versionID;
	private String contents;
	private String name;
	
	public Document() {
		author = "omada_pyravlos";
		copyright = "";
		versionID = "v0";
	}
	
	public Document(String author, String date, String copyright, String versionID, String contents, String name) {
		super();
		this.author = author;
		this.date = date;
		this.copyright = copyright;
		this.versionID = versionID;
		this.contents = contents;
		this.name = name;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public void save(String filename) {
		
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter printWriter = new PrintWriter(stream);
		printWriter.write(contents);
		printWriter.close();
	}
	
	public Document clone() {
		return new Document(author, date, copyright, versionID, contents, name);
	}
	
	public void updateVersionId() {
		String id = versionID.substring(1);
		int num = Integer.parseInt(id) + 1;
		versionID = "v"+num;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void save() {
		// TODO Auto-generated method stub
		save(name+"_"+versionID+".tex");
	}

	public String getPreviousVersionName() {
		// TODO Auto-generated method stub
		String id = versionID.substring(1);
		int num = Integer.parseInt(id) - 1;
		if(num >= 0) {
			return name+"_v"+num+".tex";
		}
		return null;
	}

	public void setVersionID(String versionID) {
		// TODO Auto-generated method stub
		this.versionID = versionID;
	}
	
	public ArrayList<String> getAllPreviousVersionsNames(){
		ArrayList<String> names = new ArrayList<String>();
		String id = versionID.substring(1);
		int num = Integer.parseInt(id) - 1;
		while(num >= 0) {
			String previousName =  name+"_v"+num+".tex";
			names.add(previousName);
			num--;
		}
		return names;
	}
}
