package Impl;

import datatype.ColorObject;
import interfaces.ICamera;
import Main.Grid;

public class GridImpl extends Grid {

	@Override
	protected ICamera make_eyeGrid() {
		// TODO Auto-generated method stub
		return new ICamera() {
			
			@Override
			public boolean hasBox() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ColorObject getBoxColor() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
