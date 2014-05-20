package instractions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Beq extends IFormat {

	public Beq(String rs, String rt, String label)
			throws NoSuchRegisterException {
		super(rs, rt, label);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
