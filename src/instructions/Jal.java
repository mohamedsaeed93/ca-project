package instructions;

import hardwares.Register;
import stages.DataPath;
import abstracts.JFormat;
import exception.NoSuchLabelException;
import exception.NoSuchRegisterException;
import exception.SyntaxErrorException;

public class Jal extends JFormat {

	public Jal(String label) throws NoSuchLabelException, SyntaxErrorException {
		super(label);
	}

	public Jal(int address) {
		super(address);
	}

	@Override
	public void exec() throws NoSuchRegisterException, SyntaxErrorException {
		Register.getRegister("$ra").setValue(DataPath.getPC());
		DataPath.setPC(getAddress());
	}
}
