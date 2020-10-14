package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {

    void addKamar(KamarModel kamar);

    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel getKamarByIdKamar(Long noKamar);

    KamarModel updateKamar(KamarModel kamar);

    void deleteKamar(KamarModel kamar);

    List<KamarModel> getKamarByNamaKamarDanTipe(String namaKamar, Integer tipe);
}
