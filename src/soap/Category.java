package soap;

public class Category {

  private String id;
  private String name;
  private int factsCount;

  public Category() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getFactsCount() {
    return factsCount;
  }

  public void setFactsCount(String factsCount) {
    this.factsCount = Integer.valueOf(factsCount);
  }

  @Override
  public String toString() {
    return "CategoryActivity{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", factsCount=" + factsCount +
            '}';
  }
}
