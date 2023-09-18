package ar.edu.unq.cryptop2p.helpers;

import ar.edu.unq.cryptop2p.model.*;
import lombok.Getter;

@Getter

    public  enum  ActionType {

        MAKETRANSFER (new MakeTransfer())   ,
        CONFIRMRECEPTION( new ConfirmReception()) ,
        CANCEL ( new Cancel());


     private Action action;
           private  ActionType (Action anAction ) {
            action =  anAction;

               }
        }





