package instructions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Addi extends IFormat {

	public Addi(String rs, String rt, Short address)
			throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
