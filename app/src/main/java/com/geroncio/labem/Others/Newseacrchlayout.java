package com.geroncio.labem.Others;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.geroncio.labem.Algebra_vetorial.AvAnguloentrevetores;
import com.geroncio.labem.Algebra_vetorial.AvCoplanaridadevetores;
import com.geroncio.labem.Algebra_vetorial.AvNormadovetor;
import com.geroncio.labem.Algebra_vetorial.AvProdutomisto;
import com.geroncio.labem.Algebra_vetorial.AvProdutovetorial;
import com.geroncio.labem.Algebra_vetorial.AvProjecaoortogonal;
import com.geroncio.labem.Algebra_vetorial.AvSomavetores;
import com.geroncio.labem.Algebra_vetorial.AvVetordoispontos;
import com.geroncio.labem.Algebra_vetorial.VersorVetor;
import com.geroncio.labem.Calculo_vetorial.CvDivergentecartesiano;
import com.geroncio.labem.Calculo_vetorial.CvDivergentecilindrico;
import com.geroncio.labem.Calculo_vetorial.CvDivergenteesferico;
import com.geroncio.labem.Calculo_vetorial.CvGradientecilindrico;
import com.geroncio.labem.Calculo_vetorial.CvGradienteesferico;
import com.geroncio.labem.Calculo_vetorial.CvRotacionalcartesiano;
import com.geroncio.labem.Calculo_vetorial.CvRotacionalcilindrico;
import com.geroncio.labem.Calculo_vetorial.CvRotacionalesferico;
import com.geroncio.labem.Calculo_vetorial.GradienteCartesiano;
import com.geroncio.labem.Campos_eletrostaticos.CeIntensidadecamposeletricos;
import com.geroncio.labem.Campos_eletrostaticos.CeLinadecargas;
import com.geroncio.labem.Campos_eletrostaticos.CePotencialeletricoSuperficie;
import com.geroncio.labem.Campos_eletrostaticos.CePotencialeletricoVolume;
import com.geroncio.labem.Campos_eletrostaticos.CePotencialeletricolinha;
import com.geroncio.labem.Campos_eletrostaticos.CeSuperficiedecargas;
import com.geroncio.labem.Campos_eletrostaticos.CeVolumedecargas;
import com.geroncio.labem.Campos_magneticos.CmDendidadecorrente;
import com.geroncio.labem.Campos_magneticos.CmDensidadecorrentecilindrico;
import com.geroncio.labem.Campos_magneticos.CmDensidadefluxomagneticocartesiano;
import com.geroncio.labem.Campos_magneticos.CmDensidadefluxomagneticocilindrico;
import com.geroncio.labem.Campos_magneticos.CmEspira;
import com.geroncio.labem.Campos_magneticos.CmLinhacoaxiallonga;
import com.geroncio.labem.Campos_magneticos.CmSolenoide;
import com.geroncio.labem.Campos_magneticos.CorrenteLamina;
import com.geroncio.labem.Campos_magneticos.Correnteemlinha;
import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.R;
import com.geroncio.labem.Transformada.StcCartesianocilindrico;
import com.geroncio.labem.Transformada.StcCartesianoesferico;
import com.geroncio.labem.Transformada.StcCilindricocartesiano;
import com.geroncio.labem.Transformada.StcCilindricoesferico;
import com.geroncio.labem.Transformada.StcEsfericocartesiano;
import com.geroncio.labem.Transformada.StcEsfericocilindrico;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Newseacrchlayout extends AppCompatActivity {

    public static ArrayList<Atributos> dados;
    ListView listView;
    SearchView searchView;
    ArrayAdapter adapter;
    String txtCod;
    BottomNavigationView bottomNavigationView;

    String[] title = new String[]{
            "??NGULO ENTRE VETORES",
            "CAMPO MAG. EM UM CABO COAXIAL",
            "CAMPO MAG. EM UMA ESPIRA",
            "CAMPO MAG. EM UMA LINHA",
            "CAMPO MAG. EM UM SOLEN??IDE",
            "CAMPO MAG. SUPERF??CIE",
            "CARTESIANO PARA CIL??NDRICO",
            "CARTESIANO PARA ESF??RICO",
            "CIL??NDRICO PARA CARTESIANO",
            "CIL??NDRICO PARA ESF??RICO",
            "COPLANARIDADE DE VETORES",
            "DENSIDADE DE CORRENTE DE UM POTENCIAL CARTESIANO",
            "DENSIDADE DE CORRENTE DE UM POTENCIAL CILINDRICO",
            "DENSIDADE DE FLUXO MAG. DE UM POTENCIAL CARTESIANO",
            "DENSIDADE DE FLUXO MAG. DE UM POTENCIAL CILINDRICO",
            "DIVERGENTE CARTESIANO",
            "DIVERGENTE CIL??NDRICO",
            "DIVERGENTE ESF??RICO",
            "ESF??RICO PARA CARTESIANO",
            "ESF??RICO PARA CIL??NDRICO",
            "FOR??A DE COULOMB",
            "GRADIENTE CARTESIANO",
            "GRADIENTE CIL??NDRTICO",
            "GRADIENTE ESF??RICO",
            "INTENSIDADE DE CAMPOS EL??TRICOS",
            "LINHA DE CARGA",
            "NORMA DO VETOR",
            "POTENCIAL EL??TRICO EM UMA LINHA",
            "POTENCIAL EL??TRICO EM UMA SUPERF??CIE",
            "POTENCIAL EL??TRICO EM UM VOLUME",
            "PRODUTO ESCALAR",
            "PRODUTO MISTO",
            "PRODUTO VETORIAL",
            "PROJE????O ORTOGONAL",
            "ROTACIONAL CARTESIANO",
            "ROTACIONAL CIL??NDRTICO",
            "ROTACIONAL ESF??RICO",
            "SOMA E SUBTRA????O DE VETORES",
            "SUPERF??CIE DE CARGA",
            "VERSOR DO VETOR",
            "VETOR A PARTIR DE DOIS PONTOS",
            "VOLUME DE CARGA"};

    String[] pos = new String[]{
            "Algebra Vetorial",
            "Campos magn??tost??ticos",
            "Campos magn??tost??ticos",
            "Campos magn??tost??ticos",
            "Campos magn??tost??ticos",
            "Campos magn??tost??ticos",
            "Sist. e Transformada de Coordenadas",
            "Sist. e Transformada de Coordenadas",
            "Sist. e Transformada de Coordenadas",
            "Sist. e Transformada de Coordenadas",
            "Algebra Vetorial",
            "Campos magn??tost??ticos",
            "Campos magn??tost??ticos",
            "Campos magn??tost??ticos",
            "Campos magn??tost??ticos",
            "C??lculo Vetorial",
            "C??lculo Vetorial",
            "C??lculo Vetorial",
            "Sist. e Transformada de Coordenadas",
            "Sist. e Transformada de Coordenadas",
            "Campos Eletrost??ticos",
            "C??lculo Vetorial",
            "C??lculo Vetorial",
            "C??lculo Vetorial",
            "Campos Eletrost??ticos",
            "Campos Eletrost??ticos",
            "Algebra Vetorial",
            "Campos Eletrost??ticos",
            "Campos Eletrost??ticos",
            "Campos Eletrost??ticos",
            "Algebra Vetorial",
            "Algebra Vetorial",
            "Algebra Vetorial",
            "Algebra Vetorial",
            "C??lculo Vetorial",
            "C??lculo Vetorial",
            "C??lculo Vetorial",
            "Algebra Vetorial",
            "Campos Eletrost??ticos",
            "Algebra Vetorial",
            "Algebra Vetorial",
            "Campos Eletrost??ticos"};

    int [] icon = new int[]{
            R.drawable.angulo_entre_vet,R.drawable.cmcabocoaxial,R.drawable.cmespira,R.drawable.coreentelinha,
            R.drawable.cmsolenoide,R.drawable.cmsuperficie,
            R.drawable.cartesiana_to_cilindrico,R.drawable.transcoord, R.drawable.cilindrico_to_cartesiano,
            R.drawable.cilindrico_to_esferico,R.drawable.coplanaridade,R.drawable.cmdensidadecorrentecart,R.drawable.cmdensidadecorrentecilindrico,
            R.drawable.cmdensidadefluxocartesiano,R.drawable.cmdensidadecilindrico,
            R.drawable.divergente_cartesiano,R.drawable.divergente_cilindro,
            R.drawable.divergente_esfera, R.drawable.esferico_to_cartesiano,R.drawable.esferico_to_cilindrico,R.drawable.imgcoulomb,
            R.drawable.gradient_cartesiano, R.drawable.gradient_cilindro,R.drawable.gradient_esferico,R.drawable.imgintensidacamposeletricos,
            R.drawable.imglinhadecargas, R.drawable.normavetor,R.drawable.potencialeletricolinhadecargas, R.drawable.potencialeletricosupeficiedecargas,
            R.drawable.potencialeletricovolumedecargas, R.drawable.produto_escalar, R.drawable.produto_misto,
            R.drawable.produto_vetorial, R.drawable.proje_ortog, R.drawable.rotacional_cartesiano, R.drawable.rotacional_cilindro,
            R.drawable.rotacional_esferico, R.drawable.somasubvetor, R.drawable.imgsuperficiedecargas,R.drawable.versorvetor,
            R.drawable.vetab, R.drawable.imgvolumedecargas};

    int [] layout = new int[]{R.drawable.circle,R.drawable.circle_purple,R.drawable.circle_purple,R.drawable.circle_purple,
            R.drawable.circle_purple,R.drawable.circle_purple,
            R.drawable.circle_orange,R.drawable.circle_orange,R.drawable.circle_orange,
            R.drawable.circle_orange,R.drawable.circle,R.drawable.circle_purple,R.drawable.circle_purple,
            R.drawable.circle_purple,R.drawable.circle_purple,R.drawable.circle_greem,R.drawable.circle_greem,
            R.drawable.circle_greem, R.drawable.circle_orange,R.drawable.circle_orange,R.drawable.circle_blue,
            R.drawable.circle_greem, R.drawable.circle_greem,R.drawable.circle_greem,R.drawable.circle_blue,
            R.drawable.circle_blue,R.drawable.circle,R.drawable.circle_blue,R.drawable.circle_blue,R.drawable.circle_blue,
            R.drawable.circle, R.drawable.circle, R.drawable.circle, R.drawable.circle, R.drawable.circle_greem,
            R.drawable.circle_greem, R.drawable.circle_greem, R.drawable.circle, R.drawable.circle_blue, R.drawable.circle,
            R.drawable.circle, R.drawable.circle_blue};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newseacrchlayout);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconTintList(ColorStateList.valueOf(Color.BLACK));
        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.home:
                    startActivity(new Intent(getApplicationContext()
                            , MainActivity2.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.calculator:
                    startActivity(new Intent(getApplicationContext()
                            , Calculator.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.settings:
                    startActivity(new Intent(getApplicationContext()
                            , Settings.class));
                    overridePendingTransition(0, 0);
                    return true;

            }
            return false;
        });

        listView = findViewById(R.id.listApps);
        searchView = findViewById(R.id.search);


        /* ListView que veio do searchViews */

        dados = AdapterList.dados;
        AdapterList.dados = null;



        final ArrayList<Atributos> getAtributos = getAtributos();

        adapter = new AdapterList(Newseacrchlayout.this, getAtributos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {

            try {
                if (dados == null){
                    txtCod = getAtributos.get(i).getName();
                }
                if (dados!=null){
                    txtCod = dados.get(i).getName();
                }



                ItemListClick();




                dados = null;

            }catch (Exception e){
                startActivity(new Intent(getApplicationContext(), Newseacrchlayout.class));
                overridePendingTransition(0, 0);
                finish();
            }

        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newquery) {

                Newseacrchlayout.this.adapter.getFilter().filter(newquery);

                return true;
            }
        });


    }


    private void ItemListClick() {

        if (txtCod.equals("??NGULO ENTRE VETORES")){
            startActivity(new Intent(getApplicationContext()
                    , AvAnguloentrevetores.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("CAMPO MAG. EM UMA ESPIRA")){
            startActivity(new Intent(getApplicationContext()
                    , CmEspira.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("CAMPO MAG. EM UM CABO COAXIAL")){
            startActivity(new Intent(getApplicationContext()
                    , CmLinhacoaxiallonga.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("CAMPO MAG. EM UMA LINHA")){
            startActivity(new Intent(getApplicationContext()
                    , Correnteemlinha.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("CAMPO MAG. EM UM SOLEN??IDE")){
            startActivity(new Intent(getApplicationContext()
                    , CmSolenoide.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("CAMPO MAG. SUPERF??CIE")){
            startActivity(new Intent(getApplicationContext()
                    , CorrenteLamina.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("CARTESIANO PARA CIL??NDRICO")){
            startActivity(new Intent(getApplicationContext()
                    , StcCartesianocilindrico.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("CARTESIANO PARA ESF??RICO")){
            startActivity(new Intent(getApplicationContext()
                    , StcCartesianoesferico.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("CIL??NDRICO PARA CARTESIANO")){
            startActivity(new Intent(getApplicationContext()
                    , StcCilindricocartesiano.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("CIL??NDRICO PARA ESF??RICO")){
            startActivity(new Intent(getApplicationContext()
                    , StcCilindricoesferico.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("COPLANARIDADE DE VETORES")){
            startActivity(new Intent(getApplicationContext()
                    , AvCoplanaridadevetores.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("DENSIDADE DE CORRENTE DE UM POTENCIAL CARTESIANO")){
            startActivity(new Intent(getApplicationContext()
                    , CmDendidadecorrente.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("DENSIDADE DE CORRENTE DE UM POTENCIAL CILINDRICO")){
            startActivity(new Intent(getApplicationContext()
                    , CmDensidadecorrentecilindrico.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("DENSIDADE DE FLUXO MAG. DE UM POTENCIAL CARTESIANO")){
            startActivity(new Intent(getApplicationContext()
                    , CmDensidadefluxomagneticocartesiano.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("DENSIDADE DE FLUXO MAG. DE UM POTENCIAL CILINDRICO")){
            startActivity(new Intent(getApplicationContext()
                    , CmDensidadefluxomagneticocilindrico.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("DIVERGENTE CARTESIANO")){
            startActivity(new Intent(getApplicationContext()
                    , CvDivergentecartesiano.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("DIVERGENTE CIL??NDRTICO")){
            startActivity(new Intent(getApplicationContext()
                    , CvDivergentecilindrico.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("DIVERGENTE ESF??RICO")){
            startActivity(new Intent(getApplicationContext()
                    , CvDivergenteesferico.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("ESF??RICO PARA CARTESIANO")){
            startActivity(new Intent(getApplicationContext()
                    , StcEsfericocartesiano.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("ESF??RICO PARA CIL??NDRICO")){
            startActivity(new Intent(getApplicationContext()
                    , StcEsfericocilindrico.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("GRADIENTE CARTESIANO")){
            startActivity(new Intent(getApplicationContext()
                    , GradienteCartesiano.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("GRADIENTE CIL??NDRTICO")){
            startActivity(new Intent(getApplicationContext()
                    , CvGradientecilindrico.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("GRADIENTE ESF??RICO")){
            startActivity(new Intent(getApplicationContext()
                    , CvGradienteesferico.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("INTENSIDADE DE CAMPOS EL??TRICOS")){
            startActivity(new Intent(getApplicationContext()
                    , CeIntensidadecamposeletricos.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("LINHA DE CARGA")){
            startActivity(new Intent(getApplicationContext()
                    , CeLinadecargas.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("NORMA DO VETOR")){
            startActivity(new Intent(getApplicationContext()
                    , AvNormadovetor.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("POTENCIAL EL??TRICO EM UMA LINHA")){
            startActivity(new Intent(getApplicationContext()
                    , CePotencialeletricolinha.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("POTENCIAL EL??TRICO EM UMA SUPERF??CIE")){
            startActivity(new Intent(getApplicationContext()
                    , CePotencialeletricoSuperficie.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("POTENCIAL EL??TRICO EM UM VOLUME")){
            startActivity(new Intent(getApplicationContext()
                    , AvNormadovetor.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("PRODUTO ESCALAR")){
            startActivity(new Intent(getApplicationContext()
                    , CePotencialeletricoVolume.class));
            overridePendingTransition(0, 0);

        }

        if (txtCod.equals("PRODUTO VETORIAL")){
            startActivity(new Intent(getApplicationContext()
                    , AvProdutovetorial.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("PRODUTO MISTO")){
            startActivity(new Intent(getApplicationContext()
                    , AvProdutomisto.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("PROJE????O ORTOGONAL")){
            startActivity(new Intent(getApplicationContext()
                    , AvProjecaoortogonal.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("ROTACIONAL CARTESIANO")){
            startActivity(new Intent(getApplicationContext()
                    , CvRotacionalcartesiano.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("ROTACIONAL CIL??NDRTICO")){
            startActivity(new Intent(getApplicationContext()
                    , CvRotacionalcilindrico.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("ROTACIONAL ESF??RICO")){
            startActivity(new Intent(getApplicationContext()
                    , CvRotacionalesferico.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("SOMA E SUBTRA????O DE VETORES")){
            startActivity(new Intent(getApplicationContext()
                    , AvSomavetores.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("SUPERF??CIE DE CARGA")){
            startActivity(new Intent(getApplicationContext()
                    , CeSuperficiedecargas.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("VERSOR DO VETOR")){
            startActivity(new Intent(getApplicationContext()
                    , VersorVetor.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("VETOR A PARTIR DE DOIS PONTOS")){
            startActivity(new Intent(getApplicationContext()
                    , AvVetordoispontos.class));
            overridePendingTransition(0, 0);
        }

        if (txtCod.equals("VOLUME DE CARGA")){
            startActivity(new Intent(getApplicationContext()
                    , CeVolumedecargas.class));
            overridePendingTransition(0, 0);
        }
    }

    private ArrayList<Atributos> getAtributos() {
        ArrayList<Atributos> atributos = new ArrayList<Atributos>();
        Atributos p;

        for (int i = 0; i<title.length; i++){

            p = new Atributos(title[i], pos[i], icon[i], layout[i]);
            atributos.add(p);
        }

        return atributos;
    }



}