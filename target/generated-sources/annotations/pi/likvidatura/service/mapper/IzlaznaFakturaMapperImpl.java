package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.domain.PoslovniPartner;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;
import pi.likvidatura.service.dto.PoslovnaGodinaDTO;
import pi.likvidatura.service.dto.PoslovniPartnerDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-26T19:06:33+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class IzlaznaFakturaMapperImpl implements IzlaznaFakturaMapper {

    @Autowired
    private PoslovnaGodinaMapper poslovnaGodinaMapper;

    @Override
    public IzlaznaFaktura toEntity(IzlaznaFakturaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        IzlaznaFaktura izlaznaFaktura = new IzlaznaFaktura();

        izlaznaFaktura.setId( dto.getId() );
        izlaznaFaktura.setBrojFakture( dto.getBrojFakture() );
        izlaznaFaktura.setIznosZaPlacanje( dto.getIznosZaPlacanje() );
        izlaznaFaktura.poslovnaGodina( poslovnaGodinaMapper.toEntity( dto.getPoslovnaGodina() ) );
        izlaznaFaktura.setPoslovniPartner( poslovniPartnerDTOToPoslovniPartner( dto.getPoslovniPartner() ) );
        izlaznaFaktura.setIsplaceniIznos( dto.getIsplaceniIznos() );
        izlaznaFaktura.setZatvorena( dto.isZatvorena() );

        return izlaznaFaktura;
    }

    @Override
    public List<IzlaznaFaktura> toEntity(List<IzlaznaFakturaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<IzlaznaFaktura> list = new ArrayList<IzlaznaFaktura>( dtoList.size() );
        for ( IzlaznaFakturaDTO izlaznaFakturaDTO : dtoList ) {
            list.add( toEntity( izlaznaFakturaDTO ) );
        }

        return list;
    }

    @Override
    public List<IzlaznaFakturaDTO> toDto(List<IzlaznaFaktura> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<IzlaznaFakturaDTO> list = new ArrayList<IzlaznaFakturaDTO>( entityList.size() );
        for ( IzlaznaFaktura izlaznaFaktura : entityList ) {
            list.add( toDto( izlaznaFaktura ) );
        }

        return list;
    }

    @Override
    public IzlaznaFakturaDTO toDto(IzlaznaFaktura s) {
        if ( s == null ) {
            return null;
        }

        PoslovnaGodinaDTO poslovnaGodina = null;
        Long id = null;
        String brojFakture = null;
        Double iznosZaPlacanje = null;
        PoslovniPartnerDTO poslovniPartner = null;
        Double isplaceniIznos = null;
        boolean zatvorena = false;

        poslovnaGodina = poslovnaGodinaMapper.toDtoId( s.getPoslovnaGodina() );
        id = s.getId();
        brojFakture = s.getBrojFakture();
        iznosZaPlacanje = s.getIznosZaPlacanje();
        poslovniPartner = poslovniPartnerToPoslovniPartnerDTO( s.getPoslovniPartner() );
        isplaceniIznos = s.getIsplaceniIznos();
        zatvorena = s.isZatvorena();

        IzlaznaFakturaDTO izlaznaFakturaDTO = new IzlaznaFakturaDTO( id, brojFakture, iznosZaPlacanje, poslovnaGodina, poslovniPartner, isplaceniIznos, zatvorena );

        return izlaznaFakturaDTO;
    }

    protected PoslovniPartner poslovniPartnerDTOToPoslovniPartner(PoslovniPartnerDTO poslovniPartnerDTO) {
        if ( poslovniPartnerDTO == null ) {
            return null;
        }

        PoslovniPartner poslovniPartner = new PoslovniPartner();

        poslovniPartner.setId( poslovniPartnerDTO.getId() );
        poslovniPartner.setNaziv( poslovniPartnerDTO.getNaziv() );
        poslovniPartner.setAdresa( poslovniPartnerDTO.getAdresa() );
        poslovniPartner.setTelefon( poslovniPartnerDTO.getTelefon() );

        return poslovniPartner;
    }

    protected PoslovniPartnerDTO poslovniPartnerToPoslovniPartnerDTO(PoslovniPartner poslovniPartner) {
        if ( poslovniPartner == null ) {
            return null;
        }

        PoslovniPartnerDTO poslovniPartnerDTO = new PoslovniPartnerDTO();

        poslovniPartnerDTO.setId( poslovniPartner.getId() );
        poslovniPartnerDTO.setNaziv( poslovniPartner.getNaziv() );
        poslovniPartnerDTO.setAdresa( poslovniPartner.getAdresa() );
        poslovniPartnerDTO.setTelefon( poslovniPartner.getTelefon() );

        return poslovniPartnerDTO;
    }
}
