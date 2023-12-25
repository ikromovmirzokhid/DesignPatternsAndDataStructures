package designPatterns.builder;

public class Customer {
    private String firstName;
    private String lastname;
    private String phone;
    private String email;
    private int age;
    private int numberOfChildren;
    private int shoesize;
    private boolean isMarried;
    private double yearlyIncome;
    private double yearlyAmountSpendOnShoes;

    private Customer(Builder builder) {
        this.firstName = builder.firstName;
        this.lastname = builder.lastname;
        this.phone = builder.phone;
        this.email = builder.email;
        this.age = builder.age;
        this.numberOfChildren = builder.numberOfChildren;
        this.shoesize = builder.shoesize;
        this.isMarried = builder.isMarried;
        this.yearlyIncome = builder.yearlyIncome;
        this.yearlyAmountSpendOnShoes = builder.yearlyAmountSpendOnShoes;
    }

    static class Builder {
        private String firstName = "";
        private String lastname = "";
        private String phone = "";
        private String email = "";
        private int age = 0;
        private int numberOfChildren = 0;
        private int shoesize = 0;
        private boolean isMarried = false;
        private double yearlyIncome = 0;
        private double yearlyAmountSpendOnShoes = 0;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setNumberOfChildren(int numberOfChildren) {
            this.numberOfChildren = numberOfChildren;
            return this;
        }

        public Builder setShoesize(int shoesize) {
            this.shoesize = shoesize;
            return this;
        }

        public Builder setMarried(boolean married) {
            isMarried = married;
            return this;
        }

        public Builder setYearlyIncome(double yearlyIncome) {
            this.yearlyIncome = yearlyIncome;
            return this;
        }

        public Builder setYearlyAmountSpendOnShoes(double yearlyAmountSpendOnShoes) {
            this.yearlyAmountSpendOnShoes = yearlyAmountSpendOnShoes;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", numberOfChildren=" + numberOfChildren +
                ", shoesize=" + shoesize +
                ", isMarried=" + isMarried +
                ", yearlyIncome=" + yearlyIncome +
                ", yearlyAmountSpendOnShoes=" + yearlyAmountSpendOnShoes +
                '}';
    }
}
