package jp.co.systena.tigerscave.shoppingcart.application.model;

import java.util.List;

public class ItemList {

  // 名前
  private String name;

  //listをstring型で宣言  
  private List<String> itemList;

  private ItemList() {
	  //listにデータを追加
	  itemList.add("水");
	  itemList.add("お茶");
	  itemList.add("コーヒー");
  }

  public String getName() {
    return this.name;
  }
  // setter
  public void setName(String name) {
    this.name = name;
  }

  // 
  public List<String> getItemList(){
	  return itemList;
  }
  
  public void setItemList(List<String> list) {
	  
  }
}
