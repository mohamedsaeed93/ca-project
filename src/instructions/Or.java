package instructions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Or extends RFormat {

	public Or(String rs, String rt, String rd) throws NoSuchRegisterException {
		super(rs, rt, rd);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}

}
