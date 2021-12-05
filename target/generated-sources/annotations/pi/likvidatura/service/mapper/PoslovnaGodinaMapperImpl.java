package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.PoslovnaGodina;
import pi.likvidatura.service.dto.PoslovnaGodinaDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-29T08:39:19+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
@Component
public class PoslovnaGodinaMapperImpl implements PoslovnaGodinaMapper {

    @Autowired
    private PreduzeceMapper preduzeceMapper;

    @Override
    public PoslovnaGodina toEntity(PoslovnaGodinaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PoslovnaGodina poslovnaGodina = new PoslovnaGodina();

        poslovnaGodina.setId( dto.getId() );
        poslovnaGodina.setGodina( dto.getGodina() );
        poslovnaGodina.setZakljucena( dto.getZakljucena() );
        poslovnaGodina.preduzece( preduzeceMapper.toEntity( dto.getPreduzece() ) );

        return poslovnaGodina;
    }

    @Override
    public List<PoslovnaGodina> toEntity(List<PoslovnaGodinaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PoslovnaGodina> list = new ArrayList<PoslovnaGodina>( dtoList.size() );
        for ( PoslovnaGodinaDTO poslovnaGodinaDTO : dtoList ) {
            list.add( toEntity( poslovnaGodinaDTO ) );
        }

        return list;
    }

    @Override
    public List<PoslovnaGodinaDTO> toDto(List<PoslovnaGodina> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PoslovnaGodinaDTO> list = new ArrayList<PoslovnaGodinaDTO>( entityList.size() );
        for ( PoslovnaGodina poslovnaGodina : entityList ) {
            list.add( toDto( poslovnaGodina ) );
        }

        return list;
    }

    @Override
    public PoslovnaGodinaDTO toDto(PoslovnaGodina s) {
        if ( s == null ) {
            return null;
        }

        PoslovnaGodinaDTO poslovnaGodinaDTO = new PoslovnaGodinaDTO();

        poslovnaGodinaDTO.setPreduzece( preduzeceMapper.toDtoId( s.getPreduzece() ) );
        poslovnaGodinaDTO.setId( s.getId() );
        poslovnaGodinaDTO.setGodina( s.getGodina() );
        poslovnaGodinaDTO.setZakljucena( s.getZakljucena() );

        return poslovnaGodinaDTO;
    }

    @Override
    public PoslovnaGodinaDTO toDtoId(PoslovnaGodina poslovnaGodina) {
        if ( poslovnaGodina == null ) {
            return null;
        }

        PoslovnaGodinaDTO poslovnaGodinaDTO = new PoslovnaGodinaDTO();

        poslovnaGodinaDTO.setId( poslovnaGodina.getId() );

        return poslovnaGodinaDTO;
    }
}
