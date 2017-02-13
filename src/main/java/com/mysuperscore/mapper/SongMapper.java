package com.mysuperscore.mapper;


import com.mysuperscore.model.Song;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongMapper implements org.springframework.jdbc.core.RowMapper<Song> {
    public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
        Song song = new Song();
        song.setId(rs.getInt("id"));
        song.setNumberOfPages(rs.getInt("numberOfPages"));
        song.setTitle(rs.getString("title"));
        song.setComposer(rs.getString("composer"));
        song.setAlbum(rs.getString("album"));
        song.setDescription(rs.getString("description"));
        song.setFileName(rs.getString("fileName"));

        return song;
    }
}
