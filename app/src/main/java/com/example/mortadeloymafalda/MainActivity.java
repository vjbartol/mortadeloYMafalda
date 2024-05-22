package com.example.mortadeloymafalda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    ImageView ivCentral;
    ImageButton ibMortadelo, ibMafalda;

    CheckBox cbFondoRojo, cbTransparente, cbActivityVerde;
    View layoutActivity;
    /**
     * para guardar los fondos.
     */
    private Drawable colorImagenCentral, fondoActivity;

    RadioButton rbCentradoSinEstirar, rbEstirado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * inicializamos las referencias
         */
        initReferences();
        /**
         * recogemos en los atributos los colores de fondo
         */
        colorImagenCentral = ivCentral.getBackground();
        fondoActivity = layoutActivity.getBackground();
        /**
         * metodo para asignar escuchadores
         */
        setListener();



    }




    private void initReferences() {
        ivCentral = findViewById(R.id.ivCentral);
        ibMortadelo = findViewById(R.id.ibMortadelo);
        ibMafalda = findViewById(R.id.ibMafalda);
        cbFondoRojo = findViewById(R.id.cbFondoRojo);
        cbTransparente = findViewById(R.id.cbTransparente);
        cbActivityVerde = findViewById(R.id.cbActivityVerde);
        layoutActivity = findViewById(R.id.Layout);
        rbCentradoSinEstirar = findViewById(R.id.rbCentradoSinEstirar);
        rbEstirado = findViewById(R.id.rbEstirado);
    }

    private void setListener() {
        /**
         * poner fondo mortadelo
         */
        ibMortadelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ivCentral.setImageResource(R.drawable.mortadelo);
                ivCentral.setImageDrawable(ibMortadelo.getDrawable());
            }
        });

        /**
         * poner imagen mafalda
         */
        ibMafalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ivCentral.setImageResource(R.drawable.mafalda);
                ivCentral.setImageDrawable(ibMafalda.getDrawable());
            }
        });

        /**
         * poner fondo color mafalda
         */
        cbFondoRojo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    ivCentral.setBackgroundColor(Color.RED);
                }else{
                    ivCentral.setBackground(colorImagenCentral);
                }

            }
        });

        /**
         * poner fondo medio transparente
         */
        cbTransparente.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ivCentral.setAlpha(0.5f);
                }else{
                    ivCentral.setAlpha(1f);
                }
            }
        });

        /**
         * poner fondo activity color verde
         */
        cbActivityVerde.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    layoutActivity.setBackgroundColor(Color.GREEN);
                }else {
                    layoutActivity.setBackground(fondoActivity);
                }
            }
        });


        /**
         * imagenen centrada sin expandir
         */
        rbCentradoSinEstirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivCentral.setScaleType(ImageView.ScaleType.CENTER);
            }
        });

        /**
         * imagen centrada y expandida
         */
        rbEstirado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivCentral.setScaleType(ImageView.ScaleType.FIT_CENTER);

            }
        });
    }


    //SALVAR Y RESTAURAR IMAGEN
    private Bitmap convertirDrawableToBitmap(Drawable drawable) {
        return ((BitmapDrawable) drawable).getBitmap();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Bitmap imagenCentralBitmap=convertirDrawableToBitmap(ivCentral.getDrawable());
        outState.putParcelable("imagen_central",imagenCentralBitmap);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ivCentral.setImageBitmap(savedInstanceState.getParcelable("imagen_central"));
    }



}