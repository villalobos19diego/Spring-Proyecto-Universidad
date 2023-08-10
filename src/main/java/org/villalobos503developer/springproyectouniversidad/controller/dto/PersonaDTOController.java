package org.villalobos503developer.springproyectouniversidad.controller.dto;

import org.villalobos503developer.springproyectouniversidad.model.dto.PersonaDTO;
import org.villalobos503developer.springproyectouniversidad.model.entity.Alumno;
import org.villalobos503developer.springproyectouniversidad.model.entity.Empleado;
import org.villalobos503developer.springproyectouniversidad.model.entity.Persona;
import org.villalobos503developer.springproyectouniversidad.model.entity.Profesor;
import org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct.AlumnoMapper;
import org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct.EmpleadoMapper;
import org.villalobos503developer.springproyectouniversidad.model.mapper.mapstruct.ProfesorMapper;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PersonaDAO;

import java.util.*;


public class PersonaDTOController extends GenericDTOController<Persona, PersonaDAO>{
    protected AlumnoMapper alumnoMapper;
    protected EmpleadoMapper empleadoMapper;
    protected ProfesorMapper profesorMapper;
    public PersonaDTOController(PersonaDAO service, String nombre_entidad, AlumnoMapper alumnoMapper) {
        super(service, nombre_entidad);
        this.alumnoMapper = alumnoMapper;
    }
    public PersonaDTOController(PersonaDAO service, String nombre_entidad, EmpleadoMapper empleadoMapper) {
        super(service, nombre_entidad);
        this.empleadoMapper = empleadoMapper;
    }

    public PersonaDTOController(PersonaDAO service, String nombre_entidad, ProfesorMapper profesorMapper) {
        super(service, nombre_entidad);
        this.profesorMapper = profesorMapper;
    }
    public List<PersonaDTO> findAllPersonas(){
        List<Persona> personas = super.findAll();
        List<PersonaDTO> dtos = new ArrayList<>();
        personas.forEach(persona -> {
            if (persona instanceof Alumno && alumnoMapper != null) {
                dtos.add(alumnoMapper.mapAlumnoDTO((Alumno) persona));
            } else if (persona instanceof Profesor && profesorMapper != null) {
                dtos.add(profesorMapper.mapProfesor((Profesor) persona));
            } else if (persona instanceof Empleado && empleadoMapper != null) {
                dtos.add(empleadoMapper.mapEmpleado((Empleado) persona));
            }
        });

        return dtos;
    }

    public PersonaDTO findPersonaId(Integer id){
        Optional<Persona>optionalPersona= super.findId(id);
        Persona persona;
        PersonaDTO dto = null;
        if (optionalPersona == null || optionalPersona.isEmpty()) {
            return null;
        }else {
            persona = optionalPersona.get();
        }
        if (persona instanceof Alumno){
            dto = alumnoMapper.mapAlumnoDTO((Alumno) persona);
        }else if(persona instanceof Profesor){
            dto = profesorMapper.mapProfesor((Profesor) persona);
        }else  if (persona instanceof Empleado){
            dto = empleadoMapper.mapEmpleado((Empleado) persona);
        }
        return dto;
    }

    public PersonaDTO altaPersona(Persona persona){
        Persona personaEntidad =super.altaEntidad(persona);
        PersonaDTO dto = null;

        if (personaEntidad instanceof Alumno){
            dto =alumnoMapper.mapAlumnoDTO((Alumno) personaEntidad);

        }else if(personaEntidad instanceof Profesor){
            dto =profesorMapper.mapProfesor((Profesor) personaEntidad);

        }else  if (personaEntidad instanceof Empleado){
            dto =empleadoMapper.mapEmpleado((Empleado) personaEntidad);
        }
        return dto;
    }
    public void deletePersonaId(Integer id){
        super.deleteByid(id);
    }

    public PersonaDTO buscarPersonaPorNombreYApellido( String nombre,String apellido){
        Optional<Persona>optionalPersona =service.findNameLastName(nombre,apellido);
        Persona persona;
        PersonaDTO dto = null;
        if (optionalPersona == null || optionalPersona.isEmpty()) {
            return null;
        }else {
            persona=optionalPersona.get();
        }
        if (persona instanceof Alumno){
            dto =alumnoMapper.mapAlumnoDTO((Alumno) persona);

        }else if(persona instanceof Profesor){
            dto =profesorMapper.mapProfesor((Profesor) persona);

        }else  if (persona instanceof Empleado){
            dto =empleadoMapper.mapEmpleado((Empleado) persona);
        }
        return dto;
    }
    public PersonaDTO buscarPorDni(String dni){
        Optional<Persona>optionalPersona =service.findDni(dni);
        Persona persona;
        PersonaDTO dto = null;

        if (optionalPersona == null || optionalPersona.isEmpty()) {
            return null;
        }else {
           persona= optionalPersona.get();
        }
        if (persona instanceof Alumno){
            dto = alumnoMapper.mapAlumnoDTO((Alumno) persona);

        }else if(persona instanceof Profesor){
            dto =profesorMapper.mapProfesor((Profesor) persona);

        }else  if (persona instanceof Empleado){
            dto =empleadoMapper.mapEmpleado((Empleado) persona);
        }
        return dto;
    }


}
