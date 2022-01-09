package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.Preduzece;
import pi.likvidatura.service.dto.PreduzeceDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-26T23:10:45+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class PreduzeceMapperImpl implements PreduzeceMapper {

    @Override
    public Preduzece toEntity(PreduzeceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Preduzece preduzece = new Preduzece();

        preduzece.setId( dto.getId() );
        preduzece.setNaziv( dto.getNaziv() );
        preduzece.setPib( dto.getPib() );
        preduzece.setMaticniBroj( dto.getMaticniBroj() );

        return preduzece;
    }

    @Override
    public PreduzeceDTO toDto(Preduzece entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String naziv = null;
        String pib = null;
        String maticniBroj = null;

        id = entity.getId();
        naziv = entity.getNaziv();
        pib = entity.getPib();
        maticniBroj = entity.getMaticniBroj();

        PreduzeceDTO preduzeceDTO = new PreduzeceDTO( id, naziv, pib, maticniBroj );

        return preduzeceDTO;
    }

    @Override
    public List<Preduzece> toEntity(List<PreduzeceDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Preduzece> list = new ArrayList<Preduzece>( dtoList.size() );
        for ( PreduzeceDTO preduzeceDTO : dtoList ) {
            list.add( toEntity( preduzeceDTO ) );
        }

        return list;
    }

    @Override
    public List<PreduzeceDTO> toDto(List<Preduzece> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PreduzeceDTO> list = new ArrayList<PreduzeceDTO>( entityList.size() );
        for ( Preduzece preduzece : entityList ) {
            list.add( toDto( preduzece ) );
        }

        return list;
    }

    @Override
    public PreduzeceDTO toDtoId(Preduzece preduzece) {
        if ( preduzece == null ) {
            return null;
        }

        Long id = null;

        id = preduzece.getId();

        String naziv = null;
        String pib = null;
        String maticniBroj = null;

        PreduzeceDTO preduzeceDTO = new PreduzeceDTO( id, naziv, pib, maticniBroj );

        return preduzeceDTO;
    }
}
