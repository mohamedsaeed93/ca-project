package abstracts;

import exception.NoSuchRegisterException;
import hardwares.Register;
import interfaces.Instruction;

public abstract class IFormat implements Instruction{
	private Register rs;
	private Register rt;
	private int address;

	public IFormat(String rs, String rt, int address) throws NoSuchRegisterException{
		this.rs = Register.getRgister(rs);
		this.rt = Register.getRgister(rt);
		this.address = address;
	}

	public IFormat(String rs, String rt, String label) throws NoSuchRegisterException{
		this.rs = Register.getRgister(rs);
		this.rt = Register.getRgister(rt);
		throw new UnsupportedOperationException();
		//address = getAddress(label);
	}

	public Register getRs() {
		return rs;
	}

	public Register getRt() {
		return rt;
	}

	public int getAddress() {
		return address;
	}
}
