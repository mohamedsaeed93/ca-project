package instractions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Slt extends RFormat {

	public Slt(String rs, String rt, String rd, int shiftAmount)
			throws NoSuchRegisterException {
		super(rs, rt, rd, shiftAmount);
	}

	public Slt(String rs, String rt, String rd) throws NoSuchRegisterException {
		super(rs, rt, rd);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
