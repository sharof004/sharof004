package uz.pdp;

import uz.pdp.model.Category;
import uz.pdp.model.Expense;
import uz.pdp.model.User;
import uz.pdp.service.CategoryService;
import uz.pdp.service.ExpenceService;
import uz.pdp.service.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        UserService userService = new UserService();
        ExpenceService expenceService = new ExpenceService();
        CategoryService categoryService = new CategoryService();
        boolean chek = false;
        int step = 10;
        while (step != 0) {
            System.out.println("""
                    1.Register    2.Login   0.exit""");
            step = scannerInt.nextInt();
            User l_user = null;
            switch (step) {
                case 1 -> {
                    System.out.print("Ism kiriting:");
                    String name = scannerStr.nextLine();
                    System.out.print("Username kiriting: ");
                    String username = scannerStr.nextLine();
                    System.out.print("password kiriting: ");
                    String password = scannerStr.nextLine();
                    userService.register(new User(name, username, password));
                }

                case 2 -> {
                    System.out.print("Username kiriting: ");
                    String username = scannerStr.nextLine();
                    System.out.print("password kiriting: ");
                    String password = scannerStr.nextLine();
                    l_user = userService.login(userService.getAllUsers(), username, password);
                    chek = true;
                }
            }

            if (chek == true && l_user != null) {
                System.out.println("""
                        1. add category
                        2. show category
                        3. add expense
                        4. show expense by category
                        5. show overall expense
                        0. exit""");
                step = scannerInt.nextInt();
                switch (step) {
                    case 1 -> {
                        System.out.println("kategoriya nomini kiring :");
                        String name = scannerStr.nextLine();
                        categoryService.addCategory(new Category(l_user.getId(), name));
                    }
                    case 2 -> {
                        List<Category> allCategory = categoryService.getAllCategory();
                        for (Category category : allCategory) {
                            System.out.println(category);
                        }
                    }
                    case 3 -> {
                        categoryService.getAllCategory();
                        System.out.println("harajating nomini kiriting ");
                        String name = scannerStr.nextLine();
                        System.out.println("qaysi kategoriyaga qo`shmoqchisz");
                        int category = scannerStr.nextInt();
                        System.out.println("narxni kiriting :");
                        int price = scannerInt.nextInt();
                        expenceService.addExpence(new Expense(name,category,price));
                    }
                    case 4 -> {

                    }
                    case 5 -> {
                        List<Expense> allexpensies = expenceService.getAllexpensies();
                        for (Expense expense : allexpensies) {
                            System.out.println(expense);
                        }
                    }
                }

            }
        }
    }
}