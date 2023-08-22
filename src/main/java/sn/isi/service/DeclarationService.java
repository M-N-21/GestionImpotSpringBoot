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

import sn.isi.doa.IDeclarationRepository;
import sn.isi.dto.DeclarationDto;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;
import sn.isi.mapping.DeclarationMapper;

@Service
public class DeclarationService {
	private IDeclarationRepository iDeclarationRepository;
    private DeclarationMapper declarationMapper;
    MessageSource messageSource;

    public DeclarationService(IDeclarationRepository iDeclarationRepository, DeclarationMapper declarationMapper, MessageSource messageSource) {
        this.iDeclarationRepository = iDeclarationRepository;
        this.declarationMapper = declarationMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<DeclarationDto>  getDeclarations() {
        return StreamSupport.stream(iDeclarationRepository.findAll().spliterator(), false)
                .map(declarationMapper::toDeclarationDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DeclarationDto getDeclaration(Long id) {
        return declarationMapper.toDeclarationDto(iDeclarationRepository.findById(id)
                .orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("declaration.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public DeclarationDto createDeclaration(@Valid DeclarationDto declarationDto) {
        return declarationMapper.toDeclarationDto(iDeclarationRepository.save(declarationMapper.toDeclaration(declarationDto)));
    }

    @Transactional
    public DeclarationDto updateDeclaration(Long id, DeclarationDto declarationDto) {
        return iDeclarationRepository.findById(id)
                .map(entity -> {
                    declarationDto.setId(id);
                    return declarationMapper.toDeclarationDto(
                            iDeclarationRepository.save(declarationMapper.toDeclaration(declarationDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("declaration.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteDeclaration(Long id) {
        try {
            iDeclarationRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("declaration.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
