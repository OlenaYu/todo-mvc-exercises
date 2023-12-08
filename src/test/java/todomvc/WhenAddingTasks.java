package todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

import net.serenitybdd.junit.runners.SerenityRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

import static org.assertj.core.api.Assertions.*;

@RunWith(SerenityRunner.class)
public class WhenAddingTasks {
    @Managed(driver = "chrome")
    WebDriver driver;
    @Before
    public void openTodoApplication() {
        todoList.openApp();
    }
    @Steps
    TodoListActions todoList;
    // TODO: Exercise 1
    @Test
    public void addingASingleTask() {
        // Add "Feed The Cat" to the list
        todoList.addATask("Feed The Cat");
        // Check that "Feed The Cat" appears in the list
        Serenity.reportThat("The todo list should contain 'Feed The Cat'",
                () -> assertThat(todoList.itemsList()).containsExactly("Feed The Cat"));
    }
    // TODO: Exercise 2
    @Test
    public void addingMultipleTasks() {
        // Add "Feed The Cat" and "Walk the dog" to the list
        todoList.addTasks("Feed The Cat", "Walk The Dog");
        // Check that they all appear in the list
        Serenity.reportThat("The todo list should contain 'Feed The Cat' and 'Walk The Dog'",
                () -> assertThat(todoList.itemsList()).containsExactly("Feed The Cat", "Walk The Dog" ));
    }

}
