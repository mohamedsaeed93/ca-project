import hardwares.Register;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.JTable;
import javax.swing.JTextArea;

import stages.DataPath;
import exception.NoSuchRegisterException;
import exception.SyntaxErrorException;

public class Main extends JFrame implements ActionListener {
	
	JButton run = new JButton("Run");
	JCheckBox myCheckBox = new JCheckBox("pipelined");
	JTextArea code_area = new JTextArea();
	JTextArea console_area = new JTextArea();
	JPanel bottomPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	JPanel holdAll = new JPanel();
	JTable table = new JTable();
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	public Main() throws NoSuchRegisterException {
		this.setSize(dim.width,dim.height);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(myCheckBox);
		bottomPanel.add(run);

		getContentPane().add(holdAll, BorderLayout.CENTER);
		
		table = redraw(table);
		table.setFillsViewportHeight(true);		

		rightPanel.setLayout(new BorderLayout());
		table.setBackground(new Color(245,245,245));
		rightPanel.add(table);
		
		console_area.setBackground(new Color(240,240,240));
		console_area.setEditable(false);
		leftPanel.setLayout(new GridLayout(2,1,0,10));
		leftPanel.add(code_area);
		leftPanel.add(console_area);
		holdAll.setLayout(new BorderLayout());
		holdAll.add(rightPanel, BorderLayout.EAST);
		holdAll.add(leftPanel, BorderLayout.CENTER);
		holdAll.add(bottomPanel, BorderLayout.SOUTH);

		run.addActionListener(this);
		myCheckBox.addActionListener(this);
	}

	private JTable redraw(JTable table2) throws NoSuchRegisterException {
		String[] columnNames = {"Name",
        "Value"};
			Object[][] data = {
				    {"$0", Register.getValue("$0"),},
				    {"$v0", Register.getValue("$v0"),},
				    {"$v1", Register.getValue("$v1"),},
				    {"$a0", Register.getValue("$a0"),},
				    {"$a1", Register.getValue("$a1"),},
				    {"$a2", Register.getValue("$a2"),},
				    {"$t0", Register.getValue("$t0"),},
				    {"$t1", Register.getValue("$t1"),},
				    {"$t2", Register.getValue("$t2"),},
				    {"$t3", Register.getValue("$t3"),},
				    {"$t4", Register.getValue("$t4"),},
				    {"$t5", Register.getValue("$t5"),},
				    {"$t6", Register.getValue("$t6"),},
				    {"$t7", Register.getValue("$t7"),},
				    {"$t8", Register.getValue("$t8"),},
				    {"$t9", Register.getValue("$t9"),},
				    {"$s0", Register.getValue("$s0"),},
				    {"$s1", Register.getValue("$s1"),},
				    {"$s2", Register.getValue("$s2"),},
				    {"$s3", Register.getValue("$s3"),},
				    {"$s4", Register.getValue("$s4"),},
				    {"$s5", Register.getValue("$s5"),},
				    {"$s6", Register.getValue("$s6"),},
				    {"$s7", Register.getValue("$s7"),},
				    {"$gp", Register.getValue("$gp"),},
				    {"$sp", Register.getValue("$sp"),},
				    {"$fp", Register.getValue("$fp"),},
			};
			
					table = new JTable(data, columnNames);
	return table;		
	}
	
	
	private void print(PrintWriter writer,String messege) {
		try {
			writer = new PrintWriter("Instructions", "UTF-8");
			writer.println(messege);
			writer.flush();
		} catch (FileNotFoundException e3) {
			e3.printStackTrace();
		} catch (UnsupportedEncodingException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == run){
			String instructions = code_area.getText();
			PrintWriter writer = null;
			print(writer,instructions);
			
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
				console_area.setText(null);
				console_area.append("compilation successful\n");
				try {
					Object[][] data = {
						    {"$0", Register.getValue("$0"),},
						    {"$v0", Register.getValue("$v0"),},
						    {"$v1", Register.getValue("$v1"),},
						    {"$a0", Register.getValue("$a0"),},
						    {"$a1", Register.getValue("$a1"),},
						    {"$a2", Register.getValue("$a2"),},
						    {"$t0", Register.getValue("$t0"),},
						    {"$t1", Register.getValue("$t1"),},
						    {"$t2", Register.getValue("$t2"),},
						    {"$t3", Register.getValue("$t3"),},
						    {"$t4", Register.getValue("$t4"),},
						    {"$t5", Register.getValue("$t5"),},
						    {"$t6", Register.getValue("$t6"),},
						    {"$t7", Register.getValue("$t7"),},
						    {"$t8", Register.getValue("$t8"),},
						    {"$t9", Register.getValue("$t9"),},
						    {"$s0", Register.getValue("$s0"),},
						    {"$s1", Register.getValue("$s1"),},
						    {"$s2", Register.getValue("$s2"),},
						    {"$s3", Register.getValue("$s3"),},
						    {"$s4", Register.getValue("$s4"),},
						    {"$s5", Register.getValue("$s5"),},
						    {"$s6", Register.getValue("$s6"),},
						    {"$s7", Register.getValue("$s7"),},
						    {"$gp", Register.getValue("$gp"),},
						    {"$sp", Register.getValue("$sp"),},
						    {"$fp", Register.getValue("$fp"),},
					};
					String[] columnNames = {"Name",
	                "Value"};
					rightPanel.remove(table);
					table = new JTable(data, columnNames);
					rightPanel.add(table);
					rightPanel.repaint();

				} catch (NoSuchRegisterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
				console_area.setText(null);
				console_area.append("compilation successful\n");
				try {
					Object[][] data = {
						    {"$0", Register.getValue("$0"),},
						    {"$v0", Register.getValue("$v0"),},
						    {"$v1", Register.getValue("$v1"),},
						    {"$a0", Register.getValue("$a0"),},
						    {"$a1", Register.getValue("$a1"),},
						    {"$a2", Register.getValue("$a2"),},
						    {"$t0", Register.getValue("$t0"),},
						    {"$t1", Register.getValue("$t1"),},
						    {"$t2", Register.getValue("$t2"),},
						    {"$t3", Register.getValue("$t3"),},
						    {"$t4", Register.getValue("$t4"),},
						    {"$t5", Register.getValue("$t5"),},
						    {"$t6", Register.getValue("$t6"),},
						    {"$t7", Register.getValue("$t7"),},
						    {"$t8", Register.getValue("$t8"),},
						    {"$t9", Register.getValue("$t9"),},
						    {"$s0", Register.getValue("$s0"),},
						    {"$s1", Register.getValue("$s1"),},
						    {"$s2", Register.getValue("$s2"),},
						    {"$s3", Register.getValue("$s3"),},
						    {"$s4", Register.getValue("$s4"),},
						    {"$s5", Register.getValue("$s5"),},
						    {"$s6", Register.getValue("$s6"),},
						    {"$s7", Register.getValue("$s7"),},
						    {"$gp", Register.getValue("$gp"),},
						    {"$sp", Register.getValue("$sp"),},
						    {"$fp", Register.getValue("$fp"),},
					};
					String[] columnNames = {"Name",
	                "Value"};
					rightPanel.remove(table);
					table = new JTable(data, columnNames);
					rightPanel.add(table);
					rightPanel.repaint();

					
				} catch (NoSuchRegisterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
	
	public static void main(String[] args) throws NoSuchRegisterException {
		 new Main();
	}

}