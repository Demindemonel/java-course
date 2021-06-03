package ch6;

import ch6.boxes.GiftBox;
import ch6.sweets.Candy;
import ch6.sweets.Chocolate;

import static ch6.ChocolateColor.*;

public class Main {
    public static void main(String[] args) {
        GiftBox giftBox = new GiftBox();
        Candy candy = new Candy("конфетка", 20.1, 9.2);
        Candy candyWithJem = new Candy("конфетка с джемом", 30.4, 21.2);
        Candy candyWithNuts = new Candy("конфетка с орешками", 40.5, 15.);
        Chocolate whiteChocolate = new Chocolate("белая шоколадка", 300., 100.1, WHITE);
        Chocolate blackChocolateWithNuts = new Chocolate("черная шоколадка с орешками", 350., 155.5, BLACK);

        giftBox.addSweets(blackChocolateWithNuts, candyWithJem, candy, candyWithNuts, whiteChocolate);
        System.out.println(giftBox.toString());
        System.out.println(giftBox.getBoxWeight());
        System.out.println(giftBox.sortBySweetsWeight());
        System.out.println(giftBox.getSweetsInSugarContentRange(15.,105.));

    }


}
