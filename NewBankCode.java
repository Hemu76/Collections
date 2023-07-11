package project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.time.Period;
public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Reader f1 = new FileReader("C:\\Users\\USER\\eclipse-workspace\\Java Programming\\src\\Files\\AccountDetails.txt");
		Reader f2 = new FileReader("C:\\Users\\USER\\eclipse-workspace\\Java Programming\\src\\Files\\TransactionDetails.txt");
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
		Collections.sort(at,new Comparator<Transactions>() {
			public int compare(Transactions t1,Transactions t2) {
				return t1.getTrans_date().compareTo(t2.getTrans_date());
			}
		});
		ArrayList<Accounts> ac = getAllAccounts(aa);
		for (Accounts z : ac) {
			System.out
					.println(z.getAcc_no() + " " + z.getAcc_type() + " " + z.getAcc_open_date() + " " + z.getAcc_bal());
		}
		ArrayList<Transactions> atr = getAccountTransactions(at, ac.get(0));
		for (Transactions tr : atr) {
			System.out.println(tr.getTrans_id() + " " + tr.getAcc_no() + " " + tr.getTrans_date() + " "
					+ tr.getTrans_type() + " " + tr.getTrans_amt());
		}
		System.out.println("Balance on date: " + getBalanceOnDate(at, aa.get(0), LocalDate.parse("2023-02-19")));
		System.out.println("Minimum balance of month: " + getMinBalance(at, aa.get(0), LocalDate.parse("2023-04-12")));
		System.out.println("Rate of Interest: " + getInterest(at, aa.get(0)));
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
						bal -= att.get(i).getTrans_amt();
					} else {
						bal += att.get(i).getTrans_amt();
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
		if(m.getMonth().compareTo(a.getAcc_open_date().getMonth())==0){
			return getBalanceOnDate(tr, a, m);
		}
		LocalDate mm = LocalDate.of(m.getYear(), m.getMonthValue() , 10);
		double bal = getBalanceOnDate(tr, a, mm);
		double min = getBalanceOnDate(tr, a, mm);
		//System.out.println(bal+"Helloo");

		double minn = 0;
		int flag=0;
		ArrayList<Transactions> att = getAccountTransactions(tr, a);
		for (int i = 0; i < att.size(); i++) {
			if (att.get(i).getTrans_date().getMonthValue() == m.getMonthValue() 
					&& att.get(i).getTrans_date().getYear() == m.getYear() && m.getDayOfMonth()>10) {
				if (att.get(i).getTrans_type().equals("withdraw")) {
					min += att.get(i).getTrans_amt();
				} else {
					min -= att.get(i).getTrans_amt();
				}
			}
			if (min < bal) {
				flag=1;
				minn = min;
			}
		}
		//System.out.println(bal+" c"+minn+"vv"+min);
		if(flag==1) {
			return Math.min(bal, minn);
		}
		return bal;
	}

	public static double getInterest(ArrayList<Transactions> tr, Accounts a) {
		LocalDate l = LocalDate.now();
		LocalDate l1=l;
		double rate = 4.5 / 6;
		double interest=0;
		double prince_amt=0;
		int n=1;
		Period period=Period.between(a.getAcc_open_date(),l);
		int diff=(int) period.toTotalMonths();
		while(n<=6) {
			if(a.getAcc_open_date().getDayOfMonth()<=10 && a.getAcc_open_date().compareTo(l1) <= 0 ) {
				prince_amt = getMinBalance(tr, a, l);
				System.out.println(prince_amt+" "+l.getMonthValue());
				interest += ((prince_amt * rate) / 1200);
				l=l.minusMonths(1);
				//System.out.println(interest+"hello");
				if((diff+1)==n) {
					break;
				}
			}
			else if(a.getAcc_open_date().getDayOfMonth()>10 && a.getAcc_open_date().compareTo(l1) <= 0 ){
				prince_amt = getMinBalance(tr, a, l);
				interest += (prince_amt * rate) / 1200;
				l=l.minusMonths(1);
				//System.out.println(interest+"hello");
				if(diff==n) {
					break;
				}
			}
			else {
				prince_amt = getMinBalance(tr, a, l);
				interest += (prince_amt * rate) / 1200;
				l=l.minusMonths(1);
			}
			n++;
		}
		return interest;
	}
}
