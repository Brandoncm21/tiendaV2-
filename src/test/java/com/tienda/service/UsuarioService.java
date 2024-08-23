/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.domain.Usuario;
import java.util.List;

/**
 *
 * @author malum
 */
public interface UsuarioService {

    public List<Usuario> getUsuarios();
// Se obtiene un Usuario, a part ir del id de un usuario

    public Usuario getUsuario(Usuario usuario);
// Se obtiene un Usuario, a part ir del username de un usuario

    public Usuario getUsuarioPorUsername(String username);
    // Se obtiene un Usuario a partir del username y el password de un usuario

    public Usuario getUsuarioPorUsernameYPassword(String username, String password);

// Se obtiene un Usuario a partir del username o el correo de un usuario
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo);

// Se valida si existe un Usuario considerando el username o el correo
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo);
// Se inserta un nuevo usuario si el id del usuario está vacío
// Se actualiza un usuario si el id del usuario NO está vacío

    public void save(Usuario usuario, boolean crearRolUser);

// Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuario usuario);

}
