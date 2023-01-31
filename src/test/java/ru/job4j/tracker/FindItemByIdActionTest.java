package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemByIdActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        LocalDateTime created = LocalDateTime.of(2022, 1, 10, 20, 30, 40);

        Item item1 = new Item(1, "Test item 1", created);
        Item item2 = new Item(2, "Test item 2", created);

        tracker.add(item1);
        tracker.add(item2);
        FindItemByIdAction fId = new FindItemByIdAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);

        assertTrue(fId.execute(input, tracker));

        String ln = System.lineSeparator();

        assertThat(out.toString(), is("=== Find item by id ====" + ln
                + item2 + ln));
    }

}