package instractions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Sll extends RFormat {

	public Sll(String rs, String rt, String rd, int shiftAmount)
			throws NoSuchRegisterException {
		super(rs, rt, rd, shiftAmount);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
