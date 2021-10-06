package lry.dip.mesure;

import java.util.ArrayList;
import java.util.List;

public class Distance {
    private double metre;
    private double inch;
    private double mile;
    public ArrayList<Double> Distance = new ArrayList<>(List.of());

    public void convMetre(double pMetre) {
        this.metre = pMetre;
        this.inch = pMetre * 39.3701;
        this.mile = pMetre * 0.000621371;
        Distance.add(this.metre);
        Distance.add(this.inch);
        Distance.add(this.mile);
    }
    public void convInch(double pInch) {
        this.inch = pInch;
        this.metre = pInch / 39.3701;
        this.mile = pInch / 63360;
        Distance.addAll(List.of(this.metre,this.inch,this.mile));
    }
    public void convMile(double pMile) {
        this.mile = pMile;
        this.inch = pMile * 63360;
        this.metre = pMile * 1609.34;
        Distance.addAll(List.of(this.metre,this.inch,this.mile));
    }

    public double getMetre() {
        return metre;
    }
    public void setMetre(double metre) {
        this.metre = metre;
    }
    public double getInch() {
        return inch;
    }
    public void setInch(double inch) {
        this.inch = inch;
    }
    public double getMile() {
        return mile;
    }
    public void setMile(double mile) {
        this.mile = mile;
    }
	public ArrayList<Double> getDistance() {
		return Distance;
	}

    public Distance(double metre, double inch, double mile) {
        this.metre = metre;
        this.inch = inch;
        this.mile = mile;
    }
}
