package pi.likvidatura.service.dto;


import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.domain.ZatvaranjeFakture;

import javax.persistence.ManyToOne;
import java.util.List;

public class ZatvaranjeFaktureDTO {

    private Long id;

    private int iznos;

    @ManyToOne
    private List<StavkaIzvodaDTO> stavkeIzvoda;

    @ManyToOne
    private List<IzlaznaFakturaDTO> fakture;

    public ZatvaranjeFaktureDTO() {};

    public ZatvaranjeFaktureDTO(Long id, int iznos, List<StavkaIzvodaDTO> stavkeIzvoda,
                                List<IzlaznaFakturaDTO> fakture) {
        this.id = id;
        this.iznos = iznos;
        this.stavkeIzvoda = stavkeIzvoda;
        this.fakture = fakture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public List<StavkaIzvodaDTO> getStavkeIzvoda() {
        return stavkeIzvoda;
    }

    public void setStavkeIzvoda(List<StavkaIzvodaDTO> stavkeIzvoda) {
        this.stavkeIzvoda = stavkeIzvoda;
    }

    public List<IzlaznaFakturaDTO> getFakture() {
        return fakture;
    }

    public void setFakture(List<IzlaznaFakturaDTO> fakture) {
        this.fakture = fakture;
    }

    public static ZatvaranjeFaktureDTO fromEntity(ZatvaranjeFakture zatvaranje) {
        return new ZatvaranjeFaktureDTO(zatvaranje.getId(), zatvaranje.getIznos(),
                StavkaIzvodaDTO.fromEntityList(zatvaranje.getStavkeIzvoda()),
                IzlaznaFakturaDTO.fromEntityList(zatvaranje.getFakture()));
    }

}
