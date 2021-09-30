package lry.dip.avatar;

public class Villageois extends Personnage{
	/********************************* ATTRIBUTS ********************************/
	private int rapidité;
	private int endurance;
	/********************************* CONSTRUCTEUR *****************************/
	public Villageois(int pRap, int pEnd) {
		super(true, 100, 0, 0);
		this.rapidité = pRap;
		this.endurance = pEnd;
	}
	/********************************* GETTERS / SETTERS ************************/
	public int getRapidité() {
		return rapidité;
	}
	public void setRapidité(int rapidité) {
		this.rapidité = rapidité;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	/********************************* METHODES *********************************/
	public int Creuser() {
		return endurance;}
	public int Tailler () {
		return endurance;}
	public int Couper () {
		return endurance;}
}
