package com.italomartinez.cancion.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italomartinez.cancion.modelos.Cancion;
import com.italomartinez.cancion.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {

    @Autowired
    private RepositorioCanciones repositorio;

    public List<Cancion> obtenerTodasLasCanciones() {
        return repositorio.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        Optional<Cancion> cancion = repositorio.findById(id);
        return cancion.orElse(null);
    }

    public Cancion agregarCancion(Cancion cancion) {
    return repositorio.save(cancion);
    }

    public Cancion actualizaCancion(Cancion cancion) {
    Optional<Cancion> existente = repositorio.findById(cancion.getId());
    if (existente.isPresent()) {
        Cancion c = existente.get();
        c.setTitulo(cancion.getTitulo());
        c.setArtista(cancion.getArtista());
        c.setAlbum(cancion.getAlbum());
        c.setGenero(cancion.getGenero());
        c.setIdioma(cancion.getIdioma());
        return repositorio.save(c);
    } 
    else {
        return null;
        }
    }
    public void eliminaCancion(Long id) {
    repositorio.deleteById(id);
}

}