package mx.ipn.e_fortlessshoping;

import java.util.ArrayList;

public class CarrxD {
    String eMail;
    int numero = 0;
    int total = 0;
    ArrayList<String> Productos = new ArrayList<String>();



    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setProductos(String productos) {
        this.Productos.add(productos);
    }

    public ArrayList<String> getProductos() {
        return Productos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void Contador(){
        numero++;
    }

    public void Limpiar(){
        numero = 0;
        total = 0;
        Productos.clear();
    }
}
