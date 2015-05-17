package interfaces;

import datatype.ColorObject;

public interface ICamera {
	public boolean hasBox();
	//boolean hasSameColorBox();
	public ColorObject getBoxColor();
	public boolean isAtNest();
}
