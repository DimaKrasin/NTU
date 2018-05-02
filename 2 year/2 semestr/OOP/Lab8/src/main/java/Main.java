import java.io.*;
import java.util.Date;

public class Main {

    /*

    Красин ПР-2-2

    ООП Лаб8
     Вдосконалити об’єктну модель лабораторної роботи №3, додавши
до неї наступну функціональність - методи для запису об’єктів з масиву з
даними у файл і навпаки.

Все измения это  addHotelRoomsMasToFile() и getHotelRoomsMasFromFile()

    Додаток
    ООП Лаб3

    Предметна область: готель, клас: готельний номер, орієнтовний перелік
полів: опис номера, кількість місць, вартість проживання, вільний/зайнятий,
дата заселення, термін проживання. Вивести окремо список вільних та
окремо список зайнятих номерів. Реалізувати пошук вільних помешкань з
вказаною кількістю місць та допустимою вартістю проживання.
     */

    public static void main(String[] args) {

        String pathToFile = "fileWithHotelRoomsMas.txt";

        //Создание масива комнат
        HotelRoom[] roomsList = fillHotel();

        //Добавляем масив в файлик
        addHotelRoomsMasToFile(pathToFile,roomsList);


        //Создаем отель из массива считаного из файлика
        Hotel hotel = new Hotel(getHotelRoomsMasFromFile(pathToFile));

        hotel.printList();
        //hotel.printList(false);
        //hotel.findByMaxCostAndPlacesToStay(50,50);
    }

    private static void addHotelRoomsMasToFile(String pathToFile, HotelRoom[] roomsList){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pathToFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(roomsList);
                oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static HotelRoom[] getHotelRoomsMasFromFile(String pathToFile){
        FileInputStream fis = null;
        HotelRoom[] roomsList = null;
        try {
            fis = new FileInputStream(pathToFile);
            ObjectInputStream oin = new ObjectInputStream(fis);
            roomsList  = (HotelRoom[]) oin.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomsList;
    }

    private static HotelRoom[] fillHotel(){

        HotelRoom[] roomsList = new HotelRoom [4];

        //пустая комната
        roomsList[0]=(new HotelRoom(
                "Common description for common room 1",
                1,
                10));

        //пустая комната
        roomsList[1]=(new HotelRoom(
                "Common description for common room 2",
                2,
                20));

        //заселились сегодня на 10 дней
        roomsList[2]=(new HotelRoom(
                "Common description for common room 3",
                3,
                30,30));

        //Забронирована на потом но сейчас свободна
        Date dateOfArrival = new Date(Long.MAX_VALUE);
        roomsList[3]=(new HotelRoom(
                "Common description for common room 4",
                4,
                40,true,dateOfArrival,10));

        return roomsList;
    }


}
