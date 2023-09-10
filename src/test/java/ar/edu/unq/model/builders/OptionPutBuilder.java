package ar.edu.unq.model.builders;

import ar.edu.unq.cryptop2p.model.*;
import lombok.Getter;
import lombok.Setter;
import org.mockito.Mockito;

@Getter
@Setter
public class OptionPutBuilder {


    public Cryptocurrency mockCryptocurrency = Mockito.mock(Cryptocurrency.class);
    public UserCrypto mockUser = Mockito.mock(UserCrypto.class);
    private int units = 0 ;
    private  double price = 0.00;

    public static OptionPutBuilder anOption() { return new OptionPutBuilder(); }

    public OptionPutBuilder withUnits(int anyUnits)
    {   units = anyUnits;
        return this;
    }

    public OptionPutBuilder withPrice(double aPrice)
    {
        price = aPrice;
        return this;
    }

    public Option build ()  { return new OptionPut(mockCryptocurrency,  price,  units, mockUser);}
}
