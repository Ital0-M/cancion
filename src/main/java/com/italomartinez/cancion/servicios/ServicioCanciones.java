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
}