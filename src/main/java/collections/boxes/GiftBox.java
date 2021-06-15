package collections.boxes;

import collections.models.Sweets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GiftBox {
    private List<Sweets> box;

    public GiftBox() {
        this.box = new ArrayList<>();
    }

    public void addSweets(Sweets ... sweets) {
        if(sweets == null || sweets.length == 0) {
            return;
        }
        this.box.addAll(Arrays.asList(sweets));
    }

    public double getBoxWeight() {
        double totalWeight = 0.;
        for (Sweets sweets : box) {
            totalWeight += sweets.getWeight();
        }
        return totalWeight;
    }

    public List<Sweets> sortBySweetsWeight() {
        return this.box.stream().sorted(Comparator.comparingDouble(Sweets::getWeight)).collect(Collectors.toList());
    }

    public List<Sweets> getSweetsInSugarContentRange(double min, double max) {
        return this.box.stream().filter(s -> s.getSugarContent() >= min && s.getSugarContent() <= max).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.box.toString();
    }
}
