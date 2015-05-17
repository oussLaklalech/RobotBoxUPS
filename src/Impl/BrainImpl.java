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
private void gotoNest(){
		
	}
	
	private void searchBox(){
		
	}
	
	@Override
	protected void start() {
		System.out.println("brain");
//        eco_provides().hand().deposerBox();
		if ( eco_requires().eye().hasBox() || eco_requires().eye().getBoxColor() == color || box == null )
			box = eco_provides().hand().takeBox();
		else if( box != null || eco_requires().eye().isAtNest())
			gotoNest();
		else 
			searchBox();
    }
}
