package com.crewgame.models.world.infrastructure.links;

import com.crewgame.models.structures.Structure;

public class LinkFactory {
	
	public Link<Structure, Structure> createLink(Structure start, Structure finish)
	{
		return new Link<Structure, Structure>(start, finish);
	}
	
}
