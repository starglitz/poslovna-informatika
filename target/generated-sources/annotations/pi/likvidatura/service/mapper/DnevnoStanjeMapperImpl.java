package pi.likvidatura.service.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.DnevnoStanje;
import pi.likvidatura.service.dto.BankarskiRacunDTO;
import pi.likvidatura.service.dto.DnevnoStanjeDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-26T19:06:33+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
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

        BankarskiRacunDTO bankarskiRacun = null;
        Long id = null;
        Integer brojIzvoda = null;
        LocalDate datumIzvoda = null;
        Double prethodnoStanje = null;
        Double prometUKorist = null;
        Double prometNaTeret = null;
        Double novoStanje = null;
        Double rezervisano = null;

        bankarskiRacun = bankarskiRacunMapper.toDtoId( s.getBankarskiRacun() );
        id = s.getId();
        brojIzvoda = s.getBrojIzvoda();
        datumIzvoda = s.getDatumIzvoda();
        prethodnoStanje = s.getPrethodnoStanje();
        prometUKorist = s.getPrometUKorist();
        prometNaTeret = s.getPrometNaTeret();
        novoStanje = s.getNovoStanje();
        rezervisano = s.getRezervisano();

        DnevnoStanjeDTO dnevnoStanjeDTO = new DnevnoStanjeDTO( id, brojIzvoda, datumIzvoda, prethodnoStanje, prometUKorist, prometNaTeret, novoStanje, rezervisano, bankarskiRacun );

        return dnevnoStanjeDTO;
    }

    @Override
    public DnevnoStanjeDTO toDtoId(DnevnoStanje dnevnoStanje) {
        if ( dnevnoStanje == null ) {
            return null;
        }

        Long id = null;

        id = dnevnoStanje.getId();

        Integer brojIzvoda = null;
        LocalDate datumIzvoda = null;
        Double prethodnoStanje = null;
        Double prometUKorist = null;
        Double prometNaTeret = null;
        Double novoStanje = null;
        Double rezervisano = null;
        BankarskiRacunDTO bankarskiRacun = null;

        DnevnoStanjeDTO dnevnoStanjeDTO = new DnevnoStanjeDTO( id, brojIzvoda, datumIzvoda, prethodnoStanje, prometUKorist, prometNaTeret, novoStanje, rezervisano, bankarskiRacun );

        return dnevnoStanjeDTO;
    }
}
