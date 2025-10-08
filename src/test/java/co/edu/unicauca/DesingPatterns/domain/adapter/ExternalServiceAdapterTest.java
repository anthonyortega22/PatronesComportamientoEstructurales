/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unicauca.DesingPatterns.domain.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author User
 */
public class ExternalServiceAdapterTest {

    @Test
    public void testGetCompany_ValidJsonWithName() {
        // Simulamos el servicio externo
        ExternalService service = mock(ExternalService.class);
        when(service.getCompanyData()).thenReturn("{\"name\": \"TechCorp\"}");

        ExternalServiceAdapter adapter = new ExternalServiceAdapter(service);
        Company result = adapter.getCompany();

        assertEquals("TechCorp", result.getName());
    }

    @Test
    public void testGetCompany_ValidJsonWithCompanyName() {
        ExternalService service = mock(ExternalService.class);
        when(service.getCompanyData()).thenReturn("{\"companyName\": \"Innova Ltd\"}");

        ExternalServiceAdapter adapter = new ExternalServiceAdapter(service);
        Company result = adapter.getCompany();

        assertEquals("Innova Ltd", result.getName());
    }

    @Test
    public void testGetCompany_ValidJsonWithNombre() {
        ExternalService service = mock(ExternalService.class);
        when(service.getCompanyData()).thenReturn("{\"nombre\": \"Fábrica Andina\"}");

        ExternalServiceAdapter adapter = new ExternalServiceAdapter(service);
        Company result = adapter.getCompany();

        assertEquals("Fábrica Andina", result.getName());
    }

    @Test
    public void testGetCompany_JsonWithoutName() {
        ExternalService service = mock(ExternalService.class);
        when(service.getCompanyData()).thenReturn("{\"id\": 10}");

        ExternalServiceAdapter adapter = new ExternalServiceAdapter(service);
        Company result = adapter.getCompany();

        assertEquals("Empresa externa (sin nombre)", result.getName());
    }

    @Test
    public void testGetCompany_NullJson() {
        ExternalService service = mock(ExternalService.class);
        when(service.getCompanyData()).thenReturn(null);

        ExternalServiceAdapter adapter = new ExternalServiceAdapter(service);
        Company result = adapter.getCompany();

        assertEquals("Empresa externa (sin datos)", result.getName());
    }

    @Test
    public void testGetCompany_InvalidJson() {
        ExternalService service = mock(ExternalService.class);
        when(service.getCompanyData()).thenReturn("esto no es json");

        ExternalServiceAdapter adapter = new ExternalServiceAdapter(service);
        Company result = adapter.getCompany();

        assertEquals("Empresa externa (JSON inválido)", result.getName());
    }
}