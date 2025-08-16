package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Expense {
    private int id;
    private String name;
    private int category_id;
    private int price;

    public Expense(String name, int category_id, int price) {
        this.name = name;
        this.category_id = category_id;
        this.price = price;
    }
}
