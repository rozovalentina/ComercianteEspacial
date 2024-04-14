package com.proyecto.ComercianteEspacial.service;

import com.proyecto.ComercianteEspacial.model.TipoNave;
import com.proyecto.ComercianteEspacial.repository.TipoNaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoNaveService {

    @Autowired
    private TipoNaveRepository tipoNaveRepository;

    public List<TipoNave> obtenerTodosLosTiposNaves() {
        return tipoNaveRepository.findAll();
    }

    public TipoNave obtenerTipoNavePorId(Long id) {
        return tipoNaveRepository.findById(id).orElse(null);
    }

    public TipoNave guardarTipoNave(TipoNave tipoNave) {
        return tipoNaveRepository.save(tipoNave);
    }

    public void eliminarTipoNavePorId(Long id) {
        tipoNaveRepository.deleteById(id);
    }
}
