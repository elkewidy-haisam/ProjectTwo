package model;

import java.io.Serializable;

public class commentCompositeKey implements Serializable{
	private int usersID;
	private int commentID;
	
	public commentCompositeKey(int usersID, int commentID){
		
	}
}
