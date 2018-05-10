public class Item {

    private String name;
    private String category;
    private double price;
    private boolean isAvailable;
    private int countInStore;

    public Item(String name, String category, double price, boolean isAvailable, int countInStore) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.isAvailable = isAvailable;
        this.countInStore = countInStore;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getCountInStore() {
        return countInStore;
    }

    public void setCountInStore(int countInStore) {
        this.countInStore = countInStore;
    }
}
