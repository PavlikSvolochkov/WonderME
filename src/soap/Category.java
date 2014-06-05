package soap;

public class Category {

  private String id = "";
  private String name = "";
  private String factsCount = "";

  public int getId() {
    return Integer.valueOf(id);
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

  public String getFactsCount() {
    return factsCount;
  }

  public void setFactsCount(String factsCount) {
    this.factsCount = factsCount;
  }

  @Override
  public String toString() {
    return "Category{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", factsCount=" + factsCount +
            '}';
  }
}
