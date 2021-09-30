package lry.dip.avatar;

public class Arme{
	/********************************* ATTRIBUTS ********************************/
	private int type;
	private int force;
	private int précision;
	/********************************* CONSTRUCTEUR *****************************/
	
	public Arme (int pType, int pForce, int pPrécision) {
		//this.type = pType;
		//this.force = pForce;
		//this.précision = pPrécision;
		super();
		if(type == 1) {
			force = 187;
			précision = 47;
		}
		else if(type == 2) {
			force = 169;
			précision = 4;
		} else if(type == 3) {
			force = 125;
			précision = 96;
		}
	}
	/********************************* GETTERS / SETTERS ************************/
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getPrécision() {
		return précision;
	}
	public void setPrécision(int précision) {
		this.précision = précision;
	}
	/********************************* METHODES *********************************/
	public Arme (int pType) {}
}
