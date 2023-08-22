package sn.isi.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import sn.isi.doa.IDeclarationRepository;
import sn.isi.doa.IPaiementRepository;
import sn.isi.dto.DeclarationDto;
import sn.isi.dto.PaiementDto;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;
import sn.isi.mapping.DeclarationMapper;
import sn.isi.mapping.PaiementMapper;

@Service @AllArgsConstructor
public class PaiementService {
	private IPaiementRepository iPaiementRepository;
	private IDeclarationRepository declarationRepository;
    private PaiementMapper paiementMapper;
    private DeclarationMapper declarationMapper;
    MessageSource messageSource;


    @Transactional(readOnly = true)
    public List<PaiementDto>  getPaiements() {
        return StreamSupport.stream(iPaiementRepository.findAll().spliterator(), false)
                .map(paiementMapper::toPaiementDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PaiementDto getPaiement(Long id) {
        return paiementMapper.toPaiementDto(iPaiementRepository.findById(id)
                .orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("paiement.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public PaiementDto createPaiement(@Valid PaiementDto paiementDto) {
    	List<PaiementDto> paiements = StreamSupport.stream(iPaiementRepository.findAll().spliterator(), false)
                .map(paiementMapper::toPaiementDto)
                .collect(Collectors.toList());
    	
    	Double totalpaie = (double) 0;
    	if (paiements != null) {
    		for (PaiementDto p : paiements) {
    			if (p.getDeclaration().getId() == paiementDto.getDeclaration().getId()) {
    				totalpaie += p.getMontantPaiement();
    			}
    		}
		}
    	System.out.println(totalpaie);
    	DeclarationDto p = declarationMapper.toDeclarationDto(declarationRepository.findById(paiementDto.getDeclaration().getId()).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("paiement.notfound", new Object[]{paiementDto.getDeclaration().getId()},
                Locale.getDefault()))));
    	
    	if (totalpaie < p.getMontantDeclaration()) {
			if ((p.getMontantDeclaration() - totalpaie) >= paiementDto.getMontantPaiement()) {
				return paiementMapper.toPaiementDto(iPaiementRepository.save(paiementMapper.toPaiement(paiementDto)));
			}else {
				try {
					throw new EntityNotFoundException(messageSource.getMessage("paiement.errormontantsupperieurpaiement", new Object[] {p.getMontantDeclaration()},
					        Locale.getDefault()));
//					throw new LogiquePaiement(messageSource.getMessage("paiement.errormontantsupperieurpaiement", new Object[] {p.getMontantDeclaration()},
//					        Locale.getDefault()),HttpStatus.CONFLICT);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			try {
				throw new Exception(messageSource.getMessage("paiement.errormontantpaiement", new Object[] {totalpaie},
				        Locale.getDefault()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return paiementDto;
        
    }

    @Transactional
    public PaiementDto updatePaiement(Long id, PaiementDto paiementDto) {
        return iPaiementRepository.findById(id)
                .map(entity -> {
                    paiementDto.setId(id);
                    return paiementMapper.toPaiementDto(
                            iPaiementRepository.save(paiementMapper.toPaiement(paiementDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("paiement.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deletePaiement(Long id) {
        try {
            iPaiementRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("paiement.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
