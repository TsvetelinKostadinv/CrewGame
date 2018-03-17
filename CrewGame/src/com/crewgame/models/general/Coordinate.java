package com.crewgame.models.general;

public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int x, int y)
	{
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coordinate)
		{
			if(((Coordinate) obj).getX() == this.getX())
			{
				if(((Coordinate) obj).getY() == this.getY())
				{
					return true;
				}
			}
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}
