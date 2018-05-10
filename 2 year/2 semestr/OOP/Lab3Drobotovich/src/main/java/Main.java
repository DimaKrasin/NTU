
public class Main {
    public static void main(String[] args) {

        Item[] mas = createItemsMas();

        System.out.println("Все:\n");

        //Вывод всех товаров в масиве
        for(int  i =0;i<mas.length;i++){
            System.out.println(mas[i].getName());
        }

        System.out.println("\nОтсутствуют:\n");

        //Вывод  товары которые отсутствуют
        for(int i = 0;i<mas.length;i++){
            if(!mas[i].isAvailable()){
                System.out.println(mas[i].getName());
            }
        }

        System.out.println("\nЕда:\n");

        //Поиск по категории еда
        for(int i = 0;i<mas.length;i++){
            if(mas[i].getCategory().equals("Food")){
                System.out.println(mas[i].getName());
            }
        }

    }

    private static Item[] createItemsMas(){
        Item[] mas  = new Item[5];

        for(int  i =0;i<mas.length;i++){
            mas[i] = new Item();
        }

        mas[0].setName("Avocado");
        mas[0].setPrice(11);
        mas[0].setAvailable(true);
        mas[0].setCategory("Food");
        mas[0].setCountInStore(102);

        mas[1].setName("Banana");
        mas[1].setPrice(7);
        mas[1].setAvailable(false);
        mas[1].setCategory("Food");
        mas[1].setCountInStore(0);

        mas[2].setName("Apple");
        mas[2].setPrice(5);
        mas[2].setAvailable(true);
        mas[2].setCategory("Food");
        mas[2].setCountInStore(506);

        mas[3].setName("Bonacva");
        mas[3].setPrice(3);
        mas[3].setAvailable(true);
        mas[3].setCategory("Drinks");
        mas[3].setCountInStore(243);

        mas[4].setName("Iphone");
        mas[4].setPrice(105);
        mas[4].setAvailable(true);
        mas[4].setCategory("Gadget");
        mas[4].setCountInStore(50);

        return mas;
    }
}
