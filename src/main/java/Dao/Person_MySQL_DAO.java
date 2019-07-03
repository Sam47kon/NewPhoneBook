package Dao;

import Model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Person_MySQL_DAO implements DAO_CRUD<Person, Integer> {
    private Connection connection;

    public Person_MySQL_DAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Person person) {
        try (PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO persons (name, number, address, date) VALUES ( ?, ?, ?, ?)")) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setLong(2, person.getNumber());
            preparedStatement.setString(3, person.getAddress());
            preparedStatement.setDate(4, new Date(person.getDate().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Person readById(Integer id) {
        Person person = new Person();
        try (PreparedStatement preparedStatement = connection.
                prepareStatement("SELECT * FROM persons WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setNumber(rs.getLong("number"));
                person.setAddress(rs.getString("address"));
                person.setDate(rs.getDate("date").toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;

    }

    @Override
    public void update(Person person) {
        try (PreparedStatement preparedStatement = connection
                .prepareStatement("UPDATE persons SET name=?, number=?, address=?, date=? WHERE id=?")) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setLong(2, person.getNumber());
            preparedStatement.setString(3, person.getAddress());
            preparedStatement.setDate(4, new Date(person.getDate().getTime()));
            preparedStatement.setInt(5, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Person person) {
        deletePerson(person.getId());
    }


    public void deletePerson(int id) {
        try (PreparedStatement preparedStatement = connection
                .prepareStatement("DELETE FROM persons WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> readAll() {
        List<Person> peoples = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM persons");
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setNumber(rs.getLong("number"));
                person.setDate(rs.getDate("date"));
                person.setAddress(rs.getString("address"));
                peoples.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peoples;
    }
}
