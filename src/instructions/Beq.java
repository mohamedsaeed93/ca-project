package instructions;

import stages.DataPath;
import exception.NoSuchLabelException;
import exception.NoSuchRegisterException;
import exception.SyntaxErrorException;
import abstracts.IFormat;

public class Beq extends IFormat {

	public Beq(String rs, String rt, String label)
			throws NoSuchRegisterException, NoSuchLabelException, SyntaxErrorException {
		super(rs, rt, label);
	}

	@Override
	public void exec() throws SyntaxErrorException {
		if(getRs().getValue() == getRt().getValue())
			DataPath.setPC(getAddress());
	}
}
