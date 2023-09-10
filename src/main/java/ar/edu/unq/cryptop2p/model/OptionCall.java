package ar.edu.unq.cryptop2p.model;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OptionCall extends Option{
    public OptionCall(Cryptocurrency cryptocurrency, Double price, float units, UserCrypto user) {
        super(cryptocurrency, price, units, user);
    }

    public String getAddress()
    {
        return user.getCryptoAddress();
    }

}
