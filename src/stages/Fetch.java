package stages;

import exception.NoSuchAddressException;
import instructionSet.*;

public class Fetch {
	
	public static InstructionString fetch(int pc) throws NoSuchAddressException {
		InstructionSet ins_set = InstructionSet.getInstance();
		return ins_set.getInstruction(pc);
	}
	
	
}
