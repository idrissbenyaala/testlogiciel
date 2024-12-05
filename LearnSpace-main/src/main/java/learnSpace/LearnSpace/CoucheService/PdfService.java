package learnSpace.LearnSpace.CoucheService;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public byte[] generateCertificate(String name, String course, String date) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Titre du certificat
            Font titleFont = new Font(Font.HELVETICA, 24, Font.BOLD);
            Paragraph title = new Paragraph("Certificat de Réussite", titleFont);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("\n\n"));

            // Contenu du certificat
            Font contentFont = new Font(Font.HELVETICA, 14);
            String content = String.format(
                    "Nous certifions que %s a réussi le cours intitulé \"%s\" le %s.",
                    name, course, date
            );
            Paragraph contentParagraph = new Paragraph(content, contentFont);
            contentParagraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(contentParagraph);

            document.add(new Paragraph("\n\n"));

            // Signature fictive
            Font signatureFont = new Font(Font.HELVETICA, 12, Font.ITALIC);
            Paragraph signature = new Paragraph("Signé, \nDirecteur de l'Établissement", signatureFont);
            signature.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(signature);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }
}
