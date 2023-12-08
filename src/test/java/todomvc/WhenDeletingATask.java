package todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;
@DisplayName("When deleting a task")
 class WhenDeletingATask {
    @Managed(driver = "firefox")
    WebDriver driver;

    @Steps
    TodoListActions todoList;
    @BeforeEach
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