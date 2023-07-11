package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Reader f1 = new FileReader("D:\\TEST1\\JavaCollections\\TextFiles\\AccountDetails.txt");
		Reader f2 = new FileReader("D:\\TEST1\\JavaCollections\\TextFiles\\TransactionsDetails.txt");
		BufferedReader br1 = new BufferedReader(f1);
		BufferedReader br2 = new BufferedReader(f2);
		ArrayList<Accounts> aa = new ArrayList<>();
		ArrayList<Transactions> at = new ArrayList<>();
		String str1 = "";
		String str2 = "";
		String[] obj1 = new String[4];
		String[] obj2 = new String[5];
		while ((str1 = br1.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str1, ",");
			int i = 0;
			while (st.hasMoreTokens()) {
				obj1[i] = st.nextToken();
				i++;
			}
			String[] ss = obj1[2].split("-");
			aa.add(new Accounts(Integer.parseInt(obj1[0]), obj1[1],
					LocalDate.of(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2])),
					Double.parseDouble(obj1[3])));
		}
		br1.close();
		while ((str2 = br2.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str2, ",");
			int i = 0;
			while (st.hasMoreTokens()) {
				obj2[i] = st.nextToken();
				i++;
			}
			String[] ss = obj2[2].split("-");
			at.add(new Transactions(Integer.parseInt(obj2[0]), Integer.parseInt(obj2[1]),
					LocalDate.of(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), Integer.parseInt(ss[2])), obj2[3],
					Double.parseDouble(obj2[4])));
		}
		br2.close();
		ArrayList<Accounts> ac = getAllAccounts(aa);
		for (Accounts z : ac) {
			System.out
					.println(z.getAcc_no() + " " + z.getAcc_type() + " " + z.getAcc_open_date() + " " + z.getAcc_bal());
		}
		ArrayList<Transactions> atr = getAccountTransactions(at, ac.get(2));
		for (Transactions tr : atr) {
			System.out.println(tr.getTrans_id() + " " + tr.getAcc_no() + " " + tr.getTrans_date() + " "
					+ tr.getTrans_type() + " " + tr.getTrans_amt());
		}
		System.out.println("Balance on date: " + getBalanceOnDate(at, aa.get(2), LocalDate.parse("2023-02-19")));
		System.out.println("Minimum balance of month: " + getMinBalance(at, aa.get(0), LocalDate.parse("2023-03-12")));
		System.out.println("Rate of Interest: " + getInterest(at, aa.get(0), LocalDate.parse("2023-03-12")));
	}

	public static ArrayList<Accounts> getAllAccounts(ArrayList<Accounts> aa) {
		ArrayList<Accounts> aa1 = new ArrayList<>();
		for (Accounts aa2 : aa) {
			aa1.add(aa2);
		}
		return aa1;
	}

	public static ArrayList<Transactions> getAccountTransactions(ArrayList<Transactions> aa, Accounts a) {
		ArrayList<Transactions> tran = new ArrayList<>();
		for (int i = 0; i < aa.size(); i++) {
			if (aa.get(i).getAcc_no() == a.getAcc_no()) {
				tran.add(aa.get(i));
			}
		}
		return tran;
	}

	public static double getBalanceOnDate(ArrayList<Transactions> at, Accounts a, LocalDate ld) {
		double bal = (double) a.getAcc_bal();
		int flag = 0;
		ArrayList<Transactions> att = getAccountTransactions(at, a);
		for (int i = 0; i < att.size(); i++) {
			if (a.getAcc_open_date().compareTo(ld) <= 0) {
				flag = 1;
				if (att.get(i).getTrans_date().compareTo(ld) <= 0) {
					if (att.get(i).getTrans_type().equals("deposit")) {
						bal += att.get(i).getTrans_amt();
					} else {
						bal -= att.get(i).getTrans_amt();
					}
				}
			}
		}
		if (flag == 0) {
			return -1;
		}
		return bal;
	}

	public static double getMinBalance(ArrayList<Transactions> tr, Accounts a, LocalDate m) {
		int days=m.getMonthValue()-1;
		LocalDate mm = LocalDate.of(m.getYear(), m.getMonthValue() - 1, m.lengthOfMonth());
		double bal = getBalanceOnDate(tr, a, mm);
		double min = (double) a.getAcc_bal();
		double minn = 0;
		ArrayList<Transactions> att = getAccountTransactions(tr, a);
		for (int i = 0; i < att.size(); i++) {
			if (att.get(i).getTrans_date().getMonthValue() == m.getMonthValue()
					&& att.get(i).getTrans_date().getYear() == m.getYear()) {
				if (att.get(i).getTrans_type().equals("deposit")) {
					min += att.get(i).getTrans_amt();
				} else {
					min -= att.get(i).getTrans_amt();
					if (min < bal) {
						minn = min;
					}
				}
			}
		}
		return Math.min(bal, minn);
	}

	public static double getInterest(ArrayList<Transactions> tr, Accounts a, LocalDate month) {
		double prince_amt = getMinBalance(tr, a, month);
		double rate = 4.5 / 6;
		double interest = (prince_amt * rate) / 1200;
		return interest;
	}
}



package project;

import java.time.LocalDate;

public class Accounts {
	private int acc_no;
	private String acc_type;
	private LocalDate acc_open_date;
	private double acc_bal;

	public Accounts(int acc_no, String acc_type, LocalDate acc_open_date, double acc_bal) {
		super();
		this.acc_no = acc_no;
		this.acc_type = acc_type;
		this.acc_open_date = acc_open_date;
		this.acc_bal = acc_bal;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public LocalDate getAcc_open_date() {
		return acc_open_date;
	}

	public void setAcc_open_date(LocalDate acc_open_date) {
		this.acc_open_date = acc_open_date;
	}

	public double getAcc_bal() {
		return acc_bal;
	}

	public void setAcc_b(double acc_bal) {
		this.acc_bal = acc_bal;
	}
}


package project;

import java.time.LocalDate;

public class Transactions {
	private int trans_id;
	private int acc_no;
	private LocalDate trans_date;
	private String trans_type;
	private double trans_amt;

	public Transactions(int trans_id, int acc_no, LocalDate trans_date, String trans_type, double trans_amt) {
		super();
		this.trans_id = trans_id;
		this.acc_no = acc_no;
		this.trans_date = trans_date;
		this.trans_type = trans_type;
		this.trans_amt = trans_amt;
	}

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public LocalDate getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(LocalDate trans_date) {
		this.trans_date = trans_date;
	}

	public String getTrans_type() {
		return trans_type;
	}

	public void setAcc_type(String acc_type) {
		this.trans_type = acc_type;
	}

	public double getTrans_amt() {
		return trans_amt;
	}

	public void setTrans_amt(double trans_amt) {
		this.trans_amt = trans_amt;
	}
}


1,Savings,2023-02-11,50000
2,Savings,2022-02-11,60000
3,Savings,2023-01-11,70000
4,Savings,2021-02-15,80000


11,1,2023-03-10,deposit,10000
12,1,2023-03-12,withdraw,50000
13,2,2023-02-10,deposit,5000
14,2,2023-02-12,withdraw,10000
15,3,2023-02-10,deposit,10000
16,3,2023-02-12,withdraw,20000
17,4,2023-04-10,deposit,17000
18,4,2023-04-12,withdraw,18000
