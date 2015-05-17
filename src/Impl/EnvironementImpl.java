package Impl;

import datatype.Box;
import datatype.ColorObject;
import datatype.ObjectEnvironment;
import interfaces.ICamera;
import Main.Environement;
import Main.Robot;

public class EnvironementImpl extends Environement {

	@Override
	protected ICamera make_eyeEnv() {
		// TODO Auto-generated method stub
		System.out.println("make EyeEnv");
		return new ICamera() {
			
			@Override
			public boolean hasBox() {
				// TODO Auto-generated method stub
				System.out.println("Icamera : has box");
				return false;
			}
			
			@Override
			public ColorObject getBoxColor() {
				System.out.println("Icamera : get color");
				return null;
			}

			@Override
			public boolean isAtNest() {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
	
	@Override
	protected void start() {
		System.out.println("start Environnement");
		Robot r1 = new RobotImpl(ColorObject.BLACK, new Box());
		
		Robot r2 = new RobotImpl(ColorObject.BLUE, new Box());
		
		//r1.make_BrainRobot(ColorObject.BLUE, new Box());
		
    }

}
