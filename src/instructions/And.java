package instructions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class And extends RFormat {

	public And(String rs, String rt, String rd) throws NoSuchRegisterException {
		super(rs, rt, rd);
	}

	@Override
	public void exec() {
		setExecutedValue(getRs().getValue() & getRt().getValue());
		setRegisterWrite(true);
	}
}
