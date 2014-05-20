package stages;

import exception.NoSuchInstructionException;
import exception.NoSuchRegisterException;
import exception.OverFlowException;
import abstracts.Instruction;
import abstracts.RFormat;
import instructionSet.InstructionString;
import instructions.*;

public class Decode {

	public static Instruction id(InstructionString instruc) throws NoSuchInstructionException, NoSuchRegisterException, OverFlowException {
		if(instruc == null)
			throw new NoSuchInstructionException("No such instruchtion found");
		
		// getting the instruction class name
		String opc = instruc.getOpcode();
		String className = instruc.getOpcode().toLowerCase();
		className = Character.toUpperCase(opc.charAt(0)) + opc.substring(1);
		Class instructionName;
		Object instructionClass;
		try {
			instructionName = Class.forName(className);
			instructionClass = instructionName.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new NoSuchInstructionException("No such instruchtion found");
		}
		
		String[] address_String = instruc.getRest().split(",");
		String rs,rt,rd;
		short address;
		
		if(instructionClass instanceof RFormat)
		
		
		switch (opc.toLowerCase()) {
		case "add":
			rs = address_String[1];
			rt = address_String[2];
			rd = address_String[0];
			int value = Integer.parseInt(address_String[2]);
			if (value > Short.MAX_VALUE || value < Short.MIN_VALUE) 
				throw new OverFlowException("");
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
