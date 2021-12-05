package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.DnevnoStanje;
import pi.likvidatura.service.dto.DnevnoStanjeDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-29T08:39:18+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
@Component
public class DnevnoStanjeMapperImpl implements DnevnoStanjeMapper {

    @Autowired
    private BankarskiRacunMapper bankarskiRacunMapper;

    @Override
    public DnevnoStanje toEntity(DnevnoStanjeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DnevnoStanje dnevnoStanje = new DnevnoStanje();

        dnevnoStanje.setId( dto.getId() );
        dnevnoStanje.setBrojIzvoda( dto.getBrojIzvoda() );
        dnevnoStanje.setDatumIzvoda( dto.getDatumIzvoda() );
        dnevnoStanje.setPrethodnoStanje( dto.getPrethodnoStanje() );
        dnevnoStanje.setPrometUKorist( dto.getPrometUKorist() );
        dnevnoStanje.setPrometNaTeret( dto.getPrometNaTeret() );
        dnevnoStanje.setNovoStanje( dto.getNovoStanje() );
        dnevnoStanje.setRezervisano( dto.getRezervisano() );
        dnevnoStanje.bankarskiRacun( bankarskiRacunMapper.toEntity( dto.getBankarskiRacun() ) );

        return dnevnoStanje;
    }

    @Override
    public List<DnevnoStanje> toEntity(List<DnevnoStanjeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DnevnoStanje> list = new ArrayList<DnevnoStanje>( dtoList.size() );
        for ( DnevnoStanjeDTO dnevnoStanjeDTO : dtoList ) {
            list.add( toEntity( dnevnoStanjeDTO ) );
        }

        return list;
    }

    @Override
    public List<DnevnoStanjeDTO> toDto(List<DnevnoStanje> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DnevnoStanjeDTO> list = new ArrayList<DnevnoStanjeDTO>( entityList.size() );
        for ( DnevnoStanje dnevnoStanje : entityList ) {
            list.add( toDto( dnevnoStanje ) );
        }

        return list;
    }

    @Override
    public DnevnoStanjeDTO toDto(DnevnoStanje s) {
        if ( s == null ) {
            return null;
        }

        DnevnoStanjeDTO dnevnoStanjeDTO = new DnevnoStanjeDTO();

        dnevnoStanjeDTO.setBankarskiRacun( bankarskiRacunMapper.toDtoId( s.getBankarskiRacun() ) );
        dnevnoStanjeDTO.setId( s.getId() );
        dnevnoStanjeDTO.setBrojIzvoda( s.getBrojIzvoda() );
        dnevnoStanjeDTO.setDatumIzvoda( s.getDatumIzvoda() );
        dnevnoStanjeDTO.setPrethodnoStanje( s.getPrethodnoStanje() );
        dnevnoStanjeDTO.setPrometUKorist( s.getPrometUKorist() );
        dnevnoStanjeDTO.setPrometNaTeret( s.getPrometNaTeret() );
        dnevnoStanjeDTO.setNovoStanje( s.getNovoStanje() );
        dnevnoStanjeDTO.setRezervisano( s.getRezervisano() );

        return dnevnoStanjeDTO;
    }

    @Override
    public DnevnoStanjeDTO toDtoId(DnevnoStanje dnevnoStanje) {
        if ( dnevnoStanje == null ) {
            return null;
        }

        DnevnoStanjeDTO dnevnoStanjeDTO = new DnevnoStanjeDTO();

        dnevnoStanjeDTO.setId( dnevnoStanje.getId() );

        return dnevnoStanjeDTO;
    }
}
