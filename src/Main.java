import hardwares.Memory;
import hardwares.Register;
import stages.DataPath;

public class Main {
	public static void main(String[] args) throws Exception {
		DataPath.getInstance().start();
		System.out.println("$t0 is " + Register.getValue("$t0"));
		System.out.println("$t1 is " + Register.getValue("$t1"));
		System.out.println("$t2 is " + Register.getValue("$t2"));
//		System.out.println("$t3 is " + Register.getValue("$t3"));
//		System.out.println("Mem is " + Memory.getInstance().getData(10));
		DataPath.getInstance().start2();
		System.out.println("$t0 is " + Register.getValue("$t0"));
		System.out.println("$t1 is " + Register.getValue("$t1"));
		System.out.println("$t2 is " + Register.getValue("$t2"));
//		System.out.println("$t3 is " + Register.getValue("$t3"));
//		System.out.println("Mem is " + Memory.getInstance().getData(10))
	}
}