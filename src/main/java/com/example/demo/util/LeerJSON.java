package com.example.demo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class LeerJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("introduzca Url para leer json");
		String urljson = sc.nextLine();
		String cadenaJson="";
		try {
			URL url = new URL(urljson);
			URLConnection conexion = url.openConnection();
			String s;
			InputStream is = conexion.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			while ((s = bf.readLine()) != null) {

				cadenaJson += s;
			}
			
		} catch (Exception e) {

		}
		String[] datos = null;
		try {

			JSONArray jsonarray = new JSONArray(cadenaJson);
			datos = new String[jsonarray.length()];
			for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject anuncio = jsonarray.getJSONObject(i);
				datos[i] = " " + anuncio.getInt("id_anuncio") + " " + anuncio.getString("user") + " "
						+ anuncio.getInt("id_categoria") + " " + anuncio.getString("titulo")+" "+anuncio.getString("descripcion")
						+" " + anuncio.getDouble("precio") + " "+anuncio.getInt("prioridad") + " "+anuncio.getString("fecha");
			
				System.out.println(datos[i]);
			}
		} catch (Exception e) {
			
		}
	}

}
