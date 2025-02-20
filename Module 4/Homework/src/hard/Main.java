package hard;

public class Main {

  public static void main(String[] args) {
    medium.MyData myData = new medium.MyData(16161616, "data");
    Box<medium.MyData> dataBox = new Box<>(myData);
    dataBox.showType();
    System.out.println(dataBox.getItem());

    Box box = new Box("box");
    box.showType();
    System.out.println(box.getItem());

  }

}
