import hardwares.Register;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import stages.DataPath;
import exception.NoSuchRegisterException;
import exception.SyntaxErrorException;

public class Main extends JFrame implements ActionListener

{
	JButton run = new JButton("Run");
	JCheckBox myCheckBox = new JCheckBox("pipelined");
	JTextArea code_area = new JTextArea("");
	JTextArea console_area = new JTextArea("");
	JPanel bottomPanel = new JPanel();
	JPanel holdAll = new JPanel();
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public Main() {
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(myCheckBox);
		bottomPanel.add(run);

		holdAll.setLayout(new BorderLayout());
		holdAll.add(bottomPanel, BorderLayout.SOUTH);
		JScrollPane sc = new JScrollPane(code_area);
		holdAll.add(sc, BorderLayout.NORTH);
		console_area.setEditable(false);
		console_area.setBackground(new Color(227,227,227));
		holdAll.add(console_area, BorderLayout.CENTER);

		getContentPane().add(holdAll, BorderLayout.CENTER);

		run.addActionListener(this);
		myCheckBox.addActionListener(this);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		Main myApplication = new Main();

		myApplication.setLocation(10, 10);
		myApplication.setSize(300, 300);

		myApplication.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == run){
			String instructions = code_area.getText();
			PrintWriter writer;
			try {
				writer = new PrintWriter("Instructions", "UTF-8");
				writer.println(instructions);
				writer.flush();
				writer.close();
			} catch (FileNotFoundException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (UnsupportedEncodingException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			if (myCheckBox.isSelected())
			{
				System.err.println("pipelined");
				try {
					DataPath.getInstance().PiplineStart(0);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SyntaxErrorException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try {
					console_area.append("$t0 is " + Register.getValue("$t0") +"\n");
					console_area.append("$t1 is " + Register.getValue("$t1") +"\n");
					console_area.append("$t2 is " + Register.getValue("$t2") +"\n");	
				} catch (NoSuchRegisterException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}else {
				System.err.println("non-pipelined");
				try {
					try {
						DataPath.getInstance().start(0);
					} catch (SyntaxErrorException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					console_area.append("$t0 is " + Register.getValue("$t0") +"\n");
					console_area.append("$t1 is " + Register.getValue("$t1") +"\n");
					console_area.append("$t2 is " + Register.getValue("$t2") +"\n");	
				} catch (NoSuchRegisterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

}