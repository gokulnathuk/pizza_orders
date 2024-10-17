package pizza;

public class Pizza {
    private int price;
    private boolean veg;
    private final int extraCheesePrice = 100;
    private final int extraToppingsPrice = 150;
    private final int chickenPrice = 150;
    private final int onionPrice = 50;
    private final int tomatoPrice = 30;
    private final int pepsiPrice = 40;
    private final int waterPrice = 20;
    private final int backPackPrice = 20;
    private int basePizzaPrice;
    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isChickenAdded = false;
    private boolean isOnionAdded = false;
    private boolean isTomatoAdded = false;
    private boolean isPepsiAdded = false;
    private boolean isWaterAdded = false;
    private boolean isDptedForTake = false;

    public Pizza(boolean veg) {
        this.veg = veg;
        this.price = veg ? 300 : 400;
        basePizzaPrice = this.price;
    }

    public void addExtracheesa() {
        isExtraCheeseAdded = true;
        this.price += extraCheesePrice;
    }

    public void addExtraTopping() {
        isExtraToppingsAdded = true;
        this.price += extraToppingsPrice;
    }

    public void addChicken() {
        isChickenAdded = true;
        this.price += chickenPrice;
    }

    public void addOnion() {
        isOnionAdded = true;
        this.price += onionPrice;
    }

    public void addTomato() {
        isTomatoAdded = true;
        this.price += tomatoPrice;
    }

    public void addCheese() {
        isExtraCheeseAdded = true;
        this.price += extraCheesePrice;
    }

    public void addPepsi() {
        isPepsiAdded = true;
        this.price += pepsiPrice;
    }

    public void addWater() {
        isWaterAdded = true;
        this.price += waterPrice;
    }

    public void TakeAway() {
        isDptedForTake = true;
        this.price += backPackPrice;
    }

    public void getBill() {
        StringBuilder bill = new StringBuilder();
        bill.append("Base Price: ").append(basePizzaPrice).append("\n");
        if (isExtraCheeseAdded) {
            bill.append("Extra Cheese: ").append(extraCheesePrice).append("\n");
        }
        if (isExtraToppingsAdded) {
            bill.append("Extra Toppings: ").append(extraToppingsPrice).append("\n");
        }
        if (isChickenAdded) {
            bill.append("Chicken: ").append(chickenPrice).append("\n");
        }
        if (isOnionAdded) {
            bill.append("Onion: ").append(onionPrice).append("\n");
        }
        if (isTomatoAdded) {
            bill.append("Tomato: ").append(tomatoPrice).append("\n");
        }
        if (isPepsiAdded) {
            bill.append("Pepsi: ").append(pepsiPrice).append("\n");
        }
        if (isWaterAdded) {
            bill.append("Water: ").append(waterPrice).append("\n");
        }
        if (isDptedForTake) {
            bill.append("Takeaway Fee: ").append(backPackPrice).append("\n");
        }
        bill.append("Total Bill: ").append(this.price).append("\n");
        System.out.print(bill);
    }
}
