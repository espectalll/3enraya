/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.azarquiel.pkg3enraya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diurno
 */
public class TTTConnection implements Runnable
{

    private AppUIController aui;
    private Thread thread;
    public boolean isThreadActive = false;
    private PrintWriter fsalida;
    private BufferedReader fentrada;

    public TTTConnection(AppUIController aui)
    {
	this.aui = aui;
	this.thread = new Thread(this);
    }

    public boolean connectMe(String host, int puerto)
    {
	Socket cliente;
	try
	{
	    cliente = new Socket(host, puerto);
	    // CREO FLUJO DE SALIDA AL SERVIDOR
	    fsalida = new PrintWriter(cliente.getOutputStream(), true);
	    // CREO FLUJO DE ENTRADA AL SERVIDOR
	    fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
	    // INICIO EL HILO
	    thread.start();
	}
	catch (IOException ex)
	{
	    Logger.getLogger(TTTConnection.class.getName()).log(Level.SEVERE, null, ex);
	    return false;
	}

	return true;
    }

    @Override
    public void run()
    {
	isThreadActive = true;
	String recibido;
	while (true)
	{
	    try
	    {
		recibido = fentrada.readLine();
		if (recibido != null)
		{
		    // Aqui hago las comprobaciones de lo que recibo y envio al UI datos
		    // aui.ponXaquijajaxDsaludos;ç
		    if (false)
		    {
			break;
		    }
		}
	    }
	    catch (IOException ex)
	    {
		Logger.getLogger(TTTConnection.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	try
	{
	    fentrada.close();
	    fsalida.close();
	}
	catch (IOException ex)
	{
	    Logger.getLogger(TTTConnection.class.getName()).log(Level.SEVERE, null, ex);
	}
	isThreadActive = false;
    }
}
