import java.util.List;

public class Shop {

    private Item mas[];

    public Shop(Item[] mas) {
        this.mas = mas;
    }

    public Shop() {
    }

    public Item[] getMas() {
        return mas;
    }

    public void setMas(Item[] mas) {
        this.mas = mas;
    }
}
