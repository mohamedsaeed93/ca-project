package instructions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Lw extends IFormat {

	public Lw(String rs, String rt, Short address) throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	@Override
	public void exec() {
		setMemoryRead(true);
	}
}
