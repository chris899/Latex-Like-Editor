package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NameWindow {

	private JFrame frame;
	private JTextField textField;
	private LatexEditorView latexEditorView;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public NameWindow(LatexEditorView latexEditorView) {
		// TODO Auto-generated constructor stub
		this.latexEditorView = latexEditorView;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGiveName = new JLabel("Give name");
		lblGiveName.setBounds(71, 28, 162, 16);
		frame.getContentPane().add(lblGiveName);
		
		textField = new JTextField();
		textField.setBounds(52, 57, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText();
				if(name.length() == 0)
					return;
				latexEditorView.setDocumentName(name);
				latexEditorView.enact("editCommand");
				latexEditorView.setFlag(false);
				frame.dispose();
			}
		});
		btnOk.setBounds(71, 121, 97, 25);
		frame.getContentPane().add(btnOk);
	}
}
