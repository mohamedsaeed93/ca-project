package instractions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Add extends RFormat {

	public Add(String rs, String rt, String rd, int shiftAmount)
			throws NoSuchRegisterException {
		super(rs, rt, rd, shiftAmount);
	}

	public Add(String rs, String rt, String rd) throws NoSuchRegisterException {
		super(rs, rt, rd);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}

}
