package todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;
import java.util.List;

import static java.util.Arrays.asList;
import static net.serenitybdd.core.Serenity.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("When filtering tasks")
public class WhenFilteringTasks {

    @Managed(driver = "firefox")
    WebDriver driver;
    @Steps
    TodoListActions todoList;
    @AfterEach
    public void tearDown()
    {
        getDriver().quit();
    }
        @ParameterizedTest
        @CsvSource({
                "Completed,  Feed the cat;Walk the dog,  Feed the cat,  Feed the cat",
                "Active,     Feed the cat;Walk the dog,  Feed the cat,  Walk the dog",
                "All,        Feed the cat;Walk the dog,  Feed the cat,  Feed the cat;Walk the dog"
        })
        public void shouldFilterTasks(String filterBy,
                                      String tasks,
                                      String itemToBeCompleted,
                                      String itemsLeft) {
        todoList.openApp();
        todoList.addTasks(listFrom(tasks));
        todoList.completeTheTask(itemToBeCompleted);    
        todoList.filterTasksByStatus(filterBy);
            reportThat("The todo list should contain the expected items",
                    () -> assertThat(todoList.items()).hasSameElementsAs(listFrom(itemsLeft)));

        }

    private List<String> listFrom(String tasks) {
            return asList(tasks.split(";"));
    }


    /*
    Exercise 6
Write a data-driven test to test the following scenarios:

items, complete, filter, should see
When you
add the items "Feed the cat" and "Walk the dog"
and complete "Feed the cat"
and then filter by "Completed",
you should only see "Feed the cat"


When you add the items "Feed the cat" and "Walk the dog",
and complete "Feed the cat",
and then filter by "Active",
you should only see "Walk the dog"


When you add the items "Feed the cat" and "Walk the dog",
and complete "Feed the cat",
and then filter by "All",
you should all the items
     */
}
