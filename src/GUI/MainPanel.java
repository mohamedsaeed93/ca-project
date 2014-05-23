package GUI;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3025476416329513174L;
	private JTextArea ta;
	JScrollPane taS;

	public MainPanel() {
		this.setVisible(true);
		GridLayout layout = new GridLayout();
		layout.setRows(1);
		layout.setColumns(3);
		this.setLayout(new GridLayout(1, 3));
		setConfigurations();
	}

	private void setConfigurations() {
		add(PannelManager.getSidePanel());
		addTextField();
	}

	private void addTextField() {
		
		JTextArea userField = new JTextArea("User:");
        userField.setEditable(false);
        add(userField);
	}
}
