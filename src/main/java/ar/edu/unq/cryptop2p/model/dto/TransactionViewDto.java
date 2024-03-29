package ar.edu.unq.cryptop2p.model.dto;

import ar.edu.unq.cryptop2p.helpers.ActionType;
import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.model.Transaction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import static ar.edu.unq.cryptop2p.helpers.CurrentDateTime.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Data
public class TransactionViewDto implements Serializable {
    @NotNull
    @Enumerated(EnumType.STRING)
    private OptionType operation;

    @NotNull
    private String dateTime;


    @NotNull
    private  String cryptoCurrencyName;

    @NotNull
    private String nameOfTheOwner;

    @NotNull
    private String nameOfTheCounterParty;

    @NotNull
    @Min(value = 0)
    private  Double price;

    @NotNull
    private float cryptoAmount;

    @NotNull
    private   Double amountPriceInPesos;

    @NotNull
    private int numberOfOperation;

    @NotNull
    private  float reputation;

    @NotNull
    private  String  address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ActionType actionType;



    public static TransactionViewDto fromModel (Transaction transaction){

        return new TransactionViewDto  (transaction.getOperationType(), dateToString(transaction.getDateTime()), transaction.getCryptoCurrencyName(), transaction.nameOfTheOwnerOfTheOption(), transaction.nameOfTheCounterParty(),transaction.getPrice(), transaction.getAmountOfCryptoCurrency(),transaction.transactionAmount(), transaction.numberOfOperations(),transaction.reputation(),transaction.getAddress(),transaction.getActionType());

    }
}
