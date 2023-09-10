package ar.edu.unq.model.builders;

import ar.edu.unq.cryptop2p.model.Cryptocurrency;
import ar.edu.unq.cryptop2p.model.Option;
import ar.edu.unq.cryptop2p.model.OptionCall;
import ar.edu.unq.cryptop2p.model.UserCrypto;
import lombok.Getter;
import lombok.Setter;
import org.mockito.Mockito;

@Getter
@Setter
public class OptionCallBuilder {

    public Cryptocurrency mockCryptocurrency = Mockito.mock(Cryptocurrency.class);
    public UserCrypto mockUser = Mockito.mock(UserCrypto.class);
    private int units= 0;
    private double price= 0.00;

    public static OptionCallBuilder anOption() { return new OptionCallBuilder(); }

    public OptionCallBuilder withUnits(int  anyUnits)
    {
        units = anyUnits;
        return this;
    }

    public OptionCallBuilder withPrice(double aPrice)
    {
        price = aPrice;
        return this;
    }

    public Option build ()  { return new OptionCall(mockCryptocurrency,  price,  units, mockUser);}
}
