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

    @OneToMany
    private List<StavkaIzvoda> stavkeIzvoda;

    @OneToMany
    private List<IzlaznaFaktura> fakture;

    public ZatvaranjeFakture() {}

    public ZatvaranjeFakture(int iznos, List<StavkaIzvoda> stavkeIzvoda, List<IzlaznaFaktura> fakture) {
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

    public List<StavkaIzvoda> getStavkeIzvoda() {
        return stavkeIzvoda;
    }

    public void setStavkeIzvoda(List<StavkaIzvoda> stavkeIzvoda) {
        this.stavkeIzvoda = stavkeIzvoda;
    }

    public List<IzlaznaFaktura> getFakture() {
        return fakture;
    }

    public void setFakture(List<IzlaznaFaktura> fakture) {
        this.fakture = fakture;
    }
}
