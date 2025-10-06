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
import com.italomartinez.cancion.modelos.Cancion;
import com.italomartinez.cancion.servicios.ServicioArtistas;
import com.italomartinez.cancion.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;

    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        model.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
        return "canciones";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion == null) {
            return "redirect:/canciones";
        }
        model.addAttribute("cancion", cancion);
        return "detalleCancion";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion, Model model) {
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult result,
            Model model) {

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
        servicioCanciones.agregarCancion(cancion);

        return "redirect:/canciones";
    }

    @GetMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
        servicioCanciones.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }

@GetMapping("/canciones/formulario/editar/{id}")
public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
    Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
    if (cancion == null) {
        return "redirect:/canciones";
    }
    model.addAttribute("cancion", cancion);
    model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
    return "editarCancion"; 
}
@PostMapping("/canciones/formulario/editar/{id}")
public String actualizarCancion(@PathVariable("id") Long id,
                                @Valid @ModelAttribute("cancion") Cancion cancionActualizada,
                                BindingResult result,
                                Model model) {
    if (result.hasErrors()) {
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "editarCancion"; // vuelve al formulario mostrando errores
    }

    Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
    if (cancion != null) {
        cancion.setTitulo(cancionActualizada.getTitulo());
        cancion.setAlbum(cancionActualizada.getAlbum());
        cancion.setGenero(cancionActualizada.getGenero());
        cancion.setIdioma(cancionActualizada.getIdioma());

        if (cancionActualizada.getArtista() != null && cancionActualizada.getArtista().getId() != null) {
            Artista artista = servicioArtistas.obtenerArtistaPorId(cancionActualizada.getArtista().getId());
            cancion.setArtista(artista);
        }

        servicioCanciones.actualizaCancion(cancion);
    }
    return "redirect:/canciones";
}

}
