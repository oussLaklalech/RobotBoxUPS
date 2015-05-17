package Impl;

import java.util.ArrayList;

import datatype.Box;
import datatype.ColorObject;
import datatype.ObjectEnvironment;
import datatype.Position;
import interfaces.ICamera;
import Main.Environement;
import Main.Robot;

public class EnvironementImpl extends Environement {

	private ArrayList<Position> positionsRobot;
	private ArrayList<RobotImpl> listRobot;
	
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
		// instantiation des robots avec leur positions
		for(int i = 0 ; i< 10; i++){
			listRobot.add(new RobotImpl(ColorObject.BLACK, null));
			// TODO : génération de positions aléatoires 
			positionsRobot.add(new Position(i+1, 0));
		}
    }

}
