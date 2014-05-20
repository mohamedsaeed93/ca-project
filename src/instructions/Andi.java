package instructions;

import exception.NoSuchRegisterException;
import abstracts.IFormat;

public class Andi extends IFormat {

	public Andi(String rs, String rt, Short address)
			throws NoSuchRegisterException {
		super(rs, rt, address);
	}

	@Override
	public void exec() {
		setExecutedValue(getRs().getValue() & getAddress());
		setRegisterWrite(true);
	}
}
