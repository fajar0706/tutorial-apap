package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //Routing URL
    @RequestMapping("/hotel/add")
    public String addHotel(
            //request parameter yang ingin di bawa
            @RequestParam(value = "idHotel", required = true) String idHotel,
            @RequestParam(value = "namaHotel", required = true) String namaHotel,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
    ){
        // membuat object HotelModel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        // memanggil service addHotel
        hotelService.addHotel(hotel);

        // add variable id hotel ke 'idhotel' untuk dirender pada thymeleaf
        model.addAttribute("idHotel",idHotel);

        // return view template yang digunakan
        return "add-hotel";
    }
    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){
        // mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

        // add variabel semua HotelModel ke "listHotel" untuk dirender pada thymeleaf
        model.addAttribute("listHotel",listHotel);

        // return view template yang diinginkan
        return "viewall-hotel";
    }
    @RequestMapping("/hotel/view")
    public String detailHotel(
            @RequestParam(value = "idHotel") String idHotel,
            Model model){

        // mendapatkan HotelModel sesuai dengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        // add variable HotelModel ke 'hotel' untuk render pada thymeleaf
        model.addAttribute("hotel", hotel);

        return "view-hotel";
    }
}
