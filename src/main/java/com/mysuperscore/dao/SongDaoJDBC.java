package com.mysuperscore.dao;


import com.mysql.jdbc.PreparedStatement;
import com.mysuperscore.mapper.ImageMapper;
import com.mysuperscore.mapper.SongMapper;
import com.mysuperscore.model.Song;
import com.mysuperscore.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SongDaoJDBC implements SongDao {

    private JdbcTemplate jdbcTemplate;
    Connection c = null;

    public void setDataSource(DataSource dataSource) {
        try {
            c = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createTable() {
        String SQL = "CREATE  TABLE IF NOT EXISTS `Songs`(" +
                "id INT(11) NOT NULL  AUTO_INCREMENT ," +
                "title VARCHAR(50) NOT NULL," +
                "composer VARCHAR(50) NOT NULL," +
                "album VARCHAR(20) NOT NULL," +
                "description TEXT NOT NULL," +
                /*"fileName VARCHAR(30) NOT NULL," +*/
                "numberOfPages INT(11) default NULL," +
                //
                "data longblob ," +
                "mime varchar(50) default NULL," +
                //
                "PRIMARY KEY(id) )";
        jdbcTemplate.execute(SQL);
    }

    public void createTableUsers() {
        String SQL = "CREATE  TABLE IF NOT EXISTS `users`(" +
                /*"id INT (11) NOT NULL AUTO_INCREMENT," +*/
                "id INT(11) NOT NULL  AUTO_INCREMENT ," +
                "username VARCHAR(45) NOT NULL ," +
                "password VARCHAR(45) NOT NULL ," +
                "passwordConfirm VARCHAR(45) NOT NULL ," +
                "enabled INT NOT NULL DEFAULT 1 ," +
                "PRIMARY KEY(id))";
        jdbcTemplate.execute(SQL);
    }

    public void createTableUsersRoles() {
        String SQL = "CREATE  TABLE IF NOT EXISTS `user_roles`(" +
                "user_role_id int(11) NOT NULL AUTO_INCREMENT," +
                "username varchar(45) NOT NULL," +
                "role varchar(45) NOT NULL," +
                "PRIMARY KEY (user_role_id)," +
                "UNIQUE KEY uni_username_role (role,username)," +
                "KEY fk_username_idx (username)," +
                "CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username))";
        jdbcTemplate.execute(SQL);
    }

    public void createTablePersistentLogins() {
        String SQL = "CREATE  TABLE IF NOT EXISTS `persistent_logins`(" +
                "username varchar(64) not null," +
                "series varchar(64) not null," +
                "token varchar(64) not null," +
                "last_used timestamp not null," +
                "PRIMARY KEY (series))";
        jdbcTemplate.execute(SQL);
    }

    public void create(Song song) {
        String SQL = "INSERT INTO Songs (title, composer, album, description, numberOfPages,data , mime) VALUES (?, ?, ?, ?, ?,?,?)";
        jdbcTemplate.update(SQL, song.getTitle(), song.getComposer(), song.getAlbum(), song.getDescription(), song.getNumberOfPages(), song.getData(), song.getMimeType());
    }


    public Song find(Integer id) {
        String SQL = "SELECT * FROM Songs WHERE id = ?";

        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new SongMapper());
    }

    public Song findImageById(Integer id) {
        String SQL = "SELECT * FROM Songs WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ImageMapper());
    }

    @Override
    public User findUsername(String name) {

        String SQL = "SELECT * FROM Users WHERE username = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = (PreparedStatement) c.prepareStatement(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            preparedStatement.setString(1, name);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = null;

        User user = new User();
        try {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {

                user.setId(Integer.parseInt(rs.getString("id")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPasswordConfirm(rs.getString("passwordConfirm"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void delete(Song song) {
        String SQL = "DELETE  FROM Songs WHERE id = ?";
        jdbcTemplate.update(SQL, song.getId());
        System.out.println("DELETE Song with ID = " + song.getId());
    }

    public void update(Song song) {

        String SQL = "UPDATE Songs SET title = ?,composer = ?,album = ?,description = ?, numberOfPages = ?, data = ?, mime = ? WHERE id = ?";
        jdbcTemplate.update(SQL, song.getTitle(), song.getComposer(), song.getAlbum(), song.getDescription(),song.getNumberOfPages(),song.getData(), song.getMimeType(), song.getId());
    }


  /*  public List<Song> findAll() {
        String SQL = "SELECT * FROM Songs";
        return jdbcTemplate.query(SQL,
                new SongMapper());
    }*/

    public List<Song> filter(Map<String, String> filters) {
        List<String> expressions = new ArrayList<>();
        List<Object> parameters = new ArrayList<>();
        filters.entrySet().stream().filter(entry -> entry.getValue() != null && !entry.getValue().trim().isEmpty()).forEach(entry -> {
            expressions.add(entry.getKey() + " LIKE ?");
            parameters.add("%" + entry.getValue() + "%");
        });

        String expressionsSql = String.join(" AND ", expressions);
        String SQL = "SELECT * FROM Songs" +
                (!expressionsSql.isEmpty() ? " WHERE " + expressionsSql : "");

        List<Song> query = jdbcTemplate.query(SQL, parameters.toArray(), new SongMapper());
        return query;
    }

    public void createUser(User user) {
        String SQL = "INSERT INTO Users (username, password, passwordConfirm, enabled) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(SQL, user.getUsername(), user.getPassword(), user.getPasswordConfirm(), user.getTinyint());
    }
}