package GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class SidePanel extends JPanel{
	
	public SidePanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.red);
		this.setVisible(true);
		this.setSize(20,20);
	}

}
