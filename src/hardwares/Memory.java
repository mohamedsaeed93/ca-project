package hardwares;

import exception.NoSuchAddressException;

public class Memory {
	private static Memory MEMORY = null;
	private int[] theMemory;

	public static Memory get_instance(){
		if (MEMORY == null)
			return MEMORY = new Memory();
		return MEMORY;
	}

	private Memory(){
		theMemory = new int[1000000];
	}

	public int getData(int address) throws NoSuchAddressException{
		if (address%4 != 0){
			throw new NoSuchAddressException("Invalid address " + address);
		}
		return theMemory[address/4];
	}

	public void setData(int address, int data) throws NoSuchAddressException{
		if (address%4 != 0){
			throw new NoSuchAddressException("Invalid address " + address);
		}
		theMemory[address/4] = data;
	}

	public byte getLeftHalf(int address){
		byte left = (byte) ((~((1 << 4)-1)) & theMemory[address]);
		return (byte) ((left&255) >> 4);
	}

	public byte getRightHalf(int address){
		return (byte) (((1 << 4)-1) & theMemory[address]);
	}

	public void setLeftHalf(int address, int data){
		int removeLeft = theMemory[address] & ((1 << 4)-1);
		theMemory[address] = (byte) ((data << 4) | removeLeft);
	}

	public void setRightHalf(int address, int data){
		int zero = ~((1 << 4) -1) & theMemory[address];
		theMemory[address] = (byte) (data | zero);
	}
}
