interface Employee {
    double calculateSalary();
}
class FixedSalaryEmployee implements Employee {
    private double salary;
    public FixedSalaryEmployee(double salary) {
        this.salary = salary;
    }
    public double calculateSalary() {
        return this.salary;
    }
}
class HourlySalaryEmployee implements Employee {
    private double hours;
    private double hourlyPay;

    public HourlySalaryEmployee(double hours, double hourlyPay) {
        this.hours = hours;
        this.hourlyPay = hourlyPay;
    }

    public double calculateSalary() {
        return this.hourlyPay * this.hours;
    }
}
class ProductSalesEmployee implements Employee {
    private double sales;
    private double price = 5;

    public ProductSalesEmployee(double sales, double price) {
        this.sales = sales;
        this.price = price;

    }

    public double calculateSalary() {
        return this.sales * this.price;
    }
}
    class ExtraSalesEmployee implements Employee {
        private double salary = 2000;
        private double extra = 1.2;

    public ExtraSalesEmployee(double salary, double extra) {
        this.salary = salary;
        this.extra = extra;
    }

    public double calculateSalary() {
        return this.salary * this.extra;

    }
}
    abstract class SalaryPayout {
        private Employee employee;

        public SalaryPayout(Employee employee) {
            this.employee = employee;
        }

        protected abstract void payout();

        public void processPayout() {
            System.out.println("Creating payout for: " + this.employee.calculateSalary() + " £");
            this.payout();
            System.out.println("Payout has been completed!");
        }
    }

    class SalaryPayoutProcessor extends SalaryPayout {
        public SalaryPayoutProcessor(Employee employee) {
            super(employee);
        }

        protected void payout() {
            System.out.println("Sending money to employee");
        }
    }

    class Application {
        public static void main(String[] args) {
            FixedSalaryEmployee employee = new FixedSalaryEmployee(2000);
            HourlySalaryEmployee employee1 = new HourlySalaryEmployee(40, 19);
            ProductSalesEmployee employee2 = new ProductSalesEmployee(500, 5);
            ExtraSalesEmployee employee3 = new ExtraSalesEmployee(2000, 1.2);

            SalaryPayoutProcessor processor = new SalaryPayoutProcessor (employee);
            SalaryPayoutProcessor processor1 = new SalaryPayoutProcessor (employee1);
            SalaryPayoutProcessor processor2 = new SalaryPayoutProcessor (employee2);
            SalaryPayoutProcessor processor3 = new SalaryPayoutProcessor (employee3);

            //processor.processPayout();
            //processor1.processPayout();
            //processor2.processPayout();
            processor3.processPayout();

        }
    }


