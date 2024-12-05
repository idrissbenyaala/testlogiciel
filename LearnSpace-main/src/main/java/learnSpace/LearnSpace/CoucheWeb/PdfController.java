package learnSpace.LearnSpace.CoucheWeb;

import learnSpace.LearnSpace.CoucheService.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "PDF")
@RestController
@CrossOrigin("*")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/generate-certificate")
    public ResponseEntity<byte[]> generateCertificate(
            @RequestParam String name,
            @RequestParam String course,
            @RequestParam String date
    ) {
        byte[] pdf = pdfService.generateCertificate(name, course, date);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "certificat.pdf");
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdf);
    }
}

