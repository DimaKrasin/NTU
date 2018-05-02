import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelRoom {

    private String description;
    private int countPlacesToStay;
    private int costDay;
    private boolean free;
    private Date dateOfArrival;
    private int lenthOfStay;



    //есть все поля класса
    public HotelRoom(
            String description, int countPlacesToStay, int costDay,
            boolean free, Date dateOfArrival, int lenthOfStay) {
        this.description = description;
        this.countPlacesToStay = countPlacesToStay;
        this.costDay = costDay;
        this.free = free;
        this.dateOfArrival = dateOfArrival;
        this.lenthOfStay = lenthOfStay;
    }

    //поле dateOfArrival отсутствует
    //поле lanthOfStay отсутствует
    //поле isFree = true
    public HotelRoom(
            String description, int countPlacesToStay, int costDay) {
        this.description = description;
        this.countPlacesToStay = countPlacesToStay;
        this.costDay = costDay;
        this.free = true;
    }

    //поле dateOfArrival ставится автоматически на сегодня
    //поле is free = false
    public HotelRoom(
            String description, int countPlacesToStay, int costDay,int lenthOfStay) {
        this.description = description;
        this.countPlacesToStay = countPlacesToStay;
        this.costDay = costDay;
        this.free = false;
        Date today = new Date();
        SimpleDateFormat nowFormat = new SimpleDateFormat("yyyy.MM.dd");
        this.dateOfArrival = today;
        this.lenthOfStay = lenthOfStay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Добавлена проверка
    public int getCountPlacesToStay() {

        if(isFree()){ return countPlacesToStay;}
        return 0;
    }

    public void setCountPlacesToStay(int countPlacesToStay) {
        this.countPlacesToStay = countPlacesToStay;
    }

    public int getCostDay() {
        return costDay;
    }

    public void setCostDay(int costDay) {
        this.costDay = costDay;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public int getLenthOfStay() {
        return lenthOfStay;
    }

    public void setLenthOfStay(int lenthOfStay) {
        this.lenthOfStay = lenthOfStay;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "description='" + description + '\'' +
                ", countPlacesToStay=" + countPlacesToStay +
                ", costDay=" + costDay +
                ", free=" + free +
                ", dateOfArrival=" + dateOfArrival +
                ", lenthOfStay=" + lenthOfStay +
                '}';
    }
}
