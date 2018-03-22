/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Christos
 */
@ManagedBean
@SessionScoped
public class About {

    /**
     * Creates a new instance of About
     */
    public About() {
    }
private MapModel simpleModel;

 @PostConstruct
 public void init()
 {
   
     simpleModel = new DefaultMapModel();
  //Shared coordinates 
 LatLng coord1 = new LatLng(37.949888, 23.750301);
 LatLng coord2 = new LatLng(37.960912,23.731806);
 LatLng coord3 = new LatLng(40.652261,22.949289);
 LatLng coord4 = new LatLng(36.420554,25.431446);
  LatLng coord5 = new LatLng(31.834401,-98.736510);
 LatLng coord6 = new LatLng(27.735809,-81.641784);
 LatLng coord7 = new LatLng(23.735334,-110.282902);
 LatLng coord8 = new LatLng(34.023644,-118.782016);
  LatLng coord9 = new LatLng(16.879466, 20.667648);
 LatLng coord10 = new LatLng(16.883707, 20.689216);
 LatLng coord11 = new LatLng(16.879703, 20.706707);
 LatLng coord12 = new LatLng(16.885233, 20.702323);
  LatLng coord13 = new LatLng(25.879466, 10.667649);
 LatLng coord14 = new LatLng(25.883707, 10.689219);
 LatLng coord15 = new LatLng(25.879703, 20.706709);
 LatLng coord16 = new LatLng(25.885233, 20.702329);
 //Basic marker
 simpleModel.addOverlay(new Marker(coord1));
 simpleModel.addOverlay(new Marker(coord2));
 simpleModel.addOverlay(new Marker(coord3));
 simpleModel.addOverlay(new Marker(coord4));
  simpleModel.addOverlay(new Marker(coord5));
 simpleModel.addOverlay(new Marker(coord6));
 simpleModel.addOverlay(new Marker(coord7));
 simpleModel.addOverlay(new Marker(coord8));
  simpleModel.addOverlay(new Marker(coord9));
 simpleModel.addOverlay(new Marker(coord10));
 simpleModel.addOverlay(new Marker(coord11));
 simpleModel.addOverlay(new Marker(coord12));
  simpleModel.addOverlay(new Marker(coord13));
 simpleModel.addOverlay(new Marker(coord14));
 simpleModel.addOverlay(new Marker(coord15));
 simpleModel.addOverlay(new Marker(coord16));
 
 }
 public MapModel getSimpleModel()
 {
     return simpleModel;
 }


}
