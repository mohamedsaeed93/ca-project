package GUI;

import java.awt.BorderLayout;

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
		this.setLayout(new BorderLayout());
		setConfigurations();
	}

	private void setConfigurations() {
		
		add(PannelManager.getSidePanel(), BorderLayout.WEST);
		add(PannelManager.getCenterPanel(), BorderLayout.CENTER);
		add(PannelManager.getConsolPanel(), BorderLayout.EAST);
	}
}
