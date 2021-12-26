package pi.likvidatura.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.domain.PoslovniPartner;
import pi.likvidatura.repository.IzlaznaFakturaRepository;
import pi.likvidatura.repository.PoslovniPartnerRepository;
import pi.likvidatura.service.IzlaznaFakturaService;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;
import pi.likvidatura.service.mapper.IzlaznaFakturaMapper;


/**
 * Service Implementation for managing {@link IzlaznaFaktura}.
 */
@Service
@Transactional
public class IzlaznaFakturaServiceImpl implements IzlaznaFakturaService {

    private final Logger log = LoggerFactory.getLogger(IzlaznaFakturaServiceImpl.class);

    private final IzlaznaFakturaRepository izlaznaFakturaRepository;

    private final PoslovniPartnerRepository poslovniPartnerRepository;

    private final IzlaznaFakturaMapper izlaznaFakturaMapper;

    public IzlaznaFakturaServiceImpl(
            IzlaznaFakturaRepository izlaznaFakturaRepository,
            IzlaznaFakturaMapper izlaznaFakturaMapper,
            PoslovniPartnerRepository poslovniPartnerRepository) {
        this.izlaznaFakturaRepository = izlaznaFakturaRepository;
        this.izlaznaFakturaMapper = izlaznaFakturaMapper;
        this.poslovniPartnerRepository = poslovniPartnerRepository;
    }

    @Override
    public IzlaznaFakturaDTO save(IzlaznaFakturaDTO izlaznaFakturaDTO) {
        log.debug("Request to save IzlaznaFaktura : {}", izlaznaFakturaDTO);
        IzlaznaFaktura izlaznaFaktura = izlaznaFakturaMapper.toEntity(izlaznaFakturaDTO);
        izlaznaFaktura = izlaznaFakturaRepository.save(izlaznaFaktura);
        return izlaznaFakturaMapper.toDto(izlaznaFaktura);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<IzlaznaFakturaDTO> findAll(String brojFakture, int pageNum) {
        log.debug("Request to get all");
        Page<IzlaznaFakturaDTO> fakture = izlaznaFakturaRepository
                .findByBrojFakture(brojFakture, PageRequest.of(pageNum, 10))
                .map(IzlaznaFakturaDTO::fromEntity);;

        return fakture;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<IzlaznaFakturaDTO> findOne(Long id) {
        log.debug("Request to get IzlaznaFaktura : {}", id);
        return izlaznaFakturaRepository.findById(id).map(izlaznaFakturaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete IzlaznaFaktura : {}", id);
        izlaznaFakturaRepository.deleteById(id);
    }

    @Override
    public Document generatePdf(Long poslovniPartnerId)
            throws DocumentException, FileNotFoundException {

        List<IzlaznaFaktura> fakturePartnera = izlaznaFakturaRepository.findByPoslovniPartner(poslovniPartnerId);
        Optional<PoslovniPartner> partner = poslovniPartnerRepository.findById(poslovniPartnerId);

        Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                Font.BOLD);

        Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                Font.NORMAL);

        Document document = new Document();

        String home = System.getProperty("user.home");

        PdfWriter.getInstance(document, new FileOutputStream(home +
                "/Downloads/knjiga-izlaznih-faktura.pdf", true));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hello World", font);


        Paragraph header = new Paragraph("Knjiga izlaznih faktura za "
                + partner.get().getNaziv());

        header.setAlignment(Element.ALIGN_CENTER);
        header.setFont(headerFont);
        document.add(header);

        Paragraph newline = new Paragraph("");
        document.add(newline);

        for(IzlaznaFaktura faktura : fakturePartnera) {
            Paragraph brojParagraph = new Paragraph("Broj fakture: " + faktura.getBrojFakture(), normalFont);
            Paragraph iznosParagraph = new Paragraph("Iznos za uplatu: " + faktura.getIznosZaPlacanje(), normalFont);
            document.add(brojParagraph);
            document.add(iznosParagraph);
            newline = new Paragraph("");
            document.add(newline);
        }

        document.close();
        return document;
    }
}
