package com.geroncio.labem.Others;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.geroncio.labem.R;

import java.util.ArrayList;

public class AdapterList extends ArrayAdapter<Atributos> implements Filterable {

    public static ArrayList<Atributos> dados;

    Context context;
    ArrayList<Atributos> elementos;

    CustomFilter filter;
    ArrayList<Atributos> filterList;


    public AdapterList(Context context, ArrayList<Atributos> elementos){
        super(context, R.layout.search_list, elementos);
        this.context = context;
        this.elementos =elementos;
        this.filterList =elementos;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Atributos getItem(int pos) {
        return super.getItem(pos);
    }

    @Override
    public long getItemId(int pos) {
        return elementos.indexOf(getItem(pos));
    }

    /**Inicializando as variaveis da lista e linkando os objetos aos valores da lista*/
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        if (convertView == null){

            convertView = inflater.inflate(R.layout.search_list,null);

        }



        TextView titleTxt = convertView.findViewById(R.id.idName);
        TextView titleSeccao = convertView.findViewById(R.id.idSeccao);
        ImageView img = convertView.findViewById(R.id.idPic);
        LinearLayout layoutSeccao = convertView.findViewById(R.id.layoutseccao);

        // SET DATA

        titleTxt.setText(elementos.get(pos).getName());
        titleSeccao.setText(elementos.get(pos).getSeccao());
        img.setImageResource(elementos.get(pos).getImagePic());
        layoutSeccao.setBackgroundResource(elementos.get(pos).getLayoutSeccao());

        return convertView;
    }

    @Override
    public Filter getFilter() {

        if (filter == null){
            filter = new CustomFilter();

        }

        return filter;
    }



    class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length()>0){

                constraint = constraint.toString().toUpperCase();

                ArrayList<Atributos> filter = new ArrayList<Atributos>();

                for (int i=0; i<filterList.size(); i++){

                    if (filterList.get(i).getName().toUpperCase().contains(constraint)){

                        Atributos p = new Atributos(filterList.get(i).getName(), filterList.get(i).getSeccao(),
                                filterList.get(i).getImagePic(), filterList.get(i).getLayoutSeccao());

                        filter.add(p);

                    }

                }

                results.count = filter.size();
                results.values = filter;



                /* Passar itens da lista de busca para activity principal */

                ArrayList<Atributos> dados = filter;
                Newseacrchlayout.dados = dados;

                /* Passar itens da lista de busca para activity principal */



            }else {
                results.count = filterList.size();
                results.values = filterList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            elementos = (ArrayList<Atributos>) results.values;
            notifyDataSetChanged();

        }
    }

}

