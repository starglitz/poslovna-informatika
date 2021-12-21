package pi.likvidatura.domain;

import javax.persistence.*;

@Entity
@Table(name = "poslovni_partner")
public class PoslovniPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private String adresa;

    private String telefon;

    public PoslovniPartner() {
    }

    public PoslovniPartner(Long id, String naziv, String adresa, String telefon) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
