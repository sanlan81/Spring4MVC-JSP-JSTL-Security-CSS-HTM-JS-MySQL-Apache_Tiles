package com.mysuperscore.mapper;

import com.mysuperscore.model.Song;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongMapper implements RowMapper<Song> {
    public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
        Song song = new Song();
        song.setId(rs.getInt("id"));
        song.setNumberOfPages(rs.getInt("numberOfPages"));
        song.setTitle(rs.getString("title"));
        song.setComposer(rs.getString("composer"));
        song.setAlbum(rs.getString("album"));
        song.setDescription(rs.getString("description"));
        return song;
    }
}
