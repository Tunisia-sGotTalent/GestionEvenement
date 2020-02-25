/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tgt.Entite.Evenement1;
/**
 *
 * @author 21695
 */
public class QRcode {
    public static void main() {
         Evenement1 E = new Evenement1();
    try {
	SQLDATA obj_DBConnection = new SQLDATA();
            Connection connection = obj_DBConnection.getConnection();
            String query = "select * from evenement";
            Statement stmt = null;
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	QRcode.generate_qr(rs.getInt("Id_Evenement"),rs.getString("Nom_Evenement"));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void generate_qr(int image_name,String qrCodeData) {
        try {
            String filePath = "C:\\Users\\21695\\Documents\\NetBeansProjects\\TestLogin\\src\\testlogin\\image\\"+image_name+".png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
