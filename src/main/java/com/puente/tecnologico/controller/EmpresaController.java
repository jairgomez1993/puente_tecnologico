package com.puente.tecnologico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.puente.tecnologico.model.Empresa;
import com.puente.tecnologico.repository.EmpresaRepository;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "formulario-empresa";
    }

    @PostMapping("/registrar-empresa")
    public String registrarEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
        System.out.println("Empresa guardada en BD: " + empresa.getNombre());
        return "exito";
    }

    @GetMapping("/vacantes")
    public String listarVacantes(Model model) {
        model.addAttribute("empresas", empresaRepository.findAll());
        return "vacantes";
    }

    @GetMapping("/convenios")
    public String mostrarConvenios(Model model) {
        // Datos estáticos por ahora: universidades y carreras
        model.addAttribute("universidades", java.util.List.of(
                java.util.Map.of(
                        "nombre", "Uniminuto",
                        "descripcion", "Universidad con programas técnicos y profesionales.",
                        "carreras", java.util.List.of("Ingeniería de Sistemas", "Administración de Empresas", "Contaduría")
                ),
                java.util.Map.of(
                        "nombre", "Corporación Universitaria Republicana",
                        "descripcion", "Institución enfocada en formación profesional y tecnológica.",
                        "carreras", java.util.List.of("Técnologo en Desarrollo de Software", "Negocios Internacionales")
                )
        ));
        return "convenios";
    }
}