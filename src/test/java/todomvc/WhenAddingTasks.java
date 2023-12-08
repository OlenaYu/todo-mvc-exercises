package todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.common.SessionFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.Assertions.*;
@DisplayName("When adding tasks")
class WhenAddingTasks {
    @Managed(driver = "chrome")
    WebDriver driver;
    @BeforeEach
    void openTodoApplication() {
        todoList.openApp();
    }
    @AfterEach
    public void tearDown()
    {
        getDriver().quit();
    }
    //OR
//    public void clearTheList() {
//        todoList.clearList();
//    }
    @Steps
    TodoListActions todoList;
    // TODO: Exercise 1
    @Nested
    class ToAnEmptyList {
        @DisplayName("Adding a single task")
        @Test
        void addingASingleTask() {
            // Add "Feed The Cat" to the list
            todoList.addATask("Feed The Cat");
            // Check that "Feed The Cat" appears in the list
            Serenity.reportThat("The todo list should contain 'Feed The Cat'",
                    () -> assertThat(todoList.itemsList()).containsExactly("Feed The Cat"));
        }

        // TODO: Exercise 2
        @DisplayName("Adding multiple tasks")
        @Test
        void addingMultipleTasks() {
            // Add "Feed The Cat" and "Walk the dog" to the list
            todoList.addTasks("Feed The Cat", "Walk The Dog");
            // Check that they all appear in the list
            Serenity.reportThat("The todo list should contain 'Feed The Cat' and 'Walk The Dog'",
                    () -> assertThat(todoList.itemsList()).containsExactly("Feed The Cat", "Walk The Dog"));
        }
    }

}
