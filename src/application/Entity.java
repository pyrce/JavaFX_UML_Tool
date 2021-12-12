/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import static com.yworks.yfiles.algorithms.LoggingUtil.log;
import com.yworks.yfiles.geometry.IRectangle;
import com.yworks.yfiles.geometry.InsetsD;
import com.yworks.yfiles.geometry.PointD;
import com.yworks.yfiles.geometry.RectD;
import com.yworks.yfiles.graph.IColumn;
import com.yworks.yfiles.graph.IGraph;
import com.yworks.yfiles.graph.ILabel;
import com.yworks.yfiles.graph.IModelItem;
import com.yworks.yfiles.graph.INode;
import com.yworks.yfiles.graph.IRow;
import com.yworks.yfiles.graph.ITable;
import com.yworks.yfiles.graph.Table;
import com.yworks.yfiles.graph.labelmodels.InteriorLabelModel;
import com.yworks.yfiles.graph.styles.TableNodeStyle;
import com.yworks.yfiles.layout.BendConverter;
import com.yworks.yfiles.layout.CompositeLayoutStage;
import com.yworks.yfiles.layout.ILayoutStage;
import com.yworks.yfiles.layout.LayoutOrientation;
import com.yworks.yfiles.layout.hierarchic.HierarchicLayout;
import com.yworks.yfiles.layout.organic.RemoveOverlapsStage;
import com.yworks.yfiles.layout.router.OrganicEdgeRouter;
import com.yworks.yfiles.utils.IEventHandler;
import com.yworks.yfiles.view.GraphControl;
import com.yworks.yfiles.view.input.ItemClickedEventArgs;
import java.time.Duration;

/**
 *
 * @author charl
 */
public class Entity {  
    
    // Create a node in the center of the given cell.
    public static INode createNodeInCell(IGraph graph, INode parent, IRow row, IColumn column) {
      INode node = graph.createNode(parent);
      graph.setNodeCenter(node, new PointD(column.getLayout().getCenter().getX(), row.getLayout().getCenter().getY()));
      return node;
    }

    public static void createTable(GraphControl graphControl) {
        ITable table = new Table();
        IGraph graph = graphControl.getGraph();

        // create a top-level group node and bind the table to it
        INode parent = graph.createGroupNode(null, new RectD(0, 0, 100, 100), new TableNodeStyle(table));

        // create some rows and columns
        IColumn column1 = table.createColumn();
        IColumn column2 = table.createColumn();
        IColumn column3 = table.createColumn();      

        // populate some of the cells with nodes
        for (int i = 0; i < 3; i++) {
            IRow row = table.createRow();
            createNodeInCell(graph, parent, row, column1);    
            createNodeInCell(graph, parent, row, column2);
            createNodeInCell(graph, parent, row, column3);
        }

        graph.addLabel(parent, "NomTable", InteriorLabelModel.NORTH);

        // and perform a layout
        HierarchicLayout layout = new HierarchicLayout();
        layout.setLayoutOrientation(LayoutOrientation.BOTTOM_TO_TOP);
        layout.setOrthogonalRoutingEnabled(true);
        graphControl.morphLayout(layout, Duration.ofSeconds(1));
    }
}