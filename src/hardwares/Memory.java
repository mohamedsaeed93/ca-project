package hardwares;

public class Memory {
	private static Memory MEMORY = null;
	private byte[] theMemory;

	public static Memory get_instance(){
		if (MEMORY == null)
			return MEMORY = new Memory();
		return MEMORY;
	}

	private Memory(){
		theMemory = new byte[1000000];
	}

	public int getData(int address){
		return theMemory[address];
	}

	public void setData(int address, int data){
		theMemory[address] = (byte)data;
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
