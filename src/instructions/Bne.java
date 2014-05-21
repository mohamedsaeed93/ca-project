package instructions;

import stages.DataPath;
import exception.NoSuchLabelException;
import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Bne extends IFormat {

	public Bne(String rs, String rt, String label)
			throws NoSuchRegisterException, NoSuchLabelException {
		super(rs, rt, label);
	}

	@Override
	public void exec() {
		if(getRs().getValue() != getRt().getValue())
			DataPath.setPC(getAddress());
	}
}
