package hardwares;

import java.util.Hashtable;

import exception.NoSuchRegisterException;

public class Register {
	private static Register REGISTER;
	private int value;
	private Hashtable<String, Register> REGISTERS = new Hashtable<String, Register>();

	private static Register getInstance() {
		if (REGISTER == null)
			REGISTER = new Register(true);
		return REGISTER;
	}

	// Init a new Register with value 0
	private Register() {
		value = 0;
	}

	private Register(boolean init) {
		if (init)
			init();
	}

	// Here all the Registers will be created and put in the HashTable
	// (REGISTERS)
	public void init() {
		REGISTERS.put("$0", new Register());
		REGISTERS.put("$v0", new Register());
		REGISTERS.put("$v1", new Register());
		REGISTERS.put("$a0", new Register());
		REGISTERS.put("$a1", new Register());
		REGISTERS.put("$a2", new Register());
		REGISTERS.put("$a3", new Register());
		createTemps();
		createSave();
		createPointers();
		REGISTERS.put("$ra", new Register());
	}

	// Create All Temp Registers
	private void createTemps() {
		REGISTERS.put("$t0", new Register());
		REGISTERS.put("$t1", new Register());
		REGISTERS.put("$t2", new Register());
		REGISTERS.put("$t3", new Register());
		REGISTERS.put("$t4", new Register());
		REGISTERS.put("$t5", new Register());
		REGISTERS.put("$t6", new Register());
		REGISTERS.put("$t7", new Register());
		REGISTERS.put("$t8", new Register());
		REGISTERS.put("$t9", new Register());
	}

	// Create all Save Registers
	private void createSave() {
		REGISTERS.put("$s0", new Register());
		REGISTERS.put("$s1", new Register());
		REGISTERS.put("$s2", new Register());
		REGISTERS.put("$s3", new Register());
		REGISTERS.put("$s4", new Register());
		REGISTERS.put("$s5", new Register());
		REGISTERS.put("$s6", new Register());
		REGISTERS.put("$s7", new Register());
	}

	// Create all pointers Registers
	private void createPointers() {
		REGISTERS.put("$gp", new Register());
		REGISTERS.put("$sp", new Register());
		REGISTERS.put("$fp", new Register());
	}

	// Get a register s from the table
	public static Register getRegister(String s) throws NoSuchRegisterException {
		Register reg = getInstance().REGISTERS.get(s.trim());
		if (reg == null)
			throw new NoSuchRegisterException(
					"There is no such Register with the name " + s);
		return reg;
	}

	// Get the value of the Register
	public int getValue() {
		return value;
	}

	// Set the value of the Register
	public void setValue(int value) {
		this.value = value;
	}

	// Get the value of the Register s
	public static int getValue(String s) throws NoSuchRegisterException {
		return getRegister(s).getValue();
	}

	// Set the value of the Register s
	public static void setValue(String s, int value)
			throws NoSuchRegisterException {
		if (s.equals("$0"))
			return;
		getRegister(s).setValue(value);
	}
}
