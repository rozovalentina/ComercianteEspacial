package com.proyecto.ComercianteEspacial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyCustomErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Obtiene el código de error
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        // Maneja diferentes códigos de error de manera diferente
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404"; // Página personalizada para errores 404
            } else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500"; // Página personalizada para errores 500
            }
        }
        
        // Si no se encuentra un código de error específico, redirige a una página de error genérica
        return "error";
    }
    
}
