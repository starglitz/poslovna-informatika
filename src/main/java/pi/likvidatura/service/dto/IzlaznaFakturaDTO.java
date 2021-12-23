package pi.likvidatura.service.dto;

import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.service.mapper.PoslovnaGodinaMapper;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link pi.likvidatura.domain.IzlaznaFaktura} entity.
 */
public class IzlaznaFakturaDTO implements Serializable {

    private Long id;

    private String brojFakture;

    private Double iznosZaPlacanje;

    private PoslovnaGodinaDTO poslovnaGodina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojFakture() {
        return brojFakture;
    }

    public void setBrojFakture(String brojFakture) {
        this.brojFakture = brojFakture;
    }

    public Double getIznosZaPlacanje() {
        return iznosZaPlacanje;
    }

    public void setIznosZaPlacanje(Double iznosZaPlacanje) {
        this.iznosZaPlacanje = iznosZaPlacanje;
    }

    public PoslovnaGodinaDTO getPoslovnaGodina() {
        return poslovnaGodina;
    }

    public void setPoslovnaGodina(PoslovnaGodinaDTO poslovnaGodina) {
        this.poslovnaGodina = poslovnaGodina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IzlaznaFakturaDTO)) {
            return false;
        }

        IzlaznaFakturaDTO izlaznaFakturaDTO = (IzlaznaFakturaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, izlaznaFakturaDTO.id);
    }

    public IzlaznaFakturaDTO(Long id, String brojFakture, Double iznosZaPlacanje, PoslovnaGodinaDTO poslovnaGodina) {
        this.id = id;
        this.brojFakture = brojFakture;
        this.iznosZaPlacanje = iznosZaPlacanje;
        this.poslovnaGodina = poslovnaGodina;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IzlaznaFakturaDTO{" +
            "id=" + getId() +
            ", brojFakture='" + getBrojFakture() + "'" +
            ", iznosZaPlacanje=" + getIznosZaPlacanje() +
            ", poslovnaGodina=" + getPoslovnaGodina() +
            "}";
    }

    public static IzlaznaFakturaDTO fromEntity(IzlaznaFaktura faktura) {
        return new IzlaznaFakturaDTO(faktura.getId(), faktura.getBrojFakture(),
                faktura.getIznosZaPlacanje(),
                PoslovnaGodinaDTO.fromEntity(faktura.getPoslovnaGodina()));
    }
}
