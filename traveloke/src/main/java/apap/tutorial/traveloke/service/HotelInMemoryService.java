//package apap.tutorial.traveloke.service;
//
//import apap.tutorial.traveloke.model.HotelModel;
//import apap.tutorial.traveloke.repository.HotelDb;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@Transactional
//public class HotelInMemoryService implements HotelService{
//
//    @Autowired
//    HotelDb hotelDb;
//
//    @Override
//    public void addHotel(HotelModel hotel){ hotelDb.save(hotel);}
//
//    @Override
//    public List<HotelModel> getHotelList() {return hotelDb.findAll();}
//
//    @Override
//    public HotelModel getHotelByIdHotel(Long idHotel){
//        return hotelDb.findById(idHotel).get();
//    }
//
//    @Override
//    public HotelModel updateHotel(HotelModel hotel) {
//        HotelModel targetHotel = hotelDb.findById(hotel.getId()).get();
//        try{
//            targetHotel.setNamaHotel(hotel.getNamaHotel());
//            targetHotel.setAlamat(hotel.getAlamat());
//            targetHotel.setNomorTelepon(hotel.getNomorTelepon());
//            hotelDb.save(targetHotel);
//            return targetHotel;
//        }catch (NullPointerException nullException){
//            return null;
//        }
//    }
//
////
////    //Constructor
////    public HotelInMemoryService(){
////        listHotel = new ArrayList<>();
////    }
////
////    @Override
////    public void addHotel(HotelModel hotel){
////        listHotel.add(hotel);
////    }
////    @Override
////    public List<HotelModel> getHotelList(){
////        return listHotel;
////    }
////
////    @Override
////    public HotelModel getHotelByIdHotel(Long idHotel) {
////        return null;
////    }
////
////    @Override
////    public HotelModel updateHotel(HotelModel hotel) {
////        return null;
////    }
////
////    @Override
////    public HotelModel getHotelByIdHotel(String idHotel) {
////        HotelModel idcheck = null;
////        for (int i = 0; i < listHotel.size(); i++) {
////            idcheck = listHotel.get(i);
////            if(idHotel.equals(idcheck.getIdHotel())){
////                return idcheck;
////            }
////        }
////        return idcheck;
////    }
////
////    @Override
////    public void updateHotel(String idHotel, String noTelepon) {
////        HotelModel idcheck = null;
////        for (int i = 0; i < listHotel.size() ; i++) {
////            idcheck = listHotel.get(i);
////            if(idHotel.equals(idcheck.getIdHotel())){
////                idcheck.setNoTelepon(noTelepon);
////            }
////        }
////    }
////
////    @Override
////    public void deleteHotel(String idHotel) {
////        HotelModel idcheck = null;
////        for (int i = 0; i < listHotel.size(); i++) {
////            idcheck = listHotel.get(i);
////            if (idHotel.equals(idcheck.getIdHotel())) {
////                listHotel.remove(i);
////            }
////        }
////    }
////
////    @Override
////    public List<HotelModel> deleteAllList() {
////        if (listHotel.size() != 0) {
////            listHotel.clear();
////        }
////        return listHotel;
////    }
//
//}
