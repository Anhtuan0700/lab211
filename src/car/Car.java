package car;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Car {

    private String nameCar;
    private String[] color;
    private int[] price; // changed to lowercase 'p'
    private String[] soldOn;

    public Car() {
    }

    public Car(String nameCar, String[] color, int[] price, String[] soldOn) {
        this.nameCar = nameCar;
        this.color = color;
        this.price = price;
        this.soldOn = soldOn;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        if (nameCar == null || nameCar.trim().isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be empty");
        }
        this.nameCar = nameCar;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        if (color == null || color.length == 0) {
            throw new IllegalArgumentException("Color cannot be empty");
        }
        this.color = color;
    }

    public int[] getPrice() {
        return price;
    }

    public void setPrice(int[] price) {
        if (price == null || price.length == 0) {
            throw new IllegalArgumentException("Price cannot be empty");
        }
        for (int p : price) {
            if (p <= 0) {
                throw new IllegalArgumentException("Price must be greater than zero");
            }
        }
        this.price = price;
    }

    public String[] getSoldOn() {
        return soldOn;
    }

    public void setSoldOn(String[] soldOn) {
        if (soldOn == null || soldOn.length == 0) {
            throw new IllegalArgumentException("SoldOn cannot be empty");
        }
        this.soldOn = soldOn;
    }

    private static final Scanner in = new Scanner(System.in);

    public static boolean checkCarExist(Car car, String color, int price, String today) throws Exception {
        boolean check = false;
        String[] listColor = car.getColor();
        int[] listPrice = car.getPrice();
        String[] listSold = car.getSoldOn();

        if (!color.equalsIgnoreCase("no color")) {
            for (String c : listColor) {
                if (color.equalsIgnoreCase(c)) {
                    check = true;
                    break;
                }
            }
        } else {
            check = true;
        }

        if (!check) {
            throw new Exception("Color Car does not exist");
        }

        check = false;
        for (int p : listPrice) {
            if (price == p) {
                check = true;
            }
        }

        if (!check) {
            throw new Exception("Price Car does not exist");
        }

        check = false;
        for (String sold : listSold) {
            if (today.equalsIgnoreCase(sold)) {
                check = true;
            }
        }

        if (!check) {
            throw new Exception("Car can't sell today");
        }

        return true;
    }

    public static void addCar(ArrayList<Car> lc) {
        String[] listColorAudi = {"White", "Yellow", "Orange"};
        int[] listPriceAudi = {5500, 3000, 4500};
        String[] listSoldDayAudi = {"Friday", "Sunday", "Monday"};
        lc.add(new Car("Audi", listColorAudi, listPriceAudi, listSoldDayAudi));

        String[] listColorMercedes = {"Green", "Blue", "Purple"};
        int[] listPriceMercedes = {5000, 6000, 8500};
        String[] listSoldDayMercedes = {"Tuesday", "Saturday", "Wednesday"};
        lc.add(new Car("Mercedes", listColorMercedes, listPriceMercedes, listSoldDayMercedes));

        String[] listColorBMW = {"Pink", "Red", "Brown"};
        int[] listPriceBMW = {2500, 3000, 3500};
        String[] listSoldDayBMW = {"Monday", "Sunday", "Thursday"};
        lc.add(new Car("BMW", listColorBMW, listPriceBMW, listSoldDayBMW));
    }

    public static boolean checkYN() throws Exception {
        while (true) {
             System.out.print("Do you want to find more?(Y/N): ");
            String result = in.nextLine();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.err.println("Re-input");
        }
    }

    public static boolean checkNameCar(ArrayList<Car> lc, String name, String color, int price, String today) throws Exception {
        boolean check = false;
        for (Car c : lc) {
            if (name.equalsIgnoreCase(c.getNameCar())) {
                if (checkCarExist(c, color, price, today)) {
                    System.out.println("Sell Car");
                    
                    if (!checkYN()) {
                        return false;
                    }
                } else {
                    System.out.println("Car break");
                }
                check = true;
                break;
            }
        }
        if (!check) {
            throw new Exception("Can't find car.");
        }
        return true;
    }

    public static void InputCar() throws Exception {
        ArrayList<Car> lc = new ArrayList<>();
        addCar(lc);
        System.out.println("Input information of car");
        while (true) {
            System.out.print("Name: ");
            String name = in.nextLine();
            System.out.print("Color: ");
            String color = in.nextLine();
            System.out.print("Price: ");
            int price = in.nextInt();
            in.nextLine(); // Consume the newline
            System.out.print("Today: ");
            String today = in.nextLine();
            if (!checkNameCar(lc, name, color, price, today)) {
                return;
            }
        }
    }
}
