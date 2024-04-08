package a3_LiangSourceCodeExamples.src.chapter28__Graphs_and_Applications;


public class Edge {
  public int u;
  public int v;

  public Edge(int u, int v) {
    this.u = u;
    this.v = v;
  }

  public boolean equals(Object o) {
    return u == ((Edge)o).u && v == ((Edge)o).v;
  }
}
