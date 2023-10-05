package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.states.*;
import lombok.Getter;

@Getter

public enum  StateType {
        UDLE (new Idle()) ,
        CRYPTOCURRENTSENT (new CryptoCurrencySent()) ,
        CVUSENT(new CVUSent()) ,
        CANCELLED(new Cancelled());

        private State state;

        private  StateType ( State anState  ) {state = anState;}

    }

