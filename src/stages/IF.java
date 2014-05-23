package stages;

import instructionSet.InstructionSet;
import instructionSet.InstructionString;
import exception.NoSuchAddressException;
import exception.SyntaxErrorException;

public class IF {

	public static InstructionString fetch(int pc) throws SyntaxErrorException {

		InstructionSet ins_set = InstructionSet.getInstance();
		try {
			InstructionString ins = ins_set.getInstruction(pc);
			while (ins.getOpcode().isEmpty()) {
				DataPath.IncPC();
				pc++;
				ins = ins_set.getInstruction(pc);
			}
			return ins;
		} catch (NoSuchAddressException e) {
			// e.printStackTrace();
		}
		return null;
	}

}
