package it.ltc.utility.zpl.commands;

import it.ltc.utility.zpl.parameters.Orientation;

public abstract class FontCommand {

	protected int height;
	protected int width;
	protected Orientation orientation;
	
	public FontCommand(int height, int width, Orientation orientation) {
		this.height = height;
		this.width = width;
		this.orientation = orientation;
	}
	
}
