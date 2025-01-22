abstract class Currency {
    protected double amount;

    public Currency(double amount) {
        this.amount = amount;
    }

    // Абстрактний метод для переводу суми у гривні
    public abstract double toUAH();

    // Абстрактний метод для виводу інформації на екран
    public abstract void display();

    @Override
    public String toString() {
        return "Currency amount: " + amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Currency currency = (Currency) obj;
        return Double.compare(currency.amount, amount) == 0;
    }
}

class Dollar extends Currency {
    private static final double EXCHANGE_RATE = 41.5; // Курс обміну на гривні

    public Dollar(double amount) {
        super(amount);
    }

    @Override
    public double toUAH() {
        return amount * EXCHANGE_RATE;
    }

    @Override
    public void display() {
        System.out.println("Dollar amount: $" + amount + " = " + toUAH() + " UAH");
    }

    @Override
    public String toString() {
        return "Dollar: $" + amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        return obj instanceof Dollar;
    }
}

class Euro extends Currency {
    private static final double EXCHANGE_RATE = 44.0; // Курс обміну на гривні

    public Euro(double amount) {
        super(amount);
    }

    @Override
    public double toUAH() {
        return amount * EXCHANGE_RATE;
    }

    @Override
    public void display() {
        System.out.println("Euro amount: e" + amount + " = " + toUAH() + " UAH");
    }

    @Override
    public String toString() {
        return "Euro: e" + amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        return obj instanceof Euro;
    }
}

public class Main {
    public static void main(String[] args) {

        Currency[] currencies = new Currency[4];
        currencies[0] = new Dollar(100);
        currencies[1] = new Euro(50);
        currencies[2] = new Dollar(200);
        currencies[3] = new Euro(80);

        for (Currency currency : currencies) {
            currency.display();
            System.out.println(currency.toString());
            System.out.println();
        }

        // Перевірка equals
        System.out.println("Equality check:");
        System.out.println(currencies[0].equals(currencies[2])); // Dollar 100 == Dollar 200
        System.out.println(currencies[1].equals(currencies[3])); // Euro 50 == Euro 80
        System.out.println(currencies[0].equals(currencies[1])); // Dollar != Euro
    }
}
