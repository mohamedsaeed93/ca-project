package instractions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Bne extends IFormat {

	public Bne(String rs, String rt, int address)
			throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	public Bne(String rs, String rt, String label)
			throws NoSuchRegisterException {
		super(rs, rt, label);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
