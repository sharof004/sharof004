package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor@Data
public class Category {
   private int user_id;
   private int id;
   private String name;

   public Category(int user_id, String name) {
      this.user_id = user_id;
      this.name = name;
   }
}
