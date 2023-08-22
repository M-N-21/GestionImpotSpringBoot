package sn.isi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import sn.isi.config.EndPoint;
import sn.isi.dto.DeclarantDto;
import sn.isi.service.DeclarantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = EndPoint.DECLARANT)
@AllArgsConstructor
public class DeclarantController {
    private DeclarantService declarantService;

    @GetMapping(value = EndPoint.GET_DECLARANT_LIST)
    public List<DeclarantDto> getDeclarant() {
        return declarantService.getDeclarants();
    }

    @GetMapping(value = EndPoint.GET_DECLARANT_BY_ID)
    public DeclarantDto getDeclarant(@PathVariable("id") Long id) {
        return declarantService.getDeclarant(id);
    }

    @PostMapping(value = EndPoint.ADD_DECLARANT)
    @ResponseStatus(code = HttpStatus.CREATED)
    public DeclarantDto createDeclarant(@Valid @RequestBody DeclarantDto declarantDto) {
        return declarantService.createDeclarant(declarantDto);
    }

    @PutMapping(value = EndPoint.UPDATE_DECLARANT)
    public DeclarantDto updateDeclarant(@PathVariable("id") Long id, @Valid @RequestBody DeclarantDto declarantDto) {
        return declarantService.updateDeclarant(id, declarantDto);
    }

    @DeleteMapping(value = EndPoint.DELETE_DECLARANT)
    public void deleteDeclarant(@PathVariable("id") Long id) {
        declarantService.deleteDeclarant(id);
    }
}
