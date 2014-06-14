package com.cbedoy.apprende.services;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;

import com.cbedoy.apprende.models.Estadistica;
import com.cbedoy.apprende.utils.RESTClient;
import com.cbedoy.apprende.utils.RESTClient.RequestMethod;
import com.cbedoy.apprende.viewcontrollers.MainActivity;

public class ServiceEstadistica extends AsyncTask<String, Integer, String> implements IServiceInteractor{
	private ProgressDialog pd;
	private Context contexto;
	private final String url="";
	
	
	public ServiceEstadistica(Context contexto){
		this.contexto = contexto;
	}
	
	
	@Override
	protected void onPreExecute(){
		pd = ProgressDialog.show(contexto, "", "Cargando...");
	}
	
	@Override
	protected String doInBackground(String... arg0) {
		
		return null;
	}
	
	@Override
	public String correrServicio(Object objeto) {
		Estadistica estadistica = (Estadistica) objeto;
		try{
			RESTClient request = new RESTClient(url);
			request .Execute(RequestMethod.GET);
			
			request.AddParam("nivel", estadistica.getNivel()+"");
			request.AddParam("aciertos", estadistica.getAciertos()+"");
			request.AddParam("idUsuario", estadistica.getIdUsuario()+"");
			request.AddParam("idTema", estadistica.getIdTema()+"");


			String respuesta = MainActivity.mthis.shared.getString("usuario", null);
			if(request.getResponse()!=null){
				Editor edit = MainActivity.mthis.shared.edit();
				edit.putString("usuario", request.getResponse());
				edit.commit();
				return request.getResponse();
				
			}
			return respuesta;
		}catch(Exception e){
			e.printStackTrace();
			String responsedsavedd = MainActivity.mthis.shared.getString("usuario", null);
			return responsedsavedd;
		
		}
	}
	
	
	
	@Override
	protected void onPostExecute(String respuesta){
		pd.dismiss();
		try {
			JSONObject json = new JSONObject(respuesta);
			
			
			
			
			
		} catch (JSONException e) {
			e.printStackTrace();
			
		}
	}
}
