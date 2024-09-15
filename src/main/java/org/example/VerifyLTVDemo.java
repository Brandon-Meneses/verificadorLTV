package org.example;



import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.signatures.LtvVerifier;
import com.itextpdf.signatures.VerificationException;
import com.itextpdf.signatures.VerificationOK;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
public class VerifyLTVDemo {

    public static void main(String[] args) {
        String filePath = "/Users/brandonluismenesessolorzano/Downloads/F_INVESTIGACIONOPERATIVA_undefined(5).pdf";
        try {
            PdfReader reader = new PdfReader(new FileInputStream(filePath));
            PdfDocument document = new PdfDocument(reader);
            LtvVerifier verifier = new LtvVerifier(document);

            List<VerificationOK> result = verifier.verify(null);
            if (result.isEmpty()) {
                System.out.println("No se encontraron firmas LTV válidas.");
            } else {
                System.out.println("El documento tiene firmas LTV válidas.");
                for (VerificationOK verificationOK : result) {
                    System.out.println(verificationOK.toString());
                }
            }
        } catch (GeneralSecurityException | IOException e) {
            System.err.println("Error verificando el documento: " + e.getMessage());
            e.printStackTrace();
        }
    }
}