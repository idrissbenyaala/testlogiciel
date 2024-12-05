package learnSpace.LearnSpace.CoucheService;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import learnSpace.LearnSpace.CoucheDAO.CourDao;
import learnSpace.LearnSpace.CoucheDAO.ImageCourDao;
import learnSpace.LearnSpace.CoucheDAO.UserDAO;
import learnSpace.LearnSpace.CoucheDTO.CourDto;
import learnSpace.LearnSpace.Entity.Cour;
import learnSpace.LearnSpace.Entity.ImageCour;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@AllArgsConstructor
@Transactional
@Service
public class CourService implements CourInterface{
    @Autowired
    private CourDao courDao;
    @Autowired
    private ImageCourDao imageCourDao;

    @Override
    public List<Cour> GetAllCour() {
        List<Cour> cours=courDao.findAll();
        return cours;
    }
    @Override
    public void AddCour(String courRequestDto, MultipartFile file) throws IOException {
        // Convertir le JSON en objet Cour
        ObjectMapper objectMapper = new ObjectMapper();
        Cour courDto = objectMapper.readValue(courRequestDto, Cour.class);

        // Créer une nouvelle entité Cour
        Cour cour = new Cour();
        cour.setContenu(courDto.getContenu());
        cour.setTitle(courDto.getTitle());

        // Sauvegarder l'objet Cour dans la base de données
        Cour savedCour = courDao.save(cour);

        // Créer une entité ImageCour associée
        if (file != null && !file.isEmpty()) {
            ImageCour imageCour = new ImageCour(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    compressBytes(file.getBytes()), // Assurez-vous que compressBytes est correcte
                    savedCour // Associez l'image à l'objet Cour sauvegardé
            );
            imageCourDao.save(imageCour);
        }
    }

    @Override
    public void DeleteCour(Long id)
    {
        ImageCour imageCour = imageCourDao.findByCour_Id(id);
        imageCourDao.deleteById(imageCour.getId());
        courDao.deleteById(id);
    }
    @Override
    public void UpdateCour(Long id,Cour UpdatedCour)
    {
        Cour cour = courDao.findById(id).get();
        cour.setContenu(UpdatedCour.getContenu());
        cour.setTitle(UpdatedCour.getTitle());
        courDao.save(cour);
    }
    @Override
    public ImageCour getImagesByCourId(Long courId) {
        ImageCour imageCour1 = imageCourDao.findByCour_Id(courId);
        ImageCour imageCour2 =new ImageCour(imageCour1.getName(),imageCour1.getType(),decompressBytes(imageCour1.getPicbyte()),imageCour1.getCour());
        return imageCour2;

    }

    @Override
    public List<ImageCour> ListeImages(){
        List<ImageCour> image1= imageCourDao.findAll();
        List<ImageCour> image2=new ArrayList<>();
        for(int i=0;i<image1.size();i++)
        {
            image2.add(new ImageCour(image1.get(i).getName(),image1.get(i).getType(),decompressBytes(image1.get(i).getPicbyte()),image1.get(i).getCour()));
        }
        return image2;
    }
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }
}
