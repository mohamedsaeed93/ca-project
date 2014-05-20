package abstracts;

public abstract class Instruction {
	private int executedValue;
	private boolean memoryWrite = false;
	private boolean memoryRead = false;
	private boolean registerWrite = false;
	
	public abstract void exec();

	public int getExecutedValue() {
		return executedValue;
	}

	public void setExecutedValue(int executedValue) {
		this.executedValue = executedValue;
	}

	public boolean isMemoryWrite() {
		return memoryWrite;
	}

	public void setMemoryWrite(boolean memoryWrite) {
		this.memoryWrite = memoryWrite;
	}

	public boolean isMemoryRead() {
		return memoryRead;
	}

	public void setMemoryRead(boolean memoryRead) {
		this.memoryRead = memoryRead;
	}

	public boolean isRegisterWrite() {
		return registerWrite;
	}

	public void setRegisterWrite(boolean registerWrite) {
		this.registerWrite = registerWrite;
	}
}
