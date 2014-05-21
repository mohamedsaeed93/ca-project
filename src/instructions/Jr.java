package instructions;

import exception.NoSuchLabelException;
import exception.NoSuchRegisterException;
import stages.DataPath;
import hardwares.Register;
import abstracts.JFormat;

public class Jr extends JFormat {

	public Jr(String label) throws NoSuchLabelException {
		super(label);
	}

	public Jr(int address) {
		super(address);
	}
	
	public Jr() {
		super();
	}

	@Override
	public void exec() throws NoSuchRegisterException {
		DataPath.setPC(Register.getRegister("$ra").getValue());
	}
}
