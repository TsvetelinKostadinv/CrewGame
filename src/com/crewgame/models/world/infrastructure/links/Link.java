package com.crewgame.models.world.infrastructure.links;

import com.crewgame.models.general.Pair;
import com.crewgame.models.structures.Structure;

class Link<S extends Structure, F extends Structure> {
	
	Pair<S, F> linkedStructures;
	//ArrayList<Path> paths;
	
	public Link(S start, F finish) 
	{
		initDependencies();
		linkedStructures.setKey(start);
		linkedStructures.setValue(finish);
	}
	
	private void initDependencies() {
		//paths = new ArrayList<>();
		
	}

	public S getStart()
	{
		return linkedStructures.getKey();
	}
	
	public F getFinish()
	{
		return linkedStructures.getValue();
	}
	
	public String getStartType()
	{
		return linkedStructures.getKey().getClass().getSimpleName();
	}
	
	public String getFinishType()
	{
		return linkedStructures.getValue().getClass().getSimpleName();
	}
}
