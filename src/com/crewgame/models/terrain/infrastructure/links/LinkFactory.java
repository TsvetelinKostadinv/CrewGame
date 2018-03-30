package com.crewgame.models.terrain.infrastructure.links;

import com.crewgame.models.structures.Structure;

public class LinkFactory {
	
	public Link createLink(Structure start, Structure finish)
	{
		return new Link<Structure, Structure>(start, finish);
	}
	
}
