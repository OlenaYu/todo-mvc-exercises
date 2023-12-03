package todomvc;


import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.pageobject.ToDoPage;

@RunWith(SerenityRunner.class)
public class WhenAddingTasks {

    // TODO: Exercise 1
    @Managed(driver = "firefox")
    WebDriver driver;

    ToDoPage todo;
    @Steps
    NavigateActions navigate;
    @Test
    public void addingASingleTask() {
        navigate.openToDoApplication();
       // todo.addASingleTaskToTheList("Feed The Cat");
        //Assertions.assertThat(todo.shownItemsInTheList).isEqualTo("Feed The Cat");
        // Add "Feed The Cat" to the list
        // Check that "Feed The Cat" appears in the list
    }

    // TODO: Exercise 2
    @Test
    public void addingMultipleTasks() {
        // Add "Feed The Cat" and "Walk the dog" to the list
        // Check that they all appear in the list
    }

}
