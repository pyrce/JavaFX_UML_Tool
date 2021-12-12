package application;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.yworks.yfiles.view.ContextConfigurator;
import com.yworks.yfiles.view.GraphControl;
import com.yworks.yfiles.view.PixelImageExporter;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class FileActions {
	@FXML GraphControl graphControl;
	  public void saveFile() {
			
		  FileChooser fc= new FileChooser();
		File file=  fc.showSaveDialog(null);
		System.out.println(file);
		 try {
			graphControl.exportToGraphML(new FileOutputStream(file+".graphml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  public void openFile() {
	
		  FileChooser fc= new FileChooser();
		File file=  fc.showOpenDialog(null);
		System.out.println(file);
		 try {
			graphControl.importFromGraphML(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  public void saveAsImage() throws IOException {

		  
		// create and configure a PixelImageExporter
		  FileChooser fc= new FileChooser();
		  File file=  fc.showSaveDialog(null);
	        ContextConfigurator configuration = new ContextConfigurator(graphControl.getContentRect());

	        // create and configure a PixelImageExporter
	        PixelImageExporter exporter = new PixelImageExporter(configuration);

	        try {
	            // export the region to a javafx.scene.image.Image
	            Image image = exporter.exportToBitmap(graphControl);

	            // convert it to a AWT image to use ImageIO
	            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
	            BufferedImage bufferedImageRGB = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.OPAQUE);
	            Graphics2D graphics = bufferedImageRGB.createGraphics();
	            graphics.drawImage(bufferedImage, 0, 0, null);
	            bufferedImage = bufferedImageRGB;
	            
	            // write it to a JPG file
	     
	            FileOutputStream stream = new FileOutputStream(file+".jpg");
	            ImageIO.write(bufferedImage, "jpg", stream);
	            stream.close();
	        } catch (IOException e) {
	            // handle exception
	            System.out.println(e);
	        }  
	  }
	  
}
