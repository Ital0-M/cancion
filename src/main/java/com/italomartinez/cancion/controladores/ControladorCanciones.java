package com.italomartinez.cancion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.italomartinez.cancion.modelos.Artista;
import com.italomartinez.cancion.modelos.Cancion;
import com.italomartinez.cancion.servicios.ServicioArtistas;
import com.italomartinez.cancion.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/canciones")
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicio;

    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping
    public String desplegarCanciones(Model model) {
        model.addAttribute("canciones", servicio.obtenerTodasLasCanciones());
        return "canciones";
    }

    @GetMapping("/detalle/{id}")
    public String desplegarDetalleCancion(@PathVariable("id") Long id, Model model) {
        Cancion cancion = servicio.obtenerCancionPorId(id);
        model.addAttribute("cancion", cancion);
        return "detalleCancion";
    }

    @GetMapping("/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

@PostMapping("/canciones/procesa/agregar")
public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
                                    BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

    if (cancion.getArtista() == null || cancion.getArtista().getId() == null) {
        result.rejectValue("artista", "error.cancion", "Debe seleccionar un artista válido");
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

    Artista artista = servicioArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
    if (artista == null) {
        result.rejectValue("artista", "error.cancion", "El artista seleccionado no existe");
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

    cancion.setArtista(artista);
    servicio.agregarCancion(cancion);

    return "redirect:/canciones";
}

    @GetMapping("/formulario/editar/{id}")
    public String formularioEditarCancion(@PathVariable("id") Long id, Model model) {
    Cancion cancion = servicio.obtenerCancionPorId(id);
    if (cancion == null) {
        return "redirect:/canciones";
    }
    model.addAttribute("cancion", cancion);
    return "editarCancion";
    }

    @PostMapping("/procesa/editar/{id}")
    public String procesarEditarCancion(@PathVariable("id") Long id,
                                    @Valid @ModelAttribute("cancion") Cancion cancion,
                                    BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "editarCancion";
    }
    cancion.setId(id);
    servicio.actualizaCancion(cancion);
    return "redirect:/canciones";
    }

    @GetMapping("/eliminar/{id}")
    public String procesarEliminarCancion(@PathVariable("id") Long id) {
    servicio.eliminaCancion(id);
    return "redirect:/canciones";
}

}