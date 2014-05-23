package hardwares;

import exception.NoSuchAddressException;

public class Memory {
	private static Memory MEMORY = null;
	private int[] theMemory;

	public static Memory getInstance() {
		if (MEMORY == null)
			return MEMORY = new Memory();
		return MEMORY;
	}

	private Memory() {
		theMemory = new int[1000];
	}

	public int getData(int address) throws NoSuchAddressException {
		return theMemory[address];
	}

	public void setData(int address, int data) throws NoSuchAddressException {
		theMemory[address] = data;
	}

	public byte getLeftHalf(int address) {
		byte left = (byte) ((~((1 << 4) - 1)) & theMemory[address]);
		return (byte) ((left & 255) >> 4);
	}

	public byte getRightHalf(int address) {
		return (byte) (((1 << 4) - 1) & theMemory[address]);
	}

	public void setLeftHalf(int address, int data) {
		int removeLeft = theMemory[address] & ((1 << 4) - 1);
		theMemory[address] = (byte) ((data << 4) | removeLeft);
	}

	public void setRightHalf(int address, int data) {
		int zero = ~((1 << 4) - 1) & theMemory[address];
		theMemory[address] = (byte) (data | zero);
	}
	
	public void setValue(int value, int address) {
		 theMemory[address] = value;
	}
	
	public void reset() {
		for(int i=0; i < theMemory.length; i++)
		 theMemory[i] = 0;
	}
}
