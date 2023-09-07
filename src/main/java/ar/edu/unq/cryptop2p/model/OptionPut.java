package ar.edu.unq.cryptop2p.model;

public class OptionPut  extends Option{

    public OptionPut(Cryptocurrency cryptocurrency, Double price, int units, UserCrypto user) {
        super(cryptocurrency, price, units, user);
    }
}
