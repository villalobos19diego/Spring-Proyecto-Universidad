package org.villalobos503developer.springproyectouniversidad.universidadbackend.servicios.implementaciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.villalobos503developer.springproyectouniversidad.model.entity.Carrera;
import org.villalobos503developer.springproyectouniversidad.repository.CarreraRepository;
import org.villalobos503developer.springproyectouniversidad.service.contratos.CarreraDAO;
import org.villalobos503developer.springproyectouniversidad.service.implementaciones.CarreraDAOImpl;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.villalobos503developer.springproyectouniversidad.universidadbackend.datos.DatosDummy.carrera01;
import static org.villalobos503developer.springproyectouniversidad.universidadbackend.datos.DatosDummy.carrera03;

class CarreraDAOImplTest {

    CarreraDAO carreraDAO;
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp() {
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepository);
    }

    @Test
    void findCarrerasByNombreContains() {
        //Given
        String nombre = "Ingenieria";
        when(carreraRepository.findCarreraByNombreContains(nombre))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarreraByNombreContains(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarreraByNombreContains(nombre);
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        //Given
        String nombre = "ingenieria";
        when(carreraRepository.findCarreraByNombreContainsIgnoreCase(nombre))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarreraByNombreContainsIgnoreCase(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarreraByNombreContainsIgnoreCase(nombre);
    }

    @Test
    void findCarrerasByCantidadAniosAfter() {
        //Given
        int cantidad = 4;
        when(carreraRepository.findCarreraByCantidadAniosAfter(cantidad))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarreraByCantidadAniosAfter(cantidad);

        //Then
        assertThat(expected.get(0)).isEqualTo(carrera01(true));
        assertThat(expected.get(1)).isEqualTo(carrera03(true));

        verify(carreraRepository).findCarreraByCantidadAniosAfter(cantidad);
    }

}