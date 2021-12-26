package pi.likvidatura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pi.likvidatura.repository.PoslovniPartnerRepository;
import pi.likvidatura.service.PoslovniPartnerService;
import pi.likvidatura.service.dto.PoslovniPartnerDTO;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoslovniPartnerServiceImpl implements PoslovniPartnerService {

    @Autowired
    private PoslovniPartnerRepository poslovniPartnerRepository;

    @Override
    public List<PoslovniPartnerDTO> getAll() {
        return poslovniPartnerRepository.findAll()
                .stream().map(PoslovniPartnerDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
