package instractions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Sltu extends RFormat {

	public Sltu(String rs, String rt, String rd) throws NoSuchRegisterException {
		super(rs, rt, rd);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}

}
