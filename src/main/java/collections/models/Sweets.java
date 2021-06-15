package collections.models;

public abstract class Sweets {
    public String name;
    public double weight;
    public double sugarContent;

    public Sweets(String name, double weight, double sugarContent) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(double sugarContent) {
        this.sugarContent = sugarContent;
    }

    @Override
    public String toString() {
        return "Sweets{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", sugarContent=" + sugarContent +
                '}';
    }
}
