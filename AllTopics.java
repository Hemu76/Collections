package Collections;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GenTh {
	public static void main(String[] args) throws Exception {
		File f = new File("D:\\TEST1\\JavaCollections\\TextFiles\\hey.txt");
		FileInputStream fr = new FileInputStream(f);
		BufferedInputStream bi = new BufferedInputStream(fr);
		int i;
		ArrayList<Employees> ae = new ArrayList<>();
		String[] ss = new String[5];
		int j = 0;
		String s = "";
		while ((i = bi.read()) != -1) {
			// System.out.println((char) i);
			if ((char) i != '\n') {
				if ((char) i == ',') {
					ss[j] = s;
					s = "";
					j++;
				} else {
					s += (char) i;
				}
			} else {
				// System.out.println(s);
				s = "";
				j = 0;
				ae.add(new Employees(ss[0], ss[1], ss[2], ss[3], ss[4]));
			}
		}
		System.out.println(ae.size());
		for (Employees ee : ae) {
			System.out.println(ee.getE_no() + " " + ee.getName() + " " + ee.getSal());
		}
		Collections.sort(ae, new Comparator<Employees>() {
			@Override
			public int compare(Employees o1, Employees o2) {
				// TODO Auto-generated method stub
				return o1.getE_no().compareTo(o2.getE_no());
			}
		});
		Collections.sort(ae);
		salAdd drr = (ArrayList<Employees> aa) -> {
			int ii = 0;
			double sal = 0;
			while (ii < ae.size()) {
				sal += Double.parseDouble(ae.get(ii).getSal());
				ii++;
			}
			return sal;
		};
		// System.out.println(drr.saladd(ae));
		shd<Employees> sas = new shd<>();
		ArrayList<Employees> aee = sas.ppp(ae);
		for (Employees ee : aee) {
			System.out.println(ee.getE_no() + " " + ee.getName() + " " + ee.getSal() + "rt54t543");
		}
		System.out.println(aee.size());
	}
}

interface salAdd {
	public double saladd(ArrayList<Employees> aa);
}

class shd<T extends Employees> {
	public ArrayList<Employees> ppp(ArrayList<? extends Employees> ee) {
		ArrayList<Integer> zz = new ArrayList<>();
		ArrayList<Employees> E = new ArrayList<>();
		for (int i = 0; i < ee.size(); i++) {
			if (ee.get(i).getE_no().charAt(0) == 'e') {
				E.add(ee.get(i));
			}
			// System.out.println(ee.get(i).getE_no().charAt(0) + " " + ee.size());
		}
		System.out.println(zz.size() + "hello");
		System.out.println(ee.size() + "hhello");
		return (ArrayList<Employees>) E;
	}
}

class Employees<T> implements Comparable<Employees> {
	private String e_no;
	private String name;
	private String job;
	private String sal;
	private String dept;

	public Employees(String e_no, String name, String job, String sal, String dept) {
		this.e_no = e_no;
		this.name = name;
		this.job = job;
		this.sal = sal;
		this.dept = dept;
	}

	public int compareTo(Employees e) {
		return this.getSal().compareTo(e.getSal());
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
