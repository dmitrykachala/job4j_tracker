package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreate() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        String ln = System.lineSeparator();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln + "0. Create Item" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenShow() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        String ln = System.lineSeparator();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        UserAction[] actions = {
                new ShowAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + ln + "0. Show all Items" + ln
                + "1. Exit" + ln + "=== Show all items ====" + ln + item + ln
                + "Menu." + ln + "0. Show all Items" + ln + "1. Exit" + ln));
    }

    @Test
    public void whenEditItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Edited item"));
        String editedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), editedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(editedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String ln = System.lineSeparator();
        Item item = tracker.add(new Item("item"));
        int search = item.getId();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(search), "1"}
        );
        UserAction[] actions = {
                new FindItemByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + ln + "0. Find Item by Id" + ln + "1. Exit" + ln
                + "=== Find item by id ====" + ln + tracker.findById(search) + ln
                + "Menu." + ln + "0. Find Item by Id" + ln + "1. Exit" + ln));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        String search = item.getName();
        String ln = System.lineSeparator();
        Input in = new StubInput(
                new String[] {"0", search, "1"}
        );
        UserAction[] actions = {
                new FindItemByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + ln + "0. Find Item by Name" + ln + "1. Exit" + ln
                + "=== Find items by name ====" + ln + item + ln
                + "Menu." + ln + "0. Find Item by Name" + ln + "1. Exit" + ln));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }
}