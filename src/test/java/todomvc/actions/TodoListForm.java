package todomvc.actions;

import org.openqa.selenium.By;

class TodoListForm {
    static final By NEW_ITEM_NAME = By.cssSelector(".new-todo");
    static final String ITEMS_LABELS = ".todo-list label";
    static final String COMPLETE_CHECKBOX = "//label[.='{0}']/preceding-sibling::input[@type='checkbox']";
    static final String FILTER_BUTTON ="//ul[@class='filters']//a[text()='{0}']";

    static final String ITEM_LABEL = "//label[.='{0}']";
    static final String DELETE_ICON ="//label[.='{0}']/following-sibling::button";
}
