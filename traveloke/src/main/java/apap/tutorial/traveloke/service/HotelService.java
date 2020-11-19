package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import java.util.List;
import java.util.Optional;

public interface HotelService {
    // method untuk menambah Hotel
    void addHotel(HotelModel hotel);

    // method untuk mendapatkan daftar Hotel yang telah tersimpan pada list
    List<HotelModel> getHotelList();

    // method untuk mendapatkan data sebuah hotel berdasarkan id hotel
    HotelModel getHotelByIdHotel(Long idHotel);
    Optional<HotelModel> getHotelByIdHotelOptional(Long idHotel);
    // Method untuk update hotel
    HotelModel updateHotel(HotelModel hotel);



    // method untuk melakukan update data
//    void updateHotel(String idHotel, String noTelepon);
//
    boolean deleteHotel(HotelModel hotel);
//
//    List<HotelModel> deleteAllList();
}
