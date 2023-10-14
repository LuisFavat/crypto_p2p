package ar.edu.unq.cryptop2p.model.dto;

public class TradedCryptoAmountDTO
{
    private final String name;
    private float amount;

    public TradedCryptoAmountDTO(String name, float amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getName()
    {
        return name;
    }

    public float getAmount()
    {
        return amount;
    }
}
