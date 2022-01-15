package pi.likvidatura.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "kredit")
public class Kredit  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String imeIPrezime;

    private int stanje;

    public Kredit() {}

    public Kredit(Long id, String imeIPrezime, int stanje) {
        this.id = id;
        this.imeIPrezime = imeIPrezime;
        this.stanje = stanje;
    }

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
    }

    public int getStanje() {
        return stanje;
    }

    public void setStanje(int stanje) {
        this.stanje = stanje;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
