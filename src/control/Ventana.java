
package control;


public  class Ventana {
    
    public Ventana(){
    }
    boolean estado=false;
    
    public void cambiarEstado(){
       this.estado=true;
    }
    
    public boolean verEstado(){
        return estado;
    }
}
