package Lab4;

import Lab4.task3and4.PlanePassenger;
import Lab4.task3and4.PlaneTransport;

/*
Завдання 1
Створити інтерфейс Run, для опису засобів пересування. Інтерфейс повинен
містити наступні методи:
 Метод виводу інформації про транспортний засіб
 Метод отримання швидкості пересування
 Метод отримання маси транспортного засобу
 Метод отримання кількості пасажирів
 Метод отримання кількості коліс (для транспортних засобів без коліс
отримувати кількість засобів передачі руху)

Завдання 2
Створити абстрактний клас Mashine, що реалізує інтерфейс Run. В даному
класі реалізувати:
 Константу максимальної швидкості
 Константу мінімальної швидкості
 Константу мінімальної кількості пасажирів
 Константу максимальної кількості пасажирів
 Поле з назвою транспортного засобу
 Поле зі швидкістю пересування в даний момент часу
 Конструктор класу Mashine (String name, int speed)
 Метод виводу інформації про транспортний засіб

Завдання 3
Створити суперклас для певного виду пересування. Від заданого суперкласу
створити двох прямих нащадків з певними властивостями. Суперкласи та
нащадки для студентів визначаються номером в списку викладача.(11. Літак транспортний, пасажирський)
Нащадки повинні реалізувати всі методи, які не реалізовані в абстрактному
класі. Дані методи повинні виводити на екран відповідну інформацію про
транспортний засіб.

Завдання 4
Створити демонстраційний клас, в якому створюються екземпляри обох
нащадків, та здійснюється виклик методів для виводу інформації про Ваш
засіб пересування.
 */

public class Main {
    public static void main(String[] args) {

        PlaneTransport planeTransport = new PlaneTransport("Boing 707",1000);
        planeTransport.printInfo();

        PlanePassenger planePassenger = new PlanePassenger("Ruslam",500);
        planePassenger.printInfo();

        PlaneTransport planeTransport1 = new PlaneTransport("Tesla",200);
        PlanePassenger planePassenger1 = new PlanePassenger("Turbo",4534);

        System.out.println("Хеш 1 = "+planeTransport.hashCode()+" Хеш 2"+planeTransport1.hashCode());
        System.out.println(planeTransport.equals(planeTransport1));

        System.out.println("Хеш 1 = "+planePassenger.hashCode()+" Хеш 2"+planePassenger1.hashCode());
        System.out.println(planePassenger.equals(planePassenger1));

        System.out.println(planeTransport.toString());
        System.out.println(planePassenger.toString());
    }

}
