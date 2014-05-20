package instructions;

import exception.NoSuchRegisterException;
import abstracts.RFormat;

public class Add extends RFormat {

	public Add(String rs, String rt, String rd) throws NoSuchRegisterException {
		super(rs, rt, rd);
	}

	@Override
	public void exec() {
		executed_value = getRs().getValue() + getRt().getValue();
		getRd().setValue(value);
	}

}
