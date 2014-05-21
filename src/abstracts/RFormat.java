package abstracts;

import exception.NoSuchRegisterException;
import hardwares.Register;

public abstract class RFormat extends Instruction {
	private Register rs;
	private Register rt;
	private Register rd;
	private int shiftAmount;

	public RFormat(String rs, String rt, String rd, int shiftAmount)
			throws NoSuchRegisterException {
		this.rs = Register.getRegister(rs);
		this.rt = Register.getRegister(rt);
		this.rd = Register.getRegister(rd);
		this.shiftAmount = shiftAmount;
	}

	public RFormat(String rs, String rt, String rd)
			throws NoSuchRegisterException {
		this.rs = Register.getRegister(rs);
		this.rt = Register.getRegister(rt);
		this.rd = Register.getRegister(rd);
		shiftAmount = 0;
	}

	public Register getRs() {
		return rs;
	}

	public Register getRt() {
		return rt;
	}

	public Register getRd() {
		return rd;
	}

	public int getShiftAmount() {
		return shiftAmount;
	}
}
