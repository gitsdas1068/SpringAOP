package com.nit.target;

import java.util.Arrays;
import java.util.Random;

import com.nit.helper.CNGEngine;
import com.nit.helper.DieselEngine;
import com.nit.helper.Engine;
import com.nit.helper.PetrolEngine;

public class EngineStore {

	Engine engine;

	public EngineStore(Engine engine) {
		super();
		this.engine = engine;
	}

	public  void workOnEngine() {
		System.out.println("Inside :workOnEngine");
		if(engine   instanceof DieselEngine) {
			engine.start();
			engine.stop();
		}else if(engine   instanceof PetrolEngine){
			engine.start();
			engine.stop();
		}else if(engine   instanceof CNGEngine){
			engine.start();
			engine.stop();
		}
	
			}

	 
}
