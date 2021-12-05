package pi.likvidatura.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-29T08:39:19+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Eclipse Adoptium)"
)
@Component
public class StavkaIzvodaMapperImpl implements StavkaIzvodaMapper {

    @Autowired
    private DnevnoStanjeMapper dnevnoStanjeMapper;

    @Override
    public StavkaIzvoda toEntity(StavkaIzvodaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StavkaIzvoda stavkaIzvoda = new StavkaIzvoda();

        stavkaIzvoda.setId( dto.getId() );
        stavkaIzvoda.setBrojStavke( dto.getBrojStavke() );
        stavkaIzvoda.setIznos( dto.getIznos() );
        stavkaIzvoda.setDuznik( dto.getDuznik() );
        stavkaIzvoda.setSvrhaPlacanja( dto.getSvrhaPlacanja() );
        stavkaIzvoda.setPrimalac( dto.getPrimalac() );
        stavkaIzvoda.setRacunDuznika( dto.getRacunDuznika() );
        stavkaIzvoda.setRacunPrimaoca( dto.getRacunPrimaoca() );
        stavkaIzvoda.setModel( dto.getModel() );
        stavkaIzvoda.setPozivNaBroj( dto.getPozivNaBroj() );
        stavkaIzvoda.dnevnoStanje( dnevnoStanjeMapper.toEntity( dto.getDnevnoStanje() ) );

        return stavkaIzvoda;
    }

    @Override
    public List<StavkaIzvoda> toEntity(List<StavkaIzvodaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<StavkaIzvoda> list = new ArrayList<StavkaIzvoda>( dtoList.size() );
        for ( StavkaIzvodaDTO stavkaIzvodaDTO : dtoList ) {
            list.add( toEntity( stavkaIzvodaDTO ) );
        }

        return list;
    }

    @Override
    public List<StavkaIzvodaDTO> toDto(List<StavkaIzvoda> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StavkaIzvodaDTO> list = new ArrayList<StavkaIzvodaDTO>( entityList.size() );
        for ( StavkaIzvoda stavkaIzvoda : entityList ) {
            list.add( toDto( stavkaIzvoda ) );
        }

        return list;
    }

    @Override
    public StavkaIzvodaDTO toDto(StavkaIzvoda s) {
        if ( s == null ) {
            return null;
        }

        StavkaIzvodaDTO stavkaIzvodaDTO = new StavkaIzvodaDTO();

        stavkaIzvodaDTO.setDnevnoStanje( dnevnoStanjeMapper.toDtoId( s.getDnevnoStanje() ) );
        stavkaIzvodaDTO.setId( s.getId() );
        stavkaIzvodaDTO.setBrojStavke( s.getBrojStavke() );
        stavkaIzvodaDTO.setIznos( s.getIznos() );
        stavkaIzvodaDTO.setDuznik( s.getDuznik() );
        stavkaIzvodaDTO.setSvrhaPlacanja( s.getSvrhaPlacanja() );
        stavkaIzvodaDTO.setPrimalac( s.getPrimalac() );
        stavkaIzvodaDTO.setRacunDuznika( s.getRacunDuznika() );
        stavkaIzvodaDTO.setRacunPrimaoca( s.getRacunPrimaoca() );
        stavkaIzvodaDTO.setModel( s.getModel() );
        stavkaIzvodaDTO.setPozivNaBroj( s.getPozivNaBroj() );

        return stavkaIzvodaDTO;
    }
}
