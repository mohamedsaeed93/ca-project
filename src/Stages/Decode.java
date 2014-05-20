package Stages;

import exception.NoSuchInstructionException;
import abstracts.Instruction;
import instructionSet.InstructionString;

public class Decode {

	public static Instruction id(InstructionString instruc) throws NoSuchInstructionException {
		String opc = instruc.getOpcode();
		
		switch (opc.toLowerCase()) {
		case "add":
			
			break;
		case "addi":
					
			break;
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
