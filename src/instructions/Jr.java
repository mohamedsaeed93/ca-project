package instructions;

import hardwares.Register;
import abstracts.JFormat;

public class Jr extends JFormat {

	public Jr(String label) {
		super(label);
	}

	public Jr(int address) {
		super(address);
	}

	@Override
	public void exec() {
		DataPath.setPC(Register.getRegister("$ra").getValue());
	}
}
