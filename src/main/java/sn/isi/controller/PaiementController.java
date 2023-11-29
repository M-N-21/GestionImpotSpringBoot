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
import sn.isi.dto.PaiementDto;
import sn.isi.service.PaiementService;

@RestController
@RequestMapping(value = EndPoint.PAIEMENT)
@AllArgsConstructor
public class PaiementController {
	private PaiementService paiementService;

    @GetMapping(value = EndPoint.GET_PAIEMENT_LIST)
    public List<PaiementDto> getPaiements() {
        return paiementService.getPaiements();
    }

    @GetMapping(value = EndPoint.GET_PAIEMENT_BY_ID)
    public PaiementDto getPaiement(@PathVariable("id") Long id) {
        return paiementService.getPaiement(id);
    }

    @PostMapping(value = EndPoint.ADD_PAIEMENT)
    @ResponseStatus(code = HttpStatus.CREATED)
    public PaiementDto createPaiement(@Valid @RequestBody PaiementDto paiementDto) {
        return paiementService.createPaiement(paiementDto);
    }

    @PutMapping(value = EndPoint.UPDATE_PAIEMENT)
    public PaiementDto updatePaiement(@PathVariable("id") Long id, @Valid @RequestBody PaiementDto paiementDto) {
        return paiementService.updatePaiement(id, paiementDto);
    }

    @DeleteMapping(value = EndPoint.DELETE_PAIEMENT)
    public void deletePaiement(@PathVariable("id") Long id) {
        paiementService.deletePaiement(id);
    }
}
