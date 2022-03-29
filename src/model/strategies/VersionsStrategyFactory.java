package model.strategies;

import java.util.HashMap;

public class VersionsStrategyFactory {

	private HashMap<String, VersionsStrategy> strategies;
	
	public VersionsStrategyFactory() {
		strategies = new HashMap<String, VersionsStrategy>();
		
		VersionsStrategy stable = createStable();
		strategies.put("stable", stable);
		
		VersionsStrategy volatile1 = createVolatile();
		strategies.put("volatile", volatile1);
		
	}
	
	public VersionsStrategy createStable() {
		return new StableVersionsStrategy();
	}
	
	public VersionsStrategy createVolatile() {
		return new VolatileVersionsStrategy();
	}
}
