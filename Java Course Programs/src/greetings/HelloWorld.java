package greetings;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;

import printing.BWCartridge;
import printing.ColorCartridge;
import printing.ICartridge;
import printing.IMachine;
import printing.Machine;
import printing.Printer;


public class HelloWorld {
		public static void main(String[] args) {
			
			Printer<BWCartridge> printer = new Printer<BWCartridge>(true, "MY PRINTER", new BWCartridge());
			
			try{
				printer.print(-1);
			}
			catch (IllegalArgumentException exceprion){
				System.out.println(exceprion.getMessage());
				return;
			}
			finally{
				printer.TurnOff();
			}
			
			//Printer<ColorCartridge> printer2 = new Printer<ColorCartridge>(true, "MY PRINTER", new ColorCartridge());
			//printOne(printer2);
		}	
		
		//public static void printOne(Printer<? extends ICartridge> printer){
			//String fillPercentage = printer.getCartridge().getFillPercentage();
			//System.out.println(fillPercentage);
		//}
}
