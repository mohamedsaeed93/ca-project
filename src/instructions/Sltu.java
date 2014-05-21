package instructions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Sltu extends RFormat {

	public Sltu(String rs, String rt, String rd) throws NoSuchRegisterException {
		super(rs, rt, rd);
	}

	@Override
	public void exec() {
		long l = Long.parseLong("00000000000000000000000000000000"
				+ "11111111111111111111111111111111", 2);
		long rs = getRs().getValue();
		long rt = getRt().getValue();
		rs = rs & l;
		rt = rt & l;
		setRegisterWrite(true);
		setExecutedValue((rs < rt) ? 1 : 0);
	}

}
