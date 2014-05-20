package instractions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Andi extends IFormat {

	public Andi(String rs, String rt, int address)
			throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
