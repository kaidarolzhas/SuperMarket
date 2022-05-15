package Class;

import java.io.Serializable;

public class Food extends Product implements Serializable {
    private double kg;

    public Food(Integer id, String name, int price, String srok, int count, double kg) {
        super(id, name, price, srok, count);
        this.kg = kg;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public String toString() {
        return  getId() + ") " + getName() + " price: " + getPrice() + " kg: " +
                 + kg + "ST: " + getSrok();

    }
}
