package pi.likvidatura.service.dto;


import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.domain.ZatvaranjeFakture;

import javax.persistence.ManyToOne;
import java.util.List;

public class ZatvaranjeFaktureDTO {

    private Long id;

    private int iznos;

    private StavkaIzvodaDTO stavkaIzvoda;

    private IzlaznaFakturaDTO faktura;

    public ZatvaranjeFaktureDTO() {};

    public ZatvaranjeFaktureDTO(Long id,
                                int iznos,
                                StavkaIzvodaDTO stavkaIzvoda,
                                IzlaznaFakturaDTO faktura) {
        this.id = id;
        this.iznos = iznos;
        this.stavkaIzvoda = stavkaIzvoda;
        this.faktura = faktura;
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

    public StavkaIzvodaDTO getStavkaIzvoda() {
        return stavkaIzvoda;
    }

    public void setStavkaIzvoda(StavkaIzvodaDTO stavkaIzvoda) {
        this.stavkaIzvoda = stavkaIzvoda;
    }

    public IzlaznaFakturaDTO getFaktura() {
        return faktura;
    }

    public void setFaktura(IzlaznaFakturaDTO faktura) {
        this.faktura = faktura;
    }

    public static ZatvaranjeFaktureDTO fromEntity(ZatvaranjeFakture zatvaranje) {
        return new ZatvaranjeFaktureDTO(zatvaranje.getId(), zatvaranje.getIznos(),
                StavkaIzvodaDTO.fromEntity(zatvaranje.getStavkaIzvoda()),
                IzlaznaFakturaDTO.fromEntity(zatvaranje.getFaktura()));
    }

}
