/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.domain.Usuario;
import com.tienda.service.FirebaseStorageService;
import com.tienda.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Método para listar todos los usuarios.
     *
     * @param model El modelo para la vista.
     * @return La vista con el listado de usuarios.
     */
    @GetMapping("/usuarios/listado")
    public String listado(Model model) {
        // Obtiene la lista de usuarios
        var usuarios = usuarioService.getUsuarios();

        // Añade los usuarios y el total de usuarios al modelo
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());

        // Devuelve el nombre de la vista
        return "/usuario/listado";

    }

    @GetMapping(" / nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    /**
     * Método para guardar un usuario, incluyendo la imagen del usuario.
     *
     * @param usuario El objeto Usuario a guardar.
     * @param imagenFile El archivo de imagen subido.
     * @return Redirige al listado de usuarios después de guardar.
     */
    @PostMapping("/usuario/guardar")
    public String usuarioGuardar(Usuario usuario, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            usuarioService.save(usuario, false);
            usuario.setRutaImagen(firebaseStorageService.cargaImagen(imagenFile, "usuario", usuario.getIdUsuario()));

        }
        usuarioService.save(usuario, true);
        return "redirect:/usuario/listado";
    }
     @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }

    /**
     * Método para modificar un usuario.
     * 
     * @param usuario El objeto Usuario que se va a modificar.
     * @param model El objeto Model para pasar datos a la vista.
     * @return La vista de modificación de usuario.
     */
    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}
