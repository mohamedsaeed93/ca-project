package instructions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Slt extends RFormat {

	public Slt(String rs, String rt, String rd) throws NoSuchRegisterException {
		super(rs, rt, rd);
	}

	@Override
	public void exec() {
		setExecutedValue((getRs().getValue() < getRt().getValue()) ? 1 : 0);
		setRegisterWrite(true);
	}
}
