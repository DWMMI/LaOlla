package com.example.laolla;

public class ItemLista {
    private int img;
    private String texto;


    public ItemLista(int img, String textoup) {
        this.img = img;
        this.texto = textoup;
    }

    public String getTextoup() {
        return texto;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setTextoup(String textoup) {
        this.texto = textoup;
    }




}
