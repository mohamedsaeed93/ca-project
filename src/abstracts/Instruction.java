package abstracts;

import exception.NoSuchRegisterException;
import exception.SyntaxErrorException;

public abstract class Instruction {
	private int executedValue;
	private boolean registerWrite = false;
	
	public abstract void exec() throws NoSuchRegisterException, SyntaxErrorException;

	public int getExecutedValue() {
		return executedValue;
	}

	public void setExecutedValue(int executedValue) {
		this.executedValue = executedValue;
	}

	public boolean isRegisterWrite() {
		return registerWrite;
	}

	public void setRegisterWrite(boolean registerWrite) {
		this.registerWrite = registerWrite;
	}
}
