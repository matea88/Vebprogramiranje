package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImplementation implements SongService {
private final SongRepository songRepository;
private final AlbumRepository albumRepository;

    public SongServiceImplementation(SongRepository songRepository, AlbumRepository albumRepository) {

        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return this.songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        this.songRepository.addArtistToSong(artist, song);
        return artist;
    }

    @Override
    public Optional<Song> findByTrackId(Long trackId) {
        return this.songRepository.findByTrackId(trackId);
    }
    @Override
    public Optional<Song> save(String title, String genre, int releaseYear, Long albumId, Optional<Long> songId) {
        Album album = albumRepository.findById(albumId).orElse(null);
        return songRepository.save(title, genre, releaseYear, album, songId);
    }

    @Override
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }
}
