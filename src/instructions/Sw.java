package instructions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Sw extends IFormat {

	public Sw(String rs, String rt, Short address) throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	@Override
	public void exec() {
	}
}
