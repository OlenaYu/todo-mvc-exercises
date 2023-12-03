package todomvc;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class NavigateActions extends UIInteractionSteps {
    public void openToDoApplication() {
        openUrl("https://todomvc.com/examples/angularjs/#/");
    }
}
