package com.mysuperscore.dao;


import com.mysuperscore.mapper.SongMapper;
import com.mysuperscore.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class SongDAO implements SongDaoInterface{
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createTable() {
        String SQL = "CREATE  TABLE IF NOT EXISTS `Songs`(" +
                "id INT(11) NOT NULL  AUTO_INCREMENT ," +
                "title VARCHAR(50) NOT NULL," +
                "composer VARCHAR(50) NOT NULL," +
                "album VARCHAR(20) NOT NULL," +
                "description VARCHAR(500) NOT NULL," +
                //"fileName VARCHAR(30) NOT NULL," +
                "numberOfPages INT(11) default NULL," +
                "PRIMARY KEY(id) )";
        jdbcTemplate.execute(SQL);
    }

    public void create(Song song) {
        String SQL = "INSERT INTO Songs (title, composer, album, description, numberOfPages,fileName) VALUES (?, ?, ?, ?, ?,?)";

        jdbcTemplate.update(SQL, song.getTitle(), song.getComposer(), song.getAlbum(), song.getDescription(),song.getNumberOfPages(),song.getFileName());
    }


   public Song find(Integer id) {
        String SQL = "SELECT * FROM Songs WHERE id = ?";

        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new SongMapper());
    }


    public void delete(Song song) {
        String SQL = "DELETE  FROM Songs WHERE id = ?";
        jdbcTemplate.update(SQL, song.getId());
        System.out.println("DELETE Song with ID = " + song.getId());
    }


    public void update(Song song) {

        String SQL = "UPDATE Songs SET title = ?,composer = ?,album = ?,description = ?, numberOfPages = ?, fileName = ? WHERE id = ?";
        jdbcTemplate.update(SQL, song.getTitle(), song.getComposer(), song.getAlbum(), song.getDescription(),song.getNumberOfPages(),song.getFileName(),song.getId());
    }


    public List<Song> findAll() {
        String SQL = "SELECT * FROM Songs";
        return jdbcTemplate.query(SQL,
                new SongMapper());
    }



}
