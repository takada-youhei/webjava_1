package jp.co.systena.tigerscave.shoppingcart.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.springhellosystena.application.model.ItemList;
import jp.co.systena.tigerscave.springhellosystena.application.model.UserForm;


@Controller  // Viewあり。Viewを返却するアノテーション
public class ItemListController {

	@Autowired
	HttpSession session;                  // セッション管理


//-----------------------------------------------------------------
  @RequestMapping(value="/Itemlist", method = RequestMethod.GET)  // URLとのマッピング(http://localhost:8080/Itemlist)
  public ModelAndView index(ModelAndView mav) {
    
	  // Viewに渡すデータを設定(セッション情報から保存したデータを取得してメッセージを生成
//    UserForm userForm = (UserForm) session.getAttribute("form");
//    session.removeAttribute("form");

//    if (userForm != null) {
//      mav.addObject("message", userForm.getName()+"を保存しました");
//    }
    mav.addObject("itemList", new ItemList());  // 新規クラスを設定

//    List<ItemList> Item = (List<ItemList>) session.getAttribute("ItemList");
//    if( users == null) {
//        users = new ArrayList<ItemList>();
//        session.setAttribute("userList", users);
    }
    mav.addObject("item", Item);

    BindingResult bindingResult = (BindingResult) session.getAttribute("result");
    if (bindingResult != null) {
      mav.addObject("bindingResult", bindingResult);
    }
    
    // Viewのテンプレート名を設定
    mav.setViewName("itemlist");
    return mav;
  }
//-----------------------------------------------------------------


//-----------------------------------------------------------------
  @RequestMapping(value="/Itemlist", method = RequestMethod.POST)  // URLとのマッピング(http://localhost:8080/Itemlist)
  private ModelAndView adduser(ModelAndView mav, @Valid UserForm userForm, BindingResult bindingResult, HttpServletRequest request) {

    List<ItemList> users = (List<ItemList>)session.getAttribute("userList");
    if( users == null) {
        users = new ArrayList<ItemList>();
        session.setAttribute("userList", users);
    }

    if (bindingResult.getAllErrors().size() > 0) {
      // エラーがある場合はそのまま戻す
      mav.addObject("userForm",userForm);  // 新規クラスを設定

      mav.addObject("users", users);

      // Viewのテンプレート名を設定
      mav.setViewName("userlist");
      return mav;

    }
    ItemList user = new ItemList();
    user.setName(userForm.getName());
    users.add(user);
    // データをセッションへ保存
    session.setAttribute("list", itemList);
    return new ModelAndView("redirect:/itemlist");        // リダイレクト
  }
//-----------------------------------------------------------------
}
