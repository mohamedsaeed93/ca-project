package abstracts;

import exception.NoSuchRegisterException;
import hardwares.Register;

public abstract class IFormat extends Instruction{
	private Register rs;
	private Register rt;
	private short address;

	public IFormat(String rs, String rt, short address) throws NoSuchRegisterException{
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
