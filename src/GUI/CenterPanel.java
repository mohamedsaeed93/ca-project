package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CenterPanel extends JPanel {

	public CenterPanel() {
		this.setLayout(new GridLayout(2, 2,0,1));
		this.setVisible(true);
		addTextarea();
		addTextarea2();
	}

	private void addTextarea() {
		JTextArea ta = new JTextArea("adas");
		JScrollPane sc = new JScrollPane(ta);
		System.out.println(this.getHeight());
		sc.setSize(1950-42,(1000));
		ta.setVisible(true);
		this.add(sc);
	
	}
	
	private void addTextarea2() {
		JTextArea tz = new JTextArea("adas");
		JScrollPane sc = new JScrollPane(tz);
		sc.setSize(2000,2000);
		tz.setVisible(true);
		this.add(sc);
	}
}
