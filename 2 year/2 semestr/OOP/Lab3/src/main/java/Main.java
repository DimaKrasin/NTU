import java.util.Date;

public class Main {
    /*
    Красин ПР-2-2 ООП Лаб3

    Предметна область: готель, клас: готельний номер, орієнтовний перелік
полів: опис номера, кількість місць, вартість проживання, вільний/зайнятий,
дата заселення, термін проживання. Вивести окремо список вільних та
окремо список зайнятих номерів. Реалізувати пошук вільних помешкань з
вказаною кількістю місць та допустимою вартістю проживання.
     */

    public static void main(String[] args) {

        HotelRoom[] roomsList = fillHotel();

        Hotel hotel = new Hotel(roomsList);
        //hotel.printList();
        //hotel.printList(false);
        //hotel.findByMaxCostAndPlacesToStay(50,50);
    }

    private static HotelRoom[] fillHotel(){

        HotelRoom[] roomsList = new HotelRoom [4];

        //пустая комната
        roomsList[0]=(new HotelRoom(
                "Common description for common room",
                1,
                10));

        //пустая комната
        roomsList[1]=(new HotelRoom(
                "Common description for common room",
                2,
                20));

        //заселились сегодня на 10 дней
        roomsList[2]=(new HotelRoom(
                "Common description for common room",
                3,
                30,30));

        //Забронирована на потом но сейчас свободна
        Date dateOfArrival = new Date(Long.MAX_VALUE);
        roomsList[3]=(new HotelRoom(
                "Common description for common room",
                4,
                40,true,dateOfArrival,10));

        return roomsList;
    }
}
