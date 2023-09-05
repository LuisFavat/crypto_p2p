package ar.edu.unq.cryptop2p.model;

public class OptionCall extends Option{
    public OptionCall(Cryptocurrency cryptocurrency, Double price, int units, UserCrypto user) {
        super(cryptocurrency, price, units, user);
    }
}
