package com.italomartinez.cancion.repositorios;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.italomartinez.cancion.modelos.Artista;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long> {
    List<Artista> findAll();
}

