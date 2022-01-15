package pi.likvidatura.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
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

import javax.swing.text.Element;


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
                .findByBrojFaktureNezatvorene(brojFakture, PageRequest.of(pageNum, 10))
                .map(IzlaznaFakturaDTO::fromEntity);

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
    public ByteArrayInputStream generatePdf(Long poslovniPartnerId)
          throws FileNotFoundException {

        List<IzlaznaFaktura> fakturePartnera = izlaznaFakturaRepository.findByPoslovniPartner(poslovniPartnerId);
        Optional<PoslovniPartner> partner = poslovniPartnerRepository.findById(poslovniPartnerId);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(bos);

        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf);

        Paragraph header = new Paragraph("Knjiga izlaznih faktura za "
                + partner.get().getNaziv()).setTextAlignment(TextAlignment.CENTER)
                .setBold().setMargin(2F);

        document.add(header);

        Paragraph newline = new Paragraph("");
        document.add(newline);

        float [] pointColumnWidths = {150F, 150F, 150F};
        Table table = new Table(pointColumnWidths);

        table.setHorizontalAlignment(HorizontalAlignment.CENTER);

        table
                .addHeaderCell(
                        new Cell().add(new Paragraph("Broj fakture"))
                                .setTextAlignment(TextAlignment.CENTER)
                                .setBorderRight(Border.NO_BORDER)
                                .setBorderTop(Border.NO_BORDER)
                                .setBorderLeft(Border.NO_BORDER))

                .addHeaderCell(
                        new Cell().add(new Paragraph("Iznos za placanje"))
                                .setTextAlignment(TextAlignment.CENTER)
                                .setBorderRight(Border.NO_BORDER)
                                .setBorderLeft(Border.NO_BORDER)
                                .setBorderTop(Border.NO_BORDER))
                .addHeaderCell(
                        new Cell().add(new Paragraph("Poslovna godina"))
                                .setTextAlignment(TextAlignment.CENTER)
                                .setBorderLeft(Border.NO_BORDER)
                                .setBorderTop(Border.NO_BORDER)
                                .setBorderRight(Border.NO_BORDER));


        for(IzlaznaFaktura faktura : fakturePartnera) {
            table
                    .addCell(
                            new Cell().add(new Paragraph(faktura.getBrojFakture()))
                                    .setTextAlignment(TextAlignment.CENTER)
                                    .setBorderTop(Border.NO_BORDER)
                                    .setBorderBottom(Border.NO_BORDER)
                                    .setBorderLeft(Border.NO_BORDER))

                    .addCell(
                            new Cell().add(new Paragraph(faktura.getIznosZaPlacanje().toString()))
                                    .setBorderTop(Border.NO_BORDER)
                                    .setBorderBottom(Border.NO_BORDER)
                                    .setTextAlignment(TextAlignment.CENTER))

                    .addCell(
                            new Cell().add(new Paragraph(faktura.getPoslovnaGodina().getGodina().toString()))
                                    .setBorderTop(Border.NO_BORDER)
                                    .setTextAlignment(TextAlignment.CENTER)
                                    .setBorderBottom(Border.NO_BORDER)
                                    .setBorderRight(Border.NO_BORDER));



        }
        document.add(table);

        document.close();
        return new ByteArrayInputStream(bos.toByteArray());
    }
}
