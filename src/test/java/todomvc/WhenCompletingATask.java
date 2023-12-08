package todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

import static net.serenitybdd.core.Serenity.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("When completing a task")
class WhenCompletingATask {
    @Managed(driver = "firefox")
    WebDriver driver;

    @BeforeEach
    void openTheApplication() {
        todoList.openApp();
    }

    // TODO: Exercise 3
    @Steps
    TodoListActions todoList;

    @Test
    void activeTasksShouldNotShowCompletedTasks() {
        todoList.addTasks("Feed The Cat", "Walk The Dog");
        assertThat(todoList.numberOfTodoItems()).isEqualTo(2);
        todoList.completeTheTask("Feed The Cat");
        todoList.filterTasksByStatus("Active");
        reportThat("Check that only 'Walk The Dog' appears in the list",
                () -> assertThat(todoList.itemsList()).containsExactly("Walk The Dog"));
    }

    // TODO: Exercise 4
    @Test
    void completedTasksShouldNotShowActiveTasks() {
        todoList.addTasks("Feed The Cat", "Walk The Dog");
        todoList.completeTheTask("Feed The Cat");
        todoList.filterTasksByStatus("Completed");
        reportThat("Check that only 'Feed The Cat' appears in the list",
                () -> assertThat(todoList.itemsList()).containsExactly("Feed The Cat"));

        // Add "Feed the cat" and "Walk the dog" to the list
        // Complete "Feed the cat"
        // Filter by "Completed"
        // Check that only "Feed the cat" appears
    }
//        @Test
//        void completedTasksShouldNotShowActiveTasks1 () {
//            todoList.addTasks("Feed The Cat", "Walk The Dog");
//            todoList.completeTheTask("Walk The Dog");
//            todoList.filterTasksByStatus("Completed");
//            reportThat("Check that only 'Walk The Dog' appears in the list",
//                    () -> assertThat(todoList.itemsList()).containsExactly("Walk The Dog"));
//
//        }
    }

