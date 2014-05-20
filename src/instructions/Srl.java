package instructions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Srl extends RFormat {

	public Srl(String rs, String rt, String rd, int shiftAmount)
			throws NoSuchRegisterException {
		super(rs, rt, rd, shiftAmount);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
