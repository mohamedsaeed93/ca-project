package Stages;

import exception.NoSuchInstructionException;
import exception.NoSuchRegisterException;
import abstracts.Instruction;
import instructionSet.InstructionString;
import instructions.*;

public class Decode {

	public static Instruction id(InstructionString instruc) throws NoSuchInstructionException, NoSuchRegisterException {
		String opc = instruc.getOpcode();
		String[] rest = instruc.getRest().split(",");
		String rs,rt,rd;
		short address;

		switch (opc.toLowerCase()) {
		case "add":
			rs = rest[1];
			rt = rest[2];
			rd = rest[0];
			return new Add(rs, rt, rd);
			
		case "addi":
			
		case "and":
			
			break;
		case "andi":
			
			break;
		case "beq":
			
			break;
		case "bne":
			
			break;
		case "j":
			
			break;
		case "jal":
			
			break;
		case "jr":
			
			break;
		case "lw":
			
			break;
		case "nor":
			
			break;
		case "or":
			
			break;
		case "ori":
			
			break;
		case "sll":
			
			break;
		case "slt":
			
			break;
		case "sltu":
			
			break;
		case "sri":
			
			break;
		case "sub":
			
			break;
		case "sw":
			
			break;

		default:
			throw new NoSuchInstructionException("No such instruchtion found");
		}
		return null;
	}
	
}
