import java.util.ArrayList;

public class Hotel {
    private HotelRoom[] rooms;

    public Hotel (HotelRoom[] list){
        rooms= list;
    }

    public void printList(){
        for (HotelRoom room : rooms){
            System.out.println(room);
        }
    }
    public void printList(boolean isFree){
        for (HotelRoom room : rooms) {
            if (room.isFree() == isFree)
                System.out.println(room);
        }
    }
    public ArrayList<HotelRoom> findByMaxCostAndPlacesToStay (int maxCost, int placesToStay){
        ArrayList<HotelRoom> result = new ArrayList<HotelRoom>();

        for (HotelRoom room : rooms) {
            if ((room.isFree())&(room.getCostDay()<=maxCost)&(room.getCountPlacesToStay()<=placesToStay)){
                result.add(room);
                System.out.println(room.toString());
            }

        } return result;
    }
}

