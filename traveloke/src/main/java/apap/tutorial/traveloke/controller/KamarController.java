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

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model){
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = new ArrayList<KamarModel>();
        hotel.setListKamar(listKamar);
        hotel.getListKamar().add(kamar);
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }
//    @PostMapping("/kamar/add")
//    private String addKamarSubmit(
//            @ModelAttribute KamarModel kamar,
//            Model model){
//        kamarService.addKamar(kamar);
//        model.addAttribute("kamar",kamar);
//        return "add-kamar";
//    }
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
    @RequestMapping(value = "/kamar/add/{idHotel}", method = RequestMethod.POST, params={"save"})
    private String addKamarSubmit(@ModelAttribute HotelModel hotel, Model model){
        HotelModel hotel2 = hotelService.getHotelByIdHotelOptional(hotel.getId()).get();
        for (KamarModel kamar : hotel.getListKamar()){
            kamar.setHotel(hotel2);
            kamarService.addKamar(kamar);
            model.addAttribute("kamar",kamar);
        }
        return "add-kamar";
    }

    @RequestMapping(value ="/kamar/add/{idHotel}", method=RequestMethod.POST, params= {"addBaris"})
    private String addRow(@ModelAttribute HotelModel hotel, Model model) {
        if(hotel.getListKamar() == null) {
            hotel.setListKamar(new ArrayList<KamarModel>());
        }
        hotel.getListKamar().add(new KamarModel());

        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @RequestMapping(value ="/kamar/add/{idHotel}", method=RequestMethod.POST, params= {"deleteBaris"})
    private String removeRow(@ModelAttribute HotelModel hotel , final HttpServletRequest req, Model model) {
        final Integer rowId = Integer.valueOf(req.getParameter("deleteBaris"));
        hotel.getListKamar().remove(rowId.intValue());

        model.addAttribute("hotel" , hotel);
        return "form-add-kamar";
    }
}
