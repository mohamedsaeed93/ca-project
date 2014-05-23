package instructionSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import exception.NoSuchAddressException;
import exception.NoSuchLabelException;
import exception.SyntaxErrorException;

public class InstructionSet {
	private static InstructionSet SET = null;
	private static Hashtable<String, InstructionString> labels;
	private static List<InstructionString> InstructionSet;

	public static InstructionSet getInstance() throws SyntaxErrorException {
		if (SET == null)
			SET = new InstructionSet();
		return SET;
	}

	public void init() throws SyntaxErrorException {

		try {
			FileReader fr = new FileReader("Instructions");
			BufferedReader bf = new BufferedReader(fr);
			int i = 0;
			InstructionString instruction;
			String temp;
			while (bf.ready()) {
				temp = bf.readLine();
				temp = temp.replaceAll("//.*", "");
				if (temp.isEmpty())
					continue;
				instruction = new InstructionString(temp, i);
				InstructionSet.add(instruction);
				labels.put(instruction.getLabel(), instruction);
				i++;
			}
			bf.close();
		} catch (IOException e) {
			System.out.println("Error Ocurred While Reading The File.");
			e.printStackTrace();
		}
	}

	private InstructionSet() throws SyntaxErrorException {
		labels = new Hashtable<String, InstructionString>();
		InstructionSet = new ArrayList<InstructionString>();
		init();
	}

	public int getAddress(String label) throws NoSuchLabelException {
		InstructionString temp = labels.get(label);
		if (temp == null)
			throw new NoSuchLabelException("The Label " + label
					+ " doesnot Exist");
		return temp.getAddress();
	}

	public InstructionString getInstruction(int address)
			throws NoSuchAddressException {
		if (InstructionSet.size() > address)
			return InstructionSet.get(address);
		throw new NoSuchAddressException("The Instruction at address "
				+ address + " doesnot Exist");
	}

	public boolean isFinished(int address) {
		return InstructionSet.size() + 4 <= address || InstructionSet.isEmpty();
	}

	public boolean isFinished2(int address) {
		return InstructionSet.size() <= address || InstructionSet.isEmpty();
	}
}
