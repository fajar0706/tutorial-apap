package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.swing.text.html.Option;
import javax.persistence.GeneratedValue;
import java.util.List;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel",new HotelModel());
        return "form-add-hotel";
    }
    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }
    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("hotel",hotel);
        return "form-update-hotel";
    }
    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }
    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value = "idHotel") Long idHotel,
            Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        model.addAttribute("hotel",hotel);
        model.addAttribute("listKamar", listKamar);
        return "view-hotel";
    }
//
//    //Routing URL
//    @RequestMapping("/hotel/add")
//    public String addHotel(
//            //request parameter yang ingin di bawa
//            @RequestParam(value = "idHotel", required = true) String idHotel,
//            @RequestParam(value = "namaHotel", required = true) String namaHotel,
//            @RequestParam(value = "alamat", required = true) String alamat,
//            @RequestParam(value = "noTelepon", required = true) String noTelepon,
//            Model model
//    ){
//        // membuat object HotelModel
//        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);
//
//        // memanggil service addHotel
//        hotelService.addHotel(hotel);
//
//        // add variable id hotel ke 'idhotel' untuk dirender pada thymeleaf
//        model.addAttribute("idHotel",idHotel);
//
//        // return view template yang digunakan
//        return "add-hotel";
//    }
//    @RequestMapping("/hotel/viewall")
//    public String listHotel(Model model){
//        // mendapatkan semua HotelModel
//        List<HotelModel> listHotel = hotelService.getHotelList();
//
//        // add variabel semua HotelModel ke "listHotel" untuk dirender pada thymeleaf
//        model.addAttribute("listHotel",listHotel);
//
//        // return view template yang diinginkan
//        return "viewall-hotel";
//    }
//    @RequestMapping("/hotel/view")
//    public String detailHotel(
//            @RequestParam(value = "idHotel") String idHotel,
//            Model model){
//
//        // mendapatkan HotelModel sesuai dengan idHotel
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//
//        // add variable HotelModel ke 'hotel' untuk render pada thymeleaf
//        model.addAttribute("hotel", hotel);
//
//        return "view-hotel";
//    }
//    @RequestMapping("/hotel/view/id-hotel/{idHotel}")
//    public String detailHotel2(
//            @PathVariable(value = "idHotel")String idHotel,
//                Model model){
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//
//        model.addAttribute("hotel", hotel);
//        return "view-hotel";
//    }
//    @RequestMapping("/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
//    public String updateHotel(
//            @PathVariable(value = "idHotel") String idHotel,
//            @PathVariable(value = "noTelepon") String noTelepon,
//            Model model){
//
//        // memanggil service updateHotel
//        hotelService.updateHotel(idHotel,noTelepon);
//
//        // add variable HotelModel ke 'hotel' untuk render pada thymeleaf
//        model.addAttribute("noTelepon", noTelepon);
//        model.addAttribute("idHotel", idHotel);
//
//        return "view-hotel-update";
//    }
//    @RequestMapping("/hotel/delete/id-hotel/{idHotel}")
//    public String deleteHotel(
//            @PathVariable(value = "idHotel") String idHotel,
//            Model model){
//
//        // memanggil service deleteHotel
//        hotelService.deleteHotel(idHotel);
//
//        // add variable HotelModel ke 'hotel' untuk render pada thymeleaf
//        model.addAttribute("idHotel", idHotel);
//
//        return "view-hotel-delete";
//    }
//
//    @RequestMapping("/hotel/delete/all")
//    public String deleteAll(Model model){
//        List<HotelModel> listHotel = hotelService.deleteAllList();
//        model.addAttribute("listhotel",listHotel);
//        return "view-delete-all";
//    }

}
