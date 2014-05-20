package instructions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Andi extends IFormat {

	public Andi(String rs, String rt, int address)
			throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	@Override
	public void exec() {
		int value = getRs().getValue() & getAddress();
		getRt().setValue(value);
	}
}
