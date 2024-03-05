package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.repository.*;
import com.proyecto.ComercianteEspacial.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoNaveService {

    @Autowired
    private TipoNaveRepository tipoNaveRepository;

    public List<TipoNave> obtenerTodosLosTiposNaves() {
        return tipoNaveRepository.findAll();
    }

    @SuppressWarnings("null")
    public TipoNave obtenerTipoNavePorId(Long id) {
        return tipoNaveRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public TipoNave guardarTipoNave(TipoNave tipoNave) {
        return tipoNaveRepository.save(tipoNave);
    }

    @SuppressWarnings("null")
    public void eliminarTipoNavePorId(Long id) {
        tipoNaveRepository.deleteById(id);
    }

    // Otros métodos según sea necesario, por ejemplo, métodos para buscar tipos de naves por nombre, actualizar tipos de naves, etc.
}
