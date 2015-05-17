package Impl;

import java.util.ArrayList;

import datatype.Box;
import datatype.ColorObject;
import datatype.ObjectEnvironment;
import datatype.Position;
import interfaces.ICamera;
import interfaces.IPosition;
import Main.Environement;
import Main.Robot;

public class EnvironementImpl extends Environement {

	private ArrayList<Position> positionsRobot;
	
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
		};
	}
	
	@Override
	protected void start() {
		System.out.println("start Environnement");
		Robot r1 = new RobotImpl(ColorObject.BLACK, null);
		Robot r2 = new RobotImpl(ColorObject.BLUE, new Box());
		positionsRobot.add(new Position(3, 5)); // position du robot r1
		positionsRobot.add(new Position(22, 1)); // position du robot r2
    }

	@Override
	protected IPosition make_positionEnv() {
		// TODO Auto-generated method stub
		return null;
	}

}
