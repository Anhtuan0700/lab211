package caculator;

import static java.lang.System.in;
import java.util.Scanner;

class Calculator {
    private double value;  // Giá trị hiện tại
    private double number;  // Số nhập vào
    private String operator; // Toán tử

    // Constructor khởi tạo
    public Calculator() {
        this.value = value;
        this.number = number;
        this.operator = operator;
    }

    // Getter và setter cho value
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // Getter và setter cho number
    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        if (number >0) { // Kiểm tra tính hợp lệ
            this.number = number;
        } else {
            System.out.println("Giá trị không hợp lệ.");
        }
    }

    // Getter và setter cho operator
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void calculate() {
         inputNumber(); // Nhập số đầu tiên
        value = number; 
        
        while (true) {
            inputOperator(); // Nhập toán tử
            if (operator.equals("=")) { // Kết thúc khi người dùng nhập dấu "="
                System.out.println("Kết quả cuối cùng: " + value);
                break;
            }
            inputNumber(); // Nhập số tiếp theo

            // Thực hiện phép tính theo toán tử
            switch (operator) {
                case "+":
                    value += number;
                    break;
                case "-":
                    value -= number;
                    break;
                case "*":
                    value *= number;
                    break;
                case "/":
                    if (number != 0) {
                        value /= number;
                    } else {
                        System.out.println("Không thể chia cho 0.");
                    }
                    break;
                case "^":
                    value = Math.pow(value, number);
                    break;
                default:
                    System.out.println("Toán tử không hợp lệ.");
                    break;
            }
            System.out.println("Giá trị hiện tại: " + value); // Hiển thị kết quả tạm thời
        }
    }

    Scanner in = new Scanner(System.in); // Đối tượng Scanner để nhập dữ liệu từ bàn phím

    // Phương thức nhập giá trị number và kiểm tra tính hợp lệ
    public void inputNumber() {
        while (true) {
            try {
                System.out.print("Nhập một số kiểu double: ");
                double result = Double.parseDouble(in.nextLine());

                setNumber(result); // Gán giá trị cho thuộc tính number
                break; // Thoát vòng lặp nếu nhập đúng

            } catch (NumberFormatException e) {
                System.err.println("Phải nhập số kiểu double, vui lòng nhập lại.");
            }
        }
    }

    // Phương thức nhập toán tử và kiểm tra tính hợp lệ
    public void inputOperator() {
        while (true) {
            System.out.print("Nhập toán tử (+, -, *, /, =): ");
            String input = in.nextLine(); // Nhập toán tử từ người dùng
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("=")) {
                setOperator(input); // Gán toán tử hợp lệ
                break; // Thoát vòng lặp nếu nhập đúng
            } else {
                System.out.println("Toán tử không hợp lệ, vui lòng nhập lại.");
            }
        }
    }

  
}
