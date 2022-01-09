package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.BankarskiRacun;
import pi.likvidatura.service.dto.BankaDTO;
import pi.likvidatura.service.dto.BankarskiRacunDTO;
import pi.likvidatura.service.dto.PreduzeceDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-26T23:10:45+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
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

        PreduzeceDTO preduzece = null;
        BankaDTO banka = null;
        Long id = null;
        String brojRacuna = null;

        preduzece = preduzeceMapper.toDtoId( s.getPreduzece() );
        banka = bankaMapper.toDtoId( s.getBanka() );
        id = s.getId();
        brojRacuna = s.getBrojRacuna();

        BankarskiRacunDTO bankarskiRacunDTO = new BankarskiRacunDTO( id, brojRacuna, preduzece, banka );

        return bankarskiRacunDTO;
    }

    @Override
    public BankarskiRacunDTO toDtoId(BankarskiRacun bankarskiRacun) {
        if ( bankarskiRacun == null ) {
            return null;
        }

        Long id = null;

        id = bankarskiRacun.getId();

        String brojRacuna = null;
        PreduzeceDTO preduzece = null;
        BankaDTO banka = null;

        BankarskiRacunDTO bankarskiRacunDTO = new BankarskiRacunDTO( id, brojRacuna, preduzece, banka );

        return bankarskiRacunDTO;
    }
}
