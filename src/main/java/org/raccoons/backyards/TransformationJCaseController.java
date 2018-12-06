package org.raccoons.backyards;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransformationJCaseController {

  @RequestMapping("/point")
  public String getPoint2D() {
    Point2D myPoint2D = new Point2D(9, 23);
    return myPoint2D.toString();
  }

  @RequestMapping("/circle")
  public String getCircle() {
    Circle myCircle = new Circle();
    return myCircle.toString();
  }

  @RequestMapping("/triangle")
  public String getTriangle() {
    Triangle myTriangle = new Triangle();
    return myTriangle.toString();
  }

}
