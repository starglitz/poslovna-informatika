package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.Banka;
import pi.likvidatura.service.dto.BankaDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-29T08:39:19+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
@Component
public class BankaMapperImpl implements BankaMapper {

    @Override
    public Banka toEntity(BankaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Banka banka = new Banka();

        banka.setId( dto.getId() );
        banka.setSifra( dto.getSifra() );
        banka.setNaziv( dto.getNaziv() );

        return banka;
    }

    @Override
    public BankaDTO toDto(Banka entity) {
        if ( entity == null ) {
            return null;
        }

        BankaDTO bankaDTO = new BankaDTO();

        bankaDTO.setId( entity.getId() );
        bankaDTO.setSifra( entity.getSifra() );
        bankaDTO.setNaziv( entity.getNaziv() );

        return bankaDTO;
    }

    @Override
    public List<Banka> toEntity(List<BankaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Banka> list = new ArrayList<Banka>( dtoList.size() );
        for ( BankaDTO bankaDTO : dtoList ) {
            list.add( toEntity( bankaDTO ) );
        }

        return list;
    }

    @Override
    public List<BankaDTO> toDto(List<Banka> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BankaDTO> list = new ArrayList<BankaDTO>( entityList.size() );
        for ( Banka banka : entityList ) {
            list.add( toDto( banka ) );
        }

        return list;
    }

    @Override
    public BankaDTO toDtoId(Banka banka) {
        if ( banka == null ) {
            return null;
        }

        BankaDTO bankaDTO = new BankaDTO();

        bankaDTO.setId( banka.getId() );

        return bankaDTO;
    }
}
