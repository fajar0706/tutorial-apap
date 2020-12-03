package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

//    @GetMapping("/kamar/add/{idHotel}")
//    private String addKamarFormPage(
//            @PathVariable Long idHotel,
//            Model model){
//        KamarModel kamar = new KamarModel();
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        List<KamarModel> listKamar = new ArrayList<KamarModel>();
//        listKamar.add(kamar);
//        kamar.setHotel(hotel);
//        model.addAttribute("kamar",kamar);
//        model.addAttribute("hotel", hotel);
//        model.addAttribute("listKamar",listKamar);
//        return "form-add-kamar";
//    }

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(@PathVariable Long idHotel, Model model){
        KamarModel kamar =new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        kamar.setHotel(hotel);
        model.addAttribute("kamar", kamar);

        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar",kamar);
        return "add-kamar";
    }
    @GetMapping("/kamar/change/{noKamar}")
    private String changeKamarFormPage(
            @PathVariable Long noKamar,
            Model model){
        KamarModel kamar = kamarService.getKamarByIdKamar(noKamar);
        model.addAttribute("kamar",kamar);
        return "form-update-kamar";
    }
    @PostMapping("/kamar/change")
    private String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model){
        KamarModel kamarUpdate = kamarService.updateKamar(kamar);
        model.addAttribute("kamar",kamar);
        return "update-kamar";
    }
//    @GetMapping("/kamar/delete/{noKamar}")
//    private String deleteKamar(
//            @PathVariable Long noKamar,
//            Model model){
//        KamarModel kamar = kamarService.getKamarByIdKamar(noKamar);
//        kamarService.deleteKamar(kamar);
//        model.addAttribute("kamar",kamar);
//        return "view-kamar-delete";
//    }
    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){
        model.addAttribute("kamarCount",hotel.getListKamar().size());
        for (KamarModel kamar : hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }
        return "view-kamar-delete";
    }
//    @PostMapping(value = "/kamar/add/{idHotel}", params = {"saveKamar"})
//    private String addKamarSubmit(
//            @ModelAttribute HotelModel hotel,
//            Model model
//    ){
////        HotelModel hotelGet= hotelService.getHotelByIdHotel(hotel.getId());
//        for (KamarModel kamar : hotel.getListKamar()) {
//            kamar.setHotel(hotel);
//            kamarService.addKamar(kamar);
//
//        }
//        model.addAttribute("listKamar",hotel.getListKamar());
//        return "add-kamar";
//    }
//
//    @PostMapping(value = "/kamar/add/{idHotel}", params = {"addBaris"})
//    private String addKamarFormRow(
//            @ModelAttribute HotelModel hotel,
//            Model model
//    ){
//        if(hotel.getListKamar() == null){
//            hotel.setListKamar(new ArrayList<KamarModel>());
//        }
//        hotel.getListKamar().add(new KamarModel());
//        model.addAttribute("hotel", hotel);
//
//        return "form-add-kamar";
//    }
//
//    @PostMapping(value = "/kamar/add/{idHotel}", params = {"deleteBaris"})
//    private String deleteKamarFormRow(
//            @ModelAttribute HotelModel hotel,
//            final HttpServletRequest req,
//            Model model
//    ){
//        final Integer rowid = Integer.valueOf(req.getParameter("deleteBaris"));
//        hotel.getListKamar().remove(rowid.intValue());
//
//        model.addAttribute("hotel", hotel);
//        return "form-add-kamar";
//    }

}
