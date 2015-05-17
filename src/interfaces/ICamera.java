package interfaces;

import datatype.ColorObject;
import datatype.Position;

public interface ICamera {
	public boolean hasBox(Position pos);
	//boolean hasSameColorBox();
	public ColorObject getBoxColor(Position pos);
}
