package Impl;

import datatype.ColorObject;
import datatype.ObjectEnvironment;
import interfaces.ICamera;
import interfaces.ICell;
import Main.Environement;

public class EnvironementImpl extends Environement {

	@Override
	protected ICamera make_eyeEnv() {
		// TODO Auto-generated method stub
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

}
