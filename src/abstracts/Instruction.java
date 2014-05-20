package abstracts;

import exception.NoSuchRegisterException;

public abstract class Instruction {
	private int executedValue;
	private boolean registerWrite = false;
	
	public abstract void exec() throws NoSuchRegisterException;

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
