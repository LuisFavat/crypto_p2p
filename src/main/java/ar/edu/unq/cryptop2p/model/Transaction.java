package ar.edu.unq.cryptop2p.model;

import ar.edu.unq.cryptop2p.helpers.ActionType;
import ar.edu.unq.cryptop2p.helpers.CurrentDateTime;
import ar.edu.unq.cryptop2p.helpers.OptionType;
import ar.edu.unq.cryptop2p.helpers.StateType;
import ar.edu.unq.cryptop2p.model.actions.Action;
import ar.edu.unq.cryptop2p.model.exceptions.BadRequestException;
import ar.edu.unq.cryptop2p.model.exceptions.CancelException;
import ar.edu.unq.cryptop2p.model.exceptions.ConfirmReceptionException;
import ar.edu.unq.cryptop2p.model.exceptions.MakeTransferException;
import ar.edu.unq.cryptop2p.model.states.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import static ar.edu.unq.cryptop2p.model.validators.Validator.response;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private int id;


    @Column
    @DateTimeFormat
    protected Date dateTime;

    @Column(nullable = false)
    protected OptionType operation;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_cryptocurrency", referencedColumnName = "id_cryptocurrency")
    protected CryptoCurrency cryptoCurrency;

    @NotNull
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_options", referencedColumnName = "id_options")
    private Option option;



    @Enumerated(EnumType.STRING)
    private StateType stateType = StateType.UDLE;


    @Enumerated(EnumType.STRING)
    private ActionType actionType = ActionType.NONE;



  @NotNull
   @ManyToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name = "id_userCrypto", referencedColumnName = "id_userCrypto"/*,insertable = false,updatable = false*/)
    private UserCrypto counterPartyUser;

    @Column
    @DateTimeFormat
    protected Date finishTime;

    @Transient
    private State state;

    @Transient
    private Action action;


    public Transaction(Option aOption)  {
        this.option = aOption;
        //TODO poner en un lugar mejor (REFACTOR)
        try {
            finishTime = CurrentDateTime.stringToDate("01/01/2000");//CurrentDateTime.getNewDate();
        }catch (Exception e)
        {}


    }




    public Action getAction() {
        return getActionType().getAction();
    }

    public State getState() {
        return getStateType().getState();
    }

    public UserCrypto getCounterPartyUser() {
        return counterPartyUser;
    }

    public Double getPrice() {
        return getOption().getPrice();
    }

    public OptionType getOperationType() {
        return getOption().getOperation();
    }

    public Date getDateTime() { return getOption().getDateTime();
    }

    public UserCrypto getUser() {
        return getOption().getUser();
    }

    public String getAddress() {
        return getOption().virtualAddress();
    }

    public CryptoCurrency getCryptoCurrency() {
        return getOption().getCryptocurrency();
    }

    public String getCryptoCurrencyName() {
        return getOption().getCryptocurrency().getName();
    }

    public float getAmountOfCryptoCurrency() {
        return getOption().getCryptoAmount();
    }

    public Double cryptoPrice() {
        return getOption().quote();
    }

    public Double transactionAmount() {
        return getAmountOfCryptoCurrency() * cryptoPrice();
    }

    public String nameOfTheOwnerOfTheOption() {
        return getOption().nameOfTheOwner();
    }

    public String nameOfTheCounterParty() {return getCounterPartyUser().getName() + " " +getCounterPartyUser().getSurname();}

    public int numberOfOperations() {
        return getOption().numberOfOperation();
    }

    public int scores() {
        return getOption().scores();
    }

    public float reputation() {
        return getOption().reputation();
    }

    public String address() {
        return getOption().getAddress();
    }

    public boolean iIsValidPceToPost() {
        return getOption().IsValidPriceToPost();
    }


    public void cancelBySystem() {
        this.setStateType(StateType.CANCELLED);
    }

    public void addOperation() {
        if (!isCanceled()) {
            addOperationsToUsers();
            addScoresToUsers(gainScores());
         }
    }

    private void addOperationsToUsers() {
        getUser().addOperation();
        getCounterPartyUser().addOperation();
    }




    public boolean isCVUSent() {
        return (getState().isCVUSent());
    }

    public boolean isCryptoCurrencySent() {
        return (getState().isCryptoCurrencySent());
    }

    public boolean isIdle() {
        return (getState().isIdle());
    }

    public boolean isCanceled() {
        return (getState().isCanceled());
    }

    public void addScoresToUsers(int scores) {
        getUser().addScore(scores);
        getCounterPartyUser().addScore(scores);
    }


    private int gainScores() {
        var thirtyMinutesAgo = CurrentDateTime.getCurrentTimeMinus30MinutesInMilliseconds();
        return (thirtyMinutesAgo < getDateTime().getTime()) ? 10 : 5;
    }

    public Transaction execute() throws ConfirmReceptionException, MakeTransferException, CancelException {
        return getAction().execute(this);


    }

    public Transaction cancel() {
        getUser().substractReputation(20);
        // setState(new Cancelled() );
        setStateType(StateType.CANCELLED);
        return this;
    }

    public Transaction makeTransfer() {
        //setState(new CVUSent());
        setStateType(StateType.CVUSENT);
        return this;
    }

    public Boolean checkTransfer() {
        return isCVUSent();
    }


    public Transaction confirmReception() {

        if (checkTransfer()) {
            //setState(new CryptoCurrencySent());
            setStateType(StateType.CRYPTOCURRENTSENT);
            addOperation();

        }
        return this;
    }

    public void  checkValidAction() throws  BadRequestException {
        if ( ! hasValidAction()) {
            var message = MessageFormat.format("Sorry, {0} is not a valid action, please valid actions must be : {1} only ",getActionType(),Arrays.toString(ActionType.values()));
            response(message, HttpStatus.BAD_REQUEST);
            throw new BadRequestException(message);
        }

    }

    public boolean  hasValidAction(){
        return  (Arrays.stream(ActionType.values()).toList()).contains(getActionType());
    }


    public void checkNotSameUser(UserCrypto userCounterParty) throws BadRequestException {
        if (getUser().getId().equals(userCounterParty.getId())) {
            var message = "The counterparty cannot be the owner of the transaction";
            response(message, HttpStatus.BAD_REQUEST);
            throw new BadRequestException(message);
        }
    }

    public void checkValidPriceToPost() throws BadRequestException {
        if ( ! iIsValidPceToPost()) {
            cancelBySystem();
            var message = "Sorry, but is not a valid price to process this transaction";
            response(message, HttpStatus.BAD_REQUEST);
            throw new BadRequestException(message);
        }
    }


}