package instructions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Ori extends IFormat {

	public Ori(String rs, String rt, int address)
			throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}

}
