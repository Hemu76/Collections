package AWT;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Awt extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) throws Exception {
		InputStream stream = new FileInputStream("D:\\TEST1\\JavaCollections\\TextFiles\\hey.txt");
		Reader reader = new InputStreamReader(stream);
		Frame f = new Frame();
		f.setBackground(Color.gray);
		f.setVisible(true);
		f.setLayout(null);
		f.setSize(700, 700);
		f.setTitle("Employee");
		Choice c = new Choice();
		c.add("Add");
		c.add("Edit");
		c.add("Delete");
		c.setBounds(600, 50, 50, 100);
		Button b1 = new Button("First");
		Button b2 = new Button("Next");
		Button b3 = new Button("Prev");
		Button b4 = new Button("Last");
		Button b5 = new Button("Add");
		Button b6 = new Button("Edit");
		Button b7 = new Button("Delete");
		Button b8 = new Button("Save");
		Button b9 = new Button("Search");
		Button b10 = new Button("Clear");
		Button b11 = new Button("Exit");
		b1.setBounds(100, 300, 50, 30);
		b2.setBounds(200, 300, 50, 30);
		b3.setBounds(300, 300, 50, 30);
		b4.setBounds(400, 300, 50, 30);
		b5.setBounds(100, 340, 50, 30);
		b6.setBounds(200, 340, 50, 30);
		b7.setBounds(300, 340, 50, 30);
		b8.setBounds(400, 340, 50, 30);
		b9.setBounds(150, 380, 50, 30);
		b10.setBounds(250, 380, 50, 30);
		b11.setBounds(350, 380, 50, 30);
		// ----------------------------------------------
		Label l1 = new Label("Employee Number");
		Label l2 = new Label("Employee Name  ");
		Label l3 = new Label("Employee Job   ");
		Label l4 = new Label("Employee Salary");
		Label l5 = new Label("Employee Dept  ");
		l1.setBounds(100, 100, 120, 30);
		l2.setBounds(100, 140, 120, 30);
		l3.setBounds(100, 180, 120, 30);
		l4.setBounds(100, 220, 120, 30);
		l5.setBounds(100, 260, 120, 30);
		// ----------------------------------------------
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		TextField t5 = new TextField();
		t1.setBounds(200, 100, 200, 30);
		t2.setBounds(200, 140, 200, 30);
		t3.setBounds(200, 180, 200, 30);
		t4.setBounds(200, 220, 200, 30);
		t5.setBounds(200, 260, 200, 30);
		// ----------------------------------------------
		f.add(c);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.add(b10);
		f.add(b11);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	}
}
