package coffee;

public class Resources {
    private Double milk;
    private Double water;
    private Double coffee;

    public Resources() {
        this.milk = 200.00;
        this.water = 500.00;
        this.coffee = 200.00;
    }

    //Show resources
    public Double getMilk() {
        return this.milk;
    }

    public Double getWater() {
        return this.water;
    }

    public Double getCoffee() {
        return this.coffee;
    }

    // Add resources
    public void addMilk(double amount) {
        this.milk += amount;
    }

    public void addWater(double amount) {
        this.water += amount;
    }

    public void addCoffee(double amount) {
        this.coffee += amount;
    }

    //check if resources are sufficient
    public boolean checkEnoughResources(double milkAmount, double waterAmount, double coffeeAmount) {
        return this.milk >= milkAmount && this.water >= waterAmount && this.coffee >= coffeeAmount;
    }

    //Using resources
    public void useResources(double milkAmount, double waterAmount, double coffeeAmount) {
        this.milk -= milkAmount;
        this.water -= waterAmount;
        this.coffee -= coffeeAmount;
    }
}
