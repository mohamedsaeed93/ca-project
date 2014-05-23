package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1103976722850526189L;
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public MainFrame() {
		this.setSize(dim.width,dim.height);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setActivePanel(PannelManager.getMainPanel());
	}
	
	public void setActivePanel(JPanel p) {
		this.setContentPane(p);
		validate();
	}
	
	public int width() {
		return dim.width;
	}
	
	public int height() {
		return dim.height;
	}
}

