package com.uandroides.aprende.fragments;

import java.util.ArrayList;

import android.app.Application;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.uandroides.aprende.R;
import com.uandroides.aprende.modelos.CuestionarioDemo;
import com.uandroides.aprende.modelos.Pregunta;
import com.uandroides.aprende.vistas.EstadisticasActivity;

public class PreguntaFragment extends Fragment {

	private RadioButton opcion1;
	private RadioButton opcion2;
	private RadioButton opcion3;
	private RadioButton opcion4;
	private TextView preg;
	
	private int posicion;
	public static final String ARG_SECTION_NUMBER = "section_number";

	public static ArrayList<Pregunta> preguntas;
	public static  Application context;
	private int cantidad;
	


	public PreguntaFragment() {
		// TODO Auto-generated constructor stub
		preguntas = new CuestionarioDemo().getCuestionario();
		posicion = 10;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.cuestionario, container,
				false);
		


		ImageView imagen = (ImageView) rootView
				.findViewById(R.id.imagen_cuestionario);

		preg = (TextView) rootView.findViewById(R.id.pregunta_cuestionario);
		opcion1 = (RadioButton) rootView.findViewById(R.id.opcion1_cuestionario);
		opcion2 = (RadioButton) rootView.findViewById(R.id.opcion2_cuestionario);
		opcion3 = (RadioButton) rootView.findViewById(R.id.opcion3_cuestionario);
		opcion4 = (RadioButton) rootView.findViewById(R.id.opcion4_cuestionario);
		Button botonFinalizar = (Button) rootView.findViewById(R.id.botonFinalizar);

		posicion = getArguments().getInt(ARG_SECTION_NUMBER);

		if (posicion % 2 == 0)
			imagen.setVisibility(View.GONE);

		imagen.setVisibility((preguntas.get(posicion).getLink() == null || preguntas.get(posicion).getLink().equals("null"))?View.GONE:View.INVISIBLE);
		

		if (posicion < cantidad-1) {
			botonFinalizar.setVisibility(View.INVISIBLE);

		} else {
			botonFinalizar.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					showNewActivity();
				}

				private void showNewActivity() {
					Intent i = new Intent(context,EstadisticasActivity.class);
					i.putExtra("cantidad", cantidad);
					i.putParcelableArrayListExtra("preguntas", preguntas);
					startActivity(i);
					
				}
			});
		}

		preg.setText(preguntas.get(posicion).getPregunta());
		opcion1.setText(preguntas.get(posicion).getRespuesta1());
		opcion2.setText(preguntas.get(posicion).getRespuesta2());
		opcion3.setText(preguntas.get(posicion).getRespuesta3());
		opcion4.setText(preguntas.get(posicion).getRespuesta4());

		// mthis.setColorSeleccion();

		Typeface tf = Typeface.createFromAsset(context.getAssets(),"font/dudu.ttf");
		opcion1.setTypeface(tf);
		opcion2.setTypeface(tf);
		opcion3.setTypeface(tf);
		opcion4.setTypeface(tf);
		preg.setTypeface(tf);

		opcion1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				preguntas.get(posicion).setRespuestaUsuario(1);
			}
		});

		opcion2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				preguntas.get(posicion).setRespuestaUsuario(2);
			}
		});

		opcion3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				preguntas.get(posicion).setRespuestaUsuario(3);
			}
		});

		opcion4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				preguntas.get(posicion).setRespuestaUsuario(4);
			}
		});

		return rootView;

	}
}