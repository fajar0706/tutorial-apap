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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.time.*;

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
//    @GetMapping("/hotel/view/{idHotel}")
//    public String viewDetailHotel(
//            @PathVariable Long idHotel,
//            Model model){
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
////        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
//        model.addAttribute("hotel",hotel);
////        model.addAttribute("listKamar", listKamar);
//        return "view-hotel";
//    }
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
    @GetMapping("/hotel/viewall")
    public String viewAllHotel(Model model){
        List<HotelModel> listHotel = hotelService.getHotelList();
        LocalTime time = LocalTime.now();
        model.addAttribute("listHotel",listHotel);
        model.addAttribute("time",time);
        return "viewall-hotel";
    }
    @GetMapping("/hotel/delete/{idHotel}")
    public String deleteHotel(
            @PathVariable Long idHotel,
            Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        boolean test = hotelService.deleteHotel(hotel);
        model.addAttribute("test",test);
        return "view-hotel-delete";
    }


}
