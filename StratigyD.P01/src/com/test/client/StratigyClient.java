package com.test.client;
import com.nit.helper.Engine;
import com.nit.helper.EngineFactory;
import com.nit.target.EngineStore;

public class StratigyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EngineStore  eng=null;
		eng= EngineFactory.getInstance("diesel");
		//invoke method
         eng.workOnEngine();
	
	}

}
