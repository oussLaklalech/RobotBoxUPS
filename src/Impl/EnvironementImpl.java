package Impl;

import datatype.ColorObject;
import interfaces.ICamera;
import Main.Cell;
import Main.Environement;
import Main.Grid;

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

	@Override
	protected Cell make_cell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Grid make_grid() {
		// TODO Auto-generated method stub
		return null;
	}

}
