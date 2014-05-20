package instructions;

import instructionSet.InstructionSet;
import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Beq extends IFormat {

	public Beq(String rs, String rt, String label)
			throws NoSuchRegisterException {
		super(rs, rt, label);
	}

	@Override
	public void exec() {
		int value;
		if(getRs().getValue() == getRt().getValue())
			DataPath.setPC(getAddress());
	}
}
