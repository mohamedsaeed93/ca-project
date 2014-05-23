package instructions;

import exception.NoSuchLabelException;
import exception.NoSuchRegisterException;
import exception.SyntaxErrorException;
import stages.DataPath;
import hardwares.Register;
import abstracts.JFormat;

public class Jr extends JFormat {

	public Jr(String label) throws NoSuchLabelException, SyntaxErrorException {
		super(label);
	}

	public Jr(int address) {
		super(address);
	}
	
	public Jr() {
		super();
	}

	@Override
	public void exec() throws NoSuchRegisterException, SyntaxErrorException {
		DataPath.setPC(Register.getRegister("$ra").getValue());
	}
}
