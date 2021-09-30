package lry.dip.avatar;

public class Protection {
	/********************************* ATTRIBUTS ********************************/
	private int type;
	private int protection;
	/********************************* CONSTRUCTEUR *****************************/
	
	public Protection (int pType) {
		//this.type = pType;
		//this.protection = pProtection;
		super();
		type = pType;
		if(type == 1) {
			protection = 89;
		}
		else if(type == 2) {
			
			protection = 41;
		} else if(type == 3) {
			
			protection = 4569;
		}
	}
	
	/********************************* GETTERS / SETTERS ************************/
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getProtection() {
		return protection;
	}
	public void setProtection(int protection) {
		this.protection = protection;
	}
	/********************************* METHODES *********************************/
}
