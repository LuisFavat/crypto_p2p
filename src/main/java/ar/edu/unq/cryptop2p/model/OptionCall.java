package ar.edu.unq.cryptop2p.model;



import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OptionCall extends Option{
<<<<<<< HEAD

    public OptionCall(Cryptocurrency cryptocurrency, Double price, int units, UserCrypto user) {

=======
    public OptionCall(Cryptocurrency cryptocurrency, Double price, float units, UserCrypto user) {
>>>>>>> 744669a75c983b9a6e7add66966968e5c811e733
        super(cryptocurrency, price, units, user);
        //address = user.getCryptoAddress();
    }

    public String getAddress()
    {
        return user.getCryptoAddress();
    }

    }
