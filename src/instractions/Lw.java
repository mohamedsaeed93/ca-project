package instractions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Lw extends IFormat {

	public Lw(String rs, String rt, int address) throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	public Lw(String rs, String rt, String label)
			throws NoSuchRegisterException {
		super(rs, rt, label);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
