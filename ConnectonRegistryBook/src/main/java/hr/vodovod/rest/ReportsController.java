package hr.vodovod.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.vodovod.services.ConnectionService;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("report")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportsController {

	@Autowired
	private ConnectionService connectionService;
	
	@GetMapping("new/connection/{id}")
	public ResponseEntity<byte[]> getNewConnectionReport(@PathVariable Integer id) {
		
		JasperReport jasperReport = null;
		byte[] bytes = null;
		Map<String, Object> datasourceParams = connectionService.newConectionRequestReportData(id);
	    List<Map<String, Object>> list= new ArrayList<>();
	    list.add(datasourceParams);
	    JRDataSource datasource = new JRBeanCollectionDataSource(list);
	    Map<String, Object> reportParams = new HashMap<>();
	    reportParams.put("requestPurpose", datasourceParams.get("requestPurpose"));
	    reportParams.put("connectionPurpose", datasourceParams.get("connectionPurpose"));
	    reportParams.put("connectionCategory", datasourceParams.get("connectionCategory"));
		try {
			jasperReport = JasperCompileManager.compileReport("C:\\Users\\Ante\\git\\ConnectionRegistryBook\\ConnectonRegistryBook\\src\\main\\resources\\reports\\Blank_A4.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParams, datasource);
			bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return ResponseEntity
					.ok()
					.header("Content-Type", "application/pdf; charset=UTF-8")
					.header("Content-Disposition", "inline; filename=Blank_A4.pdf")
                    .body(bytes);	
	}
}
