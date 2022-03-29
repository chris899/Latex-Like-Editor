package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import model.Document;
import model.VersionsManager;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ApplicationWindow {

	/*
	private LatexEditorView latexEditorView;
	private VersionsStrategy versionsStrategy;
	*/
	private String documentType;
	private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	
	private JFrame frame;
	private JMenuItem volatileStrategy = new JMenuItem("Volatile");
	
	private JMenuItem stable = new JMenuItem("Stable");
	private JMenuItem disable = new JMenuItem("Disable");
	private JMenuItem change = new JMenuItem("Change");
	private JMenu help = new JMenu("Help");
	private JMenuItem tips = new JMenuItem("Tips");
	private JMenuItem about = new JMenuItem("About");
	private JMenuItem importFile = new JMenuItem("Import");
	private JMenuItem rollback = new JMenuItem("Rollback");
	private JMenu source = new JMenu("Source");
	private JMenuItem chapter = new JMenuItem("Chapter");
	private JMenuItem section = new JMenuItem("Section");
	private JMenuItem subsection = new JMenuItem("Subsection");
	private JMenuItem subsubsection = new JMenuItem("Subsubsection");
	private JMenu enumerationList = new JMenu("Enumeration List");
	private JMenuItem itemize = new JMenuItem("Itemize");
	private JMenuItem enumerate = new JMenuItem("Enumerate");
	private JMenuItem table = new JMenuItem("Table");
	private JMenuItem figure = new JMenuItem("Figure");
	private JMenu strategy = new JMenu("Strategy");
	private JMenu enable = new JMenu("Enable");
	private JMenuItem disk = new JMenuItem("disk");
	private JMenuItem letter = new JMenuItem("Letter");
	private JMenuItem article = new JMenuItem("Article");
	private JMenuItem book = new JMenuItem("Book");
	private JMenuItem report = new JMenuItem("Report");
	private JMenu file = new JMenu("File");
	private JMenu create = new JMenu("Create");
	private JMenuItem mainMemory = new JMenuItem("Main Memory");
	private JMenu save = new JMenu("Save");
	private JEditorPane editorPane = new JEditorPane();
	private final JMenuItem empty = new JMenuItem("(Empty)");
	private final JMenuItem mntmName = new JMenuItem("Name");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setEnabled(JMenuItem item, boolean enabled) {
		item.setEnabled(enabled);
	}
	
	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();

		versionsManager = new VersionsManager();
		latexEditorView = new LatexEditorView(this.versionsManager);
		versionsManager.setView(latexEditorView);
		/*versionsStrategy = new VolatileVersionsStrategy();
		
		*/
	}
	
	private void setEnabledMenu(String type) {

		setEnabled(save, true);
		setEnabled(source, true);
		setEnabled(strategy, true);
		
		setEnabled(chapter, true);
		setEnabled(section, true);
		setEnabled(subsection, true);
		setEnabled(subsubsection, true);
		setEnabled(enumerate, true);
		setEnabled(itemize, true);
		setEnabled(table, true);
		setEnabled(figure, true);
		if(type.equals("article")) {
			setEnabled(chapter, false);
		}
		else if(type.equals("letter")){
			setEnabled(chapter, false);
			setEnabled(section, false);
			setEnabled(subsection, false);
			setEnabled(subsubsection, false);
			setEnabled(enumerate, false);
			setEnabled(itemize, false);
			setEnabled(table, false);
			setEnabled(figure, false);
		}
		setEnabled(rollback, true);
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 598, 26);
		frame.getContentPane().add(menuBar);
		
		menuBar.add(file);
		file.add(create);
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setDocumentType("report");
				latexEditorView.enact("createCommand");
				setEnabledMenu("report");
				Document document = versionsManager.getCurrentVersion();
				String contents = document.getContents();
				editorPane.setText(contents);
			}

		});
		
		create.add(report);	
		
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setDocumentType("book");
				latexEditorView.enact("createCommand");
				setEnabledMenu("book");
				Document document = versionsManager.getCurrentVersion();
				String contents = document.getContents();
				editorPane.setText(contents);
			}
		});
		create.add(book);	
		
		article.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setDocumentType("article");
				latexEditorView.enact("createCommand");
				setEnabledMenu("article");
				Document document = versionsManager.getCurrentVersion();
				String contents = document.getContents();
				editorPane.setText(contents);
			}
		});
		create.add(article);	
		letter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				latexEditorView.setDocumentType("letter");
				latexEditorView.enact("createCommand");
				setEnabledMenu("letter");
				Document document = versionsManager.getCurrentVersion();
				String contents = document.getContents();
				editorPane.setText(contents);
			}
		});
		
		create.add(letter);
		empty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setDocumentType("empty");
				latexEditorView.enact("createCommand");
				setEnabledMenu("empty");
				Document document = versionsManager.getCurrentVersion();
				String contents = document.getContents();
				editorPane.setText(contents);
			}
		});
		
		create.add(empty);
		
		file.add(save);
		save.add(mainMemory);
		disk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
				int value = chooser.showSaveDialog(null);
				if(value == JFileChooser.APPROVE_OPTION) {
					latexEditorView.setFilename(chooser.getSelectedFile().getAbsolutePath());
					latexEditorView.enact("editCommand");
					latexEditorView.enact("saveCommand");
				}
				
			}
		});
		save.add(disk);
		setEnabled(save, false);
		mainMemory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setEditorPane(editorPane);
				if(versionsManager.isEnabled() && latexEditorView.getFlag()) {
					NameWindow name = new NameWindow(latexEditorView);
				}
				else {
					latexEditorView.enact("editCommand");
				}
			}
		});
		importFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int value = chooser.showOpenDialog(null);
				if(value == JFileChooser.APPROVE_OPTION) {
					latexEditorView.setEditorPane(editorPane);
					latexEditorView.setFilename(chooser.getSelectedFile().getAbsolutePath());
					latexEditorView.enact("loadCommand");
					setEnabledMenu(latexEditorView.getDocumentType());
				}
				
			}
		});
		file.add(importFile);		
		rollback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorView.enact("rollbackCommand");
			}
		});
		file.add(rollback);		
		
		menuBar.add(source);
		chapter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setEditorPane(editorPane);
				latexEditorView.setLatexCommand("chapter");
				latexEditorView.enact("addLatexCommand");
			}
		});
				
		source.add(chapter);
		section.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setEditorPane(editorPane);
				latexEditorView.setLatexCommand("section");
				latexEditorView.enact("addLatexCommand");
			}
		});
		source.add(section);
		subsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setEditorPane(editorPane);
				latexEditorView.setLatexCommand("subsection");
				latexEditorView.enact("addLatexCommand");
			}
		});
		source.add(subsection);
		subsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setEditorPane(editorPane);
				latexEditorView.setLatexCommand("subsubsection");
				latexEditorView.enact("addLatexCommand");
			}
		});
		source.add(subsubsection);
		source.add(enumerationList);
		itemize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setEditorPane(editorPane);
				latexEditorView.setLatexCommand("itemize");
				latexEditorView.enact("addLatexCommand");
			}
		});
		
		enumerationList.add(itemize);
		enumerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setEditorPane(editorPane);
				latexEditorView.setLatexCommand("enumerate");
				latexEditorView.enact("addLatexCommand");
			}
		});
		enumerationList.add(enumerate);
		table.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setEditorPane(editorPane);
				latexEditorView.setLatexCommand("table");
				latexEditorView.enact("addLatexCommand");
			}
		});

		source.add(table);
		figure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setEditorPane(editorPane);
				latexEditorView.setLatexCommand("figure");
				latexEditorView.enact("addLatexCommand");
			}
		});
		source.add(figure);
		
		menuBar.add(strategy);
				
		strategy.add(enable);
		volatileStrategy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setHistoryType("volatile");
				latexEditorView.enact("enableCommand");
			}
		});
		
		enable.add(volatileStrategy);
		stable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setHistoryType("stable");
				latexEditorView.enact("enableCommand");
			}
		});
		enable.add(stable);
		disable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorView.enact("disableCommand");
			}
		});
		
		strategy.add(disable);	
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorView.enact("changeCommand");
			}
		});
		strategy.add(change);
			
		menuBar.add(help);
			
		help.add(tips);	
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editorPane.setText("Prepare for trouble!\n" +
						"And make it double!\n" +
						"To protect the world from devastation!\n" +
						"To unite all peoples within our nation!\n" +
						"To denounce the evils of truth and love!\n" +
						"To extend our reach to the stars above!\n" +
						"Jessie!\n" +
						"James!\n" +
						"Team Rocket blasts off at the speed of\n" +
						"light!\n" +
						"Surrender now, or prepare to fight!\n" +
						"Meowth!");
			}
		});
		help.add(about);
		
		setEnabled(strategy, false);
		setEnabled(source, false);
		setEnabled(rollback, false);
		mntmName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NameWindow name = new NameWindow(latexEditorView);
			}
		});
		
		file.add(mntmName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 588, 409);
		frame.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(editorPane);
		
	}
}
