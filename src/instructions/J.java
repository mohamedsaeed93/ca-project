package instructions;

import exception.NoSuchLabelException;
import exception.SyntaxErrorException;
import stages.DataPath;
import abstracts.JFormat;

public class J extends JFormat {

	public J(String label) throws NoSuchLabelException, SyntaxErrorException {
		super(label);
	}

	public J(int address) {
		super(address);
	}

	@Override
	public void exec() throws SyntaxErrorException {
		DataPath.setPC(getAddress());
	}
}
