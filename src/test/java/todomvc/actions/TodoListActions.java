package todomvc.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

import static todomvc.actions.TodoListForm.*;

public class TodoListActions extends UIInteractionSteps {

    private int items;

    @Step("Open the TodoMVC application")
    public void openApp() {
        openPageNamed("home");
    }
    @Step("Add a new '{0}' task")
    public void addATask(String task) {
        $(NEW_ITEM_NAME).typeAndEnter(task);
    }
    //This method returns the text for items in the list
    public List<String> itemsList() {
        return $$(ITEMS_LABELS).texts();
    }
    @Step("Add tasks {0}")
    public void addTasks (List<String> tasks) {
        tasks.forEach(task -> $(NEW_ITEM_NAME).typeAndEnter(task));

    }
    @Step("Add several tasks {0}")
    public void addTasks(String ...tasks) {
        for (String task : tasks) {
            $(NEW_ITEM_NAME).typeAndEnter(task);
        }
    }
    @Step("Complete the task {0}")
    public void completeTheTask(String task) {
        $(COMPLETE_CHECKBOX, task).click();
    }
    
    //Option 1: Returns the number of items in the list
//    public Integer numberOfTodoItems() {
//        return Integer.parseInt($$(ITEMS_IN_TODO_LIST).get());
//    }
    //Option 2
    public Integer numberOfTodoItems() {
       return items = $$(ITEMS_LABELS).size();
    }
    @Step("Filter tasks by '{0}' status")
    public void filterTasksByStatus(String status) {
        $(FILTER_BUTTON, status).click();
    }
    @Step("Delete '{0}' task from the todo list")
    public void deleteTask(String task) {
        $(ITEM_LABEL, task).click();
        $(DELETE_ICON, task).click();
    }
    //Returns the list of tasks (labels) from the todolist
    public List<String> items() {
        return $$(ITEMS_LABELS).texts();
    }

    public void clearList() {
       // ((JavascriptExecutor)driver).executeScript("localStorage.clear();");
        ((JavascriptExecutor)getDriver()).executeScript("window.localStorage.clear();");
    }
}

