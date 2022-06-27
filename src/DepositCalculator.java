import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {  т.к. метод возвращает значение... я бы назвал метод getSimplePercent()
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) { т.к. метод возвращает значение... я бы назвал метод getSimplePercent()
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateAmount() {
        int amount;
        int term;
        int typeOfDeposit;
        double result = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        term = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfDeposit = scanner.nextInt();
        if (typeOfDeposit == 1) {
            result = calculateSimplePercent(amount, 0.06, term);
        } else if (typeOfDeposit == 2) {
            result = calculateComplexPercent(amount, 0.06, term);
        }
        System.out.println("Результат вклада: " + amount + " за " + term + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateAmount();
    }
}
