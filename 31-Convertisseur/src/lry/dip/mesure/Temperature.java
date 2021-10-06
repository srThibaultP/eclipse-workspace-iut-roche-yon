package lry.dip.mesure;

public class Temperature {
    private double celsius;
    private double kelvin;
    private double fahrenheit;

    public void convKel(double pKel) {
        this.kelvin = pKel;
        this.celsius = this.kelvin - 273.15;
        this.fahrenheit = ((double) 9/5) * this.kelvin - 459.67;
    }
    public void convCel(double pCel) {
        this.celsius = pCel;
        this.fahrenheit = ((double) 9/5) * this.celsius + 32;
        this.kelvin = this.celsius + 273.15;
    }
    public void convFar(double pFar) {
        this.fahrenheit = pFar;
        this.celsius = ((double)5/9) * (this.fahrenheit - 32);
        this.kelvin = ((double) 5/9) * (this.fahrenheit + 459.67);
    }

    public double getCelsius() {
        return celsius;
    }
    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }
    public double getKelvin() {
        return kelvin;
    }
    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }
    public double getFahrenheit() {
        return fahrenheit;
    }
    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public Temperature(double celsius, double kelvin, double fahrenheit) {
        this.celsius = celsius;
        this.kelvin = kelvin;
        this.fahrenheit = fahrenheit;
    }
}
