package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindByNameThenMustBeRight() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item rsl = tracker.findByName("item").get(0);
        assertThat(rsl, is(item));
    }

    @Test
    public void whenFindAllThenMustMatch() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        List<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item1);
        expected.add(item2);
        List<Item> rsl = tracker.findAll();
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenDeleteThenMustBeCorrect() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        assertTrue(tracker.delete(item1.getId()));
        assertFalse(tracker.delete(25));
    }

    @Test
    public void whenReplaceThenNew() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item replaced = new Item(item2.getId(), "replaced");
        assertTrue(tracker.replace(item2.getId(), replaced));
    }
}