package utilities;

import exception.SyntaxErrorException;

public class SyntaxChecker {

	private static String space = "(\\s*)";
	private static String labeled = space + "(([a-zA-Z]+:)?)" + space;
	private static String label = space + "([a-zA-Z]+)" + space;
	private static String v = "(\\$v[0-1])";
	private static String a = "(\\$a[0-3])";
	private static String t = "(\\$t\\d)";
	private static String s = "(\\$s[0-7])";
	private static String po = "(\\$[gsf]p)";
	private static String r = "(\\$ra)";
	private static String zero = "(\\$0)";
	private static String comment = space + "(//.*)?";
	private static String reg = String.format("(%s(%s|%s|%s|%s|%s|%s|%s)%s)",
			space, v, a, t, zero, s, po, r, space);
	private static String slw = space + "\\d+\\(" + reg + "\\)" + space;

	private SyntaxChecker() {
	}

	public static void check(String code) throws SyntaxErrorException {
		boolean res = checkw(code) || checkILabel(code) || checkINo(code);
		res = res || checkJ(code) || checkJLabel(code) || checkR(code);
		res = res || LabeledOnly(code);
		if (!res)
			throw new SyntaxErrorException("There is a syntax error in " + code);
	}

	public static boolean checkw(String code) {
		String opcode = "((sw)|(lw))";
		String check = labeled + opcode + reg + "," + slw + comment;
		return code.matches(check);
	}

	public static boolean checkILabel(String code) {
		String opcode = "((beq)|(bne))";
		String check = labeled + opcode + reg + "," + reg + "," + label
				+ comment;
		return code.matches(check);
	}

	public static boolean checkINo(String code) {
		String opcode = "((addi)|(andi)|(ori)|(sll)|(srl))";
		String check = labeled + opcode + reg + "," + reg + "," + space
				+ "([-+]?\\d+)" + comment;
		return code.matches(check);
	}

	public static boolean checkR(String code) {
		String opcode = "((add)|(and)|(nor)|(or)|(slt)|(sub)|(sltu))";
		String check = labeled + opcode + reg + "," + reg + "," + label
				+ comment;
		return code.matches(check);
	}

	public static boolean checkJLabel(String code) {
		String opcode = "((jal)|(j))";
		String check = labeled + opcode + label + comment;
		return code.matches(check);
	}

	public static boolean checkJ(String code) {
		String opcode = "jr";
		String check = labeled + space + opcode + comment;
		return code.matches(check);
	}

	public static boolean LabeledOnly(String code) {
		String check = labeled + comment;
		return code.matches(check);
	}
}
