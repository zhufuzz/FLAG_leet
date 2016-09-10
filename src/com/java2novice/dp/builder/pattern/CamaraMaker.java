package com.java2novice.dp.builder.pattern;
 
public class CamaraMaker {
 
    private CamaraBuilder camBuilder = null;
     
    public void setCamaraBuilder(CamaraBuilder camBuilder){
        this.camBuilder = camBuilder;
    }
     
    public Camara getCamara(){
        return this.camBuilder.getCamara();
    }
     
    public void constructCamara(){
        this.camBuilder.createNewCamara();
        this.camBuilder.buildDigitalZome();
        this.camBuilder.buildOpticalZome();
        this.camBuilder.buildDisplay();
        this.camBuilder.buildMemory();
    }
}
