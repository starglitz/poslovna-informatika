package pi.likvidatura.service.dto;


import pi.likvidatura.domain.Kredit;

public class KreditDTO {

    private Long id;

    private String imeIPrezime;

    private int stanje;

    public KreditDTO() {}

    public KreditDTO(Long id, String imeIPrezime, int stanje) {
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

    public KreditDTO fromEntity(Kredit kredit) {
        return new KreditDTO(kredit.getId(), kredit.getImeIPrezime(), kredit.getStanje());
    }
}

