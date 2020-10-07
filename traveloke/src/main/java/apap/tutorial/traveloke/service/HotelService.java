package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import java.util.List;

public interface HotelService {
    // method untuk menambah Hotel
    void addHotel(HotelModel hotel);

    // method untuk mendapatkan daftar Hotel yang telah tersimpan pada list
    List<HotelModel> getHotelList();

    // method untuk mendapatkan data sebuah hotel berdasarkan id hotel
    HotelModel getHotelByIdHotel(String idHotel);

    // method untuk melakukan update data
    void updateHotel(String idHotel, String noTelepon);

    void deleteHotel(String idHotel);

}
