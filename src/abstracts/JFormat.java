package abstracts;

import interfaces.Instruction;

public abstract class JFormat implements Instruction {
	private int address;

	public JFormat(String label){
		throw new UnsupportedOperationException();
		//address = getAddress(label);
	}

	public JFormat(int address){
		this.address = address;
	}

	public int getAddress() {
		return address;
	}
}
