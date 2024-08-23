/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true) //relacionado con la base de datos,,, solo lectura
    public List<Categoria> getCategorias(boolean Activos) {// 
        var lista = categoriaDao.findAll();//logica 
        if (Activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public void save(Categoria categoria) { //guardar o mod el id de categoria
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public void delete(Categoria categoria) { //elimionar o mod el id de categoria
        categoriaDao.delete(categoria);
    }

}
