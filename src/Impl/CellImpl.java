package Impl;

import datatype.ObjectEnvironment;
import interfaces.ICell;
import Main.Cell;

public class CellImpl extends Cell{

	@Override
	protected ICell make_cell() {
		// TODO Auto-generated method stub
		return new ICell() {
			
			@Override
			public void setObject(ObjectEnvironment object) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public ObjectEnvironment getObject() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
