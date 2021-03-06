package abstracts;

import exception.NoSuchLabelException;
import exception.SyntaxErrorException;
import instructionSet.InstructionSet;

public abstract class JFormat extends Instruction {
	private int address;

	public JFormat(String label) throws NoSuchLabelException, SyntaxErrorException {
		address = InstructionSet.getInstance().getAddress(label);
	}

	public JFormat(int address) {
		this.address = address;
	}

	public JFormat() {
	}

	public int getAddress() {
		return address;
	}
}
