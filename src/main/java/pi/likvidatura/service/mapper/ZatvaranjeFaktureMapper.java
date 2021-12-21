package pi.likvidatura.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pi.likvidatura.domain.PoslovniPartner;
import pi.likvidatura.domain.ZatvaranjeFakture;
import pi.likvidatura.service.dto.PoslovniPartnerDTO;
import pi.likvidatura.service.dto.ZatvaranjeFaktureDTO;

public interface ZatvaranjeFaktureMapper extends EntityMapper<ZatvaranjeFaktureDTO, ZatvaranjeFakture>{
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ZatvaranjeFaktureDTO toDtoId(ZatvaranjeFakture zatvaranje);
}
