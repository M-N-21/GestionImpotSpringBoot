package sn.isi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import sn.isi.doa.IDeclarationRepository;
import sn.isi.doa.IPaiementRepository;
import sn.isi.dto.PaiementDto;
import sn.isi.entities.Paiement;
import sn.isi.mapping.DeclarationMapper;
import sn.isi.mapping.PaiementMapper;

class PaiementServiceTest {

    private IPaiementRepository iPaiementRepository;
    private IDeclarationRepository declarationRepository;
    private PaiementMapper paiementMapper;
    private DeclarationMapper declarationMapper;
    private MessageSource messageSource;

    private PaiementService paiementService;

    @BeforeEach
    void setUp() {
        iPaiementRepository = mock(IPaiementRepository.class);
        declarationRepository = mock(IDeclarationRepository.class);
        paiementMapper = mock(PaiementMapper.class);
        declarationMapper = mock(DeclarationMapper.class);
        messageSource = mock(MessageSource.class);

        paiementService = new PaiementService(iPaiementRepository, declarationRepository, paiementMapper,
                declarationMapper, messageSource);
    }

    @Test
    void testGetPaiements() {
        // Mocking data
        List<Paiement> paiements = new ArrayList<>();
        when(iPaiementRepository.findAll()).thenReturn(paiements);
        when(paiementMapper.toPaiementDto(any())).thenReturn(new PaiementDto());

        // Call the method
        List<PaiementDto> result = paiementService.getPaiements();

        // Assertions
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetPaiement() {
        // Mocking data
        Long paiementId = 1L;
        PaiementDto paiementDto = new PaiementDto();
        when(iPaiementRepository.findById(paiementId)).thenReturn(Optional.of(new Paiement()));
        when(paiementMapper.toPaiementDto(any())).thenReturn(paiementDto);

        // Call the method
        PaiementDto result = paiementService.getPaiement(paiementId);

        // Assertions
        assertNotNull(result);
        assertEquals(paiementDto, result);
    }

}
