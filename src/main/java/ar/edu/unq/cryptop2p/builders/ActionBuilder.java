package ar.edu.unq.cryptop2p.builders;

import ar.edu.unq.cryptop2p.helpers.ActionType;
import ar.edu.unq.cryptop2p.model.Action;
import lombok.Getter;


@Getter
public class ActionBuilder {
    private ActionType actionType;

    public ActionBuilder(ActionType actionType) {
        this.actionType = actionType;
    }

    public static ActionBuilder anAction (ActionType anActionType) {return new ActionBuilder(anActionType);}

    public Action build()
    {
        Action action =  this.actionType.getAction();
        return action;
    }


}
