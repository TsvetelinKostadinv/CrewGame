package com.crewgame.models.terrain.infrastructure;

import java.util.ArrayList;
import com.crewgame.models.general.Pair;
import com.crewgame.models.structures.Structure;

abstract class Link<S extends Structure, F extends Structure> {
	
	Pair<S, F> linkedStructures;
	ArrayList<Path> paths;
	
	public Link(S start, F finish) 
	{
		initDependencies();
		linkedStructures.setKey(start);
		linkedStructures.setValue(finish);
	}
	
	private void initDependencies() {
		paths = new ArrayList<>();
		
	}

	public S getStart()
	{
		return linkedStructures.getKey();
	}
	
	public F getFinish()
	{
		return linkedStructures.getValue();
	}
}
