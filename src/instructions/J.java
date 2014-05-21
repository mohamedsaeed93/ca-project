package instructions;

import exception.NoSuchLabelException;
import stages.DataPath;
import abstracts.JFormat;

public class J extends JFormat {

	public J(String label) throws NoSuchLabelException {
		super(label);
	}

	public J(int address) {
		super(address);
	}

	@Override
	public void exec() {
		DataPath.setPC(getAddress());
	}
}
