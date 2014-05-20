package instructions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Lw extends IFormat {

	public Lw(String rs, String rt, int address) throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	@Override
	public void exec() {
	}
}
