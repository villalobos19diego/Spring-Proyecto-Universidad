package org.villalobos503developer.springproyectouniversidad.universidadbackend.servicios.implementaciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.villalobos503developer.springproyectouniversidad.repository.AlumnoRepository;
import org.villalobos503developer.springproyectouniversidad.service.contratos.PersonaDAO;
import org.villalobos503developer.springproyectouniversidad.service.implementaciones.PersonaDAOImpl;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonaDAOImplTest {

    PersonaDAO personaDAO;
    @Mock
    AlumnoRepository alumnoRepository;

    @BeforeEach
    void setUp() {
        personaDAO = new PersonaDAOImpl(alumnoRepository);
    }

    @Test
    void buscarPorNombreYApellido() {
        //When
        personaDAO.findNameLastName(anyString(), anyString());

        //Then
        verify(alumnoRepository).buscarPorNombreYApellido(anyString(), anyString());
    }

    @Test
    void buscarPorDni() {
        //When
        personaDAO.findDni(anyString());

        //Then
        verify(alumnoRepository).buscarPorDni(anyString());
    }

    @Test
    void buscarPersonaPorApellido() {
        //When
        personaDAO.findLastName(anyString());

        //Then
        verify(alumnoRepository).buscarPersonaPorApellido(anyString());
    }

}