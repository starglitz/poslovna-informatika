package pi.likvidatura.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A IzlaznaFaktura.
 */
@Entity
@Table(name = "izlazna_faktura")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class IzlaznaFaktura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "broj_fakture")
    private String brojFakture;

    @Column(name = "iznos_za_placanje")
    private Double iznosZaPlacanje;

    private Double isplaceniIznos;

    @ManyToOne
    private PoslovnaGodina poslovnaGodina;

    @ManyToOne
    private PoslovniPartner poslovniPartner;

    private boolean zatvorena;

    public Long getId() {
        return this.id;
    }

    public IzlaznaFaktura id(Long id) {
        this.setId(id);
        return this;
    }

    public IzlaznaFaktura(){};

    public IzlaznaFaktura(Long id, String brojFakture,
                          Double iznosZaPlacanje,
                          PoslovnaGodina poslovnaGodina,
                          PoslovniPartner poslovniPartner,Double isplaceniIznos, boolean zatvorena) {
        this.id = id;
        this.brojFakture = brojFakture;
        this.iznosZaPlacanje = iznosZaPlacanje;
        this.poslovnaGodina = poslovnaGodina;
        this.poslovniPartner = poslovniPartner;
        this.isplaceniIznos = isplaceniIznos;
        this.zatvorena = zatvorena;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojFakture() {
        return this.brojFakture;
    }

    public IzlaznaFaktura brojFakture(String brojFakture) {
        this.setBrojFakture(brojFakture);
        return this;
    }

    public void setBrojFakture(String brojFakture) {
        this.brojFakture = brojFakture;
    }

    public Double getIznosZaPlacanje() {
        return this.iznosZaPlacanje;
    }

    public IzlaznaFaktura iznosZaPlacanje(Double iznosZaPlacanje) {
        this.setIznosZaPlacanje(iznosZaPlacanje);
        return this;
    }

    public void setIznosZaPlacanje(Double iznosZaPlacanje) {
        this.iznosZaPlacanje = iznosZaPlacanje;
    }

    public PoslovnaGodina getPoslovnaGodina() {
        return this.poslovnaGodina;
    }

    public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
        this.poslovnaGodina = poslovnaGodina;
    }

    public IzlaznaFaktura poslovnaGodina(PoslovnaGodina poslovnaGodina) {
        this.setPoslovnaGodina(poslovnaGodina);
        return this;
    }

    public PoslovniPartner getPoslovniPartner() {
        return poslovniPartner;
    }

    public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
        this.poslovniPartner = poslovniPartner;
    }

    public Double getIsplaceniIznos() {
        return isplaceniIznos;
    }

    public void setIsplaceniIznos(Double isplaceniIznos) {
        this.isplaceniIznos = isplaceniIznos;
    }

    public boolean isZatvorena() {
        return zatvorena;
    }

    public void setZatvorena(boolean zatvorena) {
        this.zatvorena = zatvorena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IzlaznaFaktura)) {
            return false;
        }
        return id != null && id.equals(((IzlaznaFaktura) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IzlaznaFaktura{" +
            "id=" + getId() +
            ", brojFakture='" + getBrojFakture() + "'" +
            ", iznosZaPlacanje=" + getIznosZaPlacanje() +
            "}";
    }
}
