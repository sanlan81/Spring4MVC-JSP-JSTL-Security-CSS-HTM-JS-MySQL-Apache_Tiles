package com.mysuperscore.dao;


import com.mysuperscore.model.Song;

import java.util.List;

interface SongDaoInterface {
     void create(Song song);
     void update(Song song);
     void delete(Song song);
     List<Song> findAll();
     Song find(Integer id);
}
