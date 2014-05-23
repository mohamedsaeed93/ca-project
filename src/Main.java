import hardwares.Register;
import stages.DataPath;
import utilities.SyntaxChecker;

public class Main {
	public static void main(String[] args) throws Exception {
		String s = "addi $t1, $t0, -2";
//		System.out.println(SyntaxChecker.checkINo(s));
		DataPath.getInstance().PiplineStart();
		System.out.println("$t0 is " + Register.getValue("$t0"));
		System.out.println("$t1 is " + Register.getValue("$t1"));
		System.out.println("$t2 is " + Register.getValue("$t2"));
		// System.out.println("$t3 is " + Register.getValue("$t3"));
		// System.out.println("Mem is " + Memory.getInstance().getData(10));
		DataPath.getInstance().start();
		System.out.println("$t0 is " + Register.getValue("$t0"));
		System.out.println("$t1 is " + Register.getValue("$t1"));
		System.out.println("$t2 is " + Register.getValue("$t2"));
		// System.out.println("$t3 is " + Register.getValue("$t3"));
		// System.out.println("Mem is " + Memory.getInstance().getData(10))
	}
}