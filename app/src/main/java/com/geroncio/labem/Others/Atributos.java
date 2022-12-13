package com.geroncio.labem.Others;

public class Atributos {

    private String name, seccao;
    private  int imagePic,layoutseccao;


    public Atributos(String name, String seccao, int imagePic, int layoutseccao){
        this.name = name;
        this.seccao = seccao;
        this.imagePic = imagePic;
        this.layoutseccao = layoutseccao;

    }

    public String getName() {
        return name;
    }
    public String getSeccao() {
        return seccao;
    }
    public int getImagePic() {
        return imagePic;
    }
    public int getLayoutSeccao() {
        return layoutseccao;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setSeccao(String pos) {
        this.seccao = seccao;
    }
    public void setImagePic(int imagePic) { this.imagePic = imagePic; }
    public void setLayoutSeccao(int layoutPic) {
        this.layoutseccao = layoutseccao;
    }
}
