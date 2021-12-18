package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-07T21:14:32+0100",
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

        IzlaznaFakturaDTO izlaznaFakturaDTO = new IzlaznaFakturaDTO();

        izlaznaFakturaDTO.setPoslovnaGodina( poslovnaGodinaMapper.toDtoId( s.getPoslovnaGodina() ) );
        izlaznaFakturaDTO.setId( s.getId() );
        izlaznaFakturaDTO.setBrojFakture( s.getBrojFakture() );
        izlaznaFakturaDTO.setIznosZaPlacanje( s.getIznosZaPlacanje() );

        return izlaznaFakturaDTO;
    }
}
