package ar.edu.unq.cryptop2p.model;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OptionPut  extends Option{

    public OptionPut(CryptoCurrency cryptocurrency, Double price, float units, UserCrypto user) {
        super(cryptocurrency, price, units, user);
        //address = user.getCvu();
    }

    public String getVirtualAddress()
    {
        return user.getCvu();
    }
}
