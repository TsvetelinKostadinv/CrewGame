package com.crewgame.java.world.infrastructure.links;

import com.crewgame.java.structures.Structure;

public class LinkFactory {
	
	public Link<Structure, Structure> createLink(Structure start, Structure finish)
	{
		return new Link<Structure, Structure>(start, finish);
	}
	
}
