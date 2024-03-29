package com.java2novice.dp.builder.pattern;
 
public class OpticalZoomCamaraBuilder extends CamaraBuilder {
 
    @Override
    public void buildOpticalZome() {
        this.cam.setOpticalZoom("50X Optical Zoom");
    }
 
    @Override
    public void buildDigitalZome() {
        this.cam.setDigitalZoom("None");
    }
 
    @Override
    public void buildDisplay() {
        this.cam.setDisplaySize("6 inch LED screen with touch functionality");
    }
 
    @Override
    public void buildMemory() {
        this.cam.setInMemorySize("32GB inbuilt memory");
    }
}
