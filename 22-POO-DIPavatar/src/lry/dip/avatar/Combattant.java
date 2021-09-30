package lry.dip.avatar;

public class Combattant extends Personnage{
	/********************************* ATTRIBUTS ********************************/
	private int force;
	private int précision;
	
	private Protection Casque;
	private Protection Bouclier;
	private Protection Magie;
	
	private Arme Epée;
	private Arme Gourdin;
	private Arme Hallebarde;
	/********************************* CONSTRUCTEUR *****************************/
	public Combattant(int pForce, int pPrecision, int pArme, int pProt1, int pProt2) {
		super(true, 100, 0, 0);
		this.force = pForce;
		this.précision = pPrecision;
		
		//this.Epée = new Arme(1);
		this.Gourdin = new Arme(2);
		//this.Hallebarde = new Arme(3);
		
		this.Casque = new Protection(pProt1);
		this.Bouclier = new Protection(pProt2);
		//this.Magie = new Protection(3, pProt1);
		}
	/********************************* GETTERS / SETTERS ************************/
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
	public int Taper(int pForce, Arme pGourdin) {
		return pForce;}
}
