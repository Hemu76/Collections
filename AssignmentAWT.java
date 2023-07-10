
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Main {
	static int k = 0;
	static int index;
	static String x1;
	static String x2;
	static String x3;
	static String x4;
	static String x5;

	public int incr() {
		return k++;
		// System.out.println(k);
	}

	public int decr() {
		return k--;
	}

	public static void main(String[] args) throws Exception {
		File f_src = new File("D:\\TEST1\\JavaCollections\\TextFiles\\hey.txt");
		FileReader reader = new FileReader(f_src);
		BufferedReader br = new BufferedReader(reader);
		ArrayList<Employee> AE = new ArrayList<>();
		String str;
		String[] s = new String[5];
		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str, ",");
			int i = 0;
			while (st.hasMoreTokens()) {
				s[i] = st.nextToken();
				i++;
			}
			AE.add(new Employee(s[0], s[1], s[2], s[3], s[4]));
		}
		Frame f = new Frame();
		f.setBackground(Color.yellow);
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
		t1.setBounds(250, 100, 170, 30);
		t2.setBounds(250, 140, 170, 30);
		t3.setBounds(250, 180, 170, 30);
		t4.setBounds(250, 220, 170, 30);
		t5.setBounds(250, 260, 170, 30);
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
		t1.setText(AE.get(0).getE_no());
		t2.setText(AE.get(0).getName());
		t3.setText(AE.get(0).getJob());
		t4.setText(AE.get(0).getSal());
		t5.setText(AE.get(0).getDept());
		// First
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(AE.get(0).getE_no());
				t2.setText(AE.get(0).getName());
				t3.setText(AE.get(0).getJob());
				t4.setText(AE.get(0).getSal());
				t5.setText(AE.get(0).getDept());
			}
		});
		// Next
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				try {
					int x = m.incr();
					if (x < AE.size() && x >= 0) {
						t1.setText(AE.get(x).getE_no());
						t2.setText(AE.get(x).getName());
						t3.setText(AE.get(x).getJob());
						t4.setText(AE.get(x).getSal());
						t5.setText(AE.get(x).getDept());
					}
				} catch (Exception ex) {
					System.out.println(ex.toString());
				}
			}
		});
		// Previous
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m = new Main();
				try {
					int x = m.decr();
					if (x < AE.size() && x >= 0) {
						t1.setText(AE.get(x).getE_no());
						t2.setText(AE.get(x).getName());
						t3.setText(AE.get(x).getJob());
						t4.setText(AE.get(x).getSal());
						t5.setText(AE.get(x).getDept());
					}
				} catch (Exception ex) {
					System.out.println(ex.toString());
				}
			}
		});
		// Last
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText(AE.get(AE.size() - 1).getE_no());
				t2.setText(AE.get(AE.size() - 1).getName());
				t3.setText(AE.get(AE.size() - 1).getJob());
				t4.setText(AE.get(AE.size() - 1).getSal());
				t5.setText(AE.get(AE.size() - 1).getDept());
			}
		});
		// System.out.println(AE.size());
		// Add
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select("Add");
			}
		});
		// System.out.println(AE.size());
		// Edit
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select("Edit");
				x1 = t1.getText();
				x2 = t2.getText();
				x3 = t3.getText();
				x4 = t4.getText();
				x5 = t5.getText();
				for (int i = 0; i < AE.size(); i++) {
					if (AE.get(i).getE_no().equals(x1) && AE.get(i).getName().equals(x2)
							&& AE.get(i).getJob().equals(x3) && AE.get(i).getSal().equals(x4)
							&& AE.get(i).getDept().equals(x5)) {
						index = i;
					}
				}
				System.out.println(index);
			}
		});
		// Delete
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.select("Delete");
				x1 = t1.getText();
				x2 = t2.getText();
				x3 = t3.getText();
				x4 = t4.getText();
				x5 = t5.getText();
			}
		});
		// Save
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (c.getSelectedItem().equals("Edit")) {
					x1 = t1.getText();
					x2 = t2.getText();
					x3 = t3.getText();
					x4 = t4.getText();
					x5 = t5.getText();
					AE.set(index, new Employee(x1, x2, x3, x4, x5));
					for (Employee ee : AE) {
						System.out.println(ee.getE_no() + " " + ee.getName() + " " + ee.getJob() + " " + ee.getSal()
								+ " " + ee.getDept());
					}
				}
				if (c.getSelectedItem().equals("Add")) {
					AE.add(new Employee(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText()));
					System.out.println(AE.size());
					for (Employee ee : AE) {
						System.out.println(ee.getE_no() + " " + ee.getName() + " " + ee.getJob() + " " + ee.getSal()
								+ " " + ee.getDept());
					}
				}
				if (c.getSelectedItem().equals("Delete")) {
					int flag1 = 0;
					for (int i = 0; i < AE.size(); i++) {
						if (AE.get(i).getE_no().equals(x1) && AE.get(i).getName().equals(x2)
								&& AE.get(i).getJob().equals(x3) && AE.get(i).getSal().equals(x4)
								&& AE.get(i).getDept().equals(x5)) {
							AE.remove(AE.get(i));
							flag1 = 1;
						}
					}
					if (flag1 == 0) {
						JOptionPane.showMessageDialog(f, "Data Not Found!!");
					} else {
						JOptionPane.showMessageDialog(f, "Record Deleted Successfully!!");
					}
				}
				try {
					FileWriter FW = new FileWriter(f_src);
					BufferedWriter BW = new BufferedWriter(FW);
					for (Employee ee : AE) {
						BW.write(ee.getE_no() + "," + ee.getName() + "," + ee.getJob() + "," + ee.getSal() + ","
								+ ee.getDept() + "\n");
					}
					BW.flush();
					BW.close();
					FW.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		// Search
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = 1;
				// System.out.println(t1.getText()+" "+t2.getText()+" "+t3.getText()+" "+t4.getText()+" "+t5.getText());
				for (int i = 0; i < AE.size(); i++) {
					if (AE.get(i).getE_no().equals(t1.getText()) || AE.get(i).getName().equals(t2.getText())
							|| AE.get(i).getJob().equals(t3.getText()) || AE.get(i).getSal().equals(t4.getText())
							|| AE.get(i).getDept().equals(t5.getText())) {
						t1.setText(AE.get(i).getE_no());
						t2.setText(AE.get(i).getName());
						t3.setText(AE.get(i).getJob());
						t4.setText(AE.get(i).getSal());
						t5.setText(AE.get(i).getDept());
						flag = 0;
					}
				}
				if (flag == 1) {
					JOptionPane.showMessageDialog(f, "Data Not Found Please check again");
				}
			}
		});
		// Clear
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			}
		});
		// Exit
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

class Employee {
	private String e_no;
	private String name;
	private String job;
	private String sal;
	private String dept;

	public Employee(String e_no, String name, String job, String sal, String dept) {
		this.e_no = e_no;
		this.name = name;
		this.job = job;
		this.sal = sal;
		this.dept = dept;
	}

	public String getE_no() {
		return e_no;
	}

	public void setE_no(String e_no) {
		this.e_no = e_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
