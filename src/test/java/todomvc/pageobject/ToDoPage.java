package todomvc.pageobject;

import net.serenitybdd.core.pages.PageObject;

public class ToDoPage extends PageObject {
    public void addASingleTaskToTheList(String task) {
        $(".new-todo").type(task);
    }
}
