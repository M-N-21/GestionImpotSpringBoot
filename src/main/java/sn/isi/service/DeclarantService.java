package sn.isi.service;

import org.springframework.context.MessageSource; 
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.doa.IDeclarantRepository;
import sn.isi.dto.DeclarantDto;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;
import sn.isi.mapping.DeclarantMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeclarantService {
    private IDeclarantRepository iDeclarantRepository;
    private DeclarantMapper declarantMapper;
    MessageSource messageSource;
    private static String mymessage = "declarant.notfound";
    
    public DeclarantService(IDeclarantRepository iDeclarantRepository, DeclarantMapper declarantMapper, MessageSource messageSource) {
        this.iDeclarantRepository = iDeclarantRepository;
        this.declarantMapper = declarantMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<DeclarantDto>  getDeclarants() {
        return StreamSupport.stream(iDeclarantRepository.findAll().spliterator(), false)
                .map(declarantMapper::toDeclarantDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DeclarantDto getDeclarant(Long id) {
        return declarantMapper.toDeclarantDto(iDeclarantRepository.findById(id)
                .orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage(mymessage, new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public DeclarantDto createDeclarant(DeclarantDto declarantDto) {
        return declarantMapper.toDeclarantDto(iDeclarantRepository.save(declarantMapper.toDeclarant(declarantDto)));
    }

    @Transactional
    public DeclarantDto updateDeclarant(Long id, DeclarantDto declarantDto) {
        return iDeclarantRepository.findById(id)
                .map(entity -> {
                    declarantDto.setId(id);
                    return declarantMapper.toDeclarantDto(
                            iDeclarantRepository.save(declarantMapper.toDeclarant(declarantDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage(mymessage, new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteDeclarant(Long id) {
        try {
            iDeclarantRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("declarant.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
