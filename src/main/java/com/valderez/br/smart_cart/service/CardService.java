package com.valderez.br.smart_cart.service;

import com.valderez.br.smart_cart.controller.dto.CardResponse;
import com.valderez.br.smart_cart.controller.dto.CustomerCardRequest;
import com.valderez.br.smart_cart.controller.dto.CustomerCardResponse;
import com.valderez.br.smart_cart.domain.Card;
import com.valderez.br.smart_cart.domain.CardType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    public CustomerCardResponse checkCardAvailability(CustomerCardRequest cardRequest){
        var customer = cardRequest.toCustomer();
        var card = new Card(customer);
        List<CardResponse> cards = new ArrayList<>();
        if(card.isPersonalCardAvailable()){
            cards.add(new CardResponse(CardType.PERSONAL, card.getPersonalCardInterestRate()));
        }

        if(card.isConsigmentCardAvailable()){
            cards.add(new CardResponse(CardType.CONSIGMENT, card.getConsigmentCardInterestRate()));
        }

        if(card.isGuaranteedCardAvailable()){
            cards.add(new CardResponse(CardType.GUARANTEED, card.getGuaranteedCardInterestRate()));
        }
        return new CustomerCardResponse(cardRequest.name(), cards);
    }
}
