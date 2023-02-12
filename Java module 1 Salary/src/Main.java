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
            SalaryPayoutProcessor processor = new SalaryPayoutProcessor (employee1);
            SalaryPayoutProcessor processor1 = new SalaryPayoutProcessor (employee);

            processor.processPayout();
            processor1.processPayout();
        }
    }


