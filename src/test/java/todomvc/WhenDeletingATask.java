package todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

@RunWith(SerenityRunner.class)
public class WhenDeletingATask {
    @Managed(driver = "firefox")
    WebDriver driver;

    @Steps
    TodoListActions todoList;
    @Before
    public void openTheApplication() {
        todoList.openApp();
    }
    // TODO: Exercise 5
    @Test
    public void deletedItemsShouldDisappearFromTheList() {
        todoList.addTasks("Feed The Cat", "Walk The Dog");
        todoList.deleteTask("Feed The Cat");
        Serenity.reportThat("Check that only 'Walk The Dog' appears in the list",
                () -> Assertions.assertThat(todoList.itemsList()).containsExactly("Walk The Dog"));

        // Add "Feed the cat" and "Walk the dog" to the list
        // Delete "Feed the cat"
        // Check that only "Walk the dog" appears
    }
}