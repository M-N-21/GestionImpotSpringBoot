package sn.isi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sn.isi.config.EndPoint;
import sn.isi.dto.DeclarationDto;
import sn.isi.service.DeclarationService;

@RestController
@RequestMapping(value = EndPoint.DECLARATION)
@AllArgsConstructor
public class DeclarationController {
	private DeclarationService declarationService;

    @GetMapping(value = EndPoint.GET_DECLARATION_LIST)
    public List<DeclarationDto> getDeclarations() {
        return declarationService.getDeclarations();
    }

    @GetMapping(value = EndPoint.GET_DECLARATION_BY_ID)
    public DeclarationDto getDeclaration(@PathVariable("id") Long id) {
        return declarationService.getDeclaration(id);
    }

    @PostMapping(value = EndPoint.ADD_DECLARATION)
    @ResponseStatus(code = HttpStatus.CREATED)
    public DeclarationDto createDeclaration(@Valid @RequestBody DeclarationDto declarationDto) {
        return declarationService.createDeclaration(declarationDto);
    }

    @PutMapping(value = EndPoint.UPDATE_DECLARATION)
    public DeclarationDto updateDeclaration(@PathVariable("id") Long id, @Valid @RequestBody DeclarationDto declarationDto) {
        return declarationService.updateDeclaration(id, declarationDto);
    }

    @DeleteMapping(value = EndPoint.DELETE_DECLARATION)
    public void deleteDeclaration(@PathVariable("id") Long id) {
        declarationService.deleteDeclaration(id);
    }
}
