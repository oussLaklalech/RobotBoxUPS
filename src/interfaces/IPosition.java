package interfaces;

import java.util.ArrayList;

import datatype.Position;

public interface IPosition {
	public ArrayList<Position> getAllNestPositions();
	public Position getMyPosition();
}
