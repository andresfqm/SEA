/*
 * The MIT License
 *
 * Copyright 2017 Depurador.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sea.backend.model;

import com.sea.backend.entities.Cotizacion;
import com.sea.backend.entities.Email;
import com.sun.org.apache.bcel.internal.generic.RET;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Depurador
 */
@Stateless
public class CotizacionFacade extends AbstractFacade<Cotizacion> implements CotizacionFacadeLocal {

	@PersistenceContext(unitName = "SEAPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CotizacionFacade() {
		super(Cotizacion.class);
	}

	@Override
	public List<Cotizacion> listaSeguimiento(int usuario) {
		List<Cotizacion> listaSeguimientoCotizacions;

		String consulta = "SELECT c.numero_cotizacion, cl.nombre_o_razon_social, cl.nombre_contacto, t.numero_telefono\n"
				+ "FROM tbl_cotizacion AS c\n"
				+ "INNER JOIN tbl_cliente as cl \n"
				+ "ON c.TBL_CLIENTE_ID_CLIENTE = cl.ID_CLIENTE \n"
				+ "INNER JOIN tbl_telefono AS t \n"
				+ "ON cl.ID_CLIENTE = t.TBL_CLIENTE_ID_CLIENTE\n"
				+ "INNER JOIN tbl_usuario AS u \n"
				+ "ON cl.TBL_USUARIO_ID_USUARIO = u.ID_USUARIO\n"
				+ "WHERE id_usuario = ?1";
		Query query = em.createNativeQuery(consulta);
		query.setParameter(1, usuario);

		listaSeguimientoCotizacions = query.getResultList();
		return listaSeguimientoCotizacions;
	}

	@Override
	public String correoCliente(int cliente) {
		Object email = null;
		String correo;
		String consulta = "SELECT e.email\n"
				+ "FROM tbl_email AS e\n"
				+ "INNER JOIN tbl_cliente as c \n"
				+ "ON e.TBL_CLIENTE_ID_CLIENTE = c.ID_CLIENTE \n"
				+ "WHERE id_usuario = ?1";
		Query query = em.createNativeQuery(consulta);
		query.setParameter(1, cliente);
		email = query.getSingleResult();
		correo = email.toString();
		return correo;
	}

	@Override
	public String correoUsuario(int usuario) {
		Object email = null;
		String correo;
		String consulta = "SELECT e.email\n"
				+ "FROM tbl_email AS e\n"
				+ "INNER JOIN tbl_usuario as u \n"
				+ "ON e.TBL_USUARIO_ID_USUARIO = u.ID_USUARIO \n"
				+ "WHERE id_usuario = ?1";
		Query query = em.createNativeQuery(consulta);
		query.setParameter(1, usuario);
		email = query.getSingleResult();
		correo = email.toString();
		return correo;
	}

	@Override
	public void getReportePDF(String ruta, String numero_cotizacion) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Connection conexion;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/fulldotaciones", "root", "5050");

		//Se definen los parametros si es que el reporte necesita
		Map parameter = new HashMap();
		parameter.put("numero_cotizacion", numero_cotizacion);

		try {
			File file = new File(ruta);
			String destino = "C:\\Users\\homero\\Documents\\NetBeansProjects\\SEA\\web\\PDF/cotizacion_N_" + numero_cotizacion + ".pdf";

			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

			JasperExportManager.exportReportToPdfFile(jasperPrint, destino);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void getReporteXLSX(String ruta, String numero_cotizacion) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		Connection conexion;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/fulldotaciones", "root", "5050");

		//Se definen los parametros si es que el reporte necesita
		Map parameter = new HashMap();
		parameter.put("numero_cotizacion", numero_cotizacion);
		String destino = "C:\\Users\\EdisonArturo\\Documents\\NetBeansProjects\\SEA\\web\\EXCEL/cotizacion_N_" + numero_cotizacion + ".xlsx";

		try {
			File file = new File(ruta);

			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);

			JRExporter jrExporter = null;
			jrExporter = new JRXlsxExporter();
			jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			jrExporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(destino));

			if (jrExporter != null) {
				try {
					jrExporter.exportReport();
				} catch (JRException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Object datosCotizacion(String numeroCotizacion) throws Exception {

		String consulta2 = "SELECT co.numero_cotizacion, c.nombre_o_razon_social, ci.nombre, e.email, d.direccion, co.lugar_emision\n"
				+ "FROM tbl_cotizacion AS co\n"
				+ "INNER JOIN tbl_cliente as c \n"
				+ "ON co.TBL_CLIENTE_ID_CLIENTE = c.ID_CLIENTE \n"
				+ "INNER JOIN tbl_usuario AS u \n"
				+ "ON c.TBL_USUARIO_ID_USUARIO = u.ID_USUARIO\n"
				+ "INNER JOIN\n"
				+ "TBL_EMAIL e ON c.ID_CLIENTE = e.TBL_CLIENTE_ID_CLIENTE\n"
				+ "INNER JOIN\n"
				+ "TBL_TIPO_EMAIL te ON e.TBL_TIPO_EMAIL_ID_TIPO_EMAIL = te.ID_TIPO_EMAIL\n"
				+ "INNER JOIN\n"
				+ "TBL_DIRECCION d ON d.TBL_CLIENTE_ID_CLIENTE = c.ID_CLIENTE\n"
				+ "INNER JOIN\n"
				+ "TBL_TIPO_DIRECCION tdi ON d.TBL_TIPO_DIRECCION_ID_TIPO_DIRECCION = tdi.ID_TIPO_DIRECCION\n"
				+ "INNER JOIN\n"
				+ "TBL_CIUDAD ci ON d.TBL_CIUDAD_ID_CIUDAD = ci.ID_CIUDAD\n"
				+ "WHERE numero_cotizacion = ?1";

		Query query = em.createNativeQuery(consulta2);
		query.setParameter(1, numeroCotizacion);

		//datosCliente = query.getResultList();
		Object datosCotizacion = query.getSingleResult();

		return datosCotizacion;
	}

	// Metodo para traer los datos de la cotización realizada
	@Override
	public Object ModificacionCotizacion(String numeroCotizacion) throws Exception {
		String consulta5 = "SELECT co.numero_cotizacion, co.lugar_emision, co.fecha_emision, co.numero_remision, c.nombre_o_razon_social, e.email, t.numero_telefono\n"
				+ "FROM tbl_cotizacion AS co\n"
				+ "INNER JOIN tbl_cliente AS c\n"
				+ "ON co.TBL_CLIENTE_ID_CLIENTE = c.ID_CLIENTE \n"
				+ "INNER JOIN\n"
				+ "TBL_EMAIL e ON c.ID_CLIENTE = e.TBL_CLIENTE_ID_CLIENTE\n"
				+ "INNER JOIN\n"
				+ "TBL_TIPO_EMAIL te ON e.TBL_TIPO_EMAIL_ID_TIPO_EMAIL = te.ID_TIPO_EMAIL\n"
				+ "INNER JOIN\n"
				+ "TBL_TELEFONO t ON c.ID_CLIENTE = t.TBL_CLIENTE_ID_CLIENTE\n"
				+ "INNER JOIN\n"
				+ "TBL_TIPO_TELEFONO tt ON t.TBL_TIPO_TELEFONO_ID_TIPO_TELEFONO = tt.ID_TIPO_TELEFONO\n"
				+ "WHERE numero_cotizacion = ?1";
		Query query = em.createNativeQuery(consulta5);
		query.setParameter(1, numeroCotizacion);

		//datosCliente = query.getResultList();
		Object ModificacionCotizacion = query.getSingleResult();

		return ModificacionCotizacion;
	}

}
