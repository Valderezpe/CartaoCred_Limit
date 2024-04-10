package com.valderez.br.smart_cart.controller;

import com.valderez.br.smart_cart.controller.dto.CustomerCardRequest;
import com.valderez.br.smart_cart.controller.dto.CustomerCardResponse;
import com.valderez.br.smart_cart.service.CardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class cardController {

    private final CardService cardService;

    public cardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(value = "/customer-cards")
    public ResponseEntity<CustomerCardResponse> customerCard(@RequestBody @Valid CustomerCardRequest cardRequest){
        var cardResponse = cardService.checkCardAvailability(cardRequest);
        return ResponseEntity.ok(cardResponse);

    }

}
