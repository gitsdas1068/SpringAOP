package com.nit.helper;

import com.nit.target.EngineStore;

public class EngineFactory  {

	
	public static  EngineStore  getInstance(String engineType) {
		Engine engine=null;
		EngineStore store=null;
		//create Dependent class object
		if(engineType.equalsIgnoreCase("petrol")) {
			engine=new PetrolEngine();
		}
		else if(engineType.equalsIgnoreCase("diesel")) {
			engine=new DieselEngine();
		}
		else if(engineType.equalsIgnoreCase("cng")) {
			engine=new CNGEngine();
		}
		else 
			throw new IllegalArgumentException("invalid engine option");
		//create taget class obj having depedent class object
		
		store=new EngineStore(engine);
		
		
		return store;
		
}
}
