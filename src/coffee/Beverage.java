package coffee;

public class Beverage {
    private String name;
    private Double price;
    private Double milk;
    private Double water;
    private Double coffee;

    public Beverage(String name, Double price, Double milk, Double water, Double coffee) {
        this.name = name;
        this.price = price;
        this.milk = milk;
        this.water = water;
        this.coffee = coffee;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public Double getMilkAmount() {
        return this.milk;
    }

    public Double getWaterAmount() {
        return this.water;
    }

    public Double getCoffeeAmount() {
        return this.coffee;
    }

}
