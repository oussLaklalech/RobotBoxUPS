package Impl;

import Main.Environement;
import Main.MainSystem;
//import Main.Brain;
import Main.Robot;

public class MainImpl extends MainSystem{
	

	@Override
	protected Environement make_environement() {
		// TODO Auto-generated method stub
		System.out.println("make ENV");
		return new EnvironementImpl();
	}

	@Override
	protected Robot make_robot() {
		// TODO Auto-generated method stub
		System.out.println("make ROBOT");
		return new RobotImpl(null, null);
	}
	
	public static void main(String[] args){
		new MainImpl().newComponent();
	}
}
