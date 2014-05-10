package hardwares;

import java.util.Hashtable;

import exception.NoSuchRegisterException;

public class Register {
	private int value;
	private static Hashtable<String, Register> REGISTERS = 
			new Hashtable<String, Register>();

//	Here all the Registers will be created and put in the HashTable (REGISTERS)
	public static void init(){
		throw new UnsupportedOperationException();
	}

	public static Register getRgister(String s) throws NoSuchRegisterException {
		Register reg = REGISTERS.get(s);
		if (reg == null)
			throw new NoSuchRegisterException(s);
		return reg;
	}

	private Register(int val) {
		value = val;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
