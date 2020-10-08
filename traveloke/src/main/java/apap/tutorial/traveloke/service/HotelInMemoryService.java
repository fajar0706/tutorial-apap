package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class HotelInMemoryService implements HotelService{
    private List<HotelModel> listHotel;

    //Constructor
    public HotelInMemoryService(){
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel){
        listHotel.add(hotel);
    }
    @Override
    public List<HotelModel> getHotelList(){
        return listHotel;
    }
    @Override
    public HotelModel getHotelByIdHotel(String idHotel) {
        HotelModel idcheck = null;
        for (int i = 0; i < listHotel.size(); i++) {
            idcheck = listHotel.get(i);
            if(idHotel.equals(idcheck.getIdHotel())){
                return idcheck;
            }
        }
        return idcheck;
    }

    @Override
    public void updateHotel(String idHotel, String noTelepon) {
        HotelModel idcheck = null;
        for (int i = 0; i < listHotel.size() ; i++) {
            idcheck = listHotel.get(i);
            if(idHotel.equals(idcheck.getIdHotel())){
                idcheck.setNoTelepon(noTelepon);
            }
        }
    }

    @Override
    public void deleteHotel(String idHotel) {
        HotelModel idcheck = null;
        for (int i = 0; i < listHotel.size(); i++) {
            idcheck = listHotel.get(i);
            if (idHotel.equals(idcheck.getIdHotel())) {
                listHotel.remove(i);
            }
        }
    }

    @Override
    public List<HotelModel> deleteAllList() {
        if (listHotel.size() != 0) {
            listHotel.clear();
        }
        return listHotel;
    }

}
