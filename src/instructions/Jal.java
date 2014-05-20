package instructions;

import exception.NoSuchRegisterException;
import stages.DataPath;
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
	public void exec() throws NoSuchRegisterException {
		Register.getRegister("$ra").setValue(DataPath.getPC());	
	}
}
