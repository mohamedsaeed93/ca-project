package instructions;

import hardwares.Register;
import abstracts.JFormat;

public class Jal extends JFormat {

	public Jal(String label) {
		super(label);
	}

	public Jal(int address) {
		super(address);
	}

	@Override
	public void exec() {
		Register.getRegister("$ra").setValue(DataPath.getPC());	
	}
}
