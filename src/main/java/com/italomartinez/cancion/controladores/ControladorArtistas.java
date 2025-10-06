package com.italomartinez.cancion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.italomartinez.cancion.modelos.Artista;
import com.italomartinez.cancion.servicios.ServicioArtistas;

import jakarta.validation.Valid;
@Controller
public class ControladorArtistas {

    @Autowired
    private ServicioArtistas servicio;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        model.addAttribute("artistas", servicio.obtenerTodosLosArtistas());
        return "artistas";
    }

    @GetMapping("/artistas/detalle/{id}")
    public String desplegarDetalleArtista(@PathVariable Long id, Model model) {
        Artista artista = servicio.obtenerArtistaPorId(id);
        model.addAttribute("artista", artista);
        return "detalleArtista";
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(Model model) {
        model.addAttribute("artista", new Artista());
        return "agregarArtista";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista,
                                        BindingResult result) {
        if (result.hasErrors()) {
            return "agregarArtista";
        }
        servicio.agregarArtista(artista);
        return "redirect:/artistas";
    }
}
