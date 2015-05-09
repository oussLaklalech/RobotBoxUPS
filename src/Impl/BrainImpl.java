package Impl;

import datatype.Box;
import datatype.ColorObject;
import Main.Robot.BrainRobot;

public class BrainImpl extends BrainRobot {
	
	private ColorObject color;
	private Box box;
	
	public BrainImpl(ColorObject color, Box box){
		this.color = color;
		this.box = box;
	}
	
	@Override
	protected void start() {
		System.out.println("brain");
        eco_provides().hand().deposerBox();
    }

}
