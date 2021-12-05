package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.BankarskiRacun;
import pi.likvidatura.service.dto.BankarskiRacunDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-29T08:39:19+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
@Component
public class BankarskiRacunMapperImpl implements BankarskiRacunMapper {

    @Autowired
    private PreduzeceMapper preduzeceMapper;
    @Autowired
    private BankaMapper bankaMapper;

    @Override
    public BankarskiRacun toEntity(BankarskiRacunDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BankarskiRacun bankarskiRacun = new BankarskiRacun();

        bankarskiRacun.setId( dto.getId() );
        bankarskiRacun.setBrojRacuna( dto.getBrojRacuna() );
        bankarskiRacun.preduzece( preduzeceMapper.toEntity( dto.getPreduzece() ) );
        bankarskiRacun.banka( bankaMapper.toEntity( dto.getBanka() ) );

        return bankarskiRacun;
    }

    @Override
    public List<BankarskiRacun> toEntity(List<BankarskiRacunDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BankarskiRacun> list = new ArrayList<BankarskiRacun>( dtoList.size() );
        for ( BankarskiRacunDTO bankarskiRacunDTO : dtoList ) {
            list.add( toEntity( bankarskiRacunDTO ) );
        }

        return list;
    }

    @Override
    public List<BankarskiRacunDTO> toDto(List<BankarskiRacun> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BankarskiRacunDTO> list = new ArrayList<BankarskiRacunDTO>( entityList.size() );
        for ( BankarskiRacun bankarskiRacun : entityList ) {
            list.add( toDto( bankarskiRacun ) );
        }

        return list;
    }

    @Override
    public BankarskiRacunDTO toDto(BankarskiRacun s) {
        if ( s == null ) {
            return null;
        }

        BankarskiRacunDTO bankarskiRacunDTO = new BankarskiRacunDTO();

        bankarskiRacunDTO.setPreduzece( preduzeceMapper.toDtoId( s.getPreduzece() ) );
        bankarskiRacunDTO.setBanka( bankaMapper.toDtoId( s.getBanka() ) );
        bankarskiRacunDTO.setId( s.getId() );
        bankarskiRacunDTO.setBrojRacuna( s.getBrojRacuna() );

        return bankarskiRacunDTO;
    }

    @Override
    public BankarskiRacunDTO toDtoId(BankarskiRacun bankarskiRacun) {
        if ( bankarskiRacun == null ) {
            return null;
        }

        BankarskiRacunDTO bankarskiRacunDTO = new BankarskiRacunDTO();

        bankarskiRacunDTO.setId( bankarskiRacun.getId() );

        return bankarskiRacunDTO;
    }
}
