package Impl;

import Main.Robot;
import datatype.Box;
import datatype.ColorObject;
import interfaces.IFoot;
import interfaces.IHand;

public class RobotImpl extends Robot {


	@Override
	protected BrainRobot make_BrainRobot(ColorObject color, Box box) {
		return new BrainImpl(color, box);
	}

	@Override
	protected IHand make_hand() {
		// TODO Auto-generated method stub
		return new IHand() {
			
			@Override
			public void takeBox(Box box) {
				System.out.println("take box");
			}
			
			@Override
			public void deposerBox() {
				System.out.println("depose box");
				
			}
		};
	}

	@Override
	protected IFoot make_foot() {
		return new IFoot(){

			@Override
			public void turnLeft() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void turnRight() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void goStraight() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
	@Override
	protected void start() {
		System.out.println("robot");
		this.newBrainRobot(null, null);
    }
	
	
	public static void main(String[] agrs){
		BrainRobot.Component robot = (new RobotImpl()).newBrainRobot(null, null);
	}
	
}
