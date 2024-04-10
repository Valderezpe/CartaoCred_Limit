package com.valderez.br.smart_cart.domain;

public class Card {

    private Customer customer;

    public Card(Customer customer) {
        this.customer = customer;
    }
    public boolean isPersonalCardAvailable(){
        return basicCardAvailable();
    }
    public boolean isConsigmentCardAvailable(){
        return customer.isIncomeEqualOrdGreaterThan(6000.00);
    }

    public boolean isGuaranteedCardAvailable(){
        return basicCardAvailable();
    }

    public double getPersonalCardInterestRate(){
        if (isPersonalCardAvailable()){
            return 3.5;
        }
        throw new CardNotAvailableException();
    }
    public double getGuaranteedCardInterestRate(){
        if (isGuaranteedCardAvailable()){
            return 3.0;
        }
        throw new CardNotAvailableException();
    }
    public double getConsigmentCardInterestRate(){
        if (isConsigmentCardAvailable()){
            return 1.5;
        }
        throw new CardNotAvailableException();
    }
    private boolean basicCardAvailable() {
        if(customer.isIncomeEqualOrLowerThan(2500.00)){
            return true;
        }
        return customer.isIncomeBetween(2500.00, 6000.00)
                && customer.isAgeLowerThan(40)
                && customer.isFromLocation("SP");
    }
}
