package abstracts;

import exception.NoSuchRegisterException;
import hardwares.Register;
import interfaces.Instruction;

public abstract class RFormat implements Instruction {
	private Register rs;
	private Register rt;
	private Register rd;
	private int shiftAmount;
	
	public RFormat(String rs, String rt, String rd, int shiftAmount) throws NoSuchRegisterException {
		this.rs = Register.getRgister(rs);
		this.rt = Register.getRgister(rt);
		this.rd = Register.getRgister(rd);
		this.shiftAmount = shiftAmount;
	}

	public RFormat(String rs, String rt, String rd) throws NoSuchRegisterException {
		this.rs = Register.getRgister(rs);
		this.rt = Register.getRgister(rt);
		this.rd = Register.getRgister(rd);
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
