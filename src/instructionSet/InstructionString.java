package instructionSet;

import exception.SyntaxErrorException;
import utilities.SyntaxChecker;

public class InstructionString {
	private String label = "", opcode = "", rest = "";
	private int address = 0;

	public InstructionString(String Instruction, int address)
			throws SyntaxErrorException {
		SyntaxChecker.check(Instruction);
		this.address = address;
		int labeEnd = Instruction.indexOf(":");
		if (labeEnd < 0) {
			label = "";
			Instruction = Instruction.trim();
		} else {
			label = Instruction.substring(0, labeEnd).trim();
			Instruction = Instruction.substring(labeEnd + 1).trim();
		}
		String[] notlabeled = Instruction.split(" ", 2);
		try {
			opcode = notlabeled[0];
		} catch (Exception e) {
		}
		try {
			rest = notlabeled[1];
			rest = rest.replace(" ", "");
		} catch (Exception e) {
		}
	}

	public int getAddress() {
		return address;
	}

	public String getLabel() {
		return label;
	}

	public String getOpcode() {
		return opcode;
	}

	public String getRest() {
		return rest;
	}

	@Override
	public String toString() {
		String res = "";
		if (!label.isEmpty())
			res += label + ": ";
		return res + opcode + " " + rest;
	}
}
