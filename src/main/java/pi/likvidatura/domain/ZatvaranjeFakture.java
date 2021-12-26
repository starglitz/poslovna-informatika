package pi.likvidatura.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zatvaranje_fakture")
public class ZatvaranjeFakture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int iznos;

    @ManyToOne
    private StavkaIzvoda stavkaIzvoda;

    @ManyToOne
    private IzlaznaFaktura faktura;

    public ZatvaranjeFakture() {}

    public ZatvaranjeFakture(Long id, int iznos, StavkaIzvoda stavkaIzvoda, IzlaznaFaktura faktura) {
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

    public StavkaIzvoda getStavkaIzvoda() {
        return stavkaIzvoda;
    }

    public void setStavkaIzvoda(StavkaIzvoda stavkaIzvoda) {
        this.stavkaIzvoda = stavkaIzvoda;
    }

    public IzlaznaFaktura getFaktura() {
        return faktura;
    }

    public void setFaktura(IzlaznaFaktura faktura) {
        this.faktura = faktura;
    }
}
