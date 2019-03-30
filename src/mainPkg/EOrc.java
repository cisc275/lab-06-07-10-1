package mainPkg;

public enum EOrc {
	north ("orc_animation/orc_forward_north.png", 10), 
	northEast ("orc_animation/orc_forward_northeast.png", 10), 
	east ("orc_animation/orc_forward_east.png", 10), 
	southEast ("orc_animation/orc_forward_southeast.png", 10),  
	south ("orc_animation/orc_forward_south.png", 10), 
	southWest ("orc_animation/orc_forward_southwest.png", 10),  
	west ("orc_animation/orc_forward_west.png", 10), 
	northWest ("orc_animation/orc_forward_northwest.png", 10),
	
	fireNorth ("orc_animation/orc_fire_north.png", 4),
	fireNorthEast("orc_animation/orc_fire_northeast.png", 4),
	fireEast("orc_animation/orc_fire_east.png", 4),
	fireSouthEast ("orc_animation/orc_fire_southeast.png", 4),
	fireSouth ("orc_animation/orc_fire_south.png", 4), 
	fireSouthWest ("orc_animation/orc_fire_southwest.png", 4),  
	fireWest ("orc_animation/orc_fire_west.png", 4), 
	fireNorthWest ("orc_animation/orc_fire_northwest.png", 4);
	
	
	
	private final String file;
	private final int frameCount;
	
	EOrc(String file, int frameCount) {
		this.file = file;
		this.frameCount = frameCount;
	}
	
	public String getFile() {
		return file;
	}
	
	public int getframeCount() {
		return frameCount;
	}

	
//	//returns a diagonal moving EOrc
//	public static EOrc selectOrc(boolean right, boolean down) {
//		if(right) {
//			if(down) return southEast;
//			return northEast;
//		}
//		if(down) return southWest;
//		return northWest;
//	}
//	//returns an EOrc of the correct orientation
//	public static EOrc selectOrc(boolean right, boolean down, boolean noX, boolean noY) {
//		if(!noX && !noY) return selectOrc(right, down);
//		if(noX) {
//			if(down) return south;
//			return north;
//		}
//		if(right) return east;
//		return west;
//	}
}
