package stages;

import instructionSet.InstructionSet;
import instructionSet.InstructionString;
import exception.NoSuchAddressException;

public class IF {

	public static InstructionString fetch(int pc) {

		InstructionSet ins_set = InstructionSet.getInstance();
		try {
			InstructionString ins = ins_set.getInstruction(pc);
			return ins;
		} catch (NoSuchAddressException e) {
			// e.printStackTrace();
		}
		return null;
	}

}
