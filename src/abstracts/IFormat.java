package abstracts;

import instructionSet.InstructionSet;
import exception.NoSuchLabelException;
import exception.NoSuchRegisterException;
import exception.SyntaxErrorException;
import hardwares.Register;

public abstract class IFormat extends Instruction {
	private Register rs;
	private Register rt;
	private int address;

	public IFormat(String rs, String rt, short address)
			throws NoSuchRegisterException {
		this.rs = Register.getRegister(rs);
		this.rt = Register.getRegister(rt);
		this.address = address;
	}

	public IFormat(String rs, String rt, int address)
			throws NoSuchRegisterException {
		this.rs = Register.getRegister(rs);
		this.rt = Register.getRegister(rt);
		this.address = address;
	}

	public IFormat(String rs, String rt, String label)
			throws NoSuchRegisterException, NoSuchLabelException, SyntaxErrorException {
		this.rs = Register.getRegister(rs);
		this.rt = Register.getRegister(rt);
		address = InstructionSet.getInstance().getAddress(label);
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
