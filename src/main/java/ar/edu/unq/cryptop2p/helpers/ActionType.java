package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.actions.Action;
import ar.edu.unq.cryptop2p.model.actions.Cancel;
import ar.edu.unq.cryptop2p.model.actions.ConfirmReception;
import ar.edu.unq.cryptop2p.model.actions.MakeTransfer;
import lombok.Getter;

@Getter

    public  enum  ActionType {

        MAKETRANSFER (new MakeTransfer())   ,
        CONFIRMRECEPTION( new ConfirmReception()) ,
        CANCEL ( new Cancel()),
        NONE;


           private Action action;
           private  ActionType (Action anAction ) {action =  anAction;}

    ActionType() {

    }
}





