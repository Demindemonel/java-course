package collections.sweets;

import collections.ChocolateColor;
import collections.models.Sweets;

public class Chocolate extends Sweets {
    private ChocolateColor color;

    public Chocolate(String name, double weight, double sugarContent, ChocolateColor color) {
        super(name, weight, sugarContent);
        this.color = color;
    }

    public ChocolateColor getColor() {
        return color;
    }

    public void setColor(ChocolateColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", sugarContent=" + sugarContent +
                ", color=" + color +
                '}';
    }
}
