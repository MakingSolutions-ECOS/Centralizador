/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.service.Response;

import co.uniandes.edu.ecos.dto.EmisorDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camilo Marroquin
 */
public class RespuestaEmisor extends RespuestaService{
    
    private List<EmisorDto> Emisores;

    public RespuestaEmisor() {
        this.Emisores = new ArrayList<>();
    }

    public RespuestaEmisor(List<EmisorDto> emisores) {
        this.Emisores = emisores;
    }
    
    public List<EmisorDto> getEmisores(){
        return Emisores;
    }

    public void setEmisores(List<EmisorDto> emisores) {
        this.Emisores = emisores;
    }
    
    
    
}
