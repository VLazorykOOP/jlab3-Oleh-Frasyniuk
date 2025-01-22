interface Currency {
 
    double toUAH();

    
    void display();
}

class Dollar implements Currency {
    private static final double EXCHANGE_RATE = 40.5; // Курс обміну на гривні
    private double amount;

    public Dollar(double amount) {
        this.amount = amount;
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dollar dollar = (Dollar) obj;
        return Double.compare(dollar.amount, amount) == 0;
    }
}

class Euro implements Currency {
    private static final double EXCHANGE_RATE = 44.0; // Курс обміну на гривні
    private double amount;

    public Euro(double amount) {
        this.amount = amount;
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Euro euro = (Euro) obj;
        return Double.compare(euro.amount, amount) == 0;
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
