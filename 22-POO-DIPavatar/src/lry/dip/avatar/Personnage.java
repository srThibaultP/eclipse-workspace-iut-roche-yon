package lry.dip.avatar;

public class Personnage {
	/********************************* ATTRIBUTS ********************************/
	private boolean etatPerso = true;
	private int viePerso;
	private int posH = 0;
	private int posL = 0;
	/********************************* CONSTRUCTEUR *****************************/
	
	public Personnage (boolean pEtatPerso, int pViePerso, int pPosH, int pPosL) {
		this.etatPerso = pEtatPerso;
		this.viePerso = pViePerso;
		this.posH = pPosH;
		this.posL = pPosL;
	}
	
	/********************************* GETTERS / SETTERS ************************/
	public boolean isEtatPerso() {
		return etatPerso;
	}
	public void setEtatPerso(boolean etatPerso) {
		this.etatPerso = etatPerso;
	}
	public int getViePerso() {
		return viePerso;
	}
	public void setViePerso(int viePerso) {
		this.viePerso = viePerso;
	}
	public int getPosH() {
		return posH;
	}
	public void setPosH(int posH) {
		this.posH = posH;
	}
	public int getPosL() {
		return posL;
	}
	public void setPosL(int posL) {
		this.posL = posL;
	}
	/********************************* METHODES *********************************/
	public boolean déplacer (int pHaut, int pLarg) {
		return etatPerso;}
	public boolean réveiller() {
		return etatPerso;}
	public void parler(String pPhase) {}
}
