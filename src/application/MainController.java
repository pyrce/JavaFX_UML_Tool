package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;

import com.yworks.yfiles.algorithms.Rectangle;
import com.yworks.yfiles.geometry.InsetsD;
import com.yworks.yfiles.geometry.RectD;
import com.yworks.yfiles.graph.EdgeDefaults;
import com.yworks.yfiles.graph.GraphDecorator;
import com.yworks.yfiles.graph.IEdge;
import com.yworks.yfiles.graph.IGraph;
import com.yworks.yfiles.graph.INode;
import com.yworks.yfiles.graph.SimpleEdge;
import com.yworks.yfiles.graph.styles.Arrow;
import com.yworks.yfiles.graph.styles.ArrowType;
import com.yworks.yfiles.graph.styles.IArrow;
import com.yworks.yfiles.graph.styles.IEdgeStyle;
import com.yworks.yfiles.graph.styles.IEdgeStyleRenderer;
import com.yworks.yfiles.graph.styles.PolylineEdgeStyle;
import com.yworks.yfiles.graph.styles.ShapeNodeShape;
import com.yworks.yfiles.graph.styles.ShapeNodeStyle;
import com.yworks.yfiles.graphml.GraphMLIOHandler;
import com.yworks.yfiles.layout.hierarchic.HierarchicLayout;
import com.yworks.yfiles.layout.tree.TreeLayout;
import com.yworks.yfiles.view.ContextConfigurator;
import com.yworks.yfiles.view.EdgeStyleDecorationInstaller;
import com.yworks.yfiles.view.GraphControl;
import com.yworks.yfiles.view.NodeStyleDecorationInstaller;
import com.yworks.yfiles.view.Pen;
import com.yworks.yfiles.view.PixelImageExporter;
import com.yworks.yfiles.view.StyleDecorationZoomPolicy;
import com.yworks.yfiles.view.input.GraphEditorInputMode;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.FileChooser;
import application.FileActions;

public class MainController {

	@FXML Button mybutton;
	@FXML Pane header;
	@FXML Pane side;
	@FXML Button layoutButton;
	@FXML GraphControl graphControl;
	
	private static GraphEditorInputMode graphEditorInputMode = new GraphEditorInputMode();
	

	    
	  public void initialize() {
		    // Called by the JavaFX framework on loading.
		 System.out.println("init");
		    graphControl.setInputMode(graphEditorInputMode);
	
		    
			    
		  }

		  public void onLoaded() {
		    // Called by our application right after stage is loaded.
			  System.out.println("loaded");
			   graphControl.fitGraphBounds();
		  }
		  @FXML
		  public void handleButtonAction() {
		
			
			  graphControl.morphLayout(new HierarchicLayout(), Duration.ofMillis(1000));
			  
		  }


		  
		  public void saveFile() {
				
			  saveFile();
			  
		  }
		  public void openFile() {
				
			  openFile();
			  
		  }
		  public void saveAsImage() {
				
			  saveAsImage();
			  
		  }
		  public void set1to1() {
			   IGraph graph = graphControl.getGraph();
			    PolylineEdgeStyle edgeStyle = new PolylineEdgeStyle();
			    edgeStyle.setSourceArrow(new Arrow(ArrowType.NONE));
			    edgeStyle.setTargetArrow(new Arrow(ArrowType.NONE));
			    Pen pen = new Pen(Color.AQUA, 3);
			    pen.setLineCap(StrokeLineCap.ROUND);
			    edgeStyle.setPen(pen);
			    graph.getEdgeDefaults().setStyle(edgeStyle);
		  }
		  
		  public void set1toN() {
			   IGraph graph = graphControl.getGraph();
			    PolylineEdgeStyle edgeStyle = new PolylineEdgeStyle();
			    edgeStyle.setSourceArrow(new Arrow(ArrowType.NONE));
			    edgeStyle.setTargetArrow(new Arrow(ArrowType.DIAMOND));
			    Pen pen = new Pen(Color.AQUA, 3);
			    pen.setLineCap(StrokeLineCap.ROUND);
			    edgeStyle.setPen(pen);
			    graph.getEdgeDefaults().setStyle(edgeStyle);
	
		  }
		  public void createTable() {
			   IGraph graph = graphControl.getGraph();
			   //graph.createNode(graphControl);
			  graph.createNode();
		  }
		  
}
