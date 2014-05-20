package abstracts;


public abstract class JFormat extends Instruction {
	private int address;

	public JFormat(String label){
		throw new UnsupportedOperationException();
		//address = getAddress(label);
	}

	public JFormat(int address){
		this.address = address;
	}

	public JFormat() {
		// TODO Auto-generated constructor stub
	}

	public int getAddress() {
		return address;
	}
}
