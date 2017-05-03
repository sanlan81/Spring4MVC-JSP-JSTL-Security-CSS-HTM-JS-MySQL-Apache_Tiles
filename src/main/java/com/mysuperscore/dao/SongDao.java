package com.mysuperscore.dao;


import com.mysuperscore.model.Song;
import com.mysuperscore.model.User;

import java.util.List;

interface SongDao {
     void create(Song song);
     void update(Song song);
     void delete(Song song);
     List<Song> findAll();
     Song find(Integer id);
     User findUsername(String name);
}
