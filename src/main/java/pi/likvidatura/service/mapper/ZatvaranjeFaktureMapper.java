package pi.likvidatura.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pi.likvidatura.domain.PoslovniPartner;
import pi.likvidatura.domain.ZatvaranjeFakture;
import pi.likvidatura.service.dto.PoslovniPartnerDTO;
import pi.likvidatura.service.dto.ZatvaranjeFaktureDTO;

@Mapper(componentModel = "spring", uses = { StavkaIzvodaMapper.class, IzlaznaFakturaMapper.class })
public interface ZatvaranjeFaktureMapper extends EntityMapper<ZatvaranjeFaktureDTO, ZatvaranjeFakture>{

}
