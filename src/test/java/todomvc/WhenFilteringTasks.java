package todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.TestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static net.serenitybdd.core.Serenity.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SerenityParameterizedRunner.class)
public class WhenFilteringTasks {

    @Managed(driver = "firefox")
    WebDriver driver;
    @Steps
    TodoListActions todoList;
    private String filterBy;
    private List<String> tasks;
    private String itemToBeCompleted;
    private List<String> itemsLeft;

    public WhenFilteringTasks(String filterBy,
                              List<String> tasks,
                              String itemToBeCompleted,
                              List<String> itemsLeft) {
        this.filterBy = filterBy;
        this.tasks = tasks;
        this.itemToBeCompleted = itemToBeCompleted;
        this.itemsLeft = itemsLeft;
    }
    @TestData(columnNames = "Filter By, Todo Items, Item to be completed, Items left")
    public static Collection<Object[]> testData() {
        return asList(
                new Object[][] {
                        {"Completed", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat") },
                        {"Active", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Walk the dog")},
                        {"All", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat", "Walk the dog")},
                }
        );
    }

    @Before
    public void openTheApplication() {
        todoList.openApp();
        todoList.addTasks(tasks);
        todoList.completeTheTask(itemToBeCompleted);
    }
        @Test
        public void shouldFilterTasks() {
            todoList.filterTasksByStatus(filterBy);
            reportThat("The todo list should contain the expected items",
                    () -> assertThat(todoList.items()).hasSameElementsAs(itemsLeft));

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
