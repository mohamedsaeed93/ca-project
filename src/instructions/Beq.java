package instructions;

import stages.DataPath;
import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Beq extends IFormat {

	public Beq(String rs, String rt, String label)
			throws NoSuchRegisterException {
		super(rs, rt, label);
	}

	@Override
	public void exec() {
		if(getRs().getValue() == getRt().getValue())
			DataPath.setPC(getAddress());
	}
}
