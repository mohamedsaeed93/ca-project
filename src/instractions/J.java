package instractions;

import abstracts.JFormat;

public class J extends JFormat {

	public J(String label) {
		super(label);
	}

	public J(int address) {
		super(address);
	}

	@Override
	public void exec() {
		throw new UnsupportedOperationException();
	}
}
