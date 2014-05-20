package instractions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Sub extends RFormat {

	public Sub(String rs, String rt, String rd, int shiftAmount)
			throws NoSuchRegisterException {
		super(rs, rt, rd, shiftAmount);
	}

	public Sub(String rs, String rt, String rd) throws NoSuchRegisterException {
		super(rs, rt, rd);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
