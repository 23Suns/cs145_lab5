package fractalgui.practice;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class KochFractal {

  private Point2D.Double start;
  private Point2D.Double end;
  private List<KochLine> lines;
  private int iterationLevel;

  public KochFractal(double startX, double startY, double endX, double endY) {
    this.start = new Point2D.Double(startX, startY);
    this.end = new Point2D.Double(endX, endY);
    this.lines = new ArrayList<>();
    restart();
  }

  public void nextLevel() {
    lines = iterate(lines);
    iterationLevel++;
  }

  public void restart() {
    iterationLevel = 0;
    lines.clear();
    lines.add(new KochLine(start, end)); // Add initial line segment
  }

  public int getIterationLevel() {
    return iterationLevel;
  }

  public void draw(Graphics g, int iterationLevel) {
    this.iterationLevel = iterationLevel;
    for (KochLine line : lines) {
      line.display(g);
    }
  }

  // Helper methods for calculating new points within KochLine class (not shown here)
  
  private List<KochLine> iterate(List<KochLine> currentLines) {
    List<KochLine> nextLines = new ArrayList<>();
    for (KochLine line : currentLines) {
      // Calculate new points using existing start and end points of the line segment
      Point2D.Double a = line.start();
      Point2D.Double b = line.kochLeft(a, b);  // Assuming kochLeft is in KochLine class
      Point2D.Double c = line.kochMiddle(a, b); // Assuming kochMiddle is in KochLine class
      Point2D.Double d = line.kochRight(a, b); // Assuming kochRight is in KochLine class
      Point2D.Double e = line.end();

      // Add four new lines for each original line segment
      nextLines.add(new KochLine(a, b));
      nextLines.add(new KochLine(b, c));
      nextLines.add(new KochLine(c, d));
      nextLines.add(new KochLine(d, e));
    }
    return nextLines;
  }
}
