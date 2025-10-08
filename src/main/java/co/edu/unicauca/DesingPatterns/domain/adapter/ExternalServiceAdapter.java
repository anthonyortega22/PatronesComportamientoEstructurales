 /*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.DesingPatterns.domain.adapter;
import  org.json.JSONObject;
/**
 *
 * @author User
 */
public class ExternalServiceAdapter implements CompanyDataProvider {
    private final ExternalService externalService;
    public ExternalServiceAdapter(ExternalService externalService) {
        this.externalService = externalService;
    }
    @Override
    public Company getCompany() {
        String jsonData = externalService.getCompanyData();
        if (jsonData == null || jsonData.trim().isEmpty()) {
            // Valor por defecto cuando no hay datos
            return new Company("Empresa externa (sin datos)");
        }
        try {
            JSONObject obj = new JSONObject(jsonData);
            // Buscamos varios nombres posibles en el JSON por robustez
            String name = null;
            if (obj.has("name") && !obj.isNull("name")) {
                name = obj.optString("name", "").trim();
            }
            if ((name == null || name.isEmpty()) && obj.has("companyName")) {
                name = obj.optString("companyName", "").trim();
            }
            if ((name == null || name.isEmpty()) && obj.has("nombre")) {
                name = obj.optString("nombre", "").trim();
            }
            if (name == null || name.isEmpty()) {
                name = "Empresa externa (sin nombre)";
            }
            return new Company(name);
        } catch (Exception ex) {
            // Manejo de error: no romper la app, devolver un Company con nombre por defecto
            System.err.println("ExternalServiceAdapter: error parseando JSON: " + ex.getMessage());
            return new Company("Empresa externa (JSON inválido)");
        }
    }
}