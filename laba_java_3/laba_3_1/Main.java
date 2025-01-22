import java.util.Objects;

class Worker {
    protected String name;
    protected int age;
    protected String position;

    public Worker(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public void Show() {
        System.out.println("Name: " + name + ", Age: " + age + ", Position: " + position);
    }
}

class Engineer extends Worker {
    private String specialization;
    private int experience;

    public Engineer(String name, int age, String position, String specialization, int experience) {
        super(name, age, position);
        this.specialization = specialization;
        this.experience = experience;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Specialization: " + specialization + ", Experience: " + experience + " years");
    }
}

class Administration extends Worker {
    private String department;
    private String responsibility;

    public Administration(String name, int age, String position, String department, String responsibility) {
        super(name, age, position);
        this.department = department;
        this.responsibility = responsibility;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Department: " + department + ", Responsibility: " + responsibility);
    }
}

class HR extends Worker {
    private int recruitmentCount;
    private boolean policyDevelopment;

    public HR(String name, int age, String position, int recruitmentCount, boolean policyDevelopment) {
        super(name, age, position);
        this.recruitmentCount = recruitmentCount;
        this.policyDevelopment = policyDevelopment;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Recruitment Count: " + recruitmentCount + ", Policy Development: " + policyDevelopment);
    }
}

public class Main {
    public static void main(String[] args) {
        Worker[] workers = new Worker[3];
        
        workers[0] = new Engineer("Alice", 30, "Senior Engineer", "Software Development", 8);
        workers[1] = new Administration("Bob", 45, "Manager", "Finance", "Budgeting");
        workers[2] = new HR("Carol", 35, "HR Specialist", 50, true);
        
        for (Worker worker : workers) {
            worker.Show();
            System.out.println();
        }
    }
}
