package GUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConsolPanel extends JPanel {

	public ConsolPanel() {
		this.setLayout(new GridLayout(2, 0,0,1));
		this.setVisible(true);
		this.setSize(1950,1000);
		this.setBackground(Color.green);
		
		addTextarea();
	}

	private void addTextarea() {
		JTextArea ta = new JTextArea("adas");
		JScrollPane sc = new JScrollPane(ta);
		sc.setSize(2000,500);
		ta.setVisible(true);
		this.add(sc);
	}


}
