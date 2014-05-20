package instructions;

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
		throw new UnsupportedOperationException();
	}
}
