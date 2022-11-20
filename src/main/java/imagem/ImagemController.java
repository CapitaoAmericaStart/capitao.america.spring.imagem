package imagem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("imagem")
public class ImagemController {
	
	@GetMapping(produces=MediaType.IMAGE_PNG_VALUE)
	public byte[] get() throws FileNotFoundException, IOException {
		try (InputStream baos = new FileInputStream("imagens/mario.png")){
			byte [] bytes = new byte [baos.available()];
			baos.read(bytes);
			
			return bytes;
		}
	}
}
